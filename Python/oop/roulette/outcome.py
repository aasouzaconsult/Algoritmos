import unittest


class Outcome(object):
    """

    Outcome contains a single outcome on which a bet can be placed.
    In roulette, each spin of the wheel has a number of outcomes with bets that
    will be paid off.

    For example, the "1" bin has the following winning Outcomes: "1", "Red",
    "Odd", "Low", "Column 1", "Dozen 1-12", "Split 1-2", "Split 1-4",
    "Street 1-2-3", "Corner 1-2-4-5", "Five Bet", "Line 1-2-3-4-5-6",
    "00-0-1-2-3", "Dozen 1", "Low" and "Column 1". All of these bets will
    payoff if the wheel spins a "1".

    """

    def __init__(self, name, odds):
        super(Outcome, self).__init__()
        self.name = name
        self.odds = odds

    def win_amount(self, amount):
        """

        Multiple this Outcome's odd by the given amount. The product is
        returned.

        param amount: amount being bet.

        """
        if not isinstance(amount, int):
            return
        return self.odds * amount

    def __eq__(self, other):
        """

        Compare the name attributes of self and other.

        param other: another Outcome instance to compare against.
        returns: True if this name matches the other name.

        """
        if self.name == other.name:
            return True
        return False

    def __ne__(self, other):
        """

        Compare the name attributes of self and other.

        param other: another Outcome instance to compare against.
        returns: True if this name does not match the other name.

        """
        if self.name != other.name:
            return True
        return False

    def __str__(self):
        """

        Easy to read representation of this Outcome.

        returns: String of the form name (odds: 1)

        """
        return "%s (%d:1)" % (self.name, self.odds)


class OutcomeTestCase(unittest.TestCase):
    """

    Test cases for Outcome class.

    """
    def setUp(self):
        self.a = Outcome('even', 2)
        self.b = Outcome('odd', 2)
        self.c = Outcome('even', 2)

    def test_two_instances_are_equal(self):
        self.assertEqual(self.a == self.c, True)

    def test_two_instances_are_not_equal(self):
        self.assertEqual(self.a != self.b, True)

    def test_corect_win_amount(self):
        self.assertEqual(self.a.win_amount(10), 20)


if __name__ == "__main__":
    unittest.main()
