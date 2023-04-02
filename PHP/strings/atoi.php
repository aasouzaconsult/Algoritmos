<?php

// Implement atoi to convert a string to an integer.

// Example :

// Input : "9 2704"
// Output : 9
// Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

//  Questions: Q1. Does string contain whitespace characters before the number?
// A. Yes Q2. Can the string have garbage characters after the number?
// A. Yes. Ignore it. Q3. If no numeric character is found before encountering garbage characters, what should I do?
// A. Return 0. Q4. What if the integer overflows?
// A. Return INT_MAX if the number is positive, INT_MIN otherwise. 

/**
 * Impleentation of atoi function in C++.
 * 1. trim left and right of string, if empty string, return 0.
 * 2. loop through the string, to extract the integer string.
 * 3. loop through the integer string in reverse compute the digit value and
 * exponential at each digit.
 * 4. return signed result if applicable.
 *
 * Time: O(n) where n is size of string.
 * Space: O(n)
 */
function myAtoi($legend, $str) {
    $str = trim($str);
    if (sizeof($str) < 1) {
        return 0;
    }    
    list($sign, $intString) = getIntegerString($str);
    
    $result = 0;
    $exp = 1;
    for ($i=strlen($intString)-1; $i >= 0; $i--) { 
        $value = $legend[$intString[$i]] * $exp;
        $result += $value;
        if ($result >= PHP_INT_MAX) {
            if ($sign == '-') {
                return -PHP_INT_MAX - 1;
            } else {
                return PHP_INT_MAX;
            }
        }
        $exp *= 10;
    }
    if ($sign == '-') {
        $result = -$result;
    }
    return $result;
}

function getIntegerString($str) {
    for ($i=0; $i < strlen($str); $i++) { 
        if ($str[$i] == '+' || $str[$i] == '-') {
            if (empty($sign)) {
                $sign = $str[$i];
            } else {
                return 0;
            }
        } elseif (!ctype_digit($str[$i])) {
            if (!empty($intString)) {
                break;
            } else {
                return 0;
            }
        } else {
            $intString .= $str[$i];
        }        
    }
    return [$sign, $intString];
}

$legend = [
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
$str1 = "9 2704"; // 9
$str2 = "4343"; // 4343
$str3 = "-433"; // 433
$str4 = "+4354"; // 4354
$str5 = "fger223"; // 0
$str6 = " -88297 248252140B12 37239U4622733246I218  9 1303   44 A83793H3G2 1674443R591 4368 7  97";

echo myAtoi($legend, $str1) . PHP_EOL;
echo myAtoi($legend, $str2) . PHP_EOL;
echo myAtoi($legend, $str3) . PHP_EOL;
echo myAtoi($legend, $str4) . PHP_EOL;
echo myAtoi($legend, $str5) . PHP_EOL;
echo myAtoi($legend, $str6) . PHP_EOL;
