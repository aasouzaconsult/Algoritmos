<?php

/**
 * Given a real number between 0 and 1(eg. 0.72) that is passed in as a double,
 * print a binary representation. If the number cannot be represented accurately
 * in binary with at most 32 characters, print "ERROR";
 */

function binaryToString($value) {
    if ($value >= 1 || $value <= 0) {
        return "ERROR";
    }
    $temp = $value;
    $str = "";
    $counter = 0;
    while ($temp != 0 && $counter <= 20) {
        $temp *= 2;
        if ($temp > 1) {
            $temp--;
            $str .= "1";
        } else {
            $str .= "0";
        }
        $counter++;
    }
    return $str;
}

echo binaryToString(0.72) . PHP_EOL;