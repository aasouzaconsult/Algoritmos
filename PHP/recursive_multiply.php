<?php

/**
 * Write a recursive function to multiply two positive integers without using the
 * * operator. You can use addition, subtraction, and bit shifting, but you should
 * minimize the number of those operations.
 */

/**
 * Using recursive addition to replace multiplication.
 * Time: O(n) where n is the lesser value among 2 values.
 * Space: O(n)
 */
function recursiveMultiply($value1, $value2) {
    if ($value1 > $value2) {
        $result = recursiveMultiplyHelper($value1, $value2);
    } else {
        $result = recursiveMultiplyHelper($value2, $value1);
    }
    return $result;
}

function recursiveMultiplyHelper($base, $times) {
    if ($times <= 0) {
        return 0;
    }
    return $base + recursiveMultiplyHelper($base, --$times);
}

/**
 * DP approach.
 * Time: O(lgn) where n is the lesser value among 2 values.
 * Space: O(n)
 */
function recursiveMultiplyV2($value1, $value2) {
    if ($value1 > $value2) {
        $large = $value1;
        $small = $value2;
    } else {
        $large = $value2;
        $small = $value1;
    }
    $memo = [];
    $memo[0] = 0;
    $memo[1] = $large;
    return recursiveMultiplyHelperV2($large, $small, $memo);
}

function recursiveMultiplyHelperV2($large, $small, $memo) {
    if ($small % 2 == 0) {
        if (!isset($memo[$small])) {
            $memo[$small] = recursiveMultiplyHelperV2($large, $small/2, $memo) +
                recursiveMultiplyHelperV2($large, $small/2, $memo);
        }
    } else {
        if (!isset($memo[$small])) {
            $memo[$small] = recursiveMultiplyHelperV2($large, $small/2, $memo) +
                recursiveMultiplyHelperV2($large, $small/2, $memo) + $large;
        }
    }
    return $memo[$small];
}

echo recursiveMultiply(5,6) . PHP_EOL;
echo recursiveMultiply(8,6) . PHP_EOL;
echo recursiveMultiply(9,7) . PHP_EOL;
echo recursiveMultiplyV2(5,6) . PHP_EOL;
echo recursiveMultiplyV2(8,6) . PHP_EOL;
echo recursiveMultiplyV2(9,7) . PHP_EOL;