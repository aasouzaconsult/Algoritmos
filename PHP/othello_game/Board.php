<?php

/**
 * Othello board that holds all the Pieces.
 */
class Board {
    private $board;
    private $visited;
    private $pieceCount;
    private $size;
    private $pieceFactory;

    public function __construct($size) {
        $this->board = array_fill(0, $size, array_fill(0, $size, NULL));
        $this->visited = array_fill(0, $size, array_fill(0, $size, False));
        $this->pieceCount = 0;
        $this->size = $size;
        $this->pieceFactory = new PieceFactory();
    }

    public function getBoard() {
        return $this->board;
    }

    public function piecesOnBoard() {
        return $this->pieceCount;
    }

    public function isFull() {
        return $this->pieceCount-1 == pow($this->size, 2);
    }

    public function getChoices(Player $player) {
        $isWhite = $player->isWhite();
        $choice = new Choice();

        return $this->searchChoices($choice, $isWhite);

    }

    private function searchChoices(Choice $choice, $isWhite) {
        // loop through every coord on board.
        for ($row=0; $row < $this->size; $row++) { 
            for ($col=0; $col < $this->size; $col++) { 
                $piece = $this->board[$row][$col];
                if (empty($piece)) {
                    continue;
                }
                // coord piece is opposite to player color.
                if ($piece->isWhite() != $isWhite) {
                    $choice = $this->addUnfilledNeighbourChoices($choice, $row, $col);
                }
            }
        }
        return $choice;
    }

    private function addUnfilledNeighbourChoices(Choice $choice, $row, $col) {
        // top left
        if ($this->isValidChoice($row-1, $col-1)) {
            $choice->add([$row-1, $col-1]);
        }
        // top
        if ($this->isValidChoice($row-1, $col)) {
            $choice->add([$row-1, $col]);
        }
        // top right
        if ($this->isValidChoice($row-1, $col+1)) {
            $choice->add([$row-1, $col+1]);
        }
        // right
        if ($this->isValidChoice($row, $col+1)) {
            $choice->add([$row, $col+1]);
        }
        // bottom right
        if ($this->isValidChoice($row+1, $col+1)) {
            $choice->add([$row+1, $col+1]);
        }
        // bottom
        if ($this->isValidChoice($row+1, $col)) {
            $choice->add([$row+1, $col]);
        }
        // bottom left
        if ($this->isValidChoice($row+1, $col-1)) {
            $choice->add([$row+1, $col-1]);
        }
        // left
        if ($this->isValidChoice($row, $col-1)) {
            $choice->add([$row, $col-1]);
        }
        return $choice;
    }

    private function isValidChoice($row, $col) {
        if ($row < $this->size && $row >= 0 &&
            $col < $this->size && $col >= 0) {
            if (!$this->visited[$row][$col]) {
                return True;
            }
        }
        return False;
    }

    public function buildPieceFor(Player $player) {
        if ($player->isWhite()) {
            return $this->pieceFactory->build(True);
        }
        return $this->pieceFactory->build(False);
    }

    public function add(Player $player, $coord) {
        $piece = $this->buildPieceFor($player);
        list($row, $col) = [$coord[0], $coord[1]];
        if (isset($this->board[$row][$col])) {
            return;
        }
        $this->board[$row][$col] = $piece;
        $this->visited[$row][$col] = True;
        $this->pieceCount++;
        $this->updateBoard($player->isWhite(), $row, $col);
        return;
    }

    private function needsUpdatePiece($isWhite, $row, $col) {
        if ($row < $this->size && $row >= 0 &&
            $col < $this->size && $col >= 0) {
            if ($this->visited[$row][$col] &&
                $this->board[$row][$col]->isWhite() != $isWhite) {
                return True;
            }
        }
        return False;
    }

    private function updateBoard($isWhite, $row, $col) {
        // top left
        $travRow = $row-1;
        $travCol = $col-1;
        while ($this->needsUpdatePiece($isWhite, $travRow, $travCol)) {
            $this->board[$travRow][$travCol]->reverse();
            $travRow--;
            $travCol--;
        }
        // top
        $travRow = $row-1;
        $travCol = $col;
        while ($this->needsUpdatePiece($isWhite, $travRow, $travCol)) {
            $this->board[$travRow][$travCol]->reverse();
            $travRow--;
        }
        // top right
        $travRow = $row-1;
        $travCol = $col+1;
        while ($this->needsUpdatePiece($isWhite, $travRow, $travCol)) {
            $this->board[$travRow][$travCol]->reverse();
            $travRow--;
            $travCol++;
        }
        // right
        $travRow = $row;
        $travCol = $col+1;
        while ($this->needsUpdatePiece($isWhite, $travRow, $travCol)) {
            $this->board[$travRow][$travCol]->reverse();
            $travCol++;
        }
        // bottom right
        $travRow = $row+1;
        $travCol = $col+1;
        while ($this->needsUpdatePiece($isWhite, $travRow, $travCol)) {
            $this->board[$travRow][$travCol]->reverse();
            $travRow++;
            $travCol++;
        }
        // bottom
        $travRow = $row+1;
        $travCol = $col;
        while ($this->needsUpdatePiece($isWhite, $travRow, $travCol)) {
            $this->board[$travRow][$travCol]->reverse();
            $travRow++;
        }
        // bottom left
        $travRow = $row+1;
        $travCol = $col-1;
        while ($this->needsUpdatePiece($isWhite, $travRow, $travCol)) {
            $this->board[$travRow][$travCol]->reverse();
            $travRow++;
            $travCol--;
        }
        // left
        $travRow = $row;
        $travCol = $col-1;
        while ($this->needsUpdatePiece($isWhite, $travRow, $travCol)) {
            $this->board[$travRow][$travCol]->reverse();
            $travCol--;
        }
    }

    public function calculatePieces(Player $player) {
        if ($player->isWhite()) {
            $count = $this->calculateWhitePieces();
        } else {
            $count = $this->calculateBlackPieces();
        }
        return $count;
    }

    private function calculateWhitePieces() {
        $count = 0;
        for ($row=0; $row < sizeof($this->board); $row++) { 
            for ($col=0; $col < sizeof($this->board[0]); $col++) { 
                $piece = $this->board[$row][$col];
                if (isset($piece) && $piece->isWhite()) {
                    $count++;
                }
            }
        }
        return $count;
    }

    private function calculateBlackPieces() {
        $count = 0;
        for ($row=0; $row < sizeof($this->board); $row++) { 
            for ($col=0; $col < sizeof($this->board[0]); $col++) { 
                $piece = $this->board[$row][$col];
                if (isset($piece) && !$piece->isWhite()) {
                    $count++;
                }
            }
        }
        return $count;
    }

    public function printBoard() {
        for ($row=0; $row < $this->size; $row++) { 
            for ($col=0; $col < $this->size; $col++) { 
                $piece = $this->board[$row][$col];
                if (isset($piece)) {
                    if ($piece->isWhite()) {
                        echo "W ";
                    } else {
                        echo "B ";
                    }
                }
            }
            echo PHP_EOL;
        }
    }
}