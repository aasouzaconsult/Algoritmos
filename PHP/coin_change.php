<?php

/**
 * Given unlimited number of coins with denominations of the following:
 * CoinValue: {1,6,10}
 * Find the least number of coins required to return a value of 12.
 */

/**
 * Recurrence Relation.
 * C[i][j] = 0, if j = 0. ie. value to change is 0
 * C[i][j] = C[i-1][j],   if j < denom[i]
 * C[i][j] = min(C[i-1][j], C[i][j-denom[i]]),   if j >= denom[i]
 * Time: O(n*m) where n is value, and m is size of denom
 * Space: O(n*m)
 */
function coinChange($value, $denom) {
    // check for empty denom or -ve value
    if (empty($denom) || $value < 0) {
        return [0, ""];
    }
    // set up DP table
    $values = array_fill(0, $value+1, -1);
    $table = array_fill(0, sizeof($denom), $values);
    // set up used table
    $usedCol = array_fill(0, $value+1, False);
    $used = array_fill(0, sizeof($denom), $usedCol);

    for ($i=0; $i < $value+1; $i++) { 
        $used[0][$i] = True;
    }
    // fill table according to recurrence relation
    //     if j == 0
    //         C[i][j] = 0
    //     elseif j < denom[i] or C[i-1][j] is the smaller value
    //         C[i][j] = C[i-1][j]
    //         set used[i][j] = false
    //     else
    //         C[i][j] = C[i][j-denom[i]] + 1
    //         set used[i][j] = true
    for ($row=0; $row < sizeof($table); $row++) { 
        for ($col=0; $col < sizeof($table[$row]); $col++) { 
            if ($col == 0) {
                $table[$row][$col] = 0;
            } elseif ($row == 0) {
                $table[$row][$col] = $col;
            } elseif ($col < $denom[$row] || $table[$row-1][$col] < 1 + $table[$row][$col-$denom[$row]]) {
                $table[$row][$col] = $table[$row-1][$col];
                $used[$row][$col] = False;
            } else {
                $table[$row][$col] = 1 + $table[$row][$col-$denom[$row]];
                $used[$row][$col] = True;
            }
        }
    }
    $coins = [];
    $coinCount = $table[sizeof($table)-1][sizeof($table[$row-1])-1];
    computeCoins($used, $denom, sizeof($table)-1, sizeof($table[$row-1])-1, $coins);
    $coins = implode(",", $coins);
    return [$coinCount, $coins];
}

function computeCoins($used, $denom, $row, $col, &$coins) {
    if ($col == 0) {
        return;
    }
    if ($used[$row][$col]) {
        $coins[] = $denom[$row];
        computeCoins($used, $denom, $row, $col-$denom[$row], $coins);
    } else {
        computeCoins($used, $denom, $row-1, $col, $coins);
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

$denom1 = [1, 6, 10];
$value1 = 12;

echo implode(" ", coinChange($value1, $denom1)) . PHP_EOL;