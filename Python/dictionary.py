# Implements a custom version of python dictionary


class KeyValue(object):
    """
    HashTable element structure.
    """

    def __init__(self, key, value):
        self._key = key
        self._value = value


class HashTable(object):
    """
    A hashtable of elements.
    """

    SIZE = 5003

    def __init__(self):
        self._list = [[] for i in range(self.SIZE)]

    def set(self, key, value):
        """
        Sets a key value object.
        """
        # initiate a new keyvalue instance
        # put instance in list
        hashed_key = self._hash(key)
        item = KeyValue(key, value)
        self._list[hashed_key].append(item)

    def get(self, key):
        """
        Gets the value of the given key.
        """

        hashed_key = self._hash(key)
        for i, j in enumerate(self._list[hashed_key]):
            if j._key is key:
                print "Value found."
                print "%s: %s" % (i, j._key)
                return j
        print "VALUE NOT FOUND!"
        return None

    def _hash(self, key):
        """
        Given a key, convert it to its equivalent hash value.
        """
        total = 0
        for letter in key:
            total += ord(letter)

        hashed_key = total % self.SIZE
        return hashed_key


if __name__ == "__main__":
    test = HashTable()
    test.set("apple", "an_apple")
    test.set("pear", "a_pear")
    test.get("apple")
    test.set("apple", "2 apples")
    test.get("apple")
    test.get("pear")
