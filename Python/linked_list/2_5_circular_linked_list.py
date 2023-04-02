class Node(object):
    def __init__(self, data):
        self.data = data
        self.next = self


class CircularLinkedList(object):
    def __init__(self, data):
        self.head = Node(data)
        self.last = self.head

    def get_head(self):
        return self.last.next

    def insert(self, data):
        node = Node(data)
        curr = self.head
        while curr.next is not self.head:
            curr = curr.next
        curr.next = node
        node.next = self.head
        self.last = node
        return

    def delete(self, data):
        if self.head.data == data:
            self.last.next = self.head.next
            self.head = self.head.next
        prev, node = self.lookup(data)
        if node is None:
            return None
        if node is self.last:
            self.last = prev
        if prev is not None:
            prev.next = node.next
            node = None
        return

    def lookup(self, data):
        curr = self.head
        if curr.data == data:
            return self.last, curr
        while curr.next is not self.last:
            if curr.next.data == data:
                return curr, curr.next
            curr = curr.next
        if self.last.data == data:
            return curr, self.last
        return None, None

    def print_list(self):
        curr = self.head
        while curr.next is not self.head:
            print curr.data,
            curr = curr.next
        print curr.data,
        return

if __name__ == "__main__":
    test = CircularLinkedList(1)
    test.insert(2)
    test.insert(3)
    test.insert(4)
    test.insert(5)
    test.print_list()
    print test.lookup(1)
    print test.lookup(2)
    print test.lookup(3)
    print test.lookup(4)
    print test.lookup(5)
    test.delete(1)
    test.delete(3)
    test.delete(5)
    test.print_list()
