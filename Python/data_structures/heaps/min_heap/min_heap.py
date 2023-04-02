class MinHeap(object):
    """

    Implementation of min heap with list data structure.
    Operations:
    insert(value)
    delete(value)
    sift_down(value)

    Linked list complexity:
    [method]: [worst case]
    smallest: O(1)
    insert: O(log n)
    delete: O(log n)

    """
    def __init__(self, heap=list()):
        self.heap = heap

    def smallest(self):
        """

        Return the smallest value in the heap.

        """
        return self.heap[0]

    def insert(self, value):
        """

        Insert value into the minheap structure and return the heap.

        """
        if len(self.heap) < 1:
            self.heap.append(value)
            return
        self.heap.append(value)
        # exchange top element with new value
        self.heap[0], self.heap[-1] = self.heap[-1], self.heap[0]
        # maintain min heap
        self.heap = min_heapify(self.heap)
        return

    def remove(self):
        """

        Remove the root(item with the smallest value) from heap.
        Return the removed value.

        """
        # move last element to first position and vice versa
        self.heap[0], self.heap[-1] = self.heap[-1], self. heap[0]
        value = self.heap.pop()
        # maintain min heap
        self.heap = min_heapify(self.heap)
        return value

    def left_child_index(self, index):
        """

        Return the left child index of index element.

        """
        return 2*index + 1

    def right_child_index(self, index):
        """

        Return the right child index of index element.

        """
        return 2*index + 2

    def parent_index(self, index):
        """

        Return the parent index of index element.

        """
        return int(index/2)


def sift_down(heap, index):
    """

    sift_down assumes that binary trees rooted at left and right of index
    element are min heaps. but heap[index] might be smaller than it's children,
    thus violating the min heap property. sift_down lets the value float down
    in the min heap so that the subtree rooted at index obeys the min heap
    property.

    """
    left = 2*index + 1
    right = 2*index + 2
    smallest = index
    if left < len(heap) and heap[left] < heap[smallest]:
        smallest = left
    if right < len(heap) and heap[right] < heap[smallest]:
        # right child smallest
        smallest = right
    if smallest != index:
        heap[index], heap[smallest] = heap[smallest], heap[index]
        return sift_down(heap, smallest)
    return heap


def min_heapify(a_list):
    """

    Build a min heap from a given list.
    O(n lgn)

    """
    for i in range(len(a_list)/2, -1, -1):
        sift_down(a_list, i)
    return a_list

if __name__ == "__main__":
    test_list = [30, 2, 3, 17, 19, 36, 7, 25, 100, 1]
    print sift_down(test_list, 0)
    print min_heapify(test_list)

    min_heap = MinHeap()
    min_heap.insert(30)
    min_heap.insert(2)
    min_heap.insert(3)
    min_heap.insert(17)
    min_heap.insert(19)
    min_heap.insert(36)
    min_heap.insert(7)
    min_heap.insert(25)
    min_heap.insert(100)
    min_heap.insert(1)
    print min_heap.heap
    min_heap.remove()
    print min_heap.heap
