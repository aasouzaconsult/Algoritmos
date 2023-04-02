<?php

/**
 * Given a rod of length N inches and a table of prices P for i=1,2,...n,
 * determine the maximum revenue R obtainable by cutting up the rod and selling
 * the pieces. 
 * Note that if the price P for a rod length n is large enough, an optimal solution
 * may require no cutting at all.
 */

$price = [0,1,5,8,9,10,17,17,20,24,30];

/**
 * For each rod length, computations required are:
 * cutrod(4) -> cutrod(3), cutrod(2), cutrod(1), cutrod(0)
 * cutrod(3) -> cutrod(2), cutrod(1), cutrod(0)
 * cutrod(2) -> cutrod(1), cutrod(0)
 * cutrod(1) -> cutrod(0)
 *
 * Time complexity: O(2^n)
 * This algorithm explicitly considers the 2^(n-1) ways of cutting up the rod.
 * Computing each leaf explicitly.
 */
function cutRod($price, $rodLength) {
    if ($rodLength == 0) {
        return 0;
    }
    $revenue = 0;
    for ($i=1; $i <= $rodLength ; $i++) { 
        $revenue = max($revenue, $price[$i] + cutRod($price, $rodLength-$i));
    }
    return $revenue;
}

/**
 * Top down approach with memoization.
 * At each computation, we check if the computation has already been computed.
 * If yes, we just use the computed value. Else, we compute it.
 *
 * Time complexity: O(n^2)
 * 
 */
function cutRodMemoized($price, $rodLength) {
    $revenueTable = array_fill(0, $rodLength+1, -1);
    return _cutRodMemoized($price, $rodLength, $revenueTable);
}

function _cutRodMemoized($price, $rodLength, $revenueTable) {
    if ($rodLength == 0) {
        return 0;
    } elseif ($revenueTable[$rodLength] >= 0) {
        return $revenueTable[$rodLength];
    }
    $revenue = -1;
    for ($i=1; $i <= $rodLength; $i++) { 
        $revenue = max($revenue, $price[$i] + _cutRodMemoized($price, $rodLength-$i, $revenueTable));
    }
    $revenueTable[$rodLength] = $revenue;
    return $revenue;
}

/**
 * Bottom up approach.
 *
 * Time complexity: O(n^2)
 */
function cutRodV3($price, $rodLength) {
    $revenueTable = array_fill(0, $rodLength+1, -1);
    $optimalSize = array_fill(0, $rodLength+1, -1);
    $revenueTable[0] = 0;
    for ($i=1; $i <= $rodLength ; $i++) {
        for ($j=1; $j <= $i ; $j++) {
            if ($revenue < $price[$j] + $revenueTable[$i-$j]) {
                $revenue = $price[$j] + $revenueTable[$i-$j];
                $optimalSize[$i] = $j;
            }
        }
        $revenueTable[$i] = $revenue;
    }
    echo "rod length: " . $rodLength . 
        " revenue: " . $revenueTable[$rodLength] .
        " solution : " . implode(" ", getCutRodSolution($rodLength, $optimalSize)) . PHP_EOL;
    return $revenueTable[$rodLength];
}

function getCutRodSolution($rodLength, $optimal) {
    $result = [];
    $start = $rodLength;
    while ($start > 0) {
        $result[] = $optimal[$start];
        $start -= $optimal[$start];
    }
    return $result;
}

cutRodV3($price, 1);
cutRodV3($price, 2);
cutRodV3($price, 3);
cutRodV3($price, 4);
cutRodV3($price, 5);
cutRodV3($price, 6);
cutRodV3($price, 7);
cutRodV3($price, 8);
cutRodV3($price, 9);
cutRodV3($price, 10);