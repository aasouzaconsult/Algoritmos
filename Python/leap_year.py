##################################
### Title: Leap Year      ########
### Author: GuoChen Hou   ########
##################################

# Calculates if a year is a leap year.
def isLeapYear(year):
	if year%400 == 0:
		return True
	elif year%4 == 0 and year%100 != 0:
		return True
	else:
		return False

year = int(raw_input('Enter a year to test for leap year: '))

if isLeapYear(year):
	print "%d is leap year." % year
else:
	print "%d is not leap year." % year