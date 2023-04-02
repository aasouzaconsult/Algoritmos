<?php

// function __autoload($className) {
//     $filename = "./" . $className . ".php";
//     include_once($filename);
// }

class Player {
    private $name;
    private $cards;
    private $value;

    public function __construct($name, $cards=[]) {
        $this->name = $name;
        $this->cards = $cards;
        if (empty($this->cards)) {
            $this->value = 0;
        } else {
            foreach ($this->cards as $card) {
                $this->value += $card->getDigit();
            }
        }
    }

    public function drawCard(Card $card) {
        if (empty($card)) {
            return False;
        }
        $this->cards[] = $card;
        $this->value += $card->getDigit();
    }

    public function showHand() {
        return $this->getValue();
    }

    public function getValue() {
        return $this->value;
    }

    public function getName() {
        return $this->name;
    }
}