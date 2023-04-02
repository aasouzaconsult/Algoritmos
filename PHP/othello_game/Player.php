<?php

/**
 * Player defines the current player playing the Othello game.
 */
class Player {
    private $name;
    private $isWhite;

    public function __construct($name, $isWhite) {
        $this->name = $name;
        $this->isWhite = $isWhite;
    }

    public function getName() {
        return $this->name;
    }

    public function isWhite() {
        return $this->isWhite;
    }

    // randomly makes a choice
    public function makeChoice(Choice $choices) {
        $coords = $choices->getChoices();
        if (empty($coords)) {
            return;
        }
        return $coords[array_rand($coords)];
    }
}