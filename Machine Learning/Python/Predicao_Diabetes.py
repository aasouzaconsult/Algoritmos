# Diabetes
# Download base (diabetes.csv): https://github.com/susanli2016/Machine-Learning-with-Python/blob/master/diabetes.csv
# Link: https://datascienceplus.com/machine-learning-for-diabetes-with-python/

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

diabetes = pd.read_csv('diabetes.csv')
print(diabetes.columns)

diabetes.head()

# The diabetes data set consists of 768 data points, with 9 features each:
print("dimension of diabetes data: {}".format(diabetes.shape))

# “Outcome” is the feature we are going to predict, 0 means No diabetes, 1 means diabetes. Of these 768 data points, 500 are labeled as 0 and 268 as 1:
print(diabetes.groupby('Outcome').size())

# graph
import seaborn as sns
sns.countplot(diabetes['Outcome'],label="Count")

# Informations
diabetes.info()

#######
# KNN #
#######
from sklearn.model_selection import train_test_split

X_train, X_test, y_train, y_test = train_test_split(diabetes.loc[:, diabetes.columns != 'Outcome'], diabetes['Outcome'], stratify=diabetes['Outcome'], random_state=66)

from sklearn.neighbors import KNeighborsClassifier
training_accuracy = []
test_accuracy = []
# try n_neighbors from 1 to 10
neighbors_settings = range(1, 11)

for n_neighbors in neighbors_settings:
    # build the model
    knn = KNeighborsClassifier(n_neighbors=n_neighbors)
    knn.fit(X_train, y_train)
    # record training set accuracy
    training_accuracy.append(knn.score(X_train, y_train))
    # record test set accuracy
    test_accuracy.append(knn.score(X_test, y_test))

plt.plot(neighbors_settings, training_accuracy, label="training accuracy")
plt.plot(neighbors_settings, test_accuracy, label="test accuracy")
plt.ylabel("Accuracy")
plt.xlabel("n_neighbors")
plt.legend()
plt.savefig('knn_compare_model')

#The above plot shows the training and test set accuracy on the y-axis against the setting of n_neighbors on the x-axis. Considering if we choose one single nearest neighbor, the prediction on the training set is perfect. But when more neighbors are considered, the training accuracy drops, indicating that using the single nearest neighbor leads to a model that is too complex. The best performance is somewhere around 9 neighbors.

#The plot suggests that we should choose n_neighbors=9. Here we are:
knn = KNeighborsClassifier(n_neighbors=9)
knn.fit(X_train, y_train)
print('Accuracy of K-NN classifier on training set: {:.2f}'.format(knn.score(X_train, y_train)))
print('Accuracy of K-NN classifier on test set: {:.2f}'.format(knn.score(X_test, y_test)))