# In the classic problem of the towers of hanoi, you have 3 rods and N disks of
# different sizes which can slide onto any tower. The puzzle starts with disks
# sorted in ascending order of size from top to bottom(e.g, each disk sits on
# top of an even larger one).
#
# You have the following constraints:
# A. Only one disk can be moved at a time.
# B. A disk is slid off the top one rod onto the next rod.
# C. A disk can only be placed on top of a larger disk.
# Write a program to move the disks from the first rod to the last using
# stacks.


class TowerOfHanoi(object):
    def __init__(self, disks):
        self.stack1 = [disks-i for i in range(disks)]
        self.stack2 = []
        self.stack3 = []

    def operations(self, disks):
        return pow(2, disks) - 1

    def move(self, target, dest):
        if len(target) < 1:
            return
        dest.append(target.pop())
        return

    def solve(self, disks, beg, aux, end):
        if disks == 1:
            self.move(beg, end)
        else:
            self.solve(disks-1, beg, end, aux)  # move n-1 disks from beg to aux
            self.print_towers()
            self.solve(1, beg, aux, end)  # move 1 disk from beg to end
            self.print_towers()
            self.solve(disks-1, aux, beg, end)  # move n-1 disks from aux to end
        return

    def print_towers(self):
        print self.stack1
        print self.stack2
        print self.stack3
        print ""

def hanoi(n, source, helper, target):
    print "hanoi( ", n, source, helper, target, " called"
    if n > 0:
        # move tower of size n - 1 to helper:
        hanoi(n - 1, source, target, helper)
        # move disk from source peg to target peg
        if source[0]:
            disk = source[0].pop()
            print "moving " + str(disk) + " from " + source[1] + " to " + target[1]
            target[0].append(disk)
        # move tower of size n-1 from helper to target
        hanoi(n - 1, helper, source, target)


if __name__ == "__main__":
    toh = TowerOfHanoi(5)
    toh.print_towers()
    toh.solve(5, toh.stack1, toh.stack2, toh.stack3)
    toh.print_towers()

    source = ([4, 3, 2, 1], "source")
    target = ([], "target")
    helper = ([], "helper")
    hanoi(len(source[0]), source, helper, target)

    print source, helper, target