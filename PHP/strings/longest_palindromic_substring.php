<?php

// Given a string S, find the longest palindromic substring in S.

// Substring of string S:

// S[i...j] where 0 <= i <= j < len(S)

// Palindrome string:

// A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

// Incase of conflict, return the substring which occurs first ( with the least starting index ).

// Example :

// Input : "aaaabaaa"
// Output : "aaabaaa"

/**
 * Manacher's algorithm
 * A version of manacher's algorithm.
 * Put a wild character '*' in between every adjacent character to factor in even and odd palindromes.
 * Time: O(n^2)
 * Space: O(n)
 */
function longestPalindromicSubstring($str) {
    if (strlen($str) < 1) {
        return "";
    }
    $paddedStr = addWildCard($str);
    $result = $str[0];
    $longest = [0, 0];
    for ($i=2; $i < strlen($paddedStr); $i++) { 
        $range = getPalindromicRange($paddedStr, $i);
        $size = $range[1] - $range[0] + 1;
        if ($size == strlen($paddedStr)) {
            return $str;
        } elseif ($size > $longest[1] - $longest[0] + 1) {
            $longest = $range;
        }
    }
    $result = substr($paddedStr, $longest[0], $longest[1] - $longest[0] + 1);
    return str_replace("*", "", $result);
}

function getPalindromicRange($str, $index) {
    $left = $index;
    $right = $index;
    while (True) {
        if ($str[$left] == $str[$right]) {
            $left--;
            $right++;
        } else {
            $left++;
            $right--;
            break;
        }
    }
    return [$left, $right];
}

function addWildCard($str) {
    $result = "";
    for ($i=0; $i < strlen($str); $i++) { 
        $result .= "*" . $str[$i];
    }
    $result .= "*";
    return $result;
}

$str1 = "aaaabaaa";

echo longestPalindromicSubstring($str1) . PHP_EOL;
echo addWildCard($str1) . PHP_EOL;