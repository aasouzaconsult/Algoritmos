<?php

// Given a number n, find the smallest number that has same set of digits as n
// and is greater than n. If x is the greatest possible number with its set of
// digits, then print “not possible”.

// Examples:
// For simplicity of implementation, we have considered input number as a string.

// Input:  n = "218765"
// Output: "251678"

// Input:  n = "1234"
// Output: "1243"

// Input: n = "4321"
// Output: "Not Possible"

// Input: n = "534976"
// Output: "536479"

/**
 * If descending order, not possible
 * if ascending order, swap last 2 digits
 * else
 * 1. from right to left, look for first number that's smaller than prev right,
 * track that index
 * 2. from that index to the end, find the next smallest
 * 3. swap index and that next smallest
 * 4. sort startin from index
 * 5. return new arr
 * 
 * Time: O(n)
 * Space: O(n)
 *
 */
function nextPermutation($string) {
    if (empty($string)) {
        return "Not possible";
    }
    // put string char into array for easy manipulation
    $arr = [];
    for ($i=0; $i < strlen($string); $i++) { 
        $arr[] = (int) $string[$i];
    }
    // check if array is sorted in descending order
    $sortDesc = True;
    for ($i=1; $i < sizeof($arr); $i++) { 
        if ($arr[$i] > $arr[$i-1]) {
            $sortDesc = False;
            break;
        }
    }
    if ($sortDesc) {
        return "Not possible";
    }

    // loop from right to left, look for the value that's smaller than prev right
    $smallerIndex = -1;
    for ($i=sizeof($arr)-2; $i >= 0 ; $i--) { 
        if ($arr[$i] < $arr[$i+1]) {
            $smallerIndex = $i;
            break;
        }
    }
    if ($smallerIndex === -1) {
        return "Not possible";
    }
    // find the next smallest element to the right of index
    $subArr = array_slice($arr, $smallerIndex+1, sizeof($arr), True);
    $nextSmallerIndex = $smallerIndex+1;
    for ($i=$smallerIndex+2; $i < sizeof($arr); $i++) { 
        if ($subArr[$i] < $subArr[$nextSmallerIndex]) {
            $nextSmallerIndex = $i;
        }
    }
    // swap smaller and next smaller index
    swap($arr[$smallerIndex], $arr[$nextSmallerIndex]);
    $subArr[$nextSmallerIndex] = $arr[$nextSmallerIndex];
    
    sort($subArr);
    $j = 0;
    // put sorted subArr back into original arr
    for ($i=$smallerIndex+1; $i < sizeof($arr); $i++) { 
        $arr[$i] = $subArr[$j];
        $j++;
    }
    return $arr;
}

function swap(&$v1, &$v2) {
    $temp = $v1;
    $v1 = $v2;
    $v2 = $temp;
}

$str1 = "218765";
$str2 = "1234";
$str3 = "4321";
$str4 = "534976";
print_r(nextPermutation($str1));
print_r(nextPermutation($str2));
print_r(nextPermutation($str3));
print_r(nextPermutation($str4));