import outcome
import unittest


class Bin(object):
    """

    Bin contains a collection of Outcome(s) which reflect the winning bets that
    are paid for a particular bin on a Roulette wheel.

    """
    def __init__(self, *outcomes):
        super(Bin, self).__init__()
        self.outcomes = frozenset(outcomes)

    def add(self, outcome):
        """

        Add an Outcome to this Bin.

        """
        self.outcomes |= set([outcome])
        return self.outcomes

    def __str__(self):
        return ', '.join(map(str, self.outcomes))

    def __len__(self):
        return len(self.outcomes)


class BinTestCase(unittest.TestCase):
    def setUp(self):
        self.five = outcome.Outcome('00-0-1-2-3', 6)
        self.zero = Bin(outcome.Outcome("0", 35), self.five)
        self.zerozero = Bin(outcome.Outcome("00", 35), self.five)
        self.even = outcome.Outcome('even', 2)
        self.two = Bin(self.even)

    def test_initialize_bin(self):
        self.ten = Bin(outcome.Outcome("10", 35))
        self.assertIsInstance(self.ten, Bin)

    def test_add_outcome_to_bin(self):
        self.assertEqual(len(self.two.outcomes), 1)
        self.two.add(outcome.Outcome("black", 2))
        self.assertEqual(len(self.two.outcomes), 2)


class BinBuilder(object):
    """

    BinBuilder creates the Outcome for all of the 38 individual Bin on a
    Roulette wheel.

    """
    def __init__(self):
        pass

    def build_bins(self, wheel):
        """

        Creates the Outcome instances and uses the add_outcome() method to
        place each Outcome in the appropriate Bin of Wheel.

        param wheel: the Wheel with Bins that must be populated with Outcomes.

        """
        pass

    def generate_straight_bets(self):
        """

        Straight bet Outcomes are the easiest to generate.

        For All Numbers. For each number, n, 1 \leq n < 37:

            Create Outcome. Create an Outcome from the number, n, with odds of
            35:l.

            Assign to Bin. Assign this new Outcome to Bin n.

        Zero. Create an Outcome from the “0” with odds of 35:l. Assign this to
        Bin 0.

        Double Zero. Create an Outcome from the “00” with odds of 35:l. Assign
        this to Bin 37.

        """

    def generate_split_bets(self):
        pass

    def generate_street_bets(self):
        pass

    def generate_corner_bets(self):
        pass

    def generate_line_bets(self):
        pass

    def generate_dozen_bets(self):
        pass

    def generate_column_bets(self):
        pass

    def generate_even_money_bets(self):
        pass


class BinBuilderTestCase(unittest.TestCase):
    def setUp(self):
        pass

    def create_binbuilder_object(self):
        pass

    def test_generate_straight_bets(self):
        pass

    def test_generate_street_bets(self):
        pass

    def test_generate_split_bets(self):
        pass

    def test_generate_corner_bets(self):
        pass

    def test_generate_line_bets(self):
        pass

    def test_generate_dozen_bets(self):
        pass

    def test_generate_column_bets(self):
        pass

    def test_generate_even_money_bets(self):
        pass

if __name__ == "__main__":
    unittest.main()
