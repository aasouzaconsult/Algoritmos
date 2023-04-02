class minHeap(object):
    def __init__(self):
        self.heap = []

    def smallest(self):
        return self.heap[0]

    def insert(self, value):
        self.heap.append(value)
        index = len(self.heap)-1
        self.bubble_up(index)
        return

    def bubble_up(self, index):
        while True:
            parent = self.parent_index(index)
            if parent == -1:
                break
            elif self.heap[index] >= self.heap[parent]:
                break
            self.heap[index], self.heap[parent] = self.heap[parent], self.heap[index]
            index = parent
        return

    def remove(self):
        if self.heap == []:
            return
        self.heap[0], self.heap[-1] = self.heap[-1], self.heap[0]
        result = self.heap.pop()
        self.bubble_down(0)
        return result

    @static
    def bubble_down(self, index):
        left_index = self.left_child_index(index)
        right_index = self.right_child_index(index)
        smallest = index
        if left_index < len(self.heap) and self.heap[left_index] < self.heap[smallest]:
            smallest = left_index
        if right_index < len(self.heap) and self.heap[right_index] < self.heap[smallest]:
            smallest = right_index
        if smallest != index:
            self.heap[index], self.heap[smallest] = self.heap[smallest], self.heap[index]
            return self.bubble_down(smallest)
        return

    def parent_index(self, index):
        if index == 0:
            return -1
        else:
            if index % 2 == 0:
                return (index-2)/2
            else:
                return (index-1)/2

    def left_child_index(self, index):
        return 2 * index + 1

    def right_child_index(self, index):
        return 2 * index + 2


def min_heapify(a_list):
    """Build a min heap from given list"""
    for i in xrange(len(a_list)/2, -1, -1):
        minHeap.bubble_down(a_list, i)
    return a_list

if __name__ == "__main__":
    test_list = [30, 2, 3, 17, 19, 36, 7, 25, 100, 1]
    min_heap = minHeap()
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
    min_heap.heap
    print min_heap.remove()
    print min_heap.remove()
    print min_heap.remove()
    print min_heap.remove()
    print min_heap.remove()
    print min_heap.remove()
    print min_heap.remove()
    print min_heap.remove()
    print min_heap.remove()
    print min_heap.remove()
