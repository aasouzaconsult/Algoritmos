<?php

// Write a function to find the longest common prefix string amongst an array of strings.

// Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

// As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

// Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

// Example:

// Given the array as:

// [

//   "abcdefgh",

//   "aefghijk",

//   "abcefgh"
// ]
// The answer would be “a”.

/**
 * Time: O(n * m) where n is size of array. m is size of longest string.
 * Space: O(m)
 */
function longestCommonPrefix($arr) {
    if (sizeof($arr) < 1) {
        return "";
    }
    $result = "";
    $index = 0;

    while (True) {
        $different = False;
        if ($index >= strlen($arr[0])) {
            break;
        }
        $char = $arr[0][$index];
        for ($i=0; $i < sizeof($arr); $i++) { 
            if ($index >= strlen($arr[$i]) || $arr[$i][$index] != $char) {
                $different = True;
                break;
            }
        }
        if ($different) {
            break;
        } else {
            $result .= $char;
        }
        $index++;
    }
    return $result;
}

$arr1 = [
  "abcdefgh",
  "aefghijk",
  "abcefgh"
];

echo longestCommonPrefix($arr1) . PHP_EOL;
