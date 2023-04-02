<?php

/**
 * Imagine a robot sitting on the upper left corner of grid with r rows and c
 * columns. The robot can only move in two directions, right and down, but certain
 * cells are "off limits" such that the robot cannot step on them. Design an
 * algorithm to find a path for the robot from the top left to the bottom right.
 */

/**
 * DFS approach to finding the path to end.
 * Time: O(n*m) where n is max grid row, m is max col row
 * Space: O(n*m)
 */
function computePath($grid, $start, $end) {
    // set visited grid
    $visited = array_fill(0, sizeof($grid), array_fill(0, sizeof($grid[0]), False));
    setOffLimitGrids($grid, $visited);

    // init stack and result array
    list($stack, $result) = [[],[]];
    $stack[] = [$start->row, $start->col];

    while (!empty($stack)) {
        $newPathFound = False;
        $coord = array_pop($stack);
        $result[] = $coord;

        $row = $coord[0];
        $col = $coord[1];
        $visited[$row][$col] = True;

        if ($row == $end->row && $col == $end->col) {
            return $result;
        }

        if ((!$visited[$row+1][$col] || !$visited[$row][$col+1])) {
            // row+1 is not visited and within grid
            if ($row+1 <= sizeof($grid)-1 && !$visited[$row+1][$col]) {
                $stack[] = [$row+1, $col];
                $newPathFound = True;
            }
            // col+1 is not visited and within grid
            if ($col+1 <= sizeof($grid[0])-1 && !$visited[$row][$col+1]) {
                $stack[] = [$row, $col+1];
                $newPathFound = True;
            }
        }
        if (!$newPathFound) {
            deleteDeadPaths($visited, $result);
        }
    }
    return [];
}

/**
 * DP solution.
 * Time: O(n*m) where n is max grid row, m is max col row
 * Space: O(n*m)
 */
function computePathV2($grid, $start, $end) {
    if (empty($grid)) {
        return [];
    }
    list($result, $failedPoints) = [[],[]];
    $failedPoints = [1,4];
    $failedPoints = [2,2];
    $failedPoints = [3,3];
    $failedPoints = [2,5];
    $failedPoints = [3,3];
    $failedPoints = [4,1];
    if (computePathRecur($grid, $end->row, $end->col, $result, $failedPoints)) {
        return $result;
    }
    return [];
}

function computePathRecur($grid, $row, $col, &$result, &$failed) {
    // if out of bounds or not available, return
    if (row < 0 || $col < 0 || (!$grid[row][$col] && $grid[$row][$col] != 0)) {
        return False;
    }

    $point = [$row, $col];
    if (in_array($point, $failed)) {
        return False;
    }
    $isOrigin = $row == 0 && $col == 0;
    if ($isOrigin || computePathRecur($grid, $row, $col-1, $result, $failed) ||
        computePathRecur($grid, $row-1, $col, $result, $failed)) {
        $result[] = $point;
        return True;
    }
    $failed[] = $point;
    return False;
}

// Supporting functions

function deleteDeadPaths($visited, &$result) {
    while (True) {
        if (empty($result)) {
            return [];
        } else {
            $prev = $result[sizeof($result)-1];

            $prevRow = $prev[0];
            $prevCol = $prev[1];
            // row is true OR out of bounds
            // col is true OR out of bounds
            if (($visited[$prevRow+1][$prevCol] || $prevRow+1 >= sizeof($visited)) &&
                ($visited[$prevRow][$prevCol+1] || $prevCol+1 >= sizeof($visited[0]))) {
                array_pop($result);
            } else {
                break;
            }
        }
    }
    return;
}

function setOffLimitGrids($grid, &$visited) {
    for ($i=0; $i < sizeof($grid); $i++) { 
        for ($j=0; $j < sizeof($grid[$i]); $j++) { 
            if ($grid[$i][$j] == 1) {
                $visited[$i][$j] = True;
            }
        }
    }
}

class Coordinate {
    public $row;
    public $col;

    public function __construct($row, $col) {
        $this->row = $row;
        $this->col = $col;
    }

    public function printCoordinate() {
        echo $this->row . " " . $this->col . PHP_EOL;
    }
}

function printGrid($grid) {
    for ($i=0; $i < sizeof($grid); $i++) { 
        for ($j=0; $j < sizeof($grid[$i]); $j++) { 
            echo $grid[$i][$j] . " ";
        }
        echo PHP_EOL;
    }
}

$grid = [
    [0,0,0,0,0,0],
    [0,0,0,0,1,0],
    [0,0,1,0,0,1],
    [0,0,0,1,0,0],
    [0,1,0,0,0,0],
    [0,0,0,0,0,0],
];

$start = new Coordinate(0,0);
$end = new Coordinate(sizeof($grid)-1, sizeof($grid[0])-1);

printGrid(computePath($grid, $start, $end));
// printGrid(computePathV2($grid, $start, $end));