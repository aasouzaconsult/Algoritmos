class BinaryMaxHeap(object):
    """
    BinaryMaxHeap class implements binary maxheap data structure represented
    using a list structure.
    """

    def __init__(self):
        """
        Initialize heap list structure.
        """

        self.heap = []

    def largest(self):
        """
        @return: largest value in the heap.
        """

        return self.heap[0]

    def insert(self, value):
        """
        Insert the value into heap structure and return the heap.
        """

        # add value into heap list
        self.heap.append(value)

        if len(self.heap) is 1:
            return self.heap

        # get index of where value is at
        value_index = len(self.heap) - 1

        if value_index % 2 is 0:  # value added as a right child
            parent_index = (value_index - 1) / 2
        else:  # value added as a left child
            parent_index = value_index / 2

        # when value has not reached root and value is bigger than its parent
        while value_index > 0 and value > self.heap[parent_index]:
            # move parent value down to replace its child
            self.heap[value_index] = self.heap[parent_index]

            # set the new parent index
            if value_index % 2 is 0:
                value_index = (value_index - 1) / 2
                parent_index = (value_index - 1) / 2
            else:
                value_index = value_index / 2
                parent_index = value_index / 2
        # insert value into its rightful position
        self.heap[value_index] = value
        return self.heap

    def delete(self):
        """
        Deletes the root item from the heap and replace root with the next
        biggest value.

        @return: root item that is removed. return -1 if heap is empty.
        """

        if len(self.heap) is not 0:
            value = self.heap[0]
            # move last element to root
            self.heap[0] = self.heap[-1]
            self.heap.pop()  # remove
            self.sift_down(0)
            return value
        else:
            # heap is empty
            return -1

    def sift_down(self, pos):
        """
        self.heap represents a heap structure indexed from 1 to n.
        The left and right subtrees of node at index 'pos' are heaps. After
        sift_down is called, the subtree rooted at 'pos' is a heap.
        """

        temp = self.heap[pos]
        last_index = len(self.heap) - 1

        # tests for a left child
        while (2 * pos + 1) <= last_index:
            child_index = 2 * pos + 1

            # if there's a right child bigger than the left child,
            # set right as child_index
            if child_index < last_index and self.heap[child_index+1] > self.heap[child_index]:
                child_index += 1

            # move child value up if bigger than value at pos
            if self.heap[child_index] > temp:
                self.heap[pos] = self.heap[child_index]
            else:
                break  # heap structure is maintained
            pos = child_index
        # insert original pos value into its right spot
        self.heap[pos] = temp

    def print_heap(self):
        """
        Print heap which is a list.
        """

        print self.heap
        return

    def heapify(self):
        """
        Rearranges the data in heap, so it represents a heap structure.
        """

        last_index = len(self.heap) - 1
        if last_index % 2 is 0:  # last element is a right child
            parent_index = (last_index - 1) / 2
        else:  # last element is left child
            parent_index = last_index / 2

        for i in range(parent_index, 0, -1):  # root has index 0, it has no parent
            self.sift_down(i)


if __name__ == "__main__":
    test_heap = BinaryMaxHeap()
    test_heap.insert(100)
    test_heap.insert(25)
    test_heap.insert(19)
    test_heap.insert(17)
    test_heap.insert(36)
    test_heap.insert(7)
    test_heap.insert(3)
    test_heap.insert(1)
    test_heap.insert(2)
    test_heap.print_heap()
    test_heap.delete()
    test_heap.print_heap()
    test_heap.delete()
    test_heap.print_heap()
