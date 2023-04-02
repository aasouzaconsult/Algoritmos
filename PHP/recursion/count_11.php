<?php

// Given a string, compute recursively (no loops) the number of "11" substrings
// in the string. The "11" substrings should not overlap.

// count11("11abc11") -> 2
// count11("abc11x11x11") -> 3
// count11("111") -> 1

function count11($string) {
    if (strlen($string) < 2) {
        return 0;
    }
    $index = 1;
    $prev = $string[0];
    return _count11($string, $index, $prev);
}

function _count11($string, $index, $prev) {
    $char = $string[$index];
    $count = 0;
    if ($char == "1") {
        if ($prev == "1") {
            $count++;
        }
    }
    if ($count == 1) {
        $prev = "";
    } else {
        $prev = $char;
    }
    if (strlen($string)-1 == $index) {
        return $count;
    }
    return _count11($string, ++$index, $prev) + $count;
}

echo count11("11abc11") . PHP_EOL;
echo count11("abc11x11x11") . PHP_EOL;
echo count11("111") . PHP_EOL;