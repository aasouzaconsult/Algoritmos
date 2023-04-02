<?php

// You are given an n x n 2D matrix representing an image.
// Rotate the image by 90 degrees (clockwise).
// You need to do this in place.
// Note that if you end up using an additional array, you will only receive partial score.

// Example:
// If the array is
// [
//     [1, 2],
//     [3, 4]
// ]
// Then the rotated array becomes:
// [
//     [3, 1],
//     [4, 2]
// ]

/**
 * Time: O(n^2)
 * Space: O(n^2)
 *
 */
function rotateMatrixBrute($matrix) {
    if (empty($matrix)) {
        return;
    }
    $result = array_fill(0, sizeof($matrix), array_fill(0, sizeof($matrix[0]), 0));
    // loop through row by row from matrix
    for ($row=0; $row < sizeof($matrix); $row++) { 
        $j = 0;
        $col = sizeof($matrix)-1-$row;
        while ($j < sizeof($matrix)) {
            $result[$j][$col] = $matrix[$row][$j];
            $j++;
        }
    }
    return $result;
}

/**
 * Time: O(n^2)
 * Space: O(1)
 *
 */
function rotateMatrixV2($matrix) {
    if (empty($matrix)) {
        return;
    }
    // consider each layer
    for ($layer=0; $layer < sizeof($matrix) / 2; $layer++) { 
        $first = $layer;
        $last = sizeof($matrix) - 1 - $first;
        for ($j=$first; $j < $last; $j++) { 
            $offset = $j - $first;
            // save top
            $top = $matrix[$first][$j];
            // left -> top
            $matrix[$first][$j] = $matrix[$last-$offset][$first];
            // btm -> left
            $matrix[$last-$offset][$first] = $matrix[$last][$last-$offset];
            // right -> btm
            $matrix[$last][$last-$offset] = $matrix[$j][$last];
            // top -> right
            $matrix[$j][$last] = $top;
        }
    }
    return $matrix;
}

function printMatrix($matrix) {
    for ($i=0; $i < sizeof($matrix); $i++) { 
        for ($j=0; $j < sizeof($matrix[$i]); $j++) { 
            echo $matrix[$i][$j] . " ";
        }
        echo PHP_EOL;
    }
}

$matrix1 = [
    [1,2,3,4],
    [5,6,7,8],
    [9,10,11,12],
    [13,14,15,16],
];

$matrix2 = [
    [1,2],
    [3,4]
];

$matrix3 = [
    [1,2,3,4,5],
    [6,7,8,9,10],
    [11,12,13,14,15],
    [16,17,18,19,20],
    [21,22,23,24,25]
];

$result = rotateMatrixV2($matrix1);
printMatrix($result);
echo PHP_EOL;
// printMatrix(rotateMatrixV2($matrix2));
// echo PHP_EOL;
// printMatrix(rotateMatrixV2($matrix3));