##################################
### Title: Freezer        ########
### Author: GuoChen Hou   ########
##################################

# Calculates the temperature in a freezer since a power failure after a given amount of time

hours, minutes = raw_input('Enter hours and minutes since power failure: ').split()

hours = float(hours)
minutes_decimal = float(minutes) / 60

elapsed_time = hours + minutes_decimal

temp = (4*(pow(elapsed_time, 2))/(elapsed_time + 2)) -20

print 'Temperature in freezer = %.2f' % temp