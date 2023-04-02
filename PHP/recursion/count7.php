<?php

// Given a non-negative int n, return the count of the occurrences of 7 as a digit,
// so for example 717 yields 2. (no loops). Note that mod (%) by 10 yields the
// rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost
// digit (126 / 10 is 12).

// count7(717) -> 2
// count7(7) -> 1
// count7(123) -> 0

// mission: given a value, count the number of digit 7 in this value.
// base case:
// floor number after division is 0
function count7($number) {
    $digit = $number % 10;
    $count = 0;
    if ($digit == 7) {
        $count = 1;
    }
    if (floor($number/10) == 0) {
        return $count;
    }
    return count7(floor($number/10)) + $count;
}

echo count7(717) . PHP_EOL;
echo count7(7) . PHP_EOL;
echo count7(123) . PHP_EOL;
echo count7(7667847) . PHP_EOL;