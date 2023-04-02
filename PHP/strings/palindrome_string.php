<?php

// Given a string, determine if it is a palindrome, considering only alphanumeric
// characters and ignoring cases.

// Example:

// "A man, a plan, a canal: Panama" is a palindrome.

// "race a car" is not a palindrome.

// Return 0 / 1 ( 0 for false, 1 for true ) for this problem

/**
 * Time: O(n)
 * Space: O(1)
 *
 */
function isPalindrome($str) {
    if (empty($str)) {
        return 0;
    }
    list($front, $back) = [0, strlen($str)-1];
    while ($front < $back) {
        while (!ctype_alnum($str[$front])) {
            $front++;
            if ($front >= strlen($str)) {
                return 1;
            }
        }
        while (!ctype_alnum($str[$back])) {
            $back--;
            if ($back < 0) {
                return 1;
            }
        }
        if (strtolower($str[$front]) != strtolower($str[$back])) {
            return 0;
        }
        $front++;
        $back--;
    }
    return 1;
}

$str1 = "A man, a plan, a canal: Panama";
$str2 = "race a car";

echo isPalindrome($str1) . PHP_EOL;
echo isPalindrome($str2) . PHP_EOL;