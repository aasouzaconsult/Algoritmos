##################################
### Title: Fahrenheit to celsius #
### Author: GuoChen Hou   ########
##################################

# Converts temperature in Fahrenheit to Celsius

fahrenheit = float(raw_input('Enter temperature in Fahrenheit: '))
celsius = (fahrenheit - 32) / 1.8
print '%.3f fahrenheit equates to %.3f celsius' % (fahrenheit, celsius)