<?php

// Given an input string, reverse the string word by word.

// Example:

// Given s = "the sky is blue",

// return "blue is sky the".

// A sequence of non-space characters constitutes a word.
// Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
// If there are multiple spaces between words, reduce them to a single space in the reversed string.

/**
 * Time: O(n)
 * Space: O(n)
 *
 */
function reverseString($string) {
    if (empty($string)) {
        return "";
    }
    $arr = [];
    $temp = "";
    for ($i=0; $i < strlen($string); $i++) { 
        if ($string[$i] != " ") {
            $temp .= $string[$i];
        } elseif (!empty($temp)) {
            array_unshift($arr, $temp);
            $temp = "";
        }
    }
    if (!empty($temp)) {
        array_unshift($arr, $temp);
    }
    return implode(" ", $arr);
}

/**
 * OPTIMAL
 * In place reversal of string.
 *
 * 1. Reverse the entire string character by character
 * 2. reverse each word in the reversed string. Note: we have to find the word boundary here.
 * 
 * Time: O(n)
 * Space: O(1)
 */
function reverseStringV2($string) {
    if (empty($string)) {
        return "";
    }

    $start = 0;
    $end = strlen($string) - 1;
    while ($start < $end) {
        swap($string, $start, $end);
        $start++;
        $end--;
    }
    $temp = "";
    $wordStart = NULL;
    $wordEnd = NULL;

    for ($i=0; $i < strlen($string); $i++) { 
        if ($string[$i] != ' ') {
            $temp .= $string[$i];
            if (is_null($wordStart)) {
                $wordStart = $i;
            }
            $wordEnd = $i;
        } elseif ($string[$i] == ' ') {
            reverseWord($string, $wordStart, $wordEnd);
            $wordStart = NULL;
            $wordEnd = NULL;
            $temp = "";
        }
    }
    if (!empty($temp)) {
        swap($string, $wordStart, $wordEnd);
    }
    return $string;
}

function reverseWord(&$string, $start, $end) {
    while ($start < $end) {
        swap($string, $start, $end);
        $start++;
        $end--;
    }
}

function swap(&$string, $i, $j) {
    $temp = $string[$i];
    $string[$i] = $string[$j];
    $string[$j] = $temp;
}

$str1 = "the sky is blue";

echo reverseString($str1) . PHP_EOL;
echo reverseStringV2($str1) . PHP_EOL;