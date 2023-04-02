<?php

// http://www.math.utah.edu/~alfeld/queens/queens.html
// http://algorithms.tutorialhorizon.com/backtracking-n-queens-problem/

// In chess, a queen can move as far as she pleases, horizontally, vertically, or
// diagonally. A chess board has 8 rows and 8 columns. The standard 8 by 8 Queen's
// problem asks how to place 8 queens on an ordinary chess board so that none of
// them can hit any other in one move. 

// Besides being an amusing puzzle this problem is interesting because kids love it
// and it's a great teaching tool in the upper grades of Elementary School. It also
// provides great programming exercises.

// One solution - the prettiest in my opinion - is given in the figure nearby. It
// turns out that there are 12 essentially distinct solutions. (Two solutions are
// not essentially distinct if you can obtain one from another by rotating your
// chess board, or placing in in front of a mirror, or combining these two operations.)

// An obvious modification of the 8 by 8 problem is to consider an N by N "chess
// board" and ask if one can place N queens on such a board. It's pretty easy to
// see that this is impossible if N is 2 or 3, and it's reasonably straightforward
// to find solutions when N is 4, 5, 6, or 7. The problem begins to become difficult
// for manual solution precisely when N is 8. Probably the fact that this number
// coincidentally equals the dimensions of an ordinary chess board has contributed
// to the popularity of the problem.

/**
 * Time: O(n!)
 * Space: O(n^2) 
 *
 */
function solve($size) {
    if ($size < 4) {
        return "Unsolvable";
    }
    $board = array_fill(0, $size, array_fill(0, $size, 0));

    if (placeQueens(0, $size, $board)) {
        // print result
        printBoard($board);
    } else {
        return "No Solution exists";
    }
}

function placeQueens($queen, $size, &$board) {
    if ($queen == $size) {
        // placed $size number of queens, problem is solved.
        return True;
    }
    for ($row=0; $row < sizeof($board); $row++) { 
        // check if queen can be placed at row, col
        if (canPlace($board, $row, $queen)) {
            // place the queen
            $board[$row][$queen] = 1;
            if (placeQueens($queen+1, $size, $board)) {
                return True;
            }
            $board[$row][$queen] = 0;
        }
    }
    return False;
}

function canPlace($board, $row, $col) {
    // check row has no other queen placed. already fulfilled by loop through row.
    // check col has no other queen placed
    for ($i=0; $i < sizeof($board[$row]); $i++) { 
        if ($board[$row][$i] == 1) {
            return False;
        }
    }
    // we are filling one column at a time
    // check upper diagonal has no other queen placed
    $i = $row;
    $j = $col;
    while ($i >= 0 && $j >= 0) {
        if ($board[$i][$j] == 1) {
            return False;
        }
        $i--;
        $j--;
    }
    // check lower diagonal has no other queen placed
    $i = $row;
    $j = $col;
    while ($i < sizeof($board) && $j >= 0) {
        if ($board[$i][$j] == 1) {
            return False;
        }
        $i++;
        $j--;
    }
    // safe to place queen at row, col
    return True;
}

function printBoard($board) {
    for ($row=0; $row < sizeof($board); $row++) { 
        for ($col=0; $col < sizeof($board[$row]); $col++) { 
            echo $board[$row][$col] . " ";
        }
        echo PHP_EOL;
    }
}

solve(4);
echo "----" . PHP_EOL;
solve(8);