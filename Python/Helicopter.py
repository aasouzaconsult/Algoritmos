##################################
### Title: Helicopter     ########
### Author: GuoChen Hou   ########
##################################

# Task statement at http://www.comp.nus.edu.sg/~cs1020/labs/12s2/lab3/ex3_Helicopter/Helicopter.pdf

class FieldNode:
	def __init__(self, index, helicopter=None, next=None):
		self.index = index
		self.helicopter = helicopter
		self.next = next

	# accessors
	def get_index(self):
		return self.index

	def get_helicopter(self):
		return self.helicopter

	def get_next(self):
		return self.next

	def set_helicopter(self, helicopter):
		self.helicopter = helicopter
		return None


class ControlTower:
	def __init__(self, field_count):
		self.field_count = field_count # number of fields
		self.fields = [] # a list of all FieldNode objects
		for index in range(field_count):
			self.fields.append(FieldNode(index))
		# link up the nodes
		for i in range(len(self.fields)):
			if i == len(self.fields)-1:
				self.fields[i].next = self.fields[0]
			else:
				self.fields[i].next = self.fields[i+1]

	def heli_outgoing(self, index):
		"""Vacate the 'index' helipad """
		if index < self.field_count: # index is in airport
			self.fields[index].set_helicopter(None)
		return None

	def heli_incoming(self, helicopter, dest):
		"""Return the field id where the helicopter landed"""
		placed = False
		placing = -1

		if dest < self.field_count: # dest is in airport
			if self.fields[dest].get_helicopter() == None:
				self.fields[dest].set_helicopter(helicopter)
				placed = True
				placing = dest
			else:
				for i in range(len(self.fields)):
					new_pad = self.fields[dest].get_next()
					if new_pad.helicopter == None:
						new.set_helicopter(helicopter)
						placed = True
						placing = new_pad.get_index()
		else:
			return -1
		if placed:
			return placing
		else:
			return -1

	def print_status(self):
		"""Print airport occupancy status"""
		for pad in self.fields:
			print "Field %d: occupied by helicopter: %s" % (pad.get_index(), pad.get_helicopter())

fields = int(raw_input())
ctrl_twr = ControlTower(fields)
status = []

while True:
	line = raw_input().split()
	if line[0] == "incoming":
		name, dest = line[1], line[2]
		dest = int(dest)
		ctrl_twr.heli_incoming(name, dest)
	elif line[0] == "outgoing":
		dest = int(line[1])
		ctrl_twr.heli_outgoing(dest)
	elif line[0] == "END":
		break
ctrl_twr.print_status()