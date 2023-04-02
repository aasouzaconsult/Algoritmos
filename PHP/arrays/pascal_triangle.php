<?php

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * Pascal's triangle: To generate A[i][j] in row R, sum up A[i-1][j] and A[i-1][j-1]
 * in previous row.
 *
 * Eg. 
 * Given numRows = 5,
 * Return
 * [
 *    [1],
 *    [1,1],
 *    [1,2,1],
 *    [1,3,3,1],
 *    [1,4,6,4,1]
 *]
 */

/**
 * Time: O(n^2)
 * Space: O(n^2)
 */
function pascalTriangle($num) {
    if ($num < 1) {
        return;
    }
    // init 2d array to contain pascal triangle
    $pascals = array_fill(0, $num+1, array_fill(0, $num+1, 0));
    for ($i=0; $i < sizeof($pascals); $i++) { 
        $pascals[$i][0] = 1;
    }
    // construct pascal triangle
    for ($i=1; $i < sizeof($pascals); $i++) { 
        for ($j=1; $j <= $i; $j++) { 
            $pascals[$i][$j] = $pascals[$i-1][$j] + $pascals[$i-1][$j-1];
        }
    }
    // print pascal triangle
    for ($i=0; $i < sizeof($pascals); $i++) { 
        for ($j=0; $j <= $i; $j++) { 
            echo $pascals[$i][$j] . " ";
        }
        echo PHP_EOL;
    }
}

function printMatrix($matrix) {
    for ($i=0; $i < sizeof($matrix); $i++) { 
        for ($j=0; $j < sizeof($matrix[$i]); $j++) { 
            echo $matrix[$i][$j] . " ";
        }
        echo PHP_EOL;
    }
}

$num1 = 5;

pascalTriangle($num1);
