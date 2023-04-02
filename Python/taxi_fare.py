##################################
### Title: Singapore Taxi Fare ###
### Author: GuoChen Hou   ########
##################################

# The taxi fare structure in Singapore must be one of the most complex in the world! See http://www.taxisingapore.com/taxi-fare/
# This program computs taxi fare amount given the inputs, day_type, board_time and distance travelled

import math

BASE_TRAVEL_DISTANCE = 1000
FARE_DISTANCE_MILESTONE = 10200

def computeFare(day_type, board_time, dist):
	fare = 0
	if board_time and dist:
		#Basic fare
		fare += 3.40
		dist_temp = float(dist - BASE_TRAVEL_DISTANCE)
		if dist <= 10200:
			fare += math.ceil(dist_temp/400)*0.22
		else:
			fare += math.ceil((FARE_DISTANCE_MILESTONE - BASE_TRAVEL_DISTANCE)/400)*0.22
			dist_temp -= float(FARE_DISTANCE_MILESTONE - BASE_TRAVEL_DISTANCE)
			fare += math.ceil(dist_temp/350)*0.22
		# Surcharge
		if day_type:
			if board_time <= 359:
				fare *= 1.5
			else:
				fare *= 1.25
		else:
			if board_time <= 359:
				fare *= 1.5
			elif board_time > 1080:
				fare *= 1.25
	return fare

day_type = int(raw_input('Day type: '))
hour,minute = raw_input('Boarding hour and minute: ').split()
dist = int(raw_input('Distance: '))

hour = int(hour)
minute = int(minute)
board_time = hour*60 + minute

print 'Total taxi fare is $%.2f' % computeFare(day_type, board_time, dist)