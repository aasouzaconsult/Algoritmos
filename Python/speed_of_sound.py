##################################
### Title: Speed of Sound ########
### Author: GuoChen Hou   ########
##################################

# Given temperature T in fahrenheits, calculates the speed of sound in air.

import math

def speed_of_sound(temp):
	speed = 1086 * math.sqrt((5*temp + 297)/247)
	return speed

temp = float(raw_input('Temperature in degree Fahrenheit: '))

speed = speed_of_sound(temp)

print 'Speed of sound in air of %.2f degree = %.2f ft/sec' % (temp, speed)