<?php

/**
 * Find the nth number in the fibonacci sequence.
 */

/**
 * Time: O(n)
 * Space: O(n)
 */
function nthFibo($n) {
    if ($n < 1) {
        return -1;
    }
    $memo[1] = 1;
    $memo[2] = 1;
    if ($n <= 2) {
        return $memo[$n];
    }
    for ($i=3; $i <= $n; $i++) { 
        $memo[$i] = $memo[$i-1] + $memo[$i-2];
    }
    return $memo[$n];
}

/**
 * Time: O(n)
 * Space: O(1)
 *
 */
function nthFibo2($n) {
    if ($n < 1) {
        return -1;
    }
    $value1 = 1;
    $value2 = 1;
    if ($n <= 2) {
        return 1;
    }
    for ($i=3; $i <= $n; $i++) { 
        $result = $value1 + $value2;
        $value1 = $value2;
        $value2 = $result;
    }
    return $result;
}

for ($i=0; $i <= 10; $i++) {
    echo nthFibo2($i) . " ";
}
echo PHP_EOL;
echo nthFibo2(1) . PHP_EOL;
echo nthFibo2(2) . PHP_EOL;
echo nthFibo2(3) . PHP_EOL;
echo nthFibo2(4) . PHP_EOL;
echo nthFibo2(5) . PHP_EOL;