<?php

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 *
 * Time: O(n)
 * Space: O(n)
 */

function isPalindromePermutation($string) {
    if (empty($string)) {
        return False;
    }
    $histogram = [];
    for ($i=0; $i < strlen($string); $i++) { 
        $char = strtolower($string[$i]);
        if (!isset($histogram[$char])) {
            $histogram[$char] = 1;
        } else {
            $histogram[$char]++;
        }
    }

    if (isset($histogram[' '])) {
        unset($histogram[' ']);
    }
    $hasOdd = False;
    foreach ($histogram as $key => $value) {
        if ($value%2 !== 0) {
            if (!$hasOdd) {
                $hasOdd = True;
            } else {
                return False;
            }
        }
    }
    return True;
}

$string1 = "Tact Coa";
$string2 = "abcd";

echo isPalindromePermutation($string1) . PHP_EOL;
echo isPalindromePermutation($string2) . PHP_EOL;