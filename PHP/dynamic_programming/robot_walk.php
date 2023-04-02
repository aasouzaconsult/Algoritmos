<?php

// A robot can take steps of 1 meter or 2 meters. Write an algorithm to output all of
// the ways the robot can walk n meters.

// mission: given an input of n meters to walk, output the number of ways to walk these n meters
// base case:
// - 1m - 1 ways (1)
// - 2m - 2 ways (1,1) (2)
// - 3m - 3 ways (1,1,1) (1,2) (2,1)
// - 4m - 4 ways (1,1,1,1) (1,1,2) (1,2,1) (2,1,1) (2,2)
// - Nm - (N-1) + (N-2) ways

function robotWalkWays($meters) {
    $table = array_fill(0, $meters+1, -1);
    $table[0] = 0;
    $table[1] = 1;
    $table[2] = 2;
    for ($i=3; $i <= $meters; $i++) { 
        $table[$i] = $table[$i-1] + $table[$i-2];
    }
    return $table[$meters];
}

echo robotWalkWays(0) . PHP_EOL;
echo robotWalkWays(1) . PHP_EOL;
echo robotWalkWays(2) . PHP_EOL;
echo robotWalkWays(3) . PHP_EOL;
echo robotWalkWays(4) . PHP_EOL;