<?php

// Remove Duplicates from Sorted Array

// Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory.

// Note that even though we want you to return the new length, make sure to change the original array as well in place

// For example,
// Given input array A = [1,1,1,2],

// Your function should return length = 3, and A is now [1,1,2].

/**
 * Time: O(n)
 * Space: O(1)
 *
 */
function removeDuplicates($arr) {
    if (sizeof($arr) <= 2) {
        return sizeof($arr);
    }
    $prev = 0;
    $end = 1;
    for ($i=2; $i < sizeof($arr); $i++) { 
        if ($arr[$i] != $arr[$end] || $arr[$i] != $arr[$prev]) {
            $end++;
            $arr[$end] = $arr[$i];
            $prev++;
        }
    }
    $arr = array_slice($arr, 0, $end+1);
    print_r($arr);
    return $end + 1;
}

$arr1 = [1,1,1,2];

echo removeDuplicates($arr1) . PHP_EOL;