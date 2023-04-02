import unittest


class Game(object):
    """

    Game manages the sequence of actions that defines the game of Roulette.
    This includes notifying the Player to place bets, spinning the Wheel and
    resolving the Bet actually present on the Table.

    """
    def __init__(self, wheel, table):
        """

        This is the Strategy design pattern. Each of these collaborating
        objects is a replaceable strategy, and can be changed by the client
        that uses this game.

        param wheel: the Wheel which produces random events
        param table: the Table which holds bets to be resolved.

        """
        super(Game, self).__init__()
        self.wheel = wheel
        self.table = table

    def cycle(self, player):
        """

        Executes a single cycle play with the given player. It will call
        Player.place_bets() method to get bets. It will call the Wheel's
        next() method to get the next winning Bin.

        """
        pass


class GameTestCase(unittest.TestCase):
    def setUp(self):
        pass

    def test_cycle(self):
        pass
