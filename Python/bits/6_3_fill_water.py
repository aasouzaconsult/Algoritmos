# You have a five quart jug and a three quart jug, and an unlimited supply of
# water (but no measuring cups). How would you come up with exactly four quarts
# of water?
# NOTE: The jugs are oddly shaped, such that filling up exactly ‘half’ of the
# jug would be impossible.

# ASSUME WE HAVE A HOLDER CONTAINER
# Use 5 quart jug fill up 12 times. Now there are 60 quarts of water.
# Remove 8 quarts of water 7 times, each time using both 5 and 3 quart jug.
# Remaining water left is 4 quarts.

# WE DONT HAVE A HOLDER CONTAINER
# Fill 5 quart jug
# 5Q: 5, 3Q: 0
# Fill 3 quart with 5 quart's contents
# 5Q: 2, 3Q: 3
# Dump 3Q and add 5 quart remains to 3quart:
# 5Q: 0, 3Q: 2
# Fill 5 quart jug
# 5Q: 5, 3Q: 2
# Fill 3 quart with 5 quart
# 5Q: 4, 3Q: 3
# Now 5 quart jug have 4 quart water
