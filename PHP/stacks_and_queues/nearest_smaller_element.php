<?php

// Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

// More formally,

// G[i] for an element A[i] = an element A[j] such that 
//     j is maximum possible AND 
//     j < i AND
//     A[j] < A[i]
// Elements for which no smaller element exist, consider next smaller element as -1.

// Example:

// Input : A : [4, 5, 2, 10]
// Return : [-1, 4, -1, 2]

// Example 2:

// Input : A : [3, 2, 1]
// Return : [-1, -1, -1]

/**
 * Time: O(n^2)
 * Space: O(n)
 *
 */
function nearestSmallest($arr) {
    if (sizeof($arr) < 1) {
        return [];
    }
    $stack = [];
    $temp = [];
    $result = array_fill(0, sizeof($arr), -1);
    $i = sizeof($arr) - 1;

    while ($i > 0) {
        $element = array_pop($arr);
        while ($arr[sizeof($arr)-1] >= $element) {
            $temp[] = array_pop($arr);
        }
        if (sizeof($arr) > 0) {
            $result[$i] = $arr[sizeof($arr)-1];
        }
        while (!empty($temp)) {
            $arr[] = array_pop($temp);
        }
        $i--;
    }
    return $result;
}

/**
 * OPTIMAL.
 * Use a stack to maintain elements traversed.
 * 1. init empty stack
 * 2. loop array from left to right
 * 3. if stack is not empty, pop elements in stack that are bigger or equal to current
 * element,
 * 4.    if stack is empty after 3, result for that element is -1. else result is the topmost
 * element in the stack.
 * 5. append current element to stack
 * 6. increment counter
 *
 * Time: O(n)
 * Space: O(n)
 */
function nearestSmallestV2($arr) {
    if (sizeof($arr) < 1) {
        return [];
    }
    $stack = [];
    $result = array_fill(0, sizeof($arr), -1);
    for ($i=0; $i < sizeof($arr); $i++) { 
        if (!empty($stack)) {
            while ($stack[sizeof($stack)-1] >= $arr[$i]) {
                array_pop($stack);
                if (sizeof($stack) < 1) {
                    break;
                }
            }
            if (sizeof($stack) > 0) {
                $result[$i] = $stack[sizeof($stack)-1];
            }
        }
        $stack[] = $arr[$i];
    }
    return $result;
}

$arr1 = [4, 5, 2, 10];
$arr2 = [3, 2, 1];
$arr3 = [ 34, 35, 27, 42, 5, 28, 39, 20, 28 ];

print_r(nearestSmallest($arr1));
print_r(nearestSmallest($arr2));
print_r(nearestSmallest($arr3));

print_r(nearestSmallestV2($arr1));
print_r(nearestSmallestV2($arr2));
print_r(nearestSmallestV2($arr3));
