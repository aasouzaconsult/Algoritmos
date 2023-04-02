<?php

// Rules
// Feel free to look up any online documentation you may need.
// Overview
// Tic-tac-toe is a popular paper and pencil game played on a 3x3 grid.
// Two players, “X” and “O” take turns placing their respective characters in an empty cell of the 3x3 grid.
// The winner is the first player to get three of their characters in a horizontal, vertical, or diagonal line. If the board is filled without such a line being formed, the game is a draw.
// Goal
// Implement Tic-tac-toe. Have the two players, “X” and “O” alternate taking turns. Each turn, the current player will select a random empty cell to place their character in. Draw the updated board state to the console after each turn. When one player wins, print either “X wins” or “O wins” and end the game. Otherwise, if the game ends in a draw, simply print “DRAW” and exit. Here is an example output:
// 
// Constraints
// 3x3
//
// X and O taking turns
// Computer find a location
// Computer 1 X computer O
// Win: horizontal/ vertical/diagonal of the same piece
// Draw: board is filled, but no win situation for either
// Prints: X wins  / O Wins / Draw

// board 3X3
// players X and O
// main driver
// method to check win/draw

// Board class, initialized to 3 X 3
class Board {
    private $board;
    private $count;

    public function __construct() {
        $this->board = array_fill(0, 3, array_fill(0, 3, NULL));
        $this->count = 0;
    }
    // methods
    
    public function insert($row, $col, $sign) {
        // check if position is filled
        if (!empty($this->board[$row][$col])) {
            return false;
        }
        $this->board[$row][$col] = $sign;
        $this->count++;
        return true;
    }

    public function isFull() {
        if ($this->count >= 9) {
            return True;
        } else {
            return False;
        }
    }

    public function hasWon($row, $col, $sign) {
        // check horizontal
        $sign = $this->board[$row][$col];
        $won = True;
        for ($i=0; $i < sizeof($this->board[0]); $i++) { 
            if ($this->board[$row][$i] != $sign) {
                $won = False;
                break;
            }
        }
        if ($won) {
            return True; 
        }
        // check vertical
        for ($i=0; $i < sizeof($this->board); $i++) { 
            if ($this->board[$i][$col] != $sign) {
                $won = False;
                break;
            }
        }
        if ($won) {
            return True; 
        }
        // check diagonal
        for ($i=0; $i < sizeof($this->board); $i++) { 
            if ($this->board[$i][$i] != $sign) {
                $won = False;
                break;
            }
        }
        return $won;
    }

    public function pointSet($row, $col) {
        if (!empty($this->board[$row][$col])) {
            return True;
        }
        return False;
    }

    public function hasDrawn($row, $col, $sign) {
        if (!$this->hasWon($row, $col, $sign) && $this->isFull()) {
            return True;
        }
        return False;
    }

    public function printBoard() {
        for ($i=0; $i < sizeof($this->board); $i++) { 
            for ($j=0; $j < sizeof($this->board[0]); $j++) { 
                echo $this->board[$i][$j] . " ";
            }
            echo PHP_EOL;
        }
        echo "======================" . PHP_EOL;
    }
}

// Players
class Player {
    private $sign;

    public function __construct($sign) { // X or O
        $this->sign = $sign;
    }

    // methods
    public function selectPosition() {
        $row = rand(0, 2);
        $col = rand(0, 2);
        return [$row, $col];
    }

    public function getSign() {
        return $this->sign;
    }
}

function main() {
    $board = new Board();
    $player1 = new Player("X");
    $player2 = new Player("O");

    $player1Turn = True;
    $once = 0;
    // loop player1 and 2
    while (True) {
        do {
            if ($once == 0) {
                $pos = $player1->selectPosition();
                $newSign = $player1->getSign();
                $once++;
            } elseif ($player1Turn) {
                $pos = $player1->selectPosition();
                $newSign = $player1->getSign();
            } else {
                $pos = $player2->selectPosition();
                $newSign = $player2->getSign();
            }

            if ($board->insert($pos[0], $pos[1], $newSign)) {
                $player1Turn = !$player1Turn;
            } else {
                continue;
            }
            $board->printBoard();
            if ($board->isFull()) {
                break;
            }
        } while (!$board->isFull());
        $row = $pos[0];
        $col = $pos[1];

        if ($board->hasWon($row, $col, $newSign) || $board->hasDrawn($row, $col, $newSign)) {
            // check the condition
            if (!$player1Turn) {
                $newSign = $player2->getSign();
            }
            if ($board->hasWon($row, $col, $newSign)) {
                if ($player1Turn) {
                    echo "X won";
                } else {
                    echo "O won";
                }
            } else {
                echo "Draw";
            }
            break;
        }
    }
}
main();
