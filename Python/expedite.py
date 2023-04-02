# Parsing an API response
#
# Suppose you are calling a JSON API that responds to requests using a nested
# dictionary, where the values are either other dictionaries, or strings, with no other
# possible options.
#
# Given a list of keys, write a method that traverses the dictionary to return
# the string stored at the terminal key in the sequence.


def parse(dictionary, keys):
  for i in range(len(keys)):
    if keys[i] in dictionary.keys():
      dictionary = dictionary[keys[i]]
  return dictionary

input = {
  "k1": "v1",
  "k2": {
    "k21": "v21",
    "k22": {
      "k221": "v221"
    }
  },
  "k3": {
    "k31": "v31"
  }
}

output = parse(input, ["k2", "k22", "k221"])
if (output == "v221"):
  print "Success!"
else:
  print "Output '{}' did not match 'v221'".format(output)

