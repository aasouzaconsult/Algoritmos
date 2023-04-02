##################################
### Title: Packing        ########
### Author: GuoChen Hou   ########
##################################

# Given a rectangle tray and an unlimited supply of slabs. Calculate the maximum number of slabs that can fit into the rectangular 
# tray, in a single orientation only.

def compute_max_slabs(tray_length, tray_breadth, slab_length, slab_breadth):

	length_slabs = int(tray_length / slab_length)
	breadth_slabs = int(tray_breadth / slab_breadth)
	
	remain_length = tray_length - (length_slabs * slab_length)
	remain_breadth_slab = 0

	remain_breadth = tray_breadth - (breadth_slabs * slab_breadth)
	remain_length_slab = 0

	if remain_length >= slab_breadth:
		if tray_breadth >= slab_length:
			remain_breadth_slab = int(remain_length / slab_breadth)
	if remain_breadth >= slab_length:
		if tray_length >= slab_length:
			remain_length_slab = int(remain_breadth / slab_length)
	return length_slabs * breadth_slabs +remain_breadth_slab + remain_length_slab

t_length, t_breadth = raw_input('Enter dimensions of tray: ').split()
s_length, s_breadth = raw_input('Enter dimensions of tray: ').split()

if t_breadth > t_length:
	temp = t_length
	t_length = t_breadth
	t_breadth = temp
if s_breadth > s_length:
	temp = s_length
	s_length = s_breadth
	s_breadth = temp

tray_length = int(t_length)
tray_breadth = int(t_breadth)
slab_length = int(s_length)
slab_breadth = int(s_breadth)

length_base_slab_number = compute_max_slabs(tray_length, tray_breadth, slab_length, slab_breadth)
breadth_base_slab_number = compute_max_slabs(tray_length, tray_breadth, slab_breadth, slab_length)
print length_base_slab_number
print breadth_base_slab_number
if length_base_slab_number > breadth_base_slab_number:
	print 'Maximum number of slabs =', length_base_slab_number
else:
	print 'Maximum number of slabs =', breadth_base_slab_number
