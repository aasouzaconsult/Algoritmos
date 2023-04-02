#There is a secret string which is unknown to you. Given a collection of random
#triplets from the string, recover the original string.

#A triplet here is defined as a sequence of three letters such that each letter
#occurs somewhere before the next in the given string. "whi" is a triplet for
#the string "whatisup".

#As a simplification, you may assume that no letter occurs more than once in the
#secret string.

#You can assume nothing about the triplets given to you other than that they are
#valid triplets and that they contain sufficient information to deduce the
#original string. In particular, this means that the secret string will never
#contain letters that do not occur in one of the triplets given to you.


def recoverSecret(triplets):
  'triplets is a list of triplets from the secrent string. Return the string.'
  items = set([])
  print triplets
  for item in triplets:
      items |= set(item)
  result = triplets[0]
  for i in xrange(1, len(triplets)):
      for j in xrange(len(triplets[i])-1):
          if triplets[i][j] not in result:
              result.append(triplets[i][j])
          else:
              value_index = result.index(triplets[i][j])
              if triplets[i][j-1] not in result[:value_index] and j >= 1:
                  if triplets[i][j-1] not in result[value_index+1:]:
                      result = result[:value_index] + [triplets[i][j-1]] + result[value_index:]
                  else:
                      result.pop()
                      result = result[:value_index] + [triplets[i][j-1]] + result[value_index:]

              if triplets[i][j+1] not in result[value_index+1:]:
                  if triplets[i][j+1] not in result[:value_index]:
                      result = result[:value_index+1] + [triplets[i][j+1]] + result[value_index+1:]
                  else:
                      value = result.pop(value_index)
                      result = result[:result.index(triplets[i][j+1])] + [value] + result[result.index(triplets[i][j+1]):]
      if triplets[i][-1] not in result:
          result.append(triplets[i][-1])
  return "".join(map(str, result))


if __name__ == "__main__":

  secret = "whatisup"
  triplets = [
    ['t','u','p'],
    ['w','h','i'],
    ['t','s','u'],
    ['a','t','s'],
    ['h','a','p'],
    ['t','i','s'],
    ['w','h','s']
  ]

  test.assert_equals(recoverSecret(triplets), secret)
1, 2, 4, 8, 16
  [i*i for i in xrange(1, 11)]

def xrange(num1, num2):
  i = num1
  while i < num2:
    yield i
    i += 1