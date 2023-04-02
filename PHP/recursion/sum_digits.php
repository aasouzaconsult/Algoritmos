<?php


// Given a non-negative int n, return the sum of its digits recursively (no loops).
// Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/)
// by 10 removes the rightmost digit (126 / 10 is 12).

// sumDigits(126) -> 9
// sumDigits(49) -> 13
// sumDigits(12) -> 3

// mission: given a value, add all the individual digits together and return.
// base case:
// after floor division, value is 0. return the remainder
function sumDigits($value) {
    $digit = $value % 10;
    if (floor($value / 10) == 0) {
        return $digit;
    }
    return sumDigits(floor($value/10)) + $digit;
}

echo sumDigits(126) . PHP_EOL;
echo sumDigits(49) . PHP_EOL;
echo sumDigits(12) . PHP_EOL;