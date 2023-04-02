class Node(object):
    """
    Node structure for doubly linked list object.

    """
    def __init__(self, data=None, prev=None, next=None):
        self.data = data
        self.prev = prev
        self.next = next


class DoubleLinkedList(object):
    """

    Double linked list with Node object strucure.
    Double linked list complexity:
    [method]: [average case], [worst case]
    access: O(n), O(n)
    search: O(n), O(n)
    insertion: O(1), O(1)
    deletion: O(n), O(n)
    """
    def __init__(self, data=None, prev=None, next=None):
        self.head = Node(data, prev, next)
        self.last = self.head

    def insert(self, data):
        node = Node(data)
        self.last.next = node
        node.prev = self.last
        self.last = node
        return

    def delete(self, data):
        curr = self.head
        while curr is not None:
            if curr.data == data:
                if curr != self.last:
                    curr.prev.next = curr.next
                    curr.next.prev = curr.prev
                else:
                    curr.prev.next = None
                    self.last = curr.prev
                curr = None
                break
            curr = curr.next
        return self.head

    def search(self, data):
        curr = self.head
        while curr is not None:
            if curr.data == data:
                return curr
            curr = curr.next
        return None

    def print_list(self):
        curr = self.head
        while curr is not None:
            print curr.data,
            curr = curr.next
        return

if __name__ == "__main__":
    test = DoubleLinkedList(1)
    test.insert(2)
    test.insert(3)
    test.insert(4)
    test.insert(5)
    test.print_list()
    print "\n"
    test.delete(2)
    test.print_list()
    print "\n"
    test.delete(3)
    test.print_list()
    print "\n"
    test.delete(4)
    test.print_list()
    print "\n"
