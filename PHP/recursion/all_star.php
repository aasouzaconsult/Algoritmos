<?php

// Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".

// allStar("hello") -> "h*e*l*l*o"
// allStar("abc") -> "a*b*c"
// allStar("ab") -> "a*b"

// mission: given a string, add * char in between every 2 chars. return the new string
// base case: end of string

function allStar($string) {
    $result = "";
    $index = 0;
    _allStar($string, $index, $result);
    return $result;
}

function _allStar($string, $index, &$result) {
    $char = $string[$index];
    if ($index !== strlen($string)-1) {
        $char .= "*";
    }
    $result .= $char;
    if ($index == strlen($string)-1) {
        return;
    }
    _allStar($string, ++$index, $result);
}

echo allStar("hello") . PHP_EOL;
echo allStar("abc") . PHP_EOL;
echo allStar("ab") . PHP_EOL;