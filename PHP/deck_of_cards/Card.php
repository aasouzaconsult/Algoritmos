<?php

class Card {
    private $suit;
    private $digit;

    public function __construct($suit, $digit) {
        $this->suit = $suit;
        $this->digit = $digit;
    }

    public function getSuit() {
        return $this->suit;
    }

    public function getDigit() {
        return $this->digit;
    }
}