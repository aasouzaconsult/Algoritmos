<?php

/*
Given a number of coin denominations, what's the fewest number of coins to return
if we are to return A coins?
 */

// mission: for A coins, find out the fewest number of coins to return that makes up
// exactly A coin value.

function coinChange($denom, $value) {
    // init coins table
    $perDenom = array_fill(0, $value+1, -1);
    $coins = array_fill(0, sizeof($denom), $perDenom);
    // init used array
    $perRow = array_fill(0, $value+1, False);
    $used = array_fill(0, sizeof($denom), $perRow);

    // loop through every element and compute coin numbers
    for ($i=0; $i < sizeof($denom); $i++) { 
        for ($j=0; $j < $value+1; $j++) { 
            if ($i == 0) {
                $coins[$i][$j] = $j;
                $used[$i][$j] = True;
            } else {
                if ($denom[$i] > $j || $coins[$i-1][$j] < 1 + $coins[$i][$j - $denom[$i]]) {
                    $coins[$i][$j] = $coins[$i-1][$j];
                    $used[$i][$j] = False;
                } else {
                    $coins[$i][$j] = 1 + $coins[$i][$j - $denom[$i]];
                    $used[$i][$j] = True;
                }
            }
        }
    }
    optimalCoins(sizeof($denom)-1, $value, $denom, $used);
    return $coins[sizeof($denom)-1][$value];
}

function optimalCoins($i, $j, $denom, $used) {
    if ($j == 0) {
        return;
    }
    if ($used[$i][$j]) {
        echo "Used a coin of denomination: " . $denom[$i] . PHP_EOL;
        optimalCoins($i, $j-$denom[$i], $denom, $used);
    } else {
        optimalCoins($i-1, $j, $denom, $used);
    }
}

function print2Darray($arr) {
    for ($i=0; $i < sizeof($arr); $i++) { 
        echo implode(" ", $arr[$i]) . PHP_EOL;
    }
}

$denom = [
    0 => 1,
    1 => 6,
    2 => 10
];

echo coinChange($denom, 12);