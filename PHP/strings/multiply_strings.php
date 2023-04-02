<?php

// Given two numbers represented as strings, return multiplication of the numbers as a string.

//  Note: The numbers can be arbitrarily large and are non-negative.
// Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer. 
// For example, 
// given strings "12", "10", your answer should be “120”.

function multiplyString($numerals, $str1, $str2) {
    $exp = 1;
    $results = [];
    for ($i=strlen($str1)-1; $i >= 0; $i--) {
        $temp = 0;
        $carry = 0;
        $digitExp = 1;
        for ($j=strlen($str2)-1; $j >= 0; $j--) {
            if (!isset($numerals[$str1[$i]]) || !isset($numerals[$str2[$j]])) {
                continue;
            }
            $value = $numerals[$str1[$i]] * $numerals[$str2[$j]] + $carry;
            $digit = $value % 10;
            $carry = floor($value / 10);
            $temp += $digit * $digitExp * $exp;

            $digitExp *= 10;
        }
        if ($carry > 0) {
            $temp += $carry * $digitExp * $exp;
        }
        $result[] = $temp;
        $exp *= 10;
    }
    return array_sum($result);
}

$numerals = [
    "0" => 0,
    "1" => 1,
    "2" => 2,
    "3" => 3,
    "4" => 4,
    "5" => 5,
    "6" => 6,
    "7" => 7,
    "8" => 8,
    "9" => 9,
];

echo multiplyString($numerals, "12", "12") . PHP_EOL;
echo multiplyString($numerals, "12", "10") . PHP_EOL;
echo multiplyString($numerals, "18", "574") . PHP_EOL;
echo multiplyString($numerals, "99999", "99999") . PHP_EOL;