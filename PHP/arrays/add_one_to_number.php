<?php

/**
 * Given a non-negative number represented as an array of digits,
 *
 * add 1 to the number ( increment the number represented by the digits ).
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * Example:
 * 
 * If the vector has [1, 2, 3]
 * 
 * the returned vector should be [1, 2, 4]
 * 
 * as 123 + 1 = 124.
 */

/**
 * Brute force.
 * Time: O(n) where n is size of array
 * Space: O(n)
 */
function addOneToNumber($arr) {
    // remove forward 0s 
    for ($i=0; $i < sizeof($arr); $i++) { 
        if ($arr[$i] == 0) {
            unset($arr[$i]);
        } else {
            break;
        }
    }
    $arr = array_values($arr);
    $exp = 1;
    $num = 0;
    for ($i=sizeof($arr)-1; $i >= 0; $i--) { 
        $num += $arr[$i] * $exp;
        $exp *= 10;
    }
    $num += 1;
    $result = [];
    while ($num > 1) {
        array_unshift($result, $num % 10);
        $num /= 10;
    }
    return $result;
}

/**
 * Add 1 to last element in array and ripple effect towards the front of array if
 * there's carry.
 * Time: O(n)
 * Space: O(1)
 *
 */
function addOneToNumberOptimized($arr) {
    // handle empty array
    if (empty($arr)) {
        return [1];
    }
    // remove forward padded zeros
    $arr = removeForwardZero($arr);
    // init carry variable to track forward carrys
    $carry = 0;
    // loop through array from back to front
    for ($i=sizeof($arr)-1; $i >= 0; $i--) { 
        if ($i == sizeof($arr)-1) {
            $arr[$i]++;
        } else {
            $arr[$i] += $carry;
            $carry = 0;
        }
        if ($arr[$i] >= 10) {
            $arr[$i] %= 10; 
            $carry = 1;
        } else {
            break;
        }
    }
    // if carry is 1 at the end, append a new 1 to forward of array
    if ($carry === 1) {
        array_unshift($arr, 1);
    }
    return $arr;
}

function removeForwardZero(&$arr) {
    // remove forward 0s
    for ($i=0; $i < sizeof($arr); $i++) { 
        if ($arr[$i] == 0) {
            unset($arr[$i]);
        } else {
            break;
        }
    }
    return array_values($arr);
}

$arr1 = [0,1,2,3];
$arr2 = [1,2,3];
$arr3 = [1,9,9];
$arr4 = [9,9,9];

// print_r(addOneToNumber($arr1));
// print_r(addOneToNumber($arr2));
print_r(addOneToNumberOptimized($arr1));
print_r(addOneToNumberOptimized($arr2));
print_r(addOneToNumberOptimized($arr3));
print_r(addOneToNumberOptimized($arr4));
