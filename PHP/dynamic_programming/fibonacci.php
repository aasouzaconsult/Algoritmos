<?php

/**
 * Given a sequence number, compute the fibonacci number.
 * Basic recursive fibonacci sequence.
 */
function fibonacci($n) {
    if ($n <= 0) {
        return 0;
    } elseif ($n <= 2) {
        return 1;
    }
    return fibonacci($n-1) + fibonacci($n-2);
}

/**
 * Iterative fibonacci number generation.
 */
function fibonacciIterative($n) {
    if ($n <= 0) {
        return 0;
    } elseif ($n <= 2) {
        return 1;
    }
    $prev = 1;
    $curr = 1;
    for ($i=3; $i <= $n; $i++) { 
        $temp = $curr;
        $curr += $prev;
        $prev = $temp;
    }
    return $curr;
}

/**
 * Caching solution to computing fibonacci number.
 * For each value of N, _fibonacciCache is called exactly twice.
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 * Here we are trading a linear amount of space for an exponential amount of time.
 */
function fibonacciCache($n) {
    $fiboSequence = [];
    $fiboSequence[0] = 0;
    $fiboSequence[1] = 1;

    return _fibonacciCache($n, $fiboSequence);

}

function _fibonacciCache($n, &$sequence) {
    if (!isset($sequence[$n])) {
        $sequence[$n] = _fibonacciCache($n-1, $sequence) + _fibonacciCache($n-2, $sequence);
    }
    return $sequence[$n];
}

/**
 * Dynamic Programming solution to computing fibonacci number.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
function fibonacciDP($n) {
    $fiboSequence = [];
    $fiboSequence[0] = 0;
    $fiboSequence[1] = 1;

    for ($i=2; $i <= $n; $i++) { 
        $fiboSequence[$i] = $fiboSequence[$i-1] + $fiboSequence[$i-2];
    }
    return $fiboSequence[$n];
}

/**
 * Dynamic programming solution to computing fibonacci number.
 * Most optimized solution for space and time.
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 * This solution reduces store demands to constant space with no asymptotic degradation in running time.
 */
function fibonacciDP2($n) {
    if ($n == 0) {
        return 0;
    } elseif ($n == 1) {
        return 1;
    }
    $prev = 0;
    $curr = 1;

    for ($i=2; $i <= $n ; $i++) { 
        $temp = $curr;
        $curr += $prev;
        $prev = $temp;
    }
    return $curr;
}

echo fibonacci(1) . PHP_EOL;
echo fibonacci(2) . PHP_EOL;
echo fibonacci(3) . PHP_EOL;
echo fibonacci(4) . PHP_EOL;
echo fibonacci(5) . PHP_EOL;
echo fibonacci(6) . PHP_EOL;
echo fibonacci(7) . PHP_EOL;
echo fibonacci(8) . PHP_EOL;
echo fibonacci(9) . PHP_EOL;

echo fibonacciIterative(1) . PHP_EOL;
echo fibonacciIterative(2) . PHP_EOL;
echo fibonacciIterative(3) . PHP_EOL;
echo fibonacciIterative(4) . PHP_EOL;
echo fibonacciIterative(5) . PHP_EOL;
echo fibonacciIterative(6) . PHP_EOL;
echo fibonacciIterative(7) . PHP_EOL;
echo fibonacciIterative(8) . PHP_EOL;
echo fibonacciIterative(9) . PHP_EOL;

$start = microtime(true);
echo fibonacciDP2(40) . PHP_EOL;
$elapsedTime = microtime(true) - $start;
echo "optimal DP elapsed time: " . $elapsedTime . PHP_EOL;

$start = microtime(true);
echo fibonacciDP(40) . PHP_EOL;
$elapsedTime = microtime(true) - $start;
echo "DP elapsed time: " . $elapsedTime . PHP_EOL;

$start = microtime(true);
echo fibonacciCache(40) . PHP_EOL;
$elapsedTime = microtime(true) - $start;
echo "cache elapsed time: " . $elapsedTime . PHP_EOL;

$start = microtime(true);
echo fibonacci(40) . PHP_EOL;
$elapsedTime = microtime(true) - $start;
echo "no cache elapsed time: " . $elapsedTime . PHP_EOL;
