<?php

// Given a roman numeral, convert it to an integer.

// Input is guaranteed to be within the range from 1 to 3999.

// Read more details about roman numerals at Roman Numeric System

// Example :

// Input : "XIV"
// Return : 14
// Input : "XX"
// Output : 20

/**
 * Time: O(n) where n is size of string
 * Space: O(n)
 *
 */
function romanToInteger($legend, $str) {
    if (empty($str)) {
        return;
    }
    $numbers = [];
    for ($i=0; $i < strlen($str); $i++) { 
        $numbers[] = $legend[$str[$i]];
    }
    $result = 0;
    while (!empty($numbers)) {
        if (sizeof($numbers) == 1 || $numbers[0] >= $numbers[1]) {
            $result += array_shift($numbers);
        } else { // number[0] < number[1]
            $result += abs(array_shift($numbers) - array_shift($numbers));
        }
    }
    return $result;
}

$legend = [
    'I' => 1,
    'V' => 5,
    'X' => 10,
    'L' => 50,
    'C' => 100,
    'D' => 500,
    'M' => 1000
];

$str1 = 'XIV'; // 14
$str2 = 'XX'; // 20
$str3 = 'MCMLIV'; // 1954
$str4 = 'MCMXC'; // 1990
$str5 = 'MMXIV'; // 2014

echo romanToInteger($legend, $str1) . PHP_EOL;
echo romanToInteger($legend, $str2) . PHP_EOL;
echo romanToInteger($legend, $str3) . PHP_EOL;
echo romanToInteger($legend, $str4) . PHP_EOL;
echo romanToInteger($legend, $str5) . PHP_EOL;