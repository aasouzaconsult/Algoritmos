# max_priority_queue supports the following operations
# insert(value): insert value into the priority queue
# max(): return the element of the queue with the highest priority
# extract_max(): removes and return the element in the queue with the highest
# priority


def max_heapify(a_list, i):
    # left child index
    left = 2 * i + 1
    # right child index
    right = 2*i + 2
    largest_index = i
    if left < len(a_list) and a_list[left] > a_list[largest_index]:
        largest_index = left
    if right < len(a_list) and a_list[right] > a_list[largest_index]:
        if a_list[right] > a_list[left]:
            # right child largest
            largest_index = right
    if largest_index != i:
        a_list[i], a_list[largest_index] = a_list[largest_index], a_list[i]
        return max_heapify(a_list, largest_index)
    return a_list


def build_max_heap(a_list):
    """
    Build a max heap from given list.

    """
    for i in range((len(a_list)/2), -1, -1):
        max_heapify(a_list, i)
    return a_list


class MaxPriorityQueue(object):
    """
    A max priority queue implemented with a max heap data structure.

    """
    def __init__(self, a_list=None):
        if a_list is None:
            self.heap = []
        else:
            self.heap = build_max_heap(a_list)

    def insert(self, value):
        self.heap.append(value)
        return build_max_heap(self.heap)

    def max_value(self):
        return self.heap[0]

    def extract_max_value(self):
        self.heap[0], self.heap[len(self.heap)-1] = self.heap[len(self.heap)-1], self.heap[0]
        value = self.heap.pop()
        build_max_heap(self.heap)
        return value


if __name__ == "__main__":
    test_list = [4, 1, 3, 2, 16, 9, 10, 14, 8, 7]
    max_queue = MaxPriorityQueue(test_list)
    print max_queue.heap
    print max_queue.insert(11)
    print max_queue.extract_max_value()
    print max_queue.heap
