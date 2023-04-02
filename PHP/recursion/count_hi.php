<?php

// Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.

// countHi("xxhixx") -> 1
// countHi("xhixhix") -> 2
// countHi("hi") -> 1

// mission: given a string, return number of times hi is in string
// base case: end of the string

function countHi($string) {
    $index = 0;
    $prev = "";
    return _countHi($string, $index, $prev);
}

function _countHi($string, $index, $prev) {
    $count = 0;
    if ($prev == "h" && $string[$index] == "i") {
        $count++;
    }
    if ($index == strlen($string)-1) {
        return $count;
    }
    $prev = $string[$index];
    return _countHi($string, ++$index, $prev) + $count;
}

echo countHi("xxhixx") . PHP_EOL;
echo countHi("xhixhix") . PHP_EOL;
echo countHi("hi") . PHP_EOL;