HASH_TABLE_SIZE = 32
HASH_PRIME = 13


class HashTable(object):
    """

    Implementation of a hash table using a 2d list structure to store english
    words.

    """
    def __init__(self):
        self.hash_table = [[] for i in range(HASH_TABLE_SIZE)]

    @staticmethod
    def calculate_index(a_string):
        """

        Calculate the index of a_string parameter in the hash table.

        """
        total = 0
        for alphabet in a_string:
            total += ord(alphabet)
        total *= HASH_PRIME
        return total % (HASH_TABLE_SIZE-1)

    def insert(self, a_string):
        """

        Insert a_string into the hash table.

        """
        index = self.calculate_index(a_string)
        self.hash_table[index].extend([a_string])
        return self.hash_table

    def lookup(self, key):
        """

        Lookup the hash table with key and return all the values associated
        with the key.

        """
        return self.hash_table[key]

    def delete(self, a_string):
        """

        Delete a_string parameter at hash table and return the hash table.
        Return None if a_string is not in hash table.

        """
        index = self.calculate_index(a_string)
        print index
        if len(self.hash_table[index]) < 1:
            return None
        for i in range(len(self.hash_table[index])):
            if self.hash_table[index][i] == a_string:
                self.hash_table[index].pop(i)
                return self.hash_table
        return None

    def print_table(self):
        print self.hash_table


if __name__ == "__main__":
    test = HashTable()
    test.print_table()
    test.insert('apple')
    test.insert('pear')
    test.insert('paple')
    test.print_table()
    print test.lookup(3)
    print test.delete('paple')
