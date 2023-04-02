<?php

// Given two binary strings, return their sum (also a binary string).

// Example:

// a = "100"

// b = "11"
// Return a + b = "111".

function addBinaryString($str1, $str2) {
    if (strlen($str1) < 1) {
        return $str2;
    } elseif (strlen($str2) < 1) {
        return $str1;
    }
    padToEqualLength($str1, $str2);

    $result = '';
    $carry = 0;
    $index = strlen($str1) - 1;
    while ($index >= 0) {
        $value = (int)$str1[$index] + (int) $str2[$index] + $carry;
        $carry = 0;
        if ($value == 2) {
            $value = 0;
            $carry = 1;
        } elseif ($value == 3) {
            $value = 1;
            $carry = 1;
        }
        $result = $value . $result;
        $index--;
    }
    if ($carry == 1) {
        $result = '1' . $result;
    }
    return $result;
}

function padToEqualLength(&$str1, &$str2) {
    if (strlen($str1) == strlen($str2)) {
        return;
    }
    while (strlen($str1) < strlen($str2)) {
        $str1 = '0' . $str1;
    }
    while (strlen($str2) < strlen($str1)) {
        $str2 = '0' . $str2;
    }
}

$str1 = "100";
$str2 = "11";
$str3 = "1";
$str4 = "1";


echo addBinaryString($str1, $str2) . PHP_EOL;
echo addBinaryString($str3, $str4) . PHP_EOL;