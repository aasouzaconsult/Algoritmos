##################################
### Title: Tower of Hanoi ########
### Author: GuoChen Hou   ########
##################################

from ADT.Stack import Stack_array

def solve_tower_recurs(number, source, temp, dest):
	"""
	Recursive solution of the Tower of Hanoi problem.

	if n > 0:
		1. move n-1 disks from source to temp using dest
		2. move 1 disk from source to dest using temp
		3. move n-1 disks from temp to dest using source
	"""
	if number > 0:
		solve_tower_recurs(number-1, source, dest, temp)
		print 'Move disk %d from peg %s to peg %s.' % (number, source, dest)
		solve_tower_recurs(number-1, temp, source, dest)

def solve_tower(number):
	"""
	Solve tower of hanoi problem using stack ADT and recursive solution.

	Initialize 3 stacks to with each stack symbolise each of the peg.
	"""
	towers = []
	# initialize a list reference each of the 3 towers stacks
	for i in range(number):
		stack = Stack_array()
		towers.append(stack)
	# put all pegs to starting tower in ascending order from top to bottom
	for i in range(number-1, -1, -1):
		towers[0].push(i)
	# recursive solution
	solve_tower_stack(number, towers[0], towers[1], towers[2])

def solve_tower_stack(number, source, temp, dest):
	"""
	Solve tower of hanoi problem using stack ADT and recursive solution.
	"""
	if number > 0:
		solve_tower_stack(number-1, source, dest, temp)
		move = source.pop()
		dest.push(move)
		solve_tower_stack(number-1, temp, source, dest)

if __name__ == "__main__":
	num = int(raw_input('Number of disks: '))

	solve_tower_recurs(num, 'A', 'B', 'C')
	solve_tower(num)