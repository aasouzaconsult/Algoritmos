class Node(object):
    """

    Node structure for linked list object.

    """
    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next


class LinkedList(object):
    """

    Linked list implementation with node object structure.
    Linked list complexity:
    [method]: [average case], [worst case]
    access: O(n), O(n)
    search: O(n), O(n)
    insertion: O(1), O(1)
    deletion: O(n), O(n)
    """
    def __init__(self, data):
        self.head = Node(data)
        self.last = self.head

    def insert(self, data):
        node = Node(data)
        self.last.next = node
        self.last = node
        return

    def delete(self, data):
        curr = self.head
        prev = self.head
        while curr is not None:
            if curr.data == data:
                prev.next = curr.next
                return self.head
            prev = curr
            curr = curr.next
        return None

    def search(self, data):
        """

        Return the node with data if found, else return None.

        """
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
    test = LinkedList(1)
    test.insert(2)
    test.insert(3)
    test.insert(4)
    test.print_list()
    print "\n"
    test.delete(2)
    test.print_list()
    print "\n"
    test.delete(3)
    test.print_list()
    print "\n"
    test.delete(5)
    test.print_list()
