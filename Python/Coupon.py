class Coupon:
	"Coupon class"
	def __init__(self, name, rate):
		self.name = name
		self.rate = rate

	def getName(self):
		return self.name

	def getRate(self):
		return self.rate

	def payment(self, price):
		"Take in a price and return the paid sum"
		pay = 0.0
		if self.rate < 1: # discount coupon
			pay = (1-self.rate) * price
		else: # cash coupon
			if price > self.rate: # price larger value over coupon
				pay = self.rate - price
			else: # vice versa
				pay = price - self.rate
		return pay

price, num_coupon = raw_input().split()
price = float(price)
num_coupon = int(num_coupon)
coupon = [None] * num_coupon
pay = []
least_theory_pay = []

for i in range(num_coupon):
	name,rate = raw_input().split()
	rate = float(rate)
	coupon[i] = Coupon(name, rate)
	pay.append(coupon[i].payment(price))
	least_theory_pay.append(abs(coupon[i].payment(price)))
value_pay = least_theory_pay[0]
for i in range(1, num_coupon):
	if least_theory_pay[i] < value_pay:
		value_pay = least_theory_pay[i]
		index = i

if pay[index] < 0:
	value_pay = 0.0
print "Best choice:", coupon[index].getName()
print "You need to pay $%.2f" % value_pay
