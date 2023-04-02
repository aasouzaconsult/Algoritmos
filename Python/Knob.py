##################################
### Title: Turn Knob      ########
### Author: GuoChen Hou   ########
##################################

# Task Statement 
# A four-way knob has 4 positions: up, right, down and left. The knob can only turn in the 
# clockwise direction. For example, if the current position is right, it takes 3 stops to reach position 
# up. 
# Moreover, the knob is used to control a device and the latter has two states: on or off. For 
# every stop we take to turn the knob, the device would toggle its state. For example, if the knob's 
# original position is right and its attached device's state is on, then turning the knob to "down" 
# position would turn off the device, and turning the knob to "left" position would turn on the 
# device again. 
# You are to write a program that reads in information about some knobs. Each knob has its device's 
# state, its current position and its target position. You are to find out for each knob what is the final 
# state of its device, and the total number of stops you need to make to turn all the knobs to their 
# target positions. 
# If the current position and target position of a knob are identical, you must turn the knob one 
# complete round, that is, 4 stops. You should never turn a knob more than one complete round. 
 
# Input 
# The first line of the input contains a positive integer N (1 <= N <= 10) which indicates the number of 
# knobs. In the subsequent N lines, each line contains information about a knob. If the line begins 
# with the word "on" it means that the initial state of the attached device is on; if the word "on" is 
# absent, it means the device is off. The rest of the line contains the current position and target 
# position of the knob. 
# (The above symbol N is used to ease explanation. In your program, you should give more 
# descriptive variable names and follow Java naming convention.) 
 
# Output 
# The output contains N+1 lines. The first N lines contains the final states of the respective devices, 
# and the last line contains the total number of stops made to turn all the knobs. 
class Knob:
	"Knob class determines the characteristics of knobs"
	position = ('up', 'right', 'down', 'left')
	state = ('on', 'off')
	def __init__(self, state, new_cur_pos, new_tgt_pos):
		"Constructor"
		self.isOn = state
		self.cur_pos = new_cur_pos
		self.tgt_pos = new_tgt_pos

	# Accessors
	def getState(self):
		return self.isOn

	def deviceIsOn(self):
		"Determine if the device is on or off after num moves"
		if self.isOn == "off":
			self.isOn = "on"
		else:
			self.isOn = "off"
		return self.isOn

	def changePos(self):
		"Compute the least moves to turn the knob"
		count = 0
		if self.cur_pos == self.tgt_pos:
			count = len(self.position)
		else:
			while self.cur_pos != self.tgt_pos:
				self.cur_pos = self.moveClockwise(self.cur_pos)
				self.deviceIsOn()
				count += 1
		return count

	def changeState(self):
		if self.isOn == self.state[0]:
			self.isOn = self.state[1]
		else:
			self.isOn = self.state[0]

	def moveClockwise(self, position_element):
		"Move 1 position clockwise"
		index = self.position.index(position_element)
		if index == 3:
			return self.position[0]
		else:
			return self.position[index+1]

# Declare variables
# Read input and process them accordingly
knob_num = int(raw_input())
knob = [None] * knob_num

for i in range(knob_num):
	line = raw_input().split(' ')
	if len(line) == 3:
		knob[i] = Knob(line[0], line[1], line[2])
	else:
		knob[i] = Knob('off', line[0], line[1])
total = 0
for i in range(knob_num):
	num = knob[i].changePos()
	total += num
	print knob[i].getState()
print "Total stop(s) =", total	