<?php

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string 'aabcccccaaa' would become 'a2b1c5a3'. If the "compressed string" would not
 * become smaller than the original string, your method should return the original string. You can assume
 * the string has only uppercase and lowercase letters(a-z).
 *
 * Time: O(n)
 * Space: O(n)
 */

function stringCompression($string) {
    if (empty($string)) {
        return;
    }
    $arr = [];
    for ($i=0; $i < strlen($string); $i++) { 
        $char = $string[$i];
        if (empty($arr)) {
            $arr = [$char, 1];
        } elseif ($char == $arr[sizeof($arr)-2]) {
            $arr[sizeof($arr)-1]++;
        } else {
            $arr[] = $char;
            $arr[] = 1;
        }
        if (sizeof($arr) > strlen($string)) {
            return $string;
        }
    }
    $result = implode("", $arr);
    if (strlen($result) > strlen($string)) {
        return $string;
    }
    return $result;
}

$string1 = 'aabcccccaaa';
echo stringCompression($string1) . PHP_EOL;