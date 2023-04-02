<?php

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 */

/**
 * Brute force.
 * for every char in string, check all subsequent chars that has this char
 * if have, return false. else return true.
 * Time: O(n^2)
 * Space: O(1)
 */
function isUniqueV1($string) {
    if (empty($string)) {
        return False;
    }
    for ($i=0; $i < strlen($string)-1; $i++) { 
        for ($j=$i+1; $j < strlen($string); $j++) { 
            if ($string[$i] == $string[$j]) {
                return False;
            }
        }
    }
    return True;
}

/**
 * Init a hash table.
 * Loop through string, for every char check if hash table has this char
 * if no, put into table. if yes, return false
 * Time: O(n)
 * Space: O(n)
 */
function isUniqueV2($string) {
    if (empty($string)) {
        return False;
    }
    $table = [];
    for ($i=0; $i < strlen($string); $i++) { 
        $char = $string[$i];
        if (!isset($table[$char])) {
            $table[$char] = 1;
        } else {
            return False;
        }
    }
    return True;
}

$string1 = "a"; // true
$string2 = "abcd"; // true
$string3 = "abbd"; // false
$string4 = "abcdbe"; // false

echo isUniqueV1($string1) . PHP_EOL;
echo isUniqueV1($string2) . PHP_EOL;
echo isUniqueV1($string3) . PHP_EOL;
echo isUniqueV1($string4) . PHP_EOL;

echo isUniqueV2($string1) . PHP_EOL;
echo isUniqueV2($string2) . PHP_EOL;
echo isUniqueV2($string3) . PHP_EOL;
echo isUniqueV2($string4) . PHP_EOL;