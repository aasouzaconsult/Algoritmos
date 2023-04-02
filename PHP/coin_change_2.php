<?php

// You are given coins of different denominations and a total amount of money
// amount. Write a function to compute the fewest number of coins that you need
// to make up that amount. If that amount of money cannot be made up by any
// combination of the coins, return -1.

// Example 1:
// coins = [1, 2, 5], amount = 11
// return 3 (11 = 5 + 5 + 1)

// Example 2:
// coins = [2], amount = 3
// return -1.

// Note:
// You may assume that you have an infinite number of each kind of coin.

/**
 * DP solution.
 * Time: O(n*V) where n is size of denom, V is value
 * Space: O(2n*V)
 */
function coinChange($value, $denom) {
    if ($value < 0 || empty($denom)) {
        return [-1, ""];
    }
    sort($denom);
    $tableCol = array_fill(0, $value+1, -1);
    $table = array_fill(0, sizeof($denom), $tableCol);

    $usedCol = array_fill(0, $value+1, False);
    $used = array_fill(0, sizeof($denom), $usedCol);

    // init base cases
    for ($i=0; $i < $value+1; $i++) { 
        if ($i == 0) {
            $table[0][$i] = 0;
        } else {
            if ($i % $denom[0] != 0) {
                $table[0][$i] = -1;
            } else {
                $table[0][$i] = 1 + $table[0][$i-$denom[0]];
                $used[0][$i] = True;
            }
        }
    }
    // compute dp table
    for ($row=1; $row < sizeof($table); $row++) { 
        for ($col=0; $col < sizeof($table[$row]); $col++) { 
            if ($col < $denom[$row] || $table[$row-1][$col] < 1 + $table[$row][$col-$denom[$row]]) {
                $table[$row][$col] = $table[$row-1][$col];
                $used[$row][$col] = False;
            } else {
                $table[$row][$col] = 1 + $table[$row][$col-$denom[$row]];
                $used[$row][$col] = True;
            }

            // handle -1 cases where change cant be given for previous optimal cases
            if ($col >= $denom[$row]) {
                if ($table[$row][$col-$denom[$row]] == -1) {
                    $table[$row][$col] = $table[$row-1][$col];
                    $used[$row][$col] = False;
                } else {
                    if ($table[$row-1][$col] != -1) {
                        // get min
                        if ($table[$row-1][$col] < 1 + $table[$row][$col-$denom[$row]]) {
                            $table[$row][$col] = $table[$row-1][$col];
                            $used[$row][$col] = False;
                        }
                    } else {
                        $table[$row][$col] = 1 + $table[$row][$col-$denom[$row]];
                        $used[$row][$col] = True;        
                    }
                }
            }
        }
    }
    $result = "";
    computeCoins($denom, $used, sizeof($denom)-1, $value, $result);
    return [$table[sizeof($denom)-1][$value], $result];
}

function computeCoins($denom, $used, $row, $col, &$result) {
    if ($col == 0) {
        return;
    }
    if ($used[$row][$col]) {
        $result .= $denom[$row] . " ";
        computeCoins($denom, $used, $row, $col-$denom[$row], $result);
    } else {
        computeCoins($denom, $used, $row-1, $col, $result);
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

$denom1 = [1, 2, 5];
$value1 = 11;

$denom2 = [2,5];
$value2 = 7;

echo implode(" ", coinChange($value1, $denom1)) . PHP_EOL;
echo implode(" ", coinChange($value2, $denom2)) . PHP_EOL;