<?php

// We'll say that a "pair" in a string is two instances of a char
// separated by a char. So "AxA" the A's make a pair. Pair's can overlap,
// so "AxAxA" contains 3 pairs -- 2 for A and 1 for x. Recursively compute
// the number of pairs in the given string.

// countPairs("axa") -> 1
// countPairs("axax") -> 2
// countPairs("axbx") -> 1

// mission: given a string count the number of pairs in the string. pair as defined above
// base case: end of string.

function countPair($string) {
    if (strlen($string) < 3) {
        return 0;
    }
    $index = 2;
    return _countPair($string, $index);
}

function _countPair($string, $index) {
    $char = $string[$index];
    $count = 0;
    
    if ($char == $string[$index-2]) {
        $count++;
    }
    if (strlen($string)-1 == $index) {
        return $count;
    }
    return _countPair($string, ++$index) + $count;
}

echo countPair("axa") . PHP_EOL;
echo countPair("axax"). PHP_EOL;
echo countPair("axbx") . PHP_EOL;