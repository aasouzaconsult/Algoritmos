def greedy_coin_change(denom, change):
	i = 0
	while change > 0:
		num = change / denom[i]
		print "Use %d coins of denomination %d." % (num, denom[i])
		change -= num * denom[i]
		i += 1



if __name__ == "__main__":
	denom = [10,5,1]
	greedy_coin_change(denom, 78)