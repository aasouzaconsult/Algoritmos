<?php

// Count recursively the total number of "abc" and "aba" substrings that appear in the given string.

// countAbc("abc") -> 1
// countAbc("abcxxabc") -> 2
// countAbc("abaxxaba") -> 2
// 
// mission: given a string, return the numbr of times abc or aba appears
// base case: end of string

function countABC($string) {
    if (strlen($string) < 3) {
        return 0;
    }
    $index = 2;
    return _countABC($string, $index);
}

function _countABC($string, $index) {
    $char = $string[$index];
    $count  = 0;
    if ($char == "a" || $char == "c") {
        if ($string[$index-2] == "a" && $string[$index-1] == "b") {
            $count++;
        }
    }
    if (strlen($string)-1 == $index) {
        return $count;
    }
    return _countABC($string, ++$index) + $count;
}

echo countAbc("abc") . PHP_EOL;
echo countAbc("abcxxabc") . PHP_EOL;
echo countAbc("abaxxaba") . PHP_EOL;