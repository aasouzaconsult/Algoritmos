# -*- coding: UTF-8 -*-

# Constantes para representar os tipos de jogadore CROSS/X ou NOUGHT/O

class Cell(object):
	EMPTY = 0
	CROSS = 1
	NOUGHT = 2

	def __init__(self):
		self.content = self.EMPTY

	def paint(self):
		if self.content == self.CROSS:
			print ("X"),
		elif self.content == self.NOUGHT:
			print ("O"),
		else:
			print (" "),

