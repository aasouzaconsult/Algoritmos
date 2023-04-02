<?php

/**
 * Given an M x N matrix in which each row and each column is sorted in ascending
 * order, write a method to find an element.
 */

/**
 * Brute Force.
 * Iterate through every element and find the element in question.
 * Time: O(nm) where n is number of rows, m is number of columns
 * Space: O(1)
 */
function matrixSearch($matrix, $value) {
    for ($i=0; $i < sizeof($matrix); $i++) { 
        for ($j=0; $j < sizeof($matrix[$i]); $j++) { 
            if ($matrix[$i][$j] == $value) {
                return [$i, $j];
            }
        }
    }
    return;
}

/**
 * Look at the first element of each row.
 * If $first == $value, return [i,j]
 * If $first < $value, move to next row.
 * If $first > $value. go back to the previous row.
 *
 * Once you found the row to traverse above, traverse the row itself to find the
 * element. if element is bigger than value. return not found.
 *
 * Time: O(m) where m is the row/column with the higher value.
 * Space: O(1)
 */
function matrixSearchV2($matrix, $value) {
    // our last resort is to try to find the value in last row.
    $index = sizeof($matrix)-1;
    for ($i=0; $i < sizeof($matrix); $i++) { 
        if ($matrix[$i][0] == $value) {
            return [$i, 0];
        } elseif ($matrix[$i][0] > $value) {
            $index = $i-1;
            break;
        }
    }
    for ($i=1; $i < sizeof($matrix[$index]); $i++) { 
        if ($matrix[$index][$i] == $value) {
            return [$index, $i];
        } elseif ($matrix[$index][$i] > $value) {
            break;
        }
    }
    return;
}

/**
 * Triangulation method.
 * Time: O(nm)
 */
function matrixSearchV3($matrix, $value) {
    $row = 0;
    $col = sizeof($matrix[0]) - 1;

    while ($row <= sizeof($matrix) && $col >= 0) {
        if ($matrix[$row][$col] == $value) {
            return [$row, $col];
        } elseif ($matrix[$row][$col] > $value) {
            $col--;
        } else {
            $row++;
        }
    }
    return;
}

/**
 * Ripple effect method.
 * Like a ripple starting from 0,0. Check if the (i,i)th element is bigger than
 * the value. The first time the element gets bigger than the value. We search
 * that row and column for the value.
 * If value not found, the value is not in the matrix.
 *
 * NOTE: this only works for square matrix.
 */
function matrixSearchV4($matrix, $value) {

}

$matrix = [
    [1,2,3,4,5,6],
    [7,8,9,10,11,12],
    [13,14,15,16,17,18],
];

// echo implode(" ", matrixSearch($matrix, 10)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 1)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 2)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 3)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 4)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 5)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 6)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 7)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 8)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 9)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 10)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 11)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 12)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 13)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 14)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 15)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 16)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 17)) . PHP_EOL;
echo implode(" ", matrixSearchV2($matrix, 18)) . PHP_EOL;

echo implode(" ", matrixSearchV3($matrix, 1)) . PHP_EOL;
echo implode(" ", matrixSearchV3($matrix, 4)) . PHP_EOL;
echo implode(" ", matrixSearchV3($matrix, 9)) . PHP_EOL;
echo implode(" ", matrixSearchV3($matrix, 11)) . PHP_EOL;
echo implode(" ", matrixSearchV3($matrix, 16)) . PHP_EOL;
echo implode(" ", matrixSearchV3($matrix, 18)) . PHP_EOL;