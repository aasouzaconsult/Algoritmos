##################################
### Title: Date Convert   ########
### Author: GuoChen Hou   ########
##################################

# There are two common formats used for dates. For example December 25, 2012 is more 
# commonly used in the UK, whereas 25 December 2012 is more popular with the Americans. 
# Write a program that reads a string in the UK date format and outputs the 
# equivalent American format, and also whether the year is a leap year. 
# The input consists of the month, a space, the day, a comma, a space, and the year. You may 
# assume that all inputs follow this format, and that the input date is a valid date. 
# You are to define a class method isLeapYear(int) that takes in an integer parameter which 
# represents the year, and returns true if it is a leap year, or false otherwise. A year is a leap year 
# if it satisfies one of the following two conditions: 
# It is divisible by 400; or 
# It is divisible by 4 but not by 100 
# For example, 2012, 1996, and 2000 are leap years, but 1998, 2013, 2100 and 2200 are not. 

# Calculates if a year is a leap year.
def isLeapYear(year):
	if year%400 == 0:
		return True
	elif year%4 == 0 and year%100 != 0:
		return True
	else:
		return False

month, day_string, year = raw_input("Enter date in UK format: ").split()
day = day_string[:-1]

print "Date in American format: %s %s %s" % (day, month, year)

if isLeapYear(int(year)):
	print year + " is a leap year."
else:
	print year + " is not a leap year."