<?php

// Given a string, compute recursively a new string where all the 'x' chars have been removed.

// noX("xaxb") -> "ab"
// noX("abc") -> "abc"
// noX("xx") -> ""

// mission: given a string, return a string with all x char removed
// base case: end of string

function noX($string) {
    $index = 0;
    $result = "";
    _noX($string, $index, $result);
    return $result;
}

function _noX($string, $index, &$result) {
    $char = $string[$index];
    if ($char == 'x') {
        $char = "";
    }
    $result .= $char;
    if (strlen($string)-1 == $index) {
        return;
    }
    _noX($string, ++$index, $result);
}

echo noX('xaxb') . PHP_EOL;
echo noX('abc') . PHP_EOL;
echo noX('xx') . PHP_EOL;