##################################
### Title: Station        ########
### Author: GuoChen Hou   ########
##################################

# Task statement at http://www.comp.nus.edu.sg/~cs1020/labs/12s2/lab4/ex3_RailwayStation/RailwayStation.pdf
# Test inputs at http://www.comp.nus.edu.sg/~cs1020/labs/12s2/lab4/ex3_RailwayStation/input/
# Test outputs at http://www.comp.nus.edu.sg/~cs1020/labs/12s2/lab4/ex3_RailwayStation/output/
from collections import deque
import StackADT

while True:
	coach_count = int(raw_input())
	if coach_count > 0:
		# initialize a queue with elements from 1 to coaches
		permutations = int(raw_input()) # number of permutations
		for i in range(permutations):
			lineup = map(int, raw_input().split())
			station = StackADT.Stack() # station adopts stack ADT
			coaches = deque() # incoming coaches adopts queue ADT
			for i in range(coach_count):
				coaches.append(i+1)
			for i in range(len(coaches)):				
				while True:
					if len(coaches) == 0 and len(lineup) == 0: # both coaches and lineup are exhausted
						break
					elif station.is_empty():
						station.push(coaches.popleft())
						continue
					elif station.peek() == lineup[0]: # station leaving coach is the desired permutation coach
						station.pop()
						lineup.pop(0)
					elif len(coaches) != 0: # coach is not desired permutation coach, enter next coach
						station.push(coaches.popleft())
					else:
						break		
			if len(lineup) == 0: # permutation coach orders are met
				print "YES"
			else:
				print "NO"
	else:
		break