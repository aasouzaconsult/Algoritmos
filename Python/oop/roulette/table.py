import unittest


class Table(object):
    """

    Table contains all the Bet created by a Player. A table also has a betting
    limit, and the sum of all of a player's bets must be less than or equal to
    this limit. We assume a single Player in the simulation.

    """
    def __init__(self, limit):
        super(Table, self).__init__()
        self.limit = limit
        self.bets = []

    def is_valid(self, bet):
        """

        Validates this Bet. If the sum of all bets is less than or equal to the
        table limit, then the bet is valid, return True. Otherwise, return
        False.

        """
        pass

    def place_bet(self, bet):
        """

        Add this bet to the list of working bets. If the sum of all bets is
        greater than the table limit, then an exception should be raised. This
        is a rare circumstance, and indicates a bug in the Player more than
        anything else.

        """
        pass

    def __iter__(self):
        """

        Returns an iterator over the available list of Bet instances. This
        simply returns the iterator over the list of Bet objects. Note that we
        need to be able to remove Bets from the table. Consequently, we have to
        update the list, which requires that we create a copy of the list.
        This is done with Bets[:].

        """
        pass

    def __str__(self):
        """

        Return a string representation of the bets.

        """
        pass


class TableTestCase(unittest.TestCase):
    def setUp(self):
        pass

    def test_constructing_table_instance(self):
        pass

    def test_is_valid(self):
        pass

    def test_place_bet(self):
        pass
