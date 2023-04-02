class Node(object):
    def __init__(self, data):
        self.data = data
        self.next = None

    def get_data(self):
        return self.data


class LinkedList(object):
    def __init__(self, data):
        self.head = Node(data)

    def insert(self, data):
        node = Node(data)
        node.next = self.head
        self.head = node

    def delete(self, data):
        prev, node = self._prev_node_set(data)
        if node is None:
            return
        elif node == self.head:
            self.head = self.head.next
        else:
            prev.next = node.next
        node = None
        return

    def _prev_node_set(self, data):
        prev = None
        trav = self.head
        while trav is not None:
            if trav.data == data:
                return prev, trav
            else:
                prev = trav
                trav = trav.next
        return None, None

    def search(self, data):
        trav = self.head
        while trav is not None:
            if trav.data == data:
                return trav.data
            trav = trav.next
        return

    def get_list(self):
        items = []
        trav = self.head
        while trav is not None:
            items.append(trav.data)
            trav = trav.next
        return items

    def print_list(self):
        trav = self.head
        while trav is not None:
            print trav.data,
            trav = trav.next
        print ""
        return

if __name__ == "__main__":
    test = LinkedList(0)
    test.insert(1)
    test.insert(2)
    test.insert(3)
    test.insert(4)
    print test.search(2)
    print test.search(3)
    print test.search(0)
    test.print_list()
    test.delete(2)
    test.print_list()
    test.delete(2)
    test.print_list()
    test.delete(4)
    test.print_list()
