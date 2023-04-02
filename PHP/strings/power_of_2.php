<?php

// Find if Given number is power of 2 or not. 
// More specifically, find if given number can be expressed as 2^k where k >= 1.

// Input:

// number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
// Output:

// return 1 if the number if a power of 2 else return 0

// Example:

// Input : 128
// Output : 1

/**
 * Any power of 2 expressed in binary form will have only 1 bit set.
 * With this information, we AND the target number and its value - 1.
 * If input is a power of 2, its value - 1 will have all bits set except the bit
 * previously set to 1.
 * 
 * Time: O(1)
 * Space: O(1)
 *
 */
function powerOf2($n) {
    if ($n == 1) {
        return 0;
    }
    $value = $n & ($n-1);
    if ($n > 0 && !$value) {
        return 1;
    }
    return 0;
}

echo powerOf2(1) . PHP_EOL;
echo powerOf2(15) . PHP_EOL;
echo powerOf2(2) . PHP_EOL;
echo powerOf2(64) . PHP_EOL;
echo powerOf2(4542) . PHP_EOL;