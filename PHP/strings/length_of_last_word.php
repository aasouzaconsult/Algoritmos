<?php

// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
// If the last word does not exist, return 0.

// Note: A word is defined as a character sequence consists of non-space characters only.

// Example:
// Given s = "Hello World",
// return 5 as length("World") = 5.

// Please make sure you try to solve this problem without using library functions.
// Make sure you only traverse the string once.

/**
 * Time: O(n) where n is size of string
 * Space: O(1)
 */
function lastWordLength($string) {
    if (empty($string)) {
        return 0;
    }
    $foundWord = False;
    $count = 0;
    for ($i=strlen($string)-1; $i < strlen($string); $i--) { 
        if ($string[$i] != ' ') {
            $foundWord = True;
            $count++;
        } elseif ($string[$i] == ' ' && $foundWord) {
            break;
        }
    }
    return $count;
}

$str1 = "Hello World  ";

echo lastWordLength($str1) . PHP_EOL;