<?php

// Given a string, compute recursively a new string where identical chars
// that are adjacent in the original string are separated from each other by a "*".

// pairStar("hello") -> "hel*lo"
// pairStar("xxyy") -> "x*xy*y"
// pairStar("aaaa") -> "a*a*a*a"

// mission: given a string, for each set of repeated char, put a star in between. 
// base case: end of string

function pairStar($string) {
    $index = 0;
    $result = "";
    $prev = "";
    _pairStar($string, $index, $prev, $result);
    return $result;
}
function _pairStar($string, $index, $prev, &$result) {
    $char = $string[$index];
    if ($prev == $char) {
        $char = "*" . $string[$index];
    }
    $result .= $char;
    if ($index == strlen($string)) {
        return;
    }
    $prev = $string[$index];
    _pairStar($string, ++$index, $prev, $result);
}

echo pairStar("hello"). PHP_EOL;
echo pairStar("xxyy"). PHP_EOL;
echo pairStar("aaaa"). PHP_EOL;