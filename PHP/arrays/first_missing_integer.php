<?php

// https://www.interviewbit.com/problems/first-missing-integer/
// Given an unsorted integer array, find the first missing positive integer.

// Example:

// Given [1,2,0] return 3,

// [3,4,-1,1] return 2,

// [-8, -7, -6] returns 1

// Your algorithm should run in O(n) time and use constant space.
//  Input:  {2, 3, 7, 6, 8, -1, -10, 15}
// Output: 1

// Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
// Output: 4

// Input: {1, 1, 0, -1, -2}
// Output: 2 

/**
 * Time: O(n)
 * Space: O(1)
 *
 */
function firstMissingInteger($arr) {
    if (empty($arr)) {
        return;
    }

    $arr = removeNegativeIntegers($arr);
    if (empty($arr)) {
        return 1;
    }

    // mark arr[i] as visited by setting arr[i] - 1 index value to -ve
    for ($i=0; $i < sizeof($arr); $i++) {
        $index = abs($arr[$i]) - 1;
        if ($index < sizeof($arr) && $arr[$index] > 0) {
            $arr[$index] = -$arr[$index];
        }
    }

    for ($i=0; $i < sizeof($arr); $i++) { 
        if ($arr[$i] > 0) {
            return $i+1;
        }
    }
    return sizeof($arr);

}

function removeNegativeIntegers($arr) {
    $j = 0;
    // remove all non positive integers
    for ($i=0; $i < sizeof($arr); $i++) { 
        if ($arr[$i] < 0) {
            swap($arr[$i], $arr[$j]);
            $j++;
        }
    }
    return array_slice($arr, $j);
}

function swap(&$v1, &$v2) {
    $temp = $v1;
    $v1 = $v2;
    $v2 = $temp;
}

$arr1 = [1,2,0];
$arr2 = [3,4,-1,1];
$arr3 = [-8,-7,-6];
$arr4 = [2, 3, 7, 6, 8, -1, -10, 15];
$arr5 = [2, 3, -7, 6, 8, 1, -10, 15];
$arr6 = [1, 1, 0, -1, -2];

echo firstMissingInteger($arr1) . PHP_EOL;
echo firstMissingInteger($arr2) . PHP_EOL;
echo firstMissingInteger($arr3) . PHP_EOL;
echo firstMissingInteger($arr4) . PHP_EOL;
echo firstMissingInteger($arr5) . PHP_EOL;
echo firstMissingInteger($arr6) . PHP_EOL;