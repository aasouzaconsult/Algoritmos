def matrix_product(matrix1, matrix2):
	"""
	This function computes the product of n X n matrices directly from the definition of the matrix product
	"""	
	result = [[0 for i in range(len(matrix1))] for i in range(len(matrix1))]
	for i in range(len(matrix1)):
		for k in range(len(matrix1)):			
			for j in range(len(matrix1)):
				result[i][j] += matrix1[i][k] * matrix2[k][j]
	return result

if __name__ == "__main__":
	#2d list declaration practices
	a = [[1],[2]]
	print a
	b = [[i*3+1, i*3+2, i*3+3] for i in range(3)]
	print b
	c = [[] for i in range(1)]*3
	c[0].append(1)
	print c
	
	d = [[3,1], [4,-1]]
	e = [[2,-5],[6,-3]]

	print matrix_product(d,e)
