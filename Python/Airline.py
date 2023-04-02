##################################
### Title: Airline        ########
### Author: GuoChen Hou   ########
##################################

import datetime

class SGTime:
	"Stores hour and minute of Singapore time"
	def __init__(self, hour, minute):		
		# Current time
		#self.hour = datetime.datetime.now().hour
		#self.minute = datetime.datetime.now().minute
		self.hour = hour
		self.minute = minute

	def get_hour(self):
		return self.hour

	def get_minute(self):
		return self.minute

class Airline:
	"""Stores cost, time and destination details of Airline"""
	def __init__(self, from_city, to_city, depart_time, arrival_day, arrival_time, cost):
		self.from_city = from_city
		self.to_city = to_city
		self.depart_time = depart_time
		self.arrival_day = arrival_day
		self.arrival_time = arrival_time
		self.cost = cost

	def get_from_city(self):
		return self.from_city

	def get_to_city(self):
		return self.to_city

	def get_depart_time(self):
		return self.depart_time

	def get_arrival_day(self):
		return self.arrival_day

	def get_arrival_time(self):
		return self.arrival_time

	def get_cost(self):
		return self.cost

class Query:
	"""Stores a list of airlines served and implements methods to answer the types of queries"""
	def __init__(self):
		self.airline = []

	def add_airline(self, airline):
		self.airline.append(airline)
		return self.airline
	
	def process_query(self, query_type, from_city, to_city, current_time):
		if query_type == 1: # earliest departure time from A to B?
			self.print_airline(self.get_earliest_departure(from_city, to_city, current_time))
		elif query_type == 2: # earliest arrival time from A to B?
			self.print_airline(self.get_earliest_arrival(from_city, to_city, current_time))
		elif query_type == 3: # shortest flight time from A to B?
			self.print_airline(self.get_shortest_flight(from_city, to_city, current_time))
		elif query_type == 4: # lowest cost to fly from A to B?
			self.print_airline(self.get_lowest_cost(from_city, to_city, current_time))
		return None
	
	def print_airline(self, airline):
		print "%s %s %s %s %s %s " % (airline.get_from_city(), airline.get_to_city(), 
									  airline.get_depart_time(), airline.get_arrival_day(),
									  airline.get_arrival_time(), airline.get_cost())
		return None

	def set_SGTime(self, current_time):
		hour, minute = current_time.split(':')
		hour = int(hour)
		minute = int(minute)
		time = SGTime(hour, minute)
		return time

	def get_earliest_departure(self, from_city, to_city, current_time):
		time = self.set_SGTime(current_time)

		diff = [None] * len(self.airline)
		for i in range(len(self.airline)):
			self.split_time(self.airline[i].get_depart_time())

			if self.airline[i].get_from_city() == from_city and self.airline[i].get_to_city() == to_city:
				if time.get_hour() >= depart_hour:
					break
				else:
					diff_hour = abs(depart_hour - int(time.get_hour())) + int(self.airline[i].get_arrival_day()) * 24
					diff_minute = diff_hour * 60 + abs(depart_minute - time.get_minute())
					diff[i] = diff_minute
		# find least time difference
		least = self.least_value(diff)
		return self.airline[diff.index(least)]

	def get_earliest_arrival(self, from_city, to_city, current_time):
		time = self.set_SGTime(current_time)

		diff = [None] * len(self.airline)
		for i in range(len(self.airline)):
			self.split_time(self.airline[i].get_arrival_time())

			if self.airline[i].get_from_city() == from_city and self.airline[i].get_to_city() == to_city:
				if time.get_hour() >= arrive_hour:
					break
				else:
					diff_hour = abs(arrive_hour - int(time.get_hour())) + int(self.airline[i].get_arrival_day()) * 24
					diff_minute = diff_hour * 60 + abs(arrive_minute - time.get_minute())
					diff[i] = diff_minute
		least = self.least_value(diff)
		return self.airline[diff.index(least)]

	def get_shortest_flight(self, from_city, to_city, current_time):
		diff = [None] * len(self.airline)
		for i in range(len(self.airline)):
			self.split_time(self.airline[i].get_depart_time())
			self.split_time(self.airline[i].get_arrival_time())

			if self.airline[i].get_from_city() == from_city and self.airline[i].get_to_city() == to_city:
				diff_hour = abs((arrive_hour + int(self.airline[i].get_arrival_day()) * 24) - depart_hour)
				diff_minute = (diff_hour * 60) + abs(60 - depart_minute + arrive_minute)
				diff[i] = diff_minute
		least = self.least_value(diff)
		return self.airline[diff.index(least)]

	def get_lowest_cost(self, from_city, to_city, current_time):
		diff = [None] * len(self.airline)		
		for i in range(len(self.airline)):
			if self.airline[i].get_from_city() == from_city and self.airline[i].get_to_city() == to_city:
				diff[i] = self.airline[i].get_cost()
		
		least = self.least_value(diff)
		return self.airline[diff.index(least)]

	def least_value(self, a_list):
		least = 0
		for i in range(len(a_list)):
			if a_list[i] == 0:
				continue
			else:
				if least == 0 or a_list[i] < least:
					least = a_list[i]
		return least

	def split_time(self, time):
		hour, minute = time.split(':')
		hour = int(hour)
		minute = int(minute)
		return None

airline_count = int(raw_input())
query = Query()
for i in range(airline_count):
	line = raw_input().split(' ')
	query.add_airline(Airline(line[0], line[1], line[2], line[3], line[4], line[5]))
	
query_count = int(raw_input())
for i in range(query_count):
	line = raw_input().split(' ')
	query.process_query(int(line[0]), line[1], line[2], line[3])

