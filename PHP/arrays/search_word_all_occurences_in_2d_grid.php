<?php

// Given a 2D grid of characters and a word, find all occurrences of given word
// in grid. A word can be matched in all 8 directions at any point. Word is said
// be found in a direction if all characters match in this direction
// (not in zig-zag form).

// The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up
// and 4 Diagonal directions.

// Example:

// Input:  grid[][] = {"GEEKSFORGEEKS",
//                     "GEEKSQUIZGEEK",
//                     "IDEQAPRACTICE"};
//         word = "GEEKS"

// Output: pattern found at 0, 0
//         pattern found at 0, 8
//         pattern found at 1, 0

// Input:  grid[][] = {"GEEKSFORGEEKS",
//                     "GEEKSQUIZGEEK",
//                     "IDEQAPRACTICE"};
//         word = "EEE"

// Output: pattern found at 0, 2
//         pattern found at 0, 10
//         pattern found at 2, 2
//         pattern found at 2, 12

/**
 * Time: O(n^2)
 * Space: O(n^2)
 *
 */
function findWordOccurences($matrix, $word) {
    if (empty($matrix) || empty($word)) {
        return;
    }
    $result = [];
    for ($row=0; $row < sizeof($matrix); $row++) { 
        for ($col=0; $col < sizeof($matrix[$row]); $col++) { 
            $visited = array_fill(0, sizeof($matrix), array_fill(0, sizeof($matrix[$row]), False));
            if (wordFound($matrix, $word, $visited, 0, $row, $col)) {
                $result[] = [$row, $col];
            }
        }
    }
    return $result;
}

function wordFound($matrix, $word, &$visited, $index, $row, $col) {
    // check element is not char
    if ($matrix[$row][$col] !== $word[$index]) {
        return False;
    }
    // set visited to true
    $visited[$row][$col] = True;
    // check index is last, return true
    if ($index == strlen($word)-1) {
        // whole word is matched
        return True;
    }
    // 8 sides
    // up
    if ($row-1 >= 0 && !$visited[$row-1][$col]) {
        if (wordFound($matrix, $word, $visited, $index+1, $row-1, $col)) {
            return True;
        }
    }
    // up right
    if ($row-1 >= 0 && $col+1 < sizeof($matrix[$row]) && !$visited[$row-1][$col+1]) {
        if (wordFound($matrix, $word, $visited, $index+1, $row-1, $col+1)) {
            return True;
        }    
    }
    // right
    if ($col+1 < sizeof($matrix[$row]) && !$visited[$row][$col+1]) {
        if (wordFound($matrix, $word, $visited, $index+1, $row, $col+1)) {
            return True;
        }
    }
    // right btm
    if ($row+1 < sizeof($matrix) && $col+1 < sizeof($matrix[$row]) && !$visited[$row+1][$col+1]) {
        if (wordFound($matrix, $word, $visited, $index+1, $row+1, $col+1)) {
            return True;
        }
    }
    // btm
    if ($row+1 < sizeof($matrix) && !$visited[$row+1][$col]) {
        if (wordFound($matrix, $word, $visited, $index+1, $row+1, $col)) {
            return True;
        }
    }
    // btm left
    if ($row+1 < sizeof($matrix && $col-1 >= 0 && !$visited[$row+1][$col-1])) {
        if (wordFound($matrix, $word, $visited, $index+1, $row+1, $col-1)) {
            return True;
        }
    }
    // left
    if ($col-1 >= 0 && !$visited[$row][$col-1]) {
        if (wordFound($matrix, $word, $visited, $index+1, $row, $col-1)) {
            return True;
        }
    }
    // left top
    if ($row-1 >= 0 && $col-1 >= 0 && !$visited[$row-1][$col-1]) {
        if (wordFound($matrix, $word, $visited, $index+1, $row-1, $col-1)) {
            return True;
        }
    }
    return False;
}

$matrix1 = [
    ["G","E","E","K","S","F","O","R","G","E","E","K","S"],
    ["G","E","E","K","S","Q","U","I","Z","G","E","E","K"],
    ["I","D","E","Q","A","P","R","A","C","T","I","C","E"]
];
$word1 = "GEEKS";

print_r(findWordOccurences($matrix1, $word1));
