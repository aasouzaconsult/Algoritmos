<?php

// Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version

// Input is guaranteed to be within the range from 1 to 3999.

// Example :

// Input : 5
// Return : "V"

// Input : 14
// Return : "XIV"

/**
 * Time: O(n) where n is size of the legend table
 * Space: O(n)
 */
function integerToRoman($legend, $num) {
    if ($num < 1) {
        return 0;
    }
    $result = "";
    foreach ($legend as $digit => $roman) {
        if ($num >= $digit) {
            $count = floor($num / $digit);
            $num %= $digit;
            for ($i=0; $i < $count; $i++) { 
                $result .= $roman;
            }
        }
    }
    return $result;
}

$legend = [
    1000 => "M",
    900 => "CM",
    500 => "D",
    400 => "CD",
    100 => "C",
    90 => "XC",
    50 => "L",
    40 => "XL",
    10 => "X",
    9 => "IX",
    5 => "V",
    4 => "IV",
    1 => "I"
];

echo integerToRoman($legend, 5) . PHP_EOL;
echo integerToRoman($legend, 3) . PHP_EOL;
echo integerToRoman($legend, 14) . PHP_EOL;
echo integerToRoman($legend, 1990) . PHP_EOL;
echo integerToRoman($legend, 2014) . PHP_EOL;
echo integerToRoman($legend, 1954) . PHP_EOL;