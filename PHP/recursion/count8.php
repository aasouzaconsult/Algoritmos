<?php

// Given a non-negative int n, compute recursively (no loops) the count of the
// occurrences of 8 as a digit, except that an 8 with another 8 immediately to
// its left counts double, so 8818 yields 4. Note that mod (%) by 10 yields the
// rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost
// digit (126 / 10 is 12).

// count8(8) -> 1
// count8(818) -> 2
// count8(8818) -> 4

// mission: count the number of 8's in a value, if 2 8s are together, double count the higher order one
// base case:
// floor division of number == 0. return the $count

function count8($number) {
    $prevDigit = 0;
    return _count8($number, $prevDigit);
}

function _count8($number, $prev) {
    $digit = $number % 10;
    $count = 0;
    if ($digit == 8) {
        $count++;
        if ($prev == 8) {
            $count++;
        }
    }
    if (floor($number/10) == 0) {
        return $count;
    }
    return _count8(floor($number/10), $digit) + $count;
}

echo count8(8) . PHP_EOL;
echo count8(818) . PHP_EOL;
echo count8(8818) . PHP_EOL;
