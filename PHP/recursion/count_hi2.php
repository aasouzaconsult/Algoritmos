<?php

// Given a string, compute recursively the number of times lowercase "hi"
// appears in the string, however do not count "hi" that have an 'x'
// immedately before them.

// countHi2("ahixhi") -> 1
// countHi2("ahibhi") -> 2
// countHi2("xhixhi") -> 0

// mission: given a string count number of 'hi' that does not prepend with 'x'.
// base case: end of string

function countHi2($string) {
    if (strlen($string) < 3) {
        return 0;
    }
    $index = 2;
    return _countHi2($string, $index);
}

function _countHi2($string, $index) {
    $char = $string[$index];
    $count = 0;
    if ($char = "i" && $string[$index-1] == "h") {
        if ($string[$index-2] != "x") {
            $count++;
        }
    }
    if (strlen($string)-1 == $index) {
        return $count;
    }
    return _countHi2($string, ++$index) + $count;
}

echo countHi2("ahixhi") . PHP_EOL;
echo countHi2("ahibhi") . PHP_EOL;
echo countHi2("xhixhi") . PHP_EOL;