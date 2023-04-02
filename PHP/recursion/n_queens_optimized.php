<?php

// http://www.math.utah.edu/~alfeld/queens/queens.html
// http://algorithms.tutorialhorizon.com/backtracking-n-queens-problem-better-solution/

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
 * Space: O(n)
 *
 */
function solve($size) {    
    if ($size < 4) {
        echo "No Solution";
    }
    $result = array_fill(0, $size, NULL);
    placeQueens($result, 0, $size);
}

function placeQueens(&$result, $queen, $size) {
    for ($i=0; $i < $size; $i++) { 
        if (canPlace($result, $queen, $i)) {
            $result[$queen] = $i;
            if ($queen == $size-1) {
                echo implode(" ", $result) . PHP_EOL;
            }
            placeQueens($result, $queen+1, $size);
        }
        
    }
}

/**
 * $result[$row] = $col. means queen at row index and column value.
 * Queen placed at (x1, y1) and (x2, y2)
 * x1 == x2 means same rows,
 * y1 == y2 means same columns
 * |x2-x1| == |y2-y1| means same diagonals
 */
function canPlace($result, $row, $col) {
    // check if queen can be placed in $row, $col
    for ($i=0; $i < $row; $i++) { 
        if ($result[$i] == $col || abs($i - $row) == abs($result[$i] - $col)) { // diagonal are the same
            return False;
        }
    }
    return True;
}

function printBoard($result) {
    for ($i=0; $i < sizeof($result); $i++) { 
        echo $result[$i] . " ";
    }
    echo PHP_EOL;
}

solve(4);
solve(6);
solve(8);