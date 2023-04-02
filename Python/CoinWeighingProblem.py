# There are n coins identical in appearance, but one is either heavier or lighter than the others, which all weigh the same.
# Identify the bad coin and determine whether it is heavier or lighter than the others using only a pan balance, which compares the 
# weights of two sets of coins.

class coin_problem:

	def __init__(self):
		self.list = [5,5,5,4,5]

	def find_bad_coin(self):
		index = 1
		while index != len(self.list) - 1:
			if self.list[0] < self.list[index]:
				if self.list[0] < self.list[4]:
					return "C0 lighter"
				else:
					return "Index at %d heavier" % index
			elif self.list[0] > self.list[index]:
				if self.list[1] < self.list[4]:
					return "Index at %d lighter" % index
				elif self.list[1] == self.list[4]: # wrong logic here
					return "Index at C0 lighter"
			else:
				index +=1

		if index == len(self.list) - 1:
			if self.list[0] < self.list[index]:
				return "Index at %d heavier" % index
			else:
				return "index at %d lighter" % index
			
	def find_bad_coin_v2(self):
		if self.list[0] > self.list[1]:
			if self.list[0] > self.list[4]:
				return "index at 0 is the heavy coin"
			else: # self.list[0] == self.list[4]
				return "index at 1 is the light coin"
		elif self.list[0] == self.list[1]:
			if self.list[2] > self.list[3]:
				if self.list[2] > self.list[4]:
					return "index at 2 is the heavy coin"
				else:
					return "index at 3 is the light coin"
			elif self.list[2] == self.list[3]:
				if self.list[0] > self.list[4]:
					return "index at 4 is the light coin"
				else:
					return "index at 4 is the heavy coin"
			else:
				if self.list[2] == self.list[4]:
					return "index at 3 is the heavy coin"
				else:
					return "index at 2 is the light coin"
		else:
			if self.list[0] == self.list[4]:
				return "index at 1 is the heavy coin"
			else:
				return "index at 0 is the light coin"


if __name__ == "__main__":
	coin = coin_problem()
	print coin.find_bad_coin()
	print coin.find_bad_coin_v2()