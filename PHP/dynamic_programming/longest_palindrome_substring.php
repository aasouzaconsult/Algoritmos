<?php

/**
 * Find the longest palindrome substring.
 * Brute force.
 * Get every substring and check if its a palindrome. Update the longest
 * palindrome if required.
 * Time complexity: O(n^3)
 * Space complexity: O(1)
 */
function longestPalindrome($string) {
    if (empty($string)) {
        return;
    }
    $result = "";
    for ($i=0; $i < strlen($string)-1; $i++) {

        for ($j=$i+1; $j < strlen($string); $j++) { 
            $sub = substr($string, $i, $j-$i+1);
            if (isPalindrome($sub) && strlen($sub) > strlen($result)) {
                $result = $sub;
            }
        }
    }
    return $result;
}

/**
 * Find the longest palindrome substring.
 * A version of manacher's algorithm.
 * Put a wild character '*' in between every adjacent character to factor in even and odd palindromes.
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
function longestPalindromeV2($string) {
    if (empty($string)) {
        return;
    }
    $result = "";
    $adjusted = "*";
    for ($i=0; $i < strlen($string); $i++) { 
        $adjusted .= $string[$i] . "*";
    }

    for ($j=0; $j < strlen($adjusted); $j++) { 
        $i=$j;
        $k=$j;
        while ($i >= 0 && $k <= strlen($adjusted)-1) {
            $sub = substr($adjusted, $i, $k-$i+1);
            if (isPalindrome($sub)) {
                if (strlen($sub) > strlen($result)) {
                    $result = $sub;
                }
                $i -= 1;
                $k += 1;
            } else {
                break;
            }
        }
    }
    return str_replace("*", "", $result);
}

function longestPalindromeV3($string) {
    $temp = array_fill(0, strlen($string), -1);
    $table = array_fill(0, strlen($string), $temp);
    
    // all substrings of length 1 are palindromes
    for ($i=0; $i < strlen($string); $i++) { 
        $table[$i][$i] = 1;
    }
    // check for substring of length 2
    $start = 0;
    $maxLength = 1;
    for ($i=0; $i < strlen($string)-1; $i++) { 
        if ($string[$i] == $str[$i+1]) {
            $table[$i][$i+1] = 1;
            $start = $i;
            $maxLength = 2;
        }
    }

    // check for lengths greater than 2, k is length of substring
    for ($k=3; $k <= strlen($string); $k++) { 
        for ($i=0; $i < strlen($string)-$k+1; $i++) { 
            // Get the ending index of substring from
            // starting index i and length k
            $j = $i + $k - 1;

            // check for substring from ith index to jth index
            // iff str[i+1] to str[j-1] is a palindrome
            if ($table[$i+1][$j-1] && $string[$i] == $string[$j]) {
                $table[$i][$j] = 1;
                if ($k > maxLength) {
                    $start = $i;
                    $maxLength = $k;
                }
            }
        }
    }
    // print2Darray($table);
    return substr($string, $start, $maxLength);
    // return $maxLength;
}

function print2Darray($arr) {
    for ($i=0; $i < sizeof($arr); $i++) { 
        echo implode(" ", $arr[$i]) . PHP_EOL;
    }
}

/**
 * Given a string check if it is a palindrome.
 */
function isPalindrome($string) {
    return _isPalindrome($string, 0, strlen($string)-1);
}

function _isPalindrome($string, $firstIndex, $lastIndex) {
    if ($firstIndex >= $lastIndex) {
        return True;
    }
    if ($string[$firstIndex] !== $string[$lastIndex]) {
        return False;
    } else {
        return _isPalindrome($string, $firstIndex+1, $lastIndex-1);
    }
}


$string1 = "abba";
$string2 = "abbccbba";
$string3 = "geeks";
$string4 = "civic";
$string5 = "forgeeksskeegfor";
// echo isPalindrome($string1, 0, strlen($string1)-1) . PHP_EOL; // true
// echo isPalindrome($string2, 0, strlen($string2)-1) . PHP_EOL; // true
// echo isPalindrome($string3, 0, strlen($string3)-1) . PHP_EOL; // false
// echo isPalindrome($string4, 0, strlen($string4)-1) . PHP_EOL; // true

echo longestPalindromeV2($string1) . PHP_EOL;
echo longestPalindromeV2($string2) . PHP_EOL;
echo longestPalindromeV2($string3) . PHP_EOL;
echo longestPalindromeV2($string4) . PHP_EOL;
echo longestPalindromeV2($string5) . PHP_EOL;

// echo longestPalindromeV3($string1) . PHP_EOL;
// echo longestPalindromeV3($string2) . PHP_EOL;
// echo longestPalindromeV3($string3) . PHP_EOL;
// echo longestPalindromeV3($string4) . PHP_EOL;
// echo longestPalindromeV3($string5) . PHP_EOL;
