##################################
###	Coin Change  #################
##################################

# Given coins of specific denominations, find the least amount of coins needed for a given amount
def dynamic_coin_change1(denom, change):
	"""
	Computes the minimum number of coins to make change for a given amount.
	The input is an array denom that specifies the denominations of the coins in descending order.
	Returns a 2d_list result whose value, result[i][j] is the minimum number of coins to make change for amount j.
	The first for loop runs in time O(change). The nested for loop run in time O(n change)
	Time complexity of algorithm is O(n change).
	"""
	change += 1 # 0 index offset
	result = [[None for i in range(change)] for j in range(len(denom))]
	for j in range(change):
		result[len(denom)-1][j] = j # initialize lowest denom value to to require same amt of coins as value of change.
	for i in range(len(denom)-2, -1, -1): # reverse iterate denom list
		for j in range(change):
			# if denom value bigger than change or lower result row on same column needs lesser coins than the above row,
			# result[i][j] is the same as its column value below
			# else result[i][j] is using the new denom coin + previous coin number in next row & same column below.
			if denom[i] > j or result[i+1][j] < 1 + result[i][j-denom[i]]:
				result[i][j] = result[i+1][j]
			else:
				result[i][j] = 1 + result[i][j-denom[i]]
	print result
	return result[0][change-1]

def dynamic_coin_change2(denom, change):
	"""
	Computes the minimum number of coins to make change for a given amount.
	The input is an array denom that specifies the denominations of the coins in descending order.
	Returns a 2d_list result whose value, result[i][j] is the minimum number of coins to make change for amount j.
	The 2d list used, stores True/False to indicate if the result[i] is being used to signify whether coin i appears in the smallest
	set of coins.
	"""
	change += 1 # 0 index offset
	result = [[None for i in range(change)] for j in range(len(denom))]
	used = [[None for i in range(change)] for j in range(len(denom))]
	for j in range(change):
		result[len(denom)-1][j] = j
		used[len(denom)-1][j] = True
	for i in range(len(denom)-2, -1, -1): # reverse iterate denom list
		for j in range(change):
			# if denom value bigger than change or lower result row on same column needs lesser coins than the above row,
			# result[i][j] is the same as its column value below
			# else result[i][j] is using the new denom coin + previous coin number in next row & same column below.
			if denom[i] > j or result[i+1][j] < 1 + result[i][j-denom[i]]:
				result[i][j] = result[i+1][j]
				used[i][j] = False
			else:
				result[i][j] = 1 + result[i][j-denom[i]]
				used[i][j] = True
	return result, used

def optimal_coins_set(index, change, denom, used):
	"""
	Outputs a minimum size set of coins to make change for an amount change using any coins in denom with denominations specified. 
	"""
	if change == 0:
		return
	if used[index][change]:
		print "Use a coin of denomination %d" % denom[index]
		optimal_coins_set(index, change-denom[index], denom, used)
	else:
		optimal_coins_set(index+1, change, denom, used)

if __name__ == "__main__":
	coins = [10,6,1]

	print "%d coins required to make change %d" % (dynamic_coin_change1(coins, 12), 12)
	print dynamic_coin_change2(coins, 12)
	used = dynamic_coin_change2(coins, 12)[1]
	optimal_coins_set(0, 12, coins, used)