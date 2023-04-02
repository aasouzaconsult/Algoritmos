from ADT.LinkedList import LinkedList


class UniqueLinkedList(LinkedList):
    """
    A UniqueLinkedList ensures data in the linked list is unique.
    """

    def remove_duplicates(self):
        """
        Removes all duplicate data from the linked list.
        """

        if self.size is 0:
            return
        ptr1 = self.head

        # Outer loop is used to pick the elements one by one and inner loop
        # compares the picked element with the rest of the element.
        while ptr1 is not None and ptr1.next is not None:
            ptr2 = ptr1

            # compare picked element with rest of the elements
            while ptr2.next is not None:
                # if duplicate, then delete it
                if ptr1.data is ptr2.next.data:
                    ptr2.next = ptr2.next.next
                else:
                    ptr2 = ptr2.next
            ptr1 = ptr1.next

if __name__ == "__main__":
    test = UniqueLinkedList()
    test.insert(1)
    test.insert(2)
    test.insert(3)
    test.insert(1)
    test.print_list()
    test.remove_duplicates()
    test.print_list()
