<?php

// Implement strStr().

//  strstr - locate a substring ( needle ) in a string ( haystack ). 
// Try not to use standard library string functions for this question.

// Returns the index of the first occurrence of needle in haystack, or -1 if
// needle is not part of haystack.

/**
 * Implementation of strstr function.
 * Time: O(n*m) where n is size of needle, m is size of haystack
 * Space: O(1)
 */
function myStrStr($needle, $haystack) {
    if (empty($needle) || empty($haystack)) {
        return -1;
    }
    $result = -1;
    for ($i=0; $i < strlen($haystack) - strlen($needle) + 1; $i++) { 
        if (sameSubstringAt($haystack, $needle, $i, 0)) {
            $result = $i;
        }
    }
    return $result;
}

function sameSubstringAt($haystack, $needle, $index, $needleIndex) {
    if ($needleIndex >= sizeof($needle)) {
        return True;
    }
    if ($haystack[$index] != $needle[$needleIndex]) {
        return False;
    }
    return sameSubstringAt($haystack, $needle, $index+1, $needleIndex+1);
}

$needle1 = 'stri';
$haystack1 = 'substring';

$needle2 = "b";
$haystack2 = "b ";

echo myStrStr($needle1, $haystack1) . PHP_EOL;
echo myStrStr($needle2, $haystack2) . PHP_EOL;