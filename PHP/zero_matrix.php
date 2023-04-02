<?php

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column
 * are set to 0.
 */

/**
 * create a boolean matrix out of given matrix, all init to True,
 * if an element is 0, set all row and column in bool matrix to False.
 * Check against bool matrix and re set all the values based on true/false of bool matrix.
 * Time: O(n^2)
 * Space: O(n^2)
 */
function zeroMatrix($matrix) {
    if (empty($matrix)) {
        return;
    }
    $temp = array_fill(0, sizeof($matrix[0]), True);
    $boolMatrix = array_fill(0, sizeof($matrix), $temp);
    
    for ($i=0; $i < sizeof($matrix); $i++) {
        for ($j=0; $j < sizeof($matrix[0]); $j++) {
            if ($matrix[$i][$j] == 0) {
                setRowColumnZero($boolMatrix, $i, $j);
            }
        }
    }
    for ($i=0; $i < sizeof($matrix); $i++) {
        for ($j=0; $j < sizeof($matrix[0]); $j++) {
            if (!$boolMatrix[$i][$j]) {
                $matrix[$i][$j] = 0;
            }
        }
    }
    return $matrix;
}

/**
 * Put row and column indexes in a collection to be checked later.
 * Time: O(n^2)
 * Space: O(n)
 */
function zeroMatrixV2($matrix) {
    if (empty($matrix)) {
        return;
    }
    $zeroRowIndexes = [];
    $zeroColIndexes = [];
    for ($i=0; $i < sizeof($matrix); $i++) {
        for ($j=0; $j < sizeof($matrix[0]); $j++) {
            if ($matrix[$i][$j] == 0) {
                $zeroRowIndexes[] = $i;
                $zeroColIndexes[] = $j;
            }
        }
    }
    for ($j=0; $j < sizeof($matrix[0]); $j++) { 
        foreach ($zeroRowIndexes as $value) {
            $matrix[$value][$j] = 0;
        }
    }
    for ($i=0; $i < sizeof($matrix); $i++) { 
        foreach ($zeroColIndexes as $value) {
            $matrix[$i][$value] = 0;
        }
    }
    return $matrix;
}

function setRowColumnZero(&$resultMatrix, $row, $column) {
    for ($i=0; $i < sizeof($resultMatrix); $i++) { 
        for ($j=0; $j < sizeof($resultMatrix[0]); $j++) { 
            if ($i == $row || $j == $column) {
                $resultMatrix[$i][$j] = False;
            }
        }
    }
}

function print2Darray($arr) {
    for ($i=0; $i < sizeof($arr); $i++) { 
        for ($j=0; $j < sizeof($arr[$i]); $j++) { 
            echo $arr[$i][$j] . " ";
        }
        echo PHP_EOL;
    }
}

$matrix = [
    [1,2,3,4,5,0,7],
    [1,2,3,4,5,6,7],
    [1,2,3,0,5,6,7],
    [1,2,3,4,5,6,7],
];

print2Darray(zeroMatrix($matrix));
echo PHP_EOL;
print2Darray(zeroMatrixV2($matrix));