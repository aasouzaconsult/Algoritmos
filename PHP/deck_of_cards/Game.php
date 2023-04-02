<?php

// function __autoload($className) {
//     $filename = "./" . $className . ".php";
//     include_once($filename);
// }

class Game {
    private $players;

    public function __construct() {
        $this->players = [];
        $this->deck = new Deck();
    }

    public function addPlayer(Player $player) {
        if (!isset($this->players[$player->getName()])) {
            $this->players[$player->getName()] = $player;
            return True;
        }
        return False;
    }
    public function setGame($players) {
        if (sizeof($players) < 2) {
            throw Exception("Not enough players.");
        } else {
            foreach ($players as $player) {
                $this->addPlayer($player);
            }
        }
        $this->deck->shuffle();
        return;
    }

    public function getDeck() {
        return $this->deck;
    }

    public function decideWinner(Player $player1, Player $player2) {
        $player1Hand = $player1->showHand();
        $player2Hand = $player2->showHand();
        if ($player1Hand > $player2Hand) {
            echo $player1->getName() . " won!" . PHP_EOL;
        } elseif ($player1Hand < $player2Hand) {
            echo $player2->getName() . " won!" . PHP_EOL;
        } else {
            echo "Draw" . PHP_EOL;
        }
    }
}