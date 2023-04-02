##################################
### Title: Investment     ########
### Author: GuoChen Hou   ########
##################################

# Calculates the principal amount of money at rate precent interest rate compounded annually in x number of years

principle = float(raw_input('Enter principle amount: '))
rate = float(raw_input('Enter interest rate: '))
years = int(raw_input('Enter number of years: '))

amount = (principle * (1 - (pow(rate/100, years+1)))) / (1 - (rate/100))

print 'Amount = %.2f' % amount