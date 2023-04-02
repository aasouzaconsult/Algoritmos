<?php

// Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row
// and column to 0.
// Do it in place.
// 
// Example:
// 
// Input:
// 1 0 1
// 1 1 1 
// 1 1 1
// 
// Output:
// 0 0 0
// 1 0 1
// 1 0 1

/**
 * Time: O(m * n) where m n are row and col size of matrix respectively
 * Space: O(1)
 */
function setZerosOptimal($matrix) {
    if (empty($matrix)) {
        return;
    }
    $colSize = sizeof($matrix[0]);
    $rowSize = sizeof($matrix);
    // decide if first row should be zero
    $firstRowZero = False;
    for ($col=0; $col < $colSize; $col++) { 
        if ($matrix[0][$col] == 0) {
            $firstRowZero = True;
            break;
        }
    }
    // decide if first col should be zero
    $firstColZero = False;
    for ($row=0; $row < $rowSize; $row++) { 
        if ($matrix[$row][0] == 0) {
            $firstColZero = True;
            break;
        }
    }

    // loop through rest of matrix to find zeros
    for ($row=1; $row < $rowSize; $row++) { 
        for ($col=1; $col < $colSize; $col++) { 
            if ($matrix[$row][$col] == 0) {
                $matrix[0][$col] = 0;
                $matrix[$row][0] = 0;
            }
        }
    }
    // set cols with first element 0 to whole row 0
    for ($col=0; $col < $colSize; $col++) { 
        if ($matrix[0][$col] == 0) {
            setColZero($matrix, $col);
        }
    }
    // set rows with first element 0 to whole row 0
    for ($row=0; $row < $rowSize; $row++) { 
        if ($matrix[$row][0] == 0) {
            setRowZero($matrix, $row);
        }
    }
    if ($firstRowZero) {
        setRowZero($matrix, 0);
    }
    if ($firstColZero) {
        setColZero($matrix, 0);
    }
    return $matrix;
}

function setColZero(&$matrix, $col) {
    for ($row=0; $row < sizeof($matrix); $row++) { 
        $matrix[$row][$col] = 0;
    }
}

function setRowZero(&$matrix, $row) {
    for ($col=0; $col < sizeof($matrix[0]); $col++) { 
        $matrix[$row][$col] = 0;
    }
}

/**
 * store the row and col at which a zero is found.
 * then use this info to set the matrix
 * Time: O(m * n)
 * Space: O(m + n)
 */
function setZerosV2($matrix) {
    if (empty($matrix)) {
        return;
    }
    $rows = [];
    $cols = [];
    for ($row=0; $row < sizeof($matrix); $row++) { 
        for ($col=0; $col < sizeof($matrix[$row]); $col++) { 
            if ($matrix[$row][$col] == 0) {
                if (!isset($rows[$row])) {
                    $rows[$row] = 1;
                }
                if (!isset($cols[$col])) {
                    $cols[$col] = 1;
                }
            }
        }
    }
    foreach ($rows as $row => $value) {
        for ($i=0; $i < sizeof($matrix[0]); $i++) { 
            $matrix[$row][$i] = 0;
        }
    }
    foreach ($cols as $col => $value) {
        for ($i=0; $i < sizeof($matrix); $i++) { 
            $matrix[$i][$col] = 0;
        }
    }
    return $matrix;
}

/**
 * Use a truth table to decide which element is 1/0.
 * Then adjust the matrix with the truth table.
 * Time: O(m * n) where m row size, n is col size
 * Space: O(m * n)
 */
function setZeros($matrix) {
    if (empty($matrix)) {
        return;
    }
    $truthTable = array_fill(0, sizeof($matrix), array_fill(0, sizeof($matrix[0]), True));

    for ($row=0; $row < sizeof($matrix); $row++) { 
        for ($col=0; $col < sizeof($matrix[$row]); $col++) { 
            if ($matrix[$row][$col] == 0) {
                setRowFalse($truthTable, $row);
                setColFalse($truthTable, $col);
            }
        }
    }
    for ($row=0; $row < sizeof($matrix); $row++) { 
        for ($col=0; $col < sizeof($matrix[$row]); $col++) {
            if (!$truthTable[$row][$col]) {
                $matrix[$row][$col] = 0;
            }
        }
    }
    return $matrix;
}

function printMatrix($matrix) {
    for ($row=0; $row < sizeof($matrix); $row++) { 
        for ($col=0; $col < sizeof($matrix[$row]); $col++) { 
            echo $matrix[$row][$col] . " ";
        }
        echo PHP_EOL;
    }
}

function setRowFalse(&$table, $row) {
    for ($col=0; $col < sizeof($table[$row]); $col++) { 
        $table[$row][$col] = False;
    }
}

function setColFalse(&$table, $col) {
    for ($row=0; $row < sizeof($table); $row++) { 
        $table[$row][$col] = False;
    }
}

$mat1 = [
    [1,0,1],
    [1,1,1],
    [1,1,1],
];

printMatrix(setZeros($mat1));
printMatrix(setZerosV2($mat1));
printMatrix(setZerosOptimal($mat1));
