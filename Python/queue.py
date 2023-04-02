import unittest


class Queue(object):
    """
    Implementation of a queue with list. FIFO
    enqueue(value)
    dequeue()

    """
    def __init__(self, queue=list()):
        self.queue = queue

    def is_empty(self):
        if len(self.queue) < 1:
            return True
        return False

    def enqueue(self, value):
        self.queue.append(value)
        return

    def dequeue(self):
        if self.is_empty():
            return
        return self.queue.pop(0)

    def print_queue(self):
        print self.queue


class QueueTestCase(unittest.TestCase):
    """
    Queue class test cases.

    """
    def setUp(self):
        self.queue = Queue()

    def tearDown(self):
        self.queue = None

    def test_queue(self):
        self.assertEqual(self.queue.is_empty(), True)
        self.queue.enqueue(1)
        self.queue.enqueue(2)
        self.assertEqual(self.queue.is_empty(), False)
        self.assertEqual(self.queue.queue, [1, 2])
        self.queue.dequeue()
        self.assertEqual(self.queue.queue, [2])


if __name__ == "__main__":
    unittest.main()
