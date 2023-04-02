<?php

/**
 * Othello game system. Integrates different components together.
 */
class OthelloGame {
    private $board;
    private $player1;
    private $player2;

    public function __construct($boardSize, Player $player1, Player $player2) {
        $this->board = new Board($boardSize);
        $this->player1 = $player1;
        $this->player2 = $player2;
    }

    public function getBoard() {
        return $this->board;
    }

    public function getPlayer1() {
        return $this->player1;
    }

    public function getPlayer2() {
        return $this->player2;
    }

    public function setUp() {
        $whitePiece1 = new Piece(True);
        $whitePiece2 = new Piece(True);
        $blackPiece1 = new Piece(False);
        $blackPiece2 = new Piece(False);
        $this->board->add($this->player1, [3,3]);
        $this->board->add($this->player1, [4,4]);
        $this->board->add($this->player2, [3,4]);
        $this->board->add($this->player2, [4,3]);
    }

    public function declareResult() {
        $whites = $this->board->calculatePieces($this->player1);
        $blacks = $this->board->calculatePieces($this->player2);
        if ($whites > $blacks) {
            echo $this->player1->getName() . " won!!!" . PHP_EOL;
        } elseif ($blacks > $whites) {
            echo $this->player2->getName() . " won!!!" . PHP_EOL;
        } else {
            echo "Game is a draw!" . PHP_EOL;
        }
        return;
    }
}