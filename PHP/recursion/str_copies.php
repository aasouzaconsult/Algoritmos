<?php

// Given a string and a non-empty substring sub, compute recursively
// if at least n copies of sub appear in the string somewhere, possibly
// with overlapping. N will be non-negative.

// strCopies("catcowcat", "cat", 2) -> true
// strCopies("catcowcat", "cow", 2) -> false
// strCopies("catcowcat", "cow", 1) -> true

// mission: check if substring occurs in string1 at least n times
// base case: 
// - end of string
// - n times occured

function strCopies($string1, $string2, $n) {
    $length = strlen($string2);
    $index = 2;
    $count = 0;
    _strCopies($string1, $string2, $index, $length, $count);
    if ($count >= $n) {
        return True;
    }
    return False;
}

function _strCopies($string1, $string2, $index, $length, &$count) {
    if (substr($string1, $index-2, $length) == $string2) {
        $count++;
    }
    if ($index == strlen($string1)-1) {
        return;
    }
    _strCopies($string1, $string2, ++$index, $length, $count);
}

echo strCopies("catcowcat", "cat", 2) . PHP_EOL;
echo strCopies("catcowcat", "cow", 2) . PHP_EOL;
echo strCopies("catcowcat", "cow", 1) . PHP_EOL;