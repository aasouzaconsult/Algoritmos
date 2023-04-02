<?php

// Given a string, compute recursively a new string where all the lowercase 'x'
// chars have been moved to the end of the string.

// endX("xxre") -> "rexx"
// endX("xxhixx") -> "hixxxx"
// endX("xhixhix") -> "hihixxx"

// mission: given a string, put all no x char in a string and count the number of x in the string.
// base case: end of string

function endX($string) {
    $index = 0;
    $result = "";
    $count = 0;
    _endX($string, $index, $result, $count);
    for ($i=0; $i < $count; $i++) { 
        $result .= "x";
    }
    return $result;
}

function _endx($string, $index, &$result, &$count) {
    $char = $string[$index];
    if ($char == 'x') {
        $count++;
    } else {
        $result .= $char;
    }
    if ($index == strlen($string)-1) {
        return;
    }
    _endx($string, ++$index, $result, $count);
}

echo endX("xxre") . PHP_EOL;
echo endX("xxhixx") . PHP_EOL;
echo endX("xhixhix") . PHP_EOL;