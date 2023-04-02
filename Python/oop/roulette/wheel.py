import bin
import outcome
import unittest
import random


class Wheel(object):
    """

    Wheel contains the 38 individual Bins on a roulette wheel, plus a random
    number generator. It can select a Bin at random, simulating a spin of the
    roulette wheel.

    """
    def __init__(self, rng=None):
        super(Wheel, self).__init__()
        self.bins = tuple(bin.Bin() for _ in range(38))
        if rng is None:
            self.rng = random.Random()
        else:
            self.rng = rng

    def add_outcome(self, bin, outcome):
        """

        Adds the given Outcome to the Bin with the given number.

        param bin: bin number, in the range 0 to 37 inclusive
        param outcome: the Outcome to add to this Bin
        returns: the Bin that was just added an Outcome.

        """
        if bin < 0 or bin > 37:
            return
        return self.bins[bin].add(outcome)

    def next(self):
        """

        Generates a random number between 0 and 37 inclusive, and returns the
        randomly selected bin.

        returns: A bin selected at random from the wheel

        """
        return self.bins[self.rng.choice()]

    def get(self, bin):
        """

        Returns the given Bin from the internal collection.

        param bin: bin number, in the range 0 to 37 inclusive.
        returns: the request bin

        """
        if bin < 0 or bin > 37:
            return
        return self.bins[bin]


class NonRandom(random.Random):
    """

    A NonRandom class sub classes Random class but provides a more testable
    sequence of values.

    """
    def __init__(self):
        self.value = value


class WheelTestCase(unittest.TestCase):
    def setUp(self):
        self.outcome = outcome.Outcome('odd', 1)
        self.outcome2 = outcome.Outcome('even', 2)
        self.bin = bin.Bin(self.outcome)
        self.bin2 = bin.Bin(self.outcome2)
        self.wheel = Wheel(random.Random())

    def test_add_outcome_success(self):
        self.wheel.add_outcome(2, self.outcome)
        self.assertEqual(len(self.wheel.bins[2]), 1)

    def test_get_bin(self):
        self.wheel.add_outcome(2, self.outcome)
        self.assertEqual(len(self.wheel.get(2)), 1)

if __name__ == "__main__":
    unittest.main()
