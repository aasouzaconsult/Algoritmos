<?php

/**
 * Write an algorithm to print all ways of arranging eight queens on an 8x8 chess
 * board
 * so that none of them share the same row, column, or diagonal. In this case,
 * "diagonal" means all diagonals, not just the two that bisect the board.
 *
 * TEXTBOOK SOLUTION BELOW.
 */

function placeQueens($row, $cols, $gridSize, &$results) {
    if ($row == $gridSize) {
        $result[] = $cols;
    } else {
        for ($col=0; $col < $gridSize; $col++) { 
            if (checkValid($cols, $row, $col)) {
                $cols[$row] = $col; // place queen
                placeQueens($row+1, $cols, $gridSize, $results);
            }
        }
    }
}

function checkValid($cols, $row, $col) {
    for ($row2=0; $row2 < $row; $row2++) { 
        $col2 = $cols[$row2];
        // check if row2 col2 invalidates row1, col1 as a queen spot
        
        // check if row have a queen in the same column
        if ($col == $col2) {
            return False;
        }

        // check diagonals: dist between cols == dist between rows
        $colDist = abs($col2 - $col);
        $rowDist = $row - $row2;
        if ($colDist == $rowDist) {
            return False;
        }
    }
    return True;
}
$result = [];
placeQueens(0, [], 8, $result);
print_r($result);