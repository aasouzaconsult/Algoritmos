import unittest


class Bet(object):
    """

    Bet associates an amount and an Outcome.

    """
    def __init__(self, amount, outcome):
        """

        Create a new Bet of a specific amount on a specific outcome.

        """
        super(Bet, self).__init__()
        self.amount = amount
        self.outcome = outcome

    def __str__(self):
        return "%d on %s" % (self.amount, self.outcome)

    def wins(self):
        return self.outcome.win_amount(self.amount)

    def loses(self):
        return self.amount


class BetTestCase(unittest.TestCase):
    def setUp(self):
        pass

    def test_bet_string_representation(self):
        pass

    def test_wins(self):
        pass

    def test_loses():
        pass
