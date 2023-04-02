# Implementation of queue data structure with FIFO principle


class Queue(object):
    def __init__(self):
        self.queue = []

    def insert(self, data):
        self.queue.append(data)
        return

    def remove(self):
        return self.queue.pop(0)

    def print_queue(self):
        print self.queue
        return


if __name__ == "__main__":
    test = Queue()
    test.insert(1)
    test.insert(2)
    test.insert(3)
    test.print_queue()
    test.remove()
    test.print_queue()
    test.remove()
    test.print_queue()
