<?php

// You are given a string. The only operations allowed is to insert characters in
// the beginning or end of the string. How many minimum characters are needed to be
// inserted to make the string a palindrome string

// Example:
// Input: ABC
// Output: 2
// Input: AACECAAAA
// Output: 2

/**
 * Use a version of manacher's algorithm to find the longest palindrome.
 * Then find the difference between length of longest palindrome and str length
 *
 * Time: O(n^2)
 * Space: O(n)
 */
function minCharToPalindrome($str) {
    if (strlen($str) < 1) {
        return 0;
    }
    $paddedStr = padWildChar($str);
    $longest = [0, 0];

    for ($i=1; $i < strlen($paddedStr)-1; $i++) { 
        $range = getPalindromeRange($paddedStr, $i);
        $size = $range[1] - $range[0] + 1;
        $longestSize = $longest[1] - $longest[0] + 1;
        if ($size > $longestSize) {
            $longest = $range;
        }
    }
    $palindrome = substr($paddedStr, $longest[0], $longestSize);
    $palindrome = stripWildChar($palindrome);
    return strlen($str) - strlen($palindrome);
}

function getPalindromeRange($str, $index) {
    $left = $index;
    $right = $index;
    while (True) {
        if ($left < 0 || $right >= strlen($str)) {
            $left++;
            $right--;
            break;
        }
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

function stripWildChar($str) {
    return str_replace("*", "", $str);
}

function padWildChar($str) {
    $result = "";
    for ($i=0; $i < strlen($str); $i++) { 
        $result .= "*" . $str[$i];
    }
    $result .= "*";
    return $result;
}

$str1 = "ABC";
$str2 = "AACECAAAA";

echo minCharToPalindrome($str1) . PHP_EOL;
echo minCharToPalindrome($str2) . PHP_EOL;