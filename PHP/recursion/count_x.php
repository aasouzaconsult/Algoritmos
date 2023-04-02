<?php

// Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.

// countX("xxhixx") -> 4
// countX("xhixhix") -> 3
// countX("hi") -> 0

// mission: given a string, find the number of lowercase x chars in the string
// base case: last char in the string

function count_x($string) {
    if (empty($string)) {
        return 0;
    }
    $index = 0;
    return _count_x($string, $index);
}

function _count_x($string, $index) {
    $count = 0;
    if ($string[$index] == 'x') {
        $count++;
    }
    if ($index == strlen($string)-1) {
        return $count;
    }
    return _count_x($string, ++$index) + $count;
}

echo count_x('xxhixx') . PHP_EOL;
echo count_x('xhixhix') . PHP_EOL;
echo count_x('hi') . PHP_EOL;