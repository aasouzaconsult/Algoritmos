class MaxHeap(object):
    """

    Implementation of max heap with list data structure.
    Operations:
    insert(value)
    delete(value)
    sift_down(value)

    Linked list complexity:
    [method]: [worst case]
    largest: O(1)
    insert: O(log n)
    delete: O(log n)

    """
    def __init__(self, heap=list()):
        self.heap = heap

    def largest(self):
        """

        Return the largest value in the heap.

        """
        return self.heap[0]

    def insert(self, value):
        """

        Insert value into the maxheap structure and return the heap.

        """
        if len(self.heap) < 1:
            self.heap.append(value)
            return
        self.heap.append(value)
        # exchange top element with new value
        self.heap[0], self.heap[-1] = self.heap[-1], self.heap[0]
        #maintain max heap
        self.heap = max_heapify(self.heap)
        return

    def remove(self):
        """

        Remove the root(item with the largest value) from heap.
        Return the removed value.

        """
        # move last element to first position and vice versa
        self.heap[0], self.heap[-1] = self.heap[-1], self.heap[0]
        value = self.heap.pop()
        # maintain max heap
        self.heap = max_heapify(self.heap)
        return value

    def left_child_index(self, index):
        return 2*index + 1

    def right_child_index(self, index):
        return 2*index + 2

    def parent_index(self, index):
        return int(index/2)


def sift_down(heap, index):
    """

    sift_down assumes that binary trees rooted at left and right of index
    element are max heaps. but heap[index] might be smaller than it's children,
    thus violating the max heap property. sift_down lets the value float down
    in the max heap so that the subtree rooted at index obeys the max heap
    property.

    """
    left = 2*index + 1
    right = 2*index + 2
    largest = index
    if left < len(heap) and heap[left] > heap[largest]:
        largest = left
    if right < len(heap) and heap[right] > heap[largest]:
        # right child largest
        largest = right
    if largest != index:
        heap[index], heap[largest] = heap[largest], heap[index]
        return sift_down(heap, largest)
    return heap


def max_heapify(a_list):
    """

    Build a max heap from a given list.
    O(n lgn)

    """
    for i in range(len(a_list)/2, -1, -1):
        sift_down(a_list, i)
    return a_list


if __name__ == "__main__":
    test_list = [7, 19, 36, 17, 3, 25, 1, 2, 100]
    print max_heapify(test_list)

    max_heap = MaxHeap()
    max_heap.insert(7)
    max_heap.insert(19)
    max_heap.insert(36)
    max_heap.insert(17)
    max_heap.insert(3)
    max_heap.insert(25)
    max_heap.insert(1)
    max_heap.insert(2)
    max_heap.insert(100)
    print max_heap.heap
    max_heap.remove()
    print max_heap.heap
    max_heap.remove()
    print max_heap.heap
