<?php

// Given an integer array, find a maximum product of a triplet in array.

// Examples:

// Input:  [10, 3, 5, 6, 20]
// Output: 1200
// Multiplication of 10, 6 and 20
 
// Input:  [-10, -3, -5, -6, -20]
// Output: -90

// Input:  [1, -4, 3, -6, 7, 0]
// Output: 168

/**
 * Brute Force
 * Time: O(n^3)
 * Space: O(1)
 *
 */
function maxTripletProductBrute($arr) {
    if (sizeof($arr) < 3) {
        return;
    }
    $maxValue = -1000000;
    for ($i=0; $i < sizeof($arr)-2; $i++) { 
        for ($j=$i+1; $j < sizeof($arr)-1; $j++) { 
            for ($k=$j+1; $k < sizeof($arr); $k++) { 
                $maxValue = max($maxValue, $arr[$i] * $arr[$j] * $arr[$k]);
            }
        }
    }
    return $maxValue;
}

/**
 * Sort the array from smallest to biggest.
 * then return the max between
 * 1. smallest 2 and biggest
 * 2. 3 biggest 
 * in array.
 *
 * Time: O(nlogn)
 * Space: O(1)
 */
function maxTripletProductSorting($arr) {
    if (sizeof($arr) < 3) {
        return;
    }
    sort($arr); // use a sorting algorithm with O(nlogn) complexity
    return max($arr[0] * $arr[1] * $arr[sizeof($arr)-1], $arr[sizeof($arr)-1] * $arr[sizeof($arr)-2] * $arr[sizeof($arr)-3]);
}

/**
 * Optimum.
 * Maintain a set of largest3 values and smallest2 values.
 * Loop through the array to populate the values
 * return the maximum of largest 3 OR smallest2 * largest value
 * 
 * Time: O(n)
 * Space: O(1)
 * 
 */
function maxTripletProduct($arr) {
    if (sizeof($arr) < 3) {
        return;
    }
    $largest3 = [-1000000, -1000000, -1000000];
    $smallest2 = [PHP_INT_MAX, PHP_INT_MAX];
    for ($i=0; $i < sizeof($arr); $i++) { 
        if ($arr[$i] > $largest3[0]) {
            $largest3[2] = $largest3[1];
            $largest3[1] = $largest3[0];
            $largest3[0] = $arr[$i];
        } elseif ($arr[$i] > $largest3[1]) {
            $largest3[2] = $largest3[1];
            $largest3[1] = $arr[$i];
        } elseif ($arr[$i] > $largest3[2]) {
            $largest3[2] = $arr[$i];
        }
        if ($arr[$i] < $smallest2[0]) {
            $smallest2[1] = $smallest2[0];
            $smallest2[0] = $arr[$i];
        } elseif ($arr[$i] < $smallest2[1]) {
            $smallest2[1] = $arr[$i];
        }
    }

    return max(array_product($largest3), array_product($smallest2) * max($largest3));
}

$arr1 = [10, 3, 5, 6, 20];
$arr2 = [-10, -3, -5, -6, -20];
$arr3 = [1, -4, 3, -6, 7, 0];

echo maxTripletProductBrute($arr1) . PHP_EOL;
echo maxTripletProductBrute($arr2) . PHP_EOL;
echo maxTripletProductBrute($arr3) . PHP_EOL;

echo maxTripletProductSorting($arr1) . PHP_EOL;
echo maxTripletProductSorting($arr2) . PHP_EOL;
echo maxTripletProductSorting($arr3) . PHP_EOL;

echo maxTripletProduct($arr1) . PHP_EOL;
echo maxTripletProduct($arr2) . PHP_EOL;
echo maxTripletProduct($arr3) . PHP_EOL;
