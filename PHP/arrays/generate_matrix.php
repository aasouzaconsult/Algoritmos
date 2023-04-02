<?php

/**
 * https://www.interviewbit.com/problems/spiral-order-matrix-ii/
 *  Given an integer n, generate a square matrix filled with elements from 1 to
 * n^2 in spiral order.
 *
 * Example:
 *
 * Given n = 3,
 *
 * You should return the following matrix:
 *  [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ] 
 */

/**
 * Construct the matrix of n size and insert elements in spiral order.
 * Time: O(n^2)
 * Space: O(n^2)
 *
 */
function generateMatrix($n) {
    if ($n < 1) {
        return [];
    }
    $limit = pow($n, 2);
    $matrix = array_fill(0, $n, array_fill(0, $n, -1));
    list($curr, $row, $col) = [1, 0, 0];

    while ($curr <= $limit) {
        // top
        while (True) {
            if ($col < sizeof($matrix[0]) && $matrix[$row][$col] == -1) {
                $matrix[$row][$col] = $curr;
                $curr++;
                $col++;
            } else {
                $col--;
                break;
            }
        }
        // right
        $row++;
        while (True) {
            if ($row < sizeof($matrix) && $matrix[$row][$col] == -1) {
                $matrix[$row][$col] = $curr;
                $curr++;
                $row++;
            } else {
                $row--;
                break;
            }
        }
        // down
        $col--;
        while (True) {
            if ($col >= 0 && $matrix[$row][$col] == -1) {
                $matrix[$row][$col] = $curr;
                $curr++;
                $col--;
            } else {
                $col++;
                break;
            }
        }
        // left
        $row--;
        while (True) {
            if ($row >= 0 && $matrix[$row][$col] == -1) {
                $matrix[$row][$col] = $curr;
                $curr++;
                $row--;
            } else {
                $row++;
                break;
            }
        }
        $col++;
    }
    return $matrix;
}

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
$n1 = 3; 
$result1 = [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ];

equals($result1, generateMatrix($n1));
