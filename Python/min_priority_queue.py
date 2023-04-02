# min_priority_queue supports the following operations
# insert(value): insert value into the priority queue
# min(): return the elemtn of the queue with the lowest priority
# extract_min(): removes and return the element in the queue with the lowest
# priority


def min_heapify(a_list, i):
    # left child index
    left = 2*i + 1
    # right child index
    right = 2*i + 2

    smallest_index = i
    if left < len(a_list) and a_list[left] < a_list[smallest_index]:
        smallest_index = left
    if right < len(a_list) and a_list[left] < a_list[smallest_index]:
        if a_list[right] < a_list[left]:
            # right child smallest
            smallest_index = right
    if smallest_index != i:
        a_list[i], a_list[smallest_index] = a_list[smallest_index], a_list[i]
        return min_heapify(a_list, smallest_index)
    return a_list


def build_min_heap(a_list):
    """
    Build a min heap from given list.

    """
    for i in range(len(a_list/2), -1, -1):
        min_heapify(a_list, i)
    return a_list


class MinPriorityQueue(object):
    """
    A min priority queue implemented with a min heap data structure.

    """
    def __init__(self, a_list=None):
        if a_list is None:
            self.heap = []
        else:
            self.heap = build_min_heap(a_list)

    def insert(self, value):
        self.heap.append(value)
        return build_min_heap(self.heap)

    def min_value(self):
        return self.heap[0]

    def extract_min_value(self):
        self.heap[0], self.heap[len(self.heap)-1] = self.heap[len(self.heap)-1], self.heap[0]
        value = self.heap.pop()
        build_min_heap(self.heap)
        return value

if __name__ == "__main__":
    test_list = [4, 1, 3, 2, 16, 9, 10, 14, 8, 7]
    min_queue = MinPriorityQueue(test_list)
    print min_queue.heap
    print min_queue.insert(11)
    print min_queue.extract_min_value()
    print min_queue.heap
