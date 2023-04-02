# Construct a linked list.


class Node(object):
    """

    Node structure for linked list.

    """
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList(object):
    """

    Linked list data structure.

    """
    def __init__(self, data):
        self.head = Node(data)

    def get_head(self):
        return self.head

    def insert(self, data):
        node = Node(data)
        curr = self.head
        while curr.next is not None:
            curr = curr.next
        curr.next = node
        return

    def delete(self, data):
        """

        Delete data node from linked list. Return None if data not in linked
        list.

        """
        if self.head.data == data:
            self.head = self.head.next
            return
        prev, curr = self.lookup(data)
        if curr is None:
            raise AttributeError('Data node not found.')
        prev.next = curr.next
        curr = None
        return

    def delete_node(self, node):
        """

        Delete node from linked list. Return None if node is not in linked
        list.

        """
        curr = self.head
        while curr.next is not None:
            if curr.next == node:
                break
            curr = curr.next
        curr.next = node.next
        node = None
        return

    def lookup(self, data):
        curr = self.head
        while curr.next is not None:
            if curr.next.data == data:
                return curr, curr.next
            curr = curr.next
        return None, None

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
    print ""
    test.delete(3)
    test.print_list()
    print ""
    test.delete(1)
    test.print_list()
    print ""
    test.delete(4)
    test.print_list()
    print ""
