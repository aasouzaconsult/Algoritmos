<?php

/**
 * A child is running up a staircase with n steps and can hope either 1 step, 2 steps,
 * or 3 steps at a time. Implement a method to count how many possible ways the
 * child can run up the stairs.
 */

/**
 * Brute Force.
 * Recursion.
 * Time: O(3^n)
 * Space: O(3^n)
 *
 */
function waysBrute($n) {
    if ($n < 0) {
        return -1;
    }
    if ($n <= 1) {
        return 1;
    }
    if ($n == 2) {
        return 2;
    }
    return waysBrute($n-3) + waysBrute($n-2) + waysBrute($n-1);
}

/**
 * DP bottom up approach.
 * Time: O(n)
 * Space: O(n)
 */
function ways($n) {
    $table = array_fill(0, $n+1, -1);
    $table[0] = 1;
    $table[1] = 1;
    $table[2] = 2;

    for ($i=3; $i <= $n; $i++) { 
        $table[$i] = $table[$i-3] + $table[$i-2] + $table[$i-1];
    }
    return $table[$n];
}

/**
 * DP bottom up optimized for space.
 * Time: O(n)
 * Space: O(1)
 *
 */
function waysOptimized($n) {
    if ($n < 0) {
        return -1;
    }
    if ($n <= 1) {
        return 1;
    } elseif ($n == 2) {
        return 2;
    }
    list($low, $mid, $high, $result) = [1,1,2, -1];
    for ($i=3; $i <= $n ; $i++) { 
        $result = $low + $mid + $high;
        $low = $mid;
        $mid = $high;
        $high = $result;
    }
    return $result;
}

/**
 * Top Down DP approach.
 * Time: O(n)
 * Space: O(n)
 */
function waysTopDown($n) {
    $memo = [];
    list($memo[0], $memo[1], $memo[2]) = [1,1,2];

    return waysTopDownRecur($n, $memo);
}

function waysTopDownRecur($n, &$memo) {
    if (!isset($memo[$n])) {
        $memo[$n] = waysTopDownRecur($n-3, $memo) +
            waysTopDownRecur($n-2, $memo) +
            waysTopDownRecur($n-1, $memo);
    }
    return $memo[$n];
}

function testWays($n) {
    if ($n < 0) {
        return 0;
    } elseif ($n == 0) {
        return 1;
    } else {
        return testWays($n-3) + testWays($n-2) + testWays($n-1);
    }
}

$n1 = 1; // 1 way
$n2 = 2; // 2 ways
$n3 = 3; // 4 ways
$n4 = 4; // 7 ways
$n5 = 5; // 13 ways

echo waysBrute($n1) . PHP_EOL;
echo waysBrute($n2) . PHP_EOL;
echo waysBrute($n3) . PHP_EOL;
echo waysBrute($n4) . PHP_EOL;
echo waysBrute($n5) . PHP_EOL;
echo PHP_EOL;
echo ways($n1) . PHP_EOL;
echo ways($n2) . PHP_EOL;
echo ways($n3) . PHP_EOL;
echo ways($n4) . PHP_EOL;
echo ways($n5) . PHP_EOL;
echo PHP_EOL;
echo waysOptimized($n1) . PHP_EOL;
echo waysOptimized($n2) . PHP_EOL;
echo waysOptimized($n3) . PHP_EOL;
echo waysOptimized($n4) . PHP_EOL;
echo waysOptimized($n5) . PHP_EOL;
echo waysOptimized(30) . PHP_EOL;
echo PHP_EOL;
echo waysTopDown($n1) . PHP_EOL;
echo waysTopDown($n2) . PHP_EOL;
echo waysTopDown($n3) . PHP_EOL;
echo waysTopDown($n4) . PHP_EOL;
echo waysTopDown($n5) . PHP_EOL;
echo waysTopDown(30) . PHP_EOL;
echo PHP_EOL;
echo testWays($n1) . PHP_EOL;
echo testWays($n2) . PHP_EOL;
echo testWays($n3) . PHP_EOL;
echo testWays($n4) . PHP_EOL;
echo testWays($n5) . PHP_EOL;
echo testWays(30) . PHP_EOL;