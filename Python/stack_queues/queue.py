# implementing a queue


class Queue(object):
    def __init__(self):
        self.queue = []

    def enqueue(self, value):
        self.queue.append(value)
        return

    def dequeue(self):
        return self.queue.pop(0)

    def print_queue(self):
        print self.queue
        return


if __name__ == "__main__":
    queue = Queue()
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    queue.enqueue(4)
    queue.print_queue()
    print queue.dequeue()
    queue.print_queue()
