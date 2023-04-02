##################################
### Title: Module Class   ########
### Author: GuoChen Hou   ########
##################################

# Task Statement at http://www.comp.nus.edu.sg/~cs1020/labs/12s2/lab2/ex2_Register/Register.pdf
class Schedule:
	def __init__(self, new_day, start_time, end_time):
		self.day = new_day
		self.start_time = start_time
		self.end_time = end_time
	
	def clash(self, new_schedule):
		"Returns True if new_schedule clashes with any of the existing schedules, else false"
		if self.day == new_schedule.get_day():
			if new_schedule.get_start_time() >= self.end_time or self.start_time >= new_schedule.get_end_time():
				return False
		return True;

	def get_day(self):
		return self.day

	def get_start_time(self):
		return self.start_time

	def get_end_time(self):
		return self.end_time

class Module:
	def __init__(self, new_code, lecture_schedule, tutorial_schedule, lab_schedule):
		self.code = new_code
		self.lecture_schedule = lecture_schedule
		self.tutorial_schedule = tutorial_schedule
		self.lab_schedule = lab_schedule

	def clash_with(self, new_module):
		if self.lecture_schedule.clash(new_module.get_lecture()):
			return True
		elif self.lecture_schedule.clash(new_module.get_tutorial()):
			return True
		elif self.lecture_schedule.clash(new_module.get_lab()):
			return True
		elif self.tutorial_schedule.clash(new_module.get_lecture()):
			return True
		elif self.tutorial_schedule.clash(new_module.get_tutorial()):
			return True
		elif self.tutorial_schedule.clash(new_module.get_lab()):
			return True
		elif self.lab_schedule.clash(new_module.get_lecture()):
			return True
		elif self.lab_schedule.clash(new_module.get_tutorial()):
			return True
		elif self.lab_schedule.clash(new_module.get_lab()):
			return True
		else:
			return False

	# Accessors 
	def get_lecture():
		return self.lecture_schedule

	def get_tutorial():
		return self.tutorial_schedule

	def get_lab():
		return self.lab_schedule

class Timetable:
	def __init__(self):
		self.module_list = []

	def add_module(self, module):
		"Add a module into module_list"
		self.module_list.append(module)
		return self.module_list

	def get_modules(self):
		return self.module_list

	def check_clash(self, new_module):
		"Decide if a module can be taken, If True, module clashes"
		for module in self.module_list:
			if module.clash_with(new_module):
				break
			else:
				self.module_list.append(new_module)
				return False
		return True
		
	def count_class(self, new_day):
		"Count the number of classes given a certain day"
		count = 0

		for module in self.module_list:
			if module.get_lecture().get_day() == new_day:
				count += 1
			elif module.get_tutorial().get_day() == new_day:
				count += 1
			elif module.get_lab().get_day() == new_day:
				count += 1
		return count

# Sample test inputs
operation = []
operation.append("MODULE CS1020 Wednesday 10 12 Tuesday 9 10 Thursday 10 12 ")
operation.append("MODULE CS1010 Wednesday 8 10 Tuesday 8 9 Thursday 9 10")
operation.append("MODULE CS2103 Wednesday 8 10 Wednesday 10 12 Wednesday 12 13")
operation.append("MODULE CS2100 Monday 10 12 Wednesday 9 10 Friday 10 12")
operation.append("COUNT Wednesday")
operation.append("MODULE CS1231 Friday 8 10 Friday 12 14 Friday 14 15")
operation.append("MODULE CS2105 Friday 15 16 Tuesday 16 18 Tuesday 15 16")
operation.append("MODULE CS2102 Friday 10 14 Monday 16 18 Thursday 16 18")
operation.append("COUNT Friday")
operation.append("COUNT Sunday")
