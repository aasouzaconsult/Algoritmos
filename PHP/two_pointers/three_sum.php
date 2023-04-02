<?php

// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
// Return the sum of the three integers.

// Assume that there will only be one solution

// Example: 
// given array S = {-1 2 1 -4}, 
// and target = 1.

// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

/**
 * Brute force.
 * 3 loops to get every combination of 3 numbers, while maintaining a min 3 number sets.
 *
 * Time: O(n^3) where n is size of array
 * Space: O(1)
 */
function threeSum($arr, $target) {
    if (sizeof($arr) < 3) {
        return NULL;
    }
    $range = PHP_INT_MAX;

    for ($i=0; $i < sizeof($arr); $i++) { 
        for ($j=$i+1; $j < sizeof($arr); $j++) { 
            for ($k=$j+1; $k < sizeof($arr); $k++) { 
                $temp = $arr[$i] + $arr[$j] + $arr[$k];
                $tempRange = abs($temp - $target);                
                if ($tempRange < $range) {
                    echo $arr[$i] . " " . $arr[$j] . " " . $arr[$k] . PHP_EOL;
                    $closest = $temp;
                    $range = $tempRange;
                }
            }
        }
    }
    return $closest;
}

/**
 * Using two pointer approach.
 * 1. sort the array in ascending order.
 * 2. starting from the left index, for each element, get the subsequent 2 values
 * and calculate the 3 value sums.
 * 3. update the sums if the current result is less than the max result so far
 *
 * Time: O(n^2)
 * O(nlogn) for sorting
 * O(n) * O(twoSum complexity) => O(n^2) to loop through from 0 to n - 2 elements
 * 
 * Space: O(1)
 */
function threeSumV2($arr, $target) {
    if (sizeof($arr) < 3) {
        return NULL;
    }
    sort($arr);

    $dist = PHP_INT_MAX;
    $result = NULL;
    for ($i=0; $i < sizeof($arr)-2; $i++) { 
        list($value2, $value3) = twoSum(array_slice($arr, $i+1), $target - $arr[$i]);
        $value = $arr[$i] + $value2 + $value3;
        $tempDist = abs($value - $target);
        if ($tempDist < $dist) {
            $dist = $tempDist;
            $result = $value;
        }
    }
    return $result;
}

/**
 * Two pointer approach to find the 2 values in array which sums up to target OR
 * closest to the target value.
 * Note: is is assumed the method takes in a sorted array.
 *
 * In two pointer approach, left pointer moves right until it meets right pointer and
 * vice versa.
 * Since array is sorted,
 * if value is bigger than target, moving left pointer right will only further increment
 * the value and gets even bigger than target. so when we find bigger value, we want to
 * move right pointer to the left so to try to get closer to value. we stop when left pointer
 * meets right pointer, since we cannot repeatedly use the same index.
 *
 * Time: O(n) where n is size of the array
 */
function twoSum($arr, $target) {
    $dist = PHP_INT_MAX;
    $result = [NULL, NULL];
    $left = 0;
    $right = sizeof($arr)-1;

    while ($left < $right) {
        $value = $arr[$left] + $arr[$right];
        $tempDist = abs($value - $target);
        if ($tempDist == 0) {
            return [$arr[$left], $arr[$right]];
        } elseif ($tempDist < $dist) {
            $dist = $tempDist;
            $result = [$arr[$left], $arr[$right]];
        }
        if ($value > $target) {
            $right--;
        } else {
            $left++;
        }
    }
    return $result;
}

$arr1 = [-1, 2, 1, -4];

echo threeSumV2($arr1, 1);