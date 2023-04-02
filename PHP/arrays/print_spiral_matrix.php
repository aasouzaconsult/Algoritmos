<?php

// Write a function that takes a matrix and examines each item in a spiral
// order, printing each item as it comes to it.
//
// For example, given a matrix like this as input:
//
// [11, 12, 13, 14, 15],
// [24, 25, 26, 27, 16],
// [23  30, 29, 28, 17],
// [22, 21, 20, 19, 18],
// Your program must print:
//
// 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30

/**
 * Approach 1: peel off each layer in top, right, down, left order
 * Time: O((n+m) * lg(n*m))
 * Space: O(n*m)
 */
function printSpiralMatrix($matrix) {
    if (empty($matrix)) {
        return;
    }
    $result = [];
    while (!empty($matrix)) {
        // pop top
        $top = array_shift($matrix);
        $result = array_merge($result, $top);
        // pop right
        if (!empty($matrix)) {
            for ($i=0; $i < sizeof($matrix); $i++) { 
                $result[] = array_pop($matrix[$i]);
            }
        } else { break; }
        // pop down
        if (!empty($matrix)) {
            $down = array_pop($matrix);
            $result = array_merge($result, array_reverse($down));
        } else { break; }
        // pop left
        if (!empty($matrix)) {
            for ($i=sizeof($matrix)-1; $i >= 0; $i--) { 
                $result[] = array_shift($matrix[$i]);
            }
        } else { break; }
    }
    return implode(" ", $result);
}

$matrix1 = [];
$matrix1[] = [11, 12, 13, 14, 15];
$matrix1[] = [24, 25, 26, 27, 16];
$matrix1[] = [23, 30, 29, 28, 17];
$matrix1[] = [22, 21, 20, 19, 18];
$matrix1Result = "11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30";

$matrix2 = [
  [1,2,3,4],
  [5,6,7,8],
  [9,10,11,12],
  [13,14,15,16]
];
$matrix2Result = "1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10";

$matrix3 = [
  [1,2,3,4,5,6],
  [7,8,9,10,11,12],
  [13,14,15,16,17,18]
];
$matrix3Result = "1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11";

$matrix4 = [
    [1,2],
    [3,4],
    [5,6]
];
$matrix4Result = "1 2 4 6 5 3";

function equals($expected, $actual) {
    if ($expected === $actual) {
        echo "Success!" . PHP_EOL;
        return;
    }
    echo "Failed." . PHP_EOL;
    echo "Expected: " . PHP_EOL;
    print_r($expected);
    echo PHP_EOL;
    echo "Actual: " . PHP_EOL;
    print_r($actual);
    echo PHP_EOL;
}

equals($matrix1Result, printSpiralMatrix($matrix1));
equals($matrix2Result, printSpiralMatrix($matrix2));
equals($matrix3Result, printSpiralMatrix($matrix3));
equals($matrix4Result, printSpiralMatrix($matrix4));
