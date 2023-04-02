from insertion_sort import insertion_sort

class Weighted_graph:
	"""
	Implement a weighted graph with a 2d list and a corresponding weight list
	Vertices are represented by elements(eg. 1,2,3) in the graph list and edges are represented by a list collection of each 2 vertices
	(eg. [1,2])
	"""
	edges = []
	weight = []
	vertices = []

	def __init__(self, edge_list, weight):
		self.edges.append(edge_list)
		self.weight.append(weight)

#### Private Methods ####	
	def __sort(self):
		"""
		Sorts both edges and weight lists in nondecreasing order of weight list elements
		"""	
		if len(self.edges) != len(self.weight):
			return
		for i in range(1, len(self.weight)):
			temp_weight = self.weight[i]
			temp_edge = self.edges[i]
			current = i - 1
			while current >= 0 and temp_weight < self.weight[current]:
				self.weight[current+1] = self.weight[current]
				self.edges[current+1] = self.edges[current]
				current -= 1
			self.weight[current+1] = temp_weight
			self.edges[current+1] = temp_edge

	def __makeset(self):
		"""
		Initialize each vertex to its own component
		"""
		for i in range(len(self.edges)):
			for j in range(len(self.edges[i])):				
				if self.edges[i][j] not in self.vertices:
					self.vertices.append(self.edges[i][j])
		
		for k in range(len(self.vertices)):
			self.vertices[k] = [self.vertices[k]]

	def __findset(self, vertex):
		"""
		Find and return the index to which vertex belongs in vertices list
		"""		
		for i in range(len(self.vertices)):
			for element in self.vertices[i]:
				if element == vertex:
					return i
		return None

	def __union(self, vertex1, vertex2):
		"""
		Joins 2 vertex together 		
		"""
		index1 = self.__findset(vertex1)
		index2 = self.__findset(vertex2)
		for element in self.vertices[index2]:
			self.vertices[index1].append(element)
		self.vertices.pop(index2)

#### Public Methods ####
	def add(self, edge_list, weight):
		"""
		Add an edge(defined by 2 vertices in a list) and its corresponding weight to edges
		"""
		self.edges.append(edge_list)
		self.weight.append(weight)

	def kruskal(self):
		self.__sort()
		self.__makeset()
		count, i = 0, 0		
		while len(self.vertices) > 1:
			if self.__findset(self.edges[i][0]) != self.__findset(self.edges[i][1]):
				print "(%d %d) edge selected." % (self.edges[i][0], self.edges[i][1])
				count += 1
				self.__union(self.edges[i][0], self.edges[i][1])
			i += 1

	def print_graph(self):
		"""
		Print each set of edges in a graph and its corresponding edges
		"""
		print self.edges
		print self.weight
		print self.vertices

def print_attributes(obj):
	"""
	Trverses the items in the object's dictionary and prints each attribute name to its corresponding value
	"""	
	for attr in obj.__dict__:
		print attr, getattr(obj, attr)

def find_defining_class(obj, method_name):
	"""
	Uses the method resolution method(MRO) to get the list of class objects(types) that will be searched for methods.
	Return the class to which the method 'method_name' belong to.
	"""
	for origin in type(obj).mro():
		if method_name in origin.__dict__:
			return origin

if __name__ == "__main__":
	test_graph = Weighted_graph([1,2], 4)
	test_graph.add([1,3], 2)
	test_graph.add([1,5], 3)
	test_graph.add([2,4], 5)
	test_graph.add([3,4], 1)
	test_graph.add([3,5], 6)
	test_graph.add([3,6], 3)
	test_graph.add([4,6], 6)
	test_graph.add([5,6], 2)
	test_graph.kruskal()
	test_graph.print_graph()