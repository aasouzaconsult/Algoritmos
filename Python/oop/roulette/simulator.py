class Simulator(object):
    """

    Simulator exercises the roulette simulation with a given Player placing
    bets. It reports raw statistics on a number of sessions of play.

    """
    def __init__(self, game, player):
        """

        param game: the casino game we are simulating. This is an instance of
                    Game, which embodies various rules, the Table and Wheel.
        param player: The Player; essentially, the betting strategy we are
                      simulating.

        FIELDS:
        init_duration: The duration value to use when initializing a Player
                       for a session. A default value of 250 is given.
        init_stake: The stake value to use when initalizing a Player for a
                    session. This is a count of the number of bets placed.
        samples: The number of game cycles to simulate.
        durations: A list of lengths of time the Player remained in the game.
                   Each session of play produces a duration metric, which are
                   collected into this list.
        maxima: A list of maximum stakes for each Player. Each session of play
                produces a maximum stake metric, which are collected into this
                list.

        """
        super(Simulator, self).__init__()
        self.game = game
        self.player = player
        self.init_duration = 250
        self.init_stake = 100
        self.samples = 50
        self.durations = []
        self.maxima = []

    def session(self):
        """

        Executes a single game session. The player is initialized with their
        initial stake and initial cycles to go. An empty List of stake values
        is created. The session loop executes until the Player playing()
        returns false. This loop executes the Game cycle(); then it gets the
        stake from the Player and appends this amount to the List of stake
        values. The List of individual stake values is returned as the result
        of the session of play.

        """
        pass

    def gather(self):
        """

        Executes the number of games sessions in samples. Each game session
        returns a List of stake values. When the session is over (either the
        play reached their time limit or their stake was spent), then the
        length of the session List and the maximum value in the session List
        are the resulting duration and maximum metrics. These two metrics are
        appended to the durations list and the maxima list.

        A client class will either display the durations and maxima raw metrics
        or produce statistical summaries.

        """
        pass
