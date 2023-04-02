##################################
### Title: Reading        ########
### Author: GuoChen Hou   ########
##################################

# There are various techniques of parsing inputs. In this exercise, we will implement 3 common 
# techniques: 
# 1. Given an integer N, you should read N lines, each line containing some data. 
# 2. Read until some special character(s) (e.g. read until -1). 
# 3. Read until the end of the file.

mode  = raw_input()

if mode == "LIMIT":
	n = int(raw_input())
	for i in range(n):
		cmd, num1, num2 = raw_input().split()
		num1 = int(num1)
		num2 = int(num2)
		if cmd == "ADD":
			result = num1 + num2
		elif cmd == "SUB":
			result = num1 - num2
		elif cmd == "MUL":
			result = num1 * num2
		print result
elif mode == "SENTINEL":

	while True:
		try:
			cmd, num1, num2 = raw_input().split()
			num1 = int(num1)
			num2 = int(num2)
		except ValueError:
			break;
		if cmd == "-1":
			break;
		elif cmd == "ADD":
			result = num1 + num2
		elif cmd == "SUB":
			result = num1 - num2
		elif cmd == "MUL":
			result = num1 * num2
		print result
elif mode == "EOF":
	result = []
	while True:
		try:
			cmd, num1, num2 = raw_input().split()
			num1 = int(num1)
			num2 = int(num2)
			if cmd =="ADD":
				result.append(num1+num2)
			elif cmd == "SUB":
				result.append(num1-num2)
			elif cmd =="MUL":
				result.append(num1*num2)
		except (EOFError, ValueError) as e:
			print result
			break;