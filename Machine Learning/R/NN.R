# https://www.analyticsvidhya.com/blog/2017/09/creating-visualizing-neural-network-in-r/
# http://lib.stat.cmu.edu/DASL/Datafiles/Cereals.html

# https://www.analyticsvidhya.com/blog/2017/05/neural-network-from-scratch-in-python-and-r/

# set working directory in R: setwd()

#############################
## Creating index variable ##
#############################
# Read the Data
data = read.csv("Data/cereals.csv", header=T)

# Random sampling
samplesize = 0.60 * nrow(data)
set.seed(80) # gerar mesmo toda amostra aleatoria e   manter a consistencia.
index = sample( seq_len ( nrow ( data ) ), size = samplesize )

# Create training and test set
datatrain = data[ index, ]
datatest = data[ -index, ]

###########################
## Normalizacao - Max Min #
###########################
## Scale data for neural network
max = apply(data , 2 , max)
min = apply(data, 2 , min)
scaled = as.data.frame(scale(data, center = min, scale = max - min))

##############################################
##           Fit neural network             ##
##############################################
# install library
install.packages("neuralnet ")

# load library
library(neuralnet)

# creating training and test set
trainNN = scaled[index , ] # Conjunto de Treinamento
testNN = scaled[-index , ] # Conjunto de Teste

# fit neural network
set.seed(2)
NN = neuralnet(rating ~ calories + protein + fat + sodium + fiber, trainNN, hidden = 3 , linear.output = T )

# Os pesos (weights) são calculados pelo algoritmo back propagation
# As linhas azuis são os bias

# plot neural network
plot(NN)

#####################################
## Prediction using neural network ##
#####################################
predict_testNN = compute(NN, testNN[,c(1:5)]) # Sem o Rating
predict_testNN = (predict_testNN$net.result * (max(data$rating) - min(data$rating))) + min(data$rating)

plot(datatest$rating, predict_testNN, col='blue', pch=16, ylab = "predicted rating NN", xlab = "real rating")
abline(0,1)

plot(datatest$rating  , type="l" , pch=22, col="blue", xlab = "real", ylab = "previsto" )
lines(predict_testNN  , type="l" , pch=22, col="red" )

# Calculate Root Mean Square Error (RMSE)
RMSE.NN = (sum((datatest$rating - predict_testNN)^2) / nrow(datatest)) ^ 0.5


##############################################
## Cross validation of neural network model ##
##############################################

# install relevant libraries
install.packages("boot")
install.packages("plyr")

# Load libraries
library(boot)
library(plyr)

# Initialize variables
set.seed(50)
k = 100
RMSE.NN = NULL

List = list( )

# Fit neural network model within nested for loop
for(j in 10:65){
  print("j")
  print(j)
  for (i in 1:k) {
    #print("i")
    #print(i)
    #print("k")
    #print(k)
    
    index = sample(1:nrow(data),j )
    
    #print("index")
    #print(index)
    
    trainNN  = scaled[index,]
    testNN   = scaled[-index,]
    datatest = data[-index,]
    
    NN = neuralnet(rating ~ calories + protein + fat + sodium + fiber, trainNN, hidden = 3, linear.output= T)
    predict_testNN = compute(NN,testNN[,c(1:5)])
    predict_testNN = (predict_testNN$net.result*(max(data$rating)-min(data$rating)))+min(data$rating)
    
    RMSE.NN [i]<- (sum((datatest$rating - predict_testNN)^2)/nrow(datatest))^0.5
  }
  List[[j]] = RMSE.NN
}

Matrix.RMSE = do.call(cbind, List)

## Prepare boxplot
boxplot(Matrix.RMSE[,56], ylab = "RMSE", main = "RMSE BoxPlot (length of traning set = 65)")

## Variation of median RMSE 
install.packages("matrixStats")
library(matrixStats)

med = colMedians(Matrix.RMSE)

X = seq(10,65)

plot (med~X, type = "l", xlab = "length of training set", ylab = "median RMSE", main = "Variation of RMSE with length of training set")

##############################################
