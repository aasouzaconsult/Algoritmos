<?php

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the
 * "true" length of the string.
 * Example:
 * I/P: "Mr John Smith    ", 13
 * O/P: "Mr%20John%20%Smith"
 */

/**
 * Loop through the string. If a space is found, check that space's left and right are not spaces.
 * if true, replace space with '%20.';
 * Time: O(n)
 * Space: O(n)
 */
function urlify($string, $len) {
    if (empty($string)) {
        return;
    }
    $result = "";
    $count = 0;
    for ($i=0; $i < strlen($string); $i++) {
        if ($count > $len) {
            break;
        }
        if (preg_match('/[a-zA-Z]/', $string[$i])) {
            $result .= $string[$i];
            $count++;
        } elseif ($string[$i] == ' ') {
            if (preg_match('/[a-zA-Z]/', $string[$i-1]) && preg_match('/[a-zA-Z]/', $string[$i+1])) {
                $result .= '%20';
                $count++;
            }
        }
    }
    return $result;
}

/**
 * Start from back of string, replace valid spaces with '%20'. stray spaces are removed.
 * Time: O(n)
 * Space: O(1)
 */
function urlifyV2($string, $len) {
    if (empty($string)) {
        return;
    }
    for ($i=strlen($string)-1; $i >=0 ; $i--) {
        if ($string[$i] == ' ') {
            if (preg_match('/[a-zA-Z]/', $string[$i-1]) && preg_match('/[a-zA-Z]/', $string[$i+1])) {
                $string = substr_replace($string, '%20', $i, 1);
            } else {
                $string = substr_replace($string, "", $i, 1);
            }
        }
    }
    return $string;
}

$string1 = "Mr John Smith    ";
$string2 = "    Mr John Smith    ";
echo urlify($string1, 13) . PHP_EOL;
echo urlify($string2, 13) . PHP_EOL;

echo urlifyV2($string1, 13) . PHP_EOL;
echo urlifyV2($string2, 13) . PHP_EOL;