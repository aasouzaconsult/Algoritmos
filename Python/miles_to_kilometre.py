##################################
### Title: Miles to Kilometre ####
### Author: GuoChen Hou   ########
##################################

# Converts distance in miles to kilometres


class _const:
	"""Define a private class _const to store constants and prevents attempts to rebind constants in the class"""
	class ConstError(TypeError): pass

	def __setattr__(self, name, value):
		if self.__dict__.has_key(name):
			raise self.ConstError, "Can't rebind const(%s)" % name

		self.__dict__[name] = value

KMS_PER_MILE = 1.609
miles = float(raw_input('Enter distance in miles: '))
kilometre = KMS_PER_MILE * miles
print _const.__setattr__
print '%.3f miles equates to %.3f kilometre.' % (miles, kilometre)