##################################
### Title: Ruler Class    ########
### Author: GuoChen Hou   ########
##################################

# Task Statement
# A wooden ruler is S centimeters long. The left end of the ruler is represented as 0. A 
# carpenter has already made N markings on the ruler, which are randomly distributed along 
# the ruler and each marking is of a certain distance (in cm) from the origin 0. The space 
# between a marking and its adjacent marking is called a segment. 
# Now, the carpenter is trying to make additional L markings on the ruler to minimize the 
# longest segment on the ruler. 
# Input
# The first line of the input contains a positive integer S (1 <= S < 2000) which indicates the 
# length of the ruler in centimetre. The second line of the input contains a positive integer N 
# (1 <= N <= 50) which represents the number of existing markings. This is followed by N 
# integers indicating the positions of the markings. The last line of the input contains a 
# positive integer L (1 <= L <= 30) which represents the number of new markings. 
# Note that short symbols such as S, N and L are used in the task description above for 
# convenience. In your program, you are expected to give them descriptive variable names. 


class Ruler:
	"Ruler class describes the various length position on a ruler"
	def __init__(self, a_list):
		self.measurements = self.ascending_sort(a_list)
		self.intervals = self.calc_intervals()

	def add_marking(self):
		new_value = self.measurements[self.largest_value_index()] + self.largest_value()/2
		self.measurements.insert(self.largest_value_index()+1, new_value)
		return self.measurements

	def calc_intervals(self):
		"Takes in an integer list and calculates the number interval between each pair of numbers"
		a_list = []
		for index in range(len(self.measurements)):
			for next_index in range(index+1, len(self.measurements)):
				a_list.append(self.measurements[next_index] - self.measurements[index])
				break
		self.intervals = a_list
		return a_list

	def ascending_sort(self, a_list):
		"Sort a number list in ascending order"
		for index in range(len(a_list)):
			for next_index in range(index+1, len(a_list)):
				if a_list[next_index] < a_list[index]:
					a_list[next_index], a_list[index] = a_list[index], a_list[next_index]
		return a_list

	def largest_value_index(self):
		"Return the largest integer value's index of an integer list"
		return self.intervals.index(self.largest_value())
	
	def largest_value(self):
		"Return the largest value in an integer list"
		largest = 0
		for index in range(len(self.intervals)):
			if self.intervals[index] > largest:
				largest = self.intervals[index]				
		return largest

	# Accessors
	def get_measurements(self):
		return self.measurements
	
	def get_intervals(self):
		return self.intervals

length = int(raw_input())
marking_size = int(raw_input())
markings = []
markings = raw_input().split()
new_marking_size = int(raw_input())
for i in range(len(markings)):
	markings[i] = int(markings[i])
ruler = Ruler(markings)

while new_marking_size != 0:
	ruler.add_marking()
	ruler.calc_intervals()
	new_marking_size -= 1
print ruler.largest_value()	
