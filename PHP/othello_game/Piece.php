<?php

/**
 * Piece class defines each individual piece in an othello game.
 */
class Piece {
    private $isWhite;

    public function __construct($isWhite) {
        $this->isWhite = $isWhite;
    }

    public function isWhite() {
        return $this->isWhite;
    }

    public function reverse() {
        $this->isWhite = !$this->isWhite;
    }
}