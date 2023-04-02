<?php

/**
 * A magic index in an array A[0...n-1] is defined to be an index such that
 * A[i] = i. Given a sorted array of distinct integers, write a method to find a
 * magic index, if one exists, in array A.
 *
 * FOLLOW UP
 * What if the values are not distinct?
 */

/**
 * Brute force.
 * From left to right, look through each element for match with index.
 * Return index if found, else retun null
 * Time: O(n)
 * Space: O(1)
 */
function findMagicIndex($arr) {
    if (empty($arr)) {
        return -1;
    }
    foreach ($arr as $key => $value) {
        if ($key == $value) {
            return $key;
        }
    }
    return -1;
}

/**
 * A version of binary search to search for magic number.
 *
 * Time: O(n) worse case, average O(lgn)
 * Space: O(1)
 */
function findMagicIndexV2($arr) {
    if (empty($arr)) {
        return -1;
    }
    return findMagicIndexRecur($arr, 0, sizeof($arr)-1);
}

function findMagicIndexRecur($arr, $low, $high) {
    if ($low > $high) {
        return -1;
    }
    $mid = floor(($low + $high)/2);
    if ($arr[$mid] == $mid) {
        return $mid;
    } elseif ($arr[$mid] < $mid) {
        // look on right
        return findMagicIndexRecur($arr, $mid+1, $high);
    } else {
        // look both left and right
        $left = findMagicIndexRecur($arr, $low, $mid-1);
        // if ($left == -1) {
        //     return findMagicIndexRecur($arr, $mid+1, $high);
        // } else {
            return $left;
        // }
    }
}

$arr1 = [-5,-3,1,3,5,6,8,10,12,15,21];
$arr2 = [-8,-5,-3,1,2,3,4,6,8,10,15];
$arr3 = [-8,-5,-3,1,2,3,4,6,9,11,17];

$start = microtime(true);
echo findMagicIndex($arr1) . PHP_EOL;
echo findMagicIndex($arr2) . PHP_EOL;
echo findMagicIndex($arr3) . PHP_EOL;
$elapsedTime = microtime(true) - $start;
echo "Brute force time: " . $elapsedTime * 1000 . PHP_EOL;

$start = microtime(true);
echo findMagicIndexV2($arr1) . PHP_EOL;
echo findMagicIndexV2($arr2) . PHP_EOL;
echo findMagicIndexV2($arr3) . PHP_EOL;
$elapsedTime = microtime(true) - $start;
echo "Binary search time: " . $elapsedTime * 1000 . PHP_EOL;