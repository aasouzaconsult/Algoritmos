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

function hasWord($matrix, $word) {
    if (empty($matrix) || empty($word)) {
        return False;
    }

    $visited = array_fill(0, sizeof($matrix), array_fill(0, sizeof($matrix[0]), False));
    $char = $word[0];
    $coord = [];

    for ($row=0; $row < sizeof($matrix); $row++) { 
        for ($col=0; $col < sizeof($matrix[$row]); $col++) { 
            if ($matrix[$row][$col] === $char) {
                $coord = [$row, $col];
                break;
            }    
        }  
    }
    if (empty($coord)) {
        return False;
    }
    $wordIndex = 1;
    list($stack, $result) = [[$coord],[$coord]];

    while (!empty($stack)) {
        $found = False;
        $coord = array_pop($stack);
        list($row, $col) = $coord;
        $visited[$row][$col] = True;
        // up
        if ($row-1 < sizeof($matrix) && $row-1 >= 0 && $col < sizeof($matrix[0]) && $col >= 0) {
            if ($matrix[$row-1][$col] === $word[$wordIndex] && !$visited[$row-1][$col]) {
                $visited[$row-1][$col] = True;
                $result[] = [$row-1, $col];
                $found = True;
                $wordIndex++;
                $stack[] = [$row-1, $col];
            }
        }
        // right
        if ($row < sizeof($matrix) && $row >= 0 && $col+1 < sizeof($matrix[0]) && $col+1 >= 0) {
            if ($matrix[$row][$col+1] === $word[$wordIndex] && !$visited[$row][$col+1]) {
                $visited[$row][$col+1] = True;
                $result[] = [$row, $col+1];
                $found = True;
                $wordIndex++;
                $stack[] = [$row, $col+1];
            }
        }
        // down
        if ($row+1 < sizeof($matrix) && $row+1 >= 0 && $col < sizeof($matrix[0]) && $col >= 0) {
            if ($matrix[$row+1][$col] === $word[$wordIndex] && !$visited[$row+1][$col]) {
                $visited[$row+1][$col] = True;
                $result[] = [$row+1, $col];
                $found = True;
                $wordIndex++;
                $stack[] = [$row+1, $col];
            }
        }
        // left
        if ($row < sizeof($matrix) && $row >= 0 && $col-1 < sizeof($matrix[0]) && $col-1 >= 0) {
            if ($matrix[$row][$col-1] === $word[$wordIndex] && !$visited[$row][$col-1]) {
                $visited[$row][$col-1] = True;
                $result[] = [$row, $col-1];
                $found = True;
                $wordIndex++;
                $stack[] = [$row, $col-1];
            }
        }
        // delete dead paths
        // if (!$found) {
        //   deleteDeadPaths($visited, $result, $wordIndex);
        //   if (empty($result)) {
        //       return False;
        //   }
        // }
    }
    print_r($result);
    echo "HAHHAH";
    $foundWord = "";
    foreach ($result as $coord) {
        list($row, $col) = $coord;
        $foundWord .= $matrix[$row][$col];
    }
    echo $foundWord . PHP_EOL;
    // echo $word . PHP_EOL;
    return $foundWord === $word;
}

// helper function to delete dead paths
function deleteDeadPaths($visited, &$result, &$wordIndex) {
    while (True) {
        if (empty($result)) {
            return;
        } else {
            $prev = $result[sizeof($result)-1];
            list($row, $col) = $prev;
            // if this surrounding has match but unvisited
            if ($visited[$row+1][$col]) {
              # code...
            }
        }
    }
    return;
}

$matrix1 = [
  ["A","B","C","E"],
  ["S","F","C","S"],
  ["A","D","E","E"]
];
$word1 = "ABCCED"; //-> returns true,
$word2 = "SEE"; //-> returns true,
$word3 = "ABCB"; //-> returns false.

echo hasWord($matrix1, $word1) . PHP_EOL;
// [
//   ["ABCE"],
//   ["SCCC"],
//   ["ADEE"]
// ]
