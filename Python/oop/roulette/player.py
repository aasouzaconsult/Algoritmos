import outcome


class Player(object):
    """

    Player places bets on roulette. This is an abstract class, with no actual
    body for the place_bets() method. However, this class implements the basic
    win() method used by all subclasses.

    """
    def __init__(self, table):
        super(Player, self).__init__()
        self.table = table

    def playing(self):
        """

        Returns True if player is still active.

        """
        pass

    def place_bets(self):
        """

        Updates the table with the various Bet. When designing the Table, we
        decided that we needed to deduct the amount of a bet from the stake
        when the bet is created.

        """
        pass

    def win(self, bet):
        """

        Notification from the Game that the Bet was a winner. The amount of
        money won is available via Bet method win_amount().

        """
        pass

    def lose(self, bet):
        """

        Notification from the Game that the Bet was a loser. Note the amount
        was already deducted from the stake when the bet was created.

        """
        pass


class Martingale(Player):
    """

    Martingale is a Player who place bets in roulette. This player doubles
    their bet on every loss and resets their bet to a base amount on each win.

    """
    def __init__(self):
        super(Martingale, self).__init__()
        self.loss_count = 0
        # bet multiple is based on number of losses. This starts at 1 and is
        # reset to 1 on each win. It is doubled in each loss. This is always
        # equal to pow(2, loss_count)
        self.bet_multiple = pow(2, self.loss_count)

    def place_bets(self):
        """

        Updates the Table with a bet on 'black'. The amount bet is
        pow(2, loss_count), which is the value of bet_multiple.

        """
        pass

    def win(self, bet):
        """

        Uses the superclass win() method to update the stake with an amount
        won. This method then resets loss_count to zero, and bet_multiple to 1.

        """
        pass

    def lose(self, bet):
        """

        Uses the superclass lose() method to do whatever bookkeeping the
        superclass already does. Increments loss by 1 and doubles bet_multiple.

        """
        pass


class Passenger57(object):
    """

    Passenger57 constructs a Bet based on the Outcome named "black". This is a
    very persistent Player.

    """
    def __init__(self, table):
        self.black = outcome.Outcome('black', 2)
        self.table = table

    def place_bets(self):
        """

        Updates the Table with various bets. This version creates a bet
        instance from the black Outcome. It uses Table.place_bet() to
        place that bet.

        """
        pass

    def win(self, bet):
        """

        Notification from the Game that the Bet was a winner. The amount of
        money won is available via the wins() method of Bet.

        """
        pass

    def lose(self, bet):
        """

        Notification from the Game that Bet was a loser.

        """
        pass
