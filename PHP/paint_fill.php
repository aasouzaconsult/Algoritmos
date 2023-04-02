<?php

/**
 * Implement the "paint fill" function that one might see on many image editing
 * programs, That is, given a screen(represented by two-dimensional array of colors),
 * a point, and a new color, fill the surrounding area until the color changes
 * from the original color.
 */

function paintFill(&$screen, $point, $color) {
    if (empty($screen) || $screen[$point[0]][$point[1]] == $color) {
        // empty screen
        return $screen;
    } elseif ($point[0] >= sizeof($screen) || $point[1] >= sizeof($screen[0])) {
        // point is out of screen
        return -1;
    }
    $visited = array_fill(0, sizeof($screen), array_fill(0, sizeof($screen[0]), False));
    $originalColor = $screen[$point[0]][$point[1]];
    $queue = [$point];

    while (!empty($queue)) {
        $point = array_shift($queue);
        list($row, $col) = $point;
        $visited[$row][$col] = True;
        $screen[$row][$col] = $color;
        // check up
        if ($row - 1 >= 0 && $screen[$row-1][$col] == $originalColor) {
            enqueueUnvisitedPoint($queue, $visited, $row-1, $col);
        }
        // check right
        if ($col + 1 < sizeof($screen[0]) && $screen[$row][$col+1] == $originalColor) {
            enqueueUnvisitedPoint($queue, $visited, $row, $col+1);
        }
        // check down
        if ($row + 1 < sizeof($screen) && $screen[$row+1][$col] == $originalColor) {
            enqueueUnvisitedPoint($queue, $visited, $row+1, $col);
        }
        // check left
        if ($col-1 >= 0 && $screen[$row][$col-1] == $originalColor) {
            enqueueUnvisitedPoint($queue, $visited, $row-1, $col-1);
        }
    }
    return $screen;
}

function enqueueUnvisitedPoint(&$queue, $visited, $row, $col) {
    if (!$visited[$row][$col]) {
        $queue[] = [$row, $col];
    }
}

function printScreen($screen) {
    for ($i=0; $i < sizeof($screen); $i++) { 
        for ($j=0; $j < sizeof($screen[$i]); $j++) { 
            echo $screen[$i][$j] . " ";
        }
        echo PHP_EOL;
    }
}

$screen = [
//   0 1 2 3 4 5 6 7 8 9
    [1,1,1,2,2,4,4,4,4,4], // 0
    [1,1,1,2,2,4,4,4,4,5], // 1
    [1,1,2,2,2,2,2,5,5,5], // 2
    [1,1,2,2,2,2,5,5,5,5], // 3
    [8,8,8,8,8,2,5,5,5,6], // 4
    [9,9,8,8,8,5,5,5,6,6], // 5
    [9,9,9,9,6,6,6,6,6,6], // 6
    [9,9,3,3,6,6,6,6,7,7], // 7
    [9,3,3,3,6,6,6,7,7,7], // 8
    [3,3,3,3,6,6,6,7,7,7], // 9
];

$point1 = [4,5];
$point2 = [9,9];
$point3 = [0,9];
$point4 = [9,0];
$point5 = [0,0];
$color1 = 0;

paintFill($screen, $point5, $color1);
printScreen($screen);
