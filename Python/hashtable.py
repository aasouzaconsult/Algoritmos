class HashTable(object):
    def __init__(self, size):
        self.size = size
        self.slots = [None for _ in xrange(self.size)]
        self.data = [None for _ in xrange(self.size)]

    def insert(self, key, data):
        hash_value = self.hash(key, len(self.slots))

        if self.slots[hash_value] is None:
            self.slots[hash_value] = key
            self.data[hash_value] = data
        else:
            if self.slots[hash_value] == key:
                # replacing with new data
                self.data[hash_value] = data
            else:
                while True:
                    next = self.rehash(next, len(self.slots))
                    if self.slots[next] is None or self.slots[next] == key:
                        break
                if self.slots[next] is None:
                    self.slots[next] = key
                    self.data[next] = data
                else:
                    # replace with new data
                    self.data[next] = data

    def search(self, key):
        start = self.hash(key, len(self.slots))
        data = None
        pos = start
        while self.slots[pos] is not None:
            if self.slots[pos] == key:
                data = self.data[pos]
                break
            else:
                pos = self.rehash(pos, len(self.slots))
                if pos == start:
                    break
        return data

    def hash(self, key, size):
        return key % size

    def rehash(self, old_hash, size):
        """Linear probing"""
        return (old_hash+1) % size


class Table(object):
    """

    Implementation of Hash table.

    """
    def __init__(self):
        self.table = [0 for _ in xrange(11)]

    def insert(self, value):
        self.table[self.hashcode(value)] = [self.hashcode(value), value]

    def hashcode(self, value):
        return value % len(self.table)

    def search(self, value):
        return self.table[self.hashcode(value)]

    def delete(self, value):
        return self.table.pop(self.hashcode(value))

    """
    def hash(string):
        Hashing using ordinal values of characters
        total = 0
        i = 1
        for pos in string:
            total += ord(pos) * i
            i += 1
        return total % len(self.table)
    """
if __name__ == "__main__":
    table = Table()
    table.insert(15)
    table.insert(14)
    table.insert(13)
    table.insert(43)
    print table.search(14)
    print table.delete(13)
    print table.table
