<?php

// Remove duplicates from Sorted Array
// Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

// Note that even though we want you to return the new length, make sure to change the original array as well in place

// Do not allocate extra space for another array, you must do this in place with constant memory.

//  Example: 
// Given input array A = [1,1,2],
// Your function should return length = 2, and A is now [1,2]. 

/**
 * OPTIMAL
 * 1. maintain a slow and fast pointer
 * 2. if the past pointer is smaller than pointer+1 element, put pointer element to
 * slow pointer location and increment pointer.
 * 
 * Time: O(n) where n is size of array
 * Space: O(1)
 *
 */
function removeDuplicates($arr) {
    if (sizeof($arr) < 1) {
        return 0; 
    } elseif (sizeof($arr) == 1) {
        return 1;
    }
    $end = 0;
    for ($i=0; $i < sizeof($arr)-1; $i++) { 
        if ($arr[$i] < $arr[$i+1]) {
            $arr[$end] = $arr[$i];
            $end++;
        }
    }
    $arr[$end] = $arr[sizeof($arr)-1];
    $arr = array_slice($arr, 0, $end+1);
    print_r($arr);
    return $end + 1;
}

$arr1 = [1, 1, 2];

echo removeDuplicates($arr1) . PHP_EOL;