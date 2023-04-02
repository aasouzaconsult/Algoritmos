Please use this Google doc to code during your interview. To free your hands for coding, we recommend that you use a headset or a phone with speaker option.

hot = there is a 24 hr period during which no other image has received more likes (during that period)
# image1: 500
# image2: 400
#..
#
# Yesterday:
# image1: 0
# image2: 400
# ...
#
# one year ago exactly:
# image1: 500
# image2: 0
# ...
#

# one week ago:
# image_a: 100
# image_b: 100
# all else: 0

# day1:
# image_a: 100
# image_b: 50

# day2:
# image_a: 40
# image_b: 80

# return image_a, image_b, ...

Which images are "hot"?

input data: chronological list of likes
eg. [(like_object1), (like_object2)]
class Like:

  image  # string
  liker  # int
  time  # timestamp - datetime object

# emphasis: chronologically ordered
likes = [like1, like2, etc...]
like1.time <= like2.time
# within the same timeframe, the “hot” object must have the highest number of likes.

hey, Gary? trying to call now.... Yeah, I'm trying to dial that, but I'm not getting through. Let me try again... DO you have another phone? Sure.
Try 510 473 5924. Are you calling?


hi this is gary. My number is 415-812-2043. Shall we try skype if this doesn’t work? No :(
Shall i try to call you instead?
------
# likes = [like1, like2, etc...]
# [image1, image2]
import datetime

def hot_images(like_list):
    “””
    return a list of the image strings that are hot.
“””

histogram = {}  # image_string: likes
# define 24 hour periods
period = datetime.timedelta(24*60*60)
first_timestamp = like_list[0].get_time()  # return the time
    # new time <= first_timestamp + period
# traverse the like list
#   input the like into its relevant key in histogram
# my histogram to output all key of the highest likes within 24 hour period
temp = {}
for i in xrange(1, like_list):
    if like_list[i].time <= first_timestamp + period:
        if like_list[i].image in histogram:
            temp[like_list[i].image] += 1
        else:
            temp[like_list[i].image] = 1
    else:
        # out of the prev time period
        # unload temp elements into histogram
        #   check if temp[image] exist in histogram:
        #       put image and temp[image] into histogram
        #   check if temp[image] > histogram[image]
        #       put image and temp[image] into histogram
        # init temp hash table again
    temp = {}
# 2nd filter
# iterate through the histogram
#   compare like_obj.time with current list time
#   put into a list

# return list
