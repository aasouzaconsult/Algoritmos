#######################################
# Exemplo de Rede Neural - Perceptron #
#######################################
# Fonte e Direitos: https://jtsulliv.github.io/perceptron/
"""
Created on Tue Feb 17 13:32:18 2017
@author: JSULLIVAN
"""

import numpy as np
import matplotlib.pyplot as plt 

# setting the random seed
np.random.seed(5)

# number of observations
obs = 1000

# generating synthetic data from multivariate normal distribution  
class_zeros = np.random.multivariate_normal([0,0], [[1.,.95],[.95,1.]], obs)
class_ones = np.random.multivariate_normal([1,5], [[1.,.85],[.85,1.]], obs)

# generating a column of ones as a dummy feature to create an intercept
intercept = np.ones((2*obs,1))

# vertically stacking the two classes 
features = np.vstack((class_zeros, class_ones)).astype(np.float32)

# putting in the dummy feature column
features = np.hstack((intercept, features))


# creating the labels for the two classes
label_zeros = np.zeros((obs,1))
label_ones = np.ones((obs,1))


# stacking the labels, and then adding them to the dataset
labels = np.vstack((label_zeros,label_ones))
dataset = np.hstack((features,labels))

# scatter plot to visualize the two classes (red=1, blue=0)
#plt.scatter(features[:,1], features[:,2], c = labels)

# shuffling the data to make the sampling random
np.random.shuffle(dataset)

# splitting the data into train/test  (70%/30%) sets
train = dataset[0:(0.7*(obs*2))]
test = dataset[(0.7*(obs*2)):(obs*2)]

# Training the Perceptron
#
# x:   features
# y:   outputs 
# z:   threshold
# eta: learning rate
# t:   number of iterations

# reshaping the data for the function
x_train = train[:,0:3]
y_train = train[:,3]

x_test = test[:,0:3]
y_test = test[:,3]

def perceptron_train(x, y, z, eta, t):
    
    # Initializing parameters for the Perceptron
    w = np.zeros(len(x[0]))        # initial weights 
    n = 0                          
    
    # Initializing additional parameters to compute sum-of-squared errors
    yhat_vec = np.ones(len(y))     # vector for predictions
    errors = np.ones(len(y))       # vector for errors (actual - predictions)
    J = []                         # vector for the SSE cost function
     
        
    while n < t: 
        #print "iteration:"
        #print n                                 
        for i in xrange(0, len(x)):                 
            
            # summation step
            f = np.dot(x[i], w)   
                  
            # activation function
            if f >= z:                               
                yhat = 1.                               
            else:                                   
                yhat = 0.
            yhat_vec[i] = yhat 
            
            # updating the weights
            for j in xrange(0, len(w)):             
                w[j] = w[j] + eta*(y[i]-yhat)*x[i][j]
           
        n += 1
        
        # computing the sum-of-squared errors
        for i in xrange(0,len(y)):     
           errors[i] = (y[i]-yhat_vec[i])**2
        J.append(0.5*np.sum(errors))

            
    # function returns the weight vector, and sum-of-squared errors        
    return w, J
    


z = 0.0     # threshold
eta = 0.1   # learning rate
t = 5       # number of iterations

#print "The weights are:"
perceptron_train(x_train, y_train, z, eta, t)

w = perceptron_train(x_train, y_train, z, eta, t)[0]
J = perceptron_train(x_train, y_train, z, eta, t)[1]
epoch = np.linspace(1,len(J),len(J))


# convergence plot
#plt.figure(1)
#plt.plot(epoch, J)
#plt.xlabel('Epoch')
#plt.ylabel('Sum-of-Squared Error')
#plt.title('Perceptron Convergence')

#
#print "The sum-of-squared erros are:"
#print perceptron_train(x_train, y_train, z, eta, t)[1]


def perceptron_test(x, w, z, eta, t):
    y_pred = []
    for i in xrange(0, len(x-1)):
        f = np.dot(x[i], w)   

            # activation function
        if f > z:                               
            yhat = 1                               
        else:                                   
            yhat = 0 
        y_pred.append(yhat)
    return y_pred
        
y_pred = perceptron_test(x_test, w, z, eta, t)

def accuracy(y_pred, y_test):
    acc = []
    for i in xrange(0,len(y_pred)):
        if y_pred[i] == y_test[i]:
            acc.append(1.)
        else:
            acc.append(0.)
    accuracy_num = np.sum(acc)/len(y_pred)
    print accuracy_num
    accuracy_str = str(accuracy_num*100)+'%'    
    return accuracy_str


min = np.min(x_test[:,1])
max = np.max(x_test[:,1])
x1 = np.linspace(min,max,100)

# plot the decision boundary
# 0 = w0x0 + w1x1 + w2x2

def x2(x1, w):
    w0 = w[0]
    w1 = w[1]
    w2 = w[2]
    x2 = []
    for i in xrange(0, len(x1-1)):
        x2_temp = (-w0-w1*x1[i])/w2
        x2.append(x2_temp)
    return x2
    
x_2 = np.asarray(x2(x1,w))

plt.figure(2)
plt.scatter(features[:,1], features[:,2], c = labels)
plt.plot(x1, x_2)



# sklearn implementation
from sklearn.linear_model import Perceptron
from sklearn.linear_model.stochastic_gradient import SGDClassifier
from sklearn.metrics import accuracy_score


# Fitting an sklearn Perceptron and SGDClassifier with perceptron loss function (these should be identical)
clf = Perceptron(random_state=None, eta0= 0.1, shuffle=False, penalty=None, class_weight=None, fit_intercept=False)
clf2 = SGDClassifier(loss="perceptron",eta0=0.1,learning_rate="constant",penalty=None,random_state=None,shuffle=False,fit_intercept=False,warm_start=False,average=False,n_iter=1000)
clf.fit(x_train, y_train)
clf2.fit(x_train, y_train)

y_predict = clf.predict(x_test)
y_preSGD = clf2.predict(x_test)

print "sklearn Perceptron accuracy:"
print accuracy_score(y_test, y_predict)

print "sklearn SGDClassifier accuracy:"
print accuracy_score(y_test, y_preSGD)

print "my perceptron accuracy:"
print accuracy_score(y_test, y_pred)
print "\n"
#print clf.coef_

def x22(x1, w):
    w0 = clf.coef_[0][0]
    w1 = clf.coef_[0][1]
    w2 = clf.coef_[0][2]
    x2 = []
    for i in xrange(0, len(x1-1)):
        x2_temp = (-w0-w1*x1[i])/w2
        x2.append(x2_temp)
    return x2
    
x_22 = np.asarray(x22(x1,clf2.coef_))

plt.plot(x1, x_22)
print "sklearn perceptron coeffs:"
print clf.coef_
print "SGDClassifier coeffs:"
print clf2.coef_
print "my coeffs:"
print w
