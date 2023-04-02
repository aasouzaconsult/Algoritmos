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
