<?php

// function __autoload($className) {
//     $filename = "./" . $className . ".php";
//     include_once($filename);
// }

class Deck {
    private $cards;

    const DIAMOND = 0;
    const CLUB = 1;
    const HEART = 2;
    const SPADE = 3;

    public function __construct() {
        $suits = [DIAMOND, CLUB, HEART, SPADE];
        $ranks = 13;
        foreach ($suits as $suit) {
            for ($i=1; $i <= 13; $i++) { 
                $this->cards[] = new Card($suit, $i);
            }
        }
    }

    public function shuffle() {
        shuffle($this->cards);
    }

    public function getDeck() {
        return $this->cards;
    }

    public function getCard() {
        return array_pop($this->cards);
    }

    public function isEmpty() {
        return empty($this->cards);
    }
}

// $deck = new Deck();
// $deck->shuffle();
// print_r($deck->getDeck());