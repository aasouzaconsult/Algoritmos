class Node(object):
    """

    Node for linked list object.

    """
    def __init__(self, data, prev=None, next=None):
        self.data = data
        self.prev = prev
        self.next = next


class LinkedList(object):
    """

    Implementation of a Doubly linked list.

    """
    def __init__(self, data):
        self.head = Node(data)

    def search(self, data):
        """

        Search for data in linked list.

        """
        curr = self.head
        while curr is not None and curr.data != data:
            curr = curr.next
        return curr

    def last_node(self):
        """

        Return the last node in the linked list.

        """
        curr = self.head
        while curr.next is not None:
            curr = curr.next
        return curr

    def insert(self, data):
        """

        Insert data into linked list.

        """
        new_node = Node(data)
        last_node = self.last_node()
        last_node.next = new_node
        new_node.prev = last_node
        return

    def delete(self, data):
        """

        Delete data from the linked list.

        """
        curr = self.search(data)
        if curr is None:
            # data not found in list.
            return
        curr.prev.next = curr.next
        curr.next.prev = curr.prev
        curr = None
        return data

    def print_linkedlist(self):
        curr = self.head
        while curr is not None:
            print curr.data
            curr = curr.next
        return

if __name__ == "__main__":
    test = LinkedList(1)
    test.insert(2)
    test.insert(3)
    test.insert(4)

    test.delete(3)
    test.print_linkedlist()
