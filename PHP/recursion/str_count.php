<?php


// Given a string and a non-empty substring sub, compute recursively
// the number of times that sub appears in the string, without the sub strings overlapping.

// strCount("catcowcat", "cat") -> 2
// strCount("catcowcat", "cow") -> 1
// strCount("catcowcat", "dog") -> 0

// mission: given 2 strings, check how many times string 2 occurs in string1 non-overlapping
// base case:
// - end of string 1

function strCount($string1, $string2) {
    $jump = strlen($string2);
    $index = 0;
    return _strCount($string1, $string2, $jump, $index);
}

function _strCount($string1, $string2, $jump, $index) {
    $count = 0;
    if (substr($string1, $index, $jump) == $string2) {
        $count++;
    }
    if ($index >= strlen($string1)-1) {
        return $count;
    }
    $index += $jump;
    return _strCount($string1, $string2, $jump, $index) + $count;
}

echo strCount("catcowcat", "cat"). PHP_EOL;
echo strCount("catcowcat", "cow"). PHP_EOL;
echo strCount("catcowcat", "dog"). PHP_EOL;