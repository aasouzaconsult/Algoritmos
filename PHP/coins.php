<?php

/**
 * Given an infinite number of quarters 25cents, 10 cents, 5 cents and 1 cent,
 * write code to calculate the number of ways of representing n cents.
 */

/**
 * DP table solution.
 * Recurrence relation:
 * 1. DP[i][j],    if j == 0
 * 2. DP[i-1][j],  if j < denom[i]
 * 3. DP[i-1][j] + DP[i][j-denom[i]],   if j >= denom[i]
 * 
 * Time: O(n*m) where n is number of coin denominations, m is size of change
 * Space: O(n*m)
 *
 */
function waysToChange($denom, $change) {
    if (empty($denom)) {
        return 0;
    } elseif ($change < 0) {
        return -1;
    }
    $table = array_fill(0, sizeof($denom), array_fill(0, $change+1, -1));

    for ($row=0; $row < sizeof($table); $row++) { 
        for ($col=0; $col < sizeof($table[$row]); $col++) { 
            if ($col == 0) {
                $table[$row][$col] = 1;
            } elseif ($col < $denom[$row]) {
                $table[$row][$col] = $table[$row-1][$col];
            } else {
                $table[$row][$col] = $table[$row-1][$col] +
                    $table[$row][$col-$denom[$row]];
            }
        }
    }
    printScreen($table);
    return $table[sizeof($denom)-1][$change];
}

function printScreen($screen) {
    for ($i=0; $i < sizeof($screen); $i++) { 
        for ($j=0; $j < sizeof($screen[$i]); $j++) { 
            echo $screen[$i][$j] . " ";
        }
        echo PHP_EOL;
    }
}

$denom1 = [1,2,6,10];
$denom2 = [1,5,10,25];

$change1 = 12;
$change2 = 63;

echo waysToChange($denom1, $change1) . PHP_EOL;
echo waysToChange($denom2, $change2) . PHP_EOL;