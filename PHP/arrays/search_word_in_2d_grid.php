<?php

/*

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example, given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]


[
  ["ABCE"],
  ["SCCC"],
  ["ADEE"]
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

  */
// moves: up left down right
// 2d matrix max size :  n by n  0< n < PHP_INT_MAX
// 1 of 26 alphabets
// empty word
// Time: O(n^2) BCR
// Space: O(n^2)

/**
 * My earlier code had the error of not checking all the possible locations for the first element
 * in the grid. I've changed my implementation from your hints given.
 * Time: O(n^2)
 * Space: O(n^2)
 */
function hasWord($matrix, $word) {
    if (empty($matrix) || empty($word)) {
        return False;
    }

    for ($row=0; $row < sizeof($matrix); $row++) { 
        for ($col=0; $col < sizeof($matrix[$row]); $col++) {
            $visited = array_fill(0, sizeof($matrix), array_fill(0, sizeof($matrix[$row]), False));
            if (findWord($matrix, $word, $visited, $row, $col, 0)) {
                return True;
            }
        }
    }
    return False;
}

function findWord($matrix, $word, &$visited, $row, $col, $index) {
    if ($matrix[$row][$col] !== $word[$index]) {
        // element doesn't match
        return False;
    }
    $visited[$row][$col] = True;
    if ($index == strlen($word)-1) {
        // whole word is matched
        return True;
    }

    // current index char is match but there are still more chars to match
    // we search up right down left
    // up
    if ($row-1 < sizeof($matrix) && $row-1 >= 0 && !$visited[$row-1][$col]) {
        if (findWord($matrix, $word, $visited, $row-1, $col, $index+1)) {
            return True;
        }
    }
    // right
    if ($col+1 < sizeof($matrix) && $col+1 >= 0 && !$visited[$row][$col+1]) {
        if (findWord($matrix, $word, $visited, $row, $col+1, $index+1)) {
            return True;
        }
    }
    // down
    if ($row+1 < sizeof($matrix) && $row+1 >= 0 && !$visited[$row+1][$col]) {
        if (findWord($matrix, $word, $visited, $row+1, $col, $index+1)) {
            return True;
        }
    }
    // left
    if ($col-1 < sizeof($matrix) && $col-1 >= 0 && !$visited[$row][$col-1]) {
        if (findWord($matrix, $word, $visited, $row, $col-1, $index+1)) {
            return True;
        }
    }
    return False;
}

$matrix1 = [
  ["A","B","C","E"],
  ["S","F","C","S"],
  ["A","D","E","E"]
];

$matrix2 = [
  ["A","B","C","E"],
  ["S","C","C","S"],
  ["A","D","E","E"]
];

$word1 = "ABCCED"; //-> returns true,
$word2 = "SEE"; //-> returns true,
$word3 = "ABAB"; //-> returns false.

echo hasWord($matrix1, $word1) . PHP_EOL;
echo hasWord($matrix1, $word2) . PHP_EOL;
echo hasWord($matrix1, $word3) . PHP_EOL;

// echo hasWord($matrix2, $word1) . PHP_EOL;
// echo hasWord($matrix2, $word2) . PHP_EOL;
// echo hasWord($matrix2, $word3) . PHP_EOL;