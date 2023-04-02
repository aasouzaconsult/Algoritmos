<?php

/**
 * Give a N*N square matrix, return an array of its anti-diagonals. Look at the
 * example for more details.
 * Input:   
 * 
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 
 * Return the following :
 * 
 * [ 
 *   [1],
 *   [2, 4],
 *   [3, 5, 7],
 *   [6, 8],
 *   [9]
 * ]
 * 
 * Input : 
 * 1 2
 * 3 4
 * 
 * Return the following  : 
 * 
 * [
 *   [1],
 *   [2, 3],
 *   [4]
 * ]
 */

function antiDiagonal($matrix) {
    if (empty($matrix)) {
        return $matrix;
    }
    $visited = array_fill(0, sizeof($matrix), array_fill(0, sizeof($matrix), False));
    $queue[] = [0, [0,0]]; // starting coordinate
    $result = [];

    while (!empty($queue)) {
        $data = array_shift($queue);
        list($index, $row, $col) = [$data[0], $data[1][0], $data[1][1]];
        $visited[$row][$col] = True;

        if (!isset($result[$index])) {
            $result[$index] = [$matrix[$row][$col]];
        } else {
            $result[$index][] = $matrix[$row][$col];
        }
        
        if ($col+1 < sizeof($matrix) && !$visited[$row][$col+1]) {
            $newData = [$index+1, [$row, $col+1]];
            if (!in_array($newData, $queue)) {
                $queue[] = $newData;
            }
        }
        if ($row+1 < sizeof($matrix) && !$visited[$row+1][$col]) {
            $newData = [$index+1, [$row+1, $col]];
            if (!in_array($newData, $queue)) {
                $queue[] = $newData;
            }
        }
    }
    return $result;
}

$matrix1 = [
    [1,2,3],
    [4,5,6],
    [7,8,9]
];
$matrix2 = [
    [1,2],
    [3,4]
];
$res = antiDiagonal($matrix1);
foreach ($res as $data) {
    echo implode(" ", $data) . PHP_EOL;
}

$res = antiDiagonal($matrix2);
foreach ($res as $data) {
    echo implode(" ", $data) . PHP_EOL;
}