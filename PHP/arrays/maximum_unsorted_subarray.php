<?php

// You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
// Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order)
// that sub array, then the whole array should get sorted.
// If A is already sorted, output -1.

// Example :

// Input 1:

// A = [1, 3, 2, 4, 5]

// Return: [1, 2]

// Input 2:

// A = [1, 2, 3, 4, 5]

// Return: [-1]
// In the above example(Input 1), if we sort the subarray A1, A2, then whole
// array A should get sorted.

/**
 * http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
 * get a preliminary start end index and check if array is sorted with start end
 * sorted. if sorted, return start end.
 * else
 * find min and max value in the start end portion, then search left for bigger
 * than min, search right for smaller than max.
 * return the new start end indexes.
 *
 * Time: O(nlgn) where n is size of array. O(nlgn) because we sort the partial array
 * Other than that, the algorithm is O(n)
 * Space: O(n). again because of the isSorted check. otherwise its O(1) space.
 */
function maxUnsortedV2($arr) {
    // check empty arr
    if (empty($arr)) {
        return [-1];
    }
    // init start and end indexes
    list($start, $end) = [-1, -1];
    // find first element that's smaller than its prev element
    for ($i=1; $i < sizeof($arr); $i++) { 
        if ($arr[$i] < $arr[$i-1]) {
            $start = $i-1;
            break;
        }
    }
    // arr is already sorted
    if ($start == -1) {
        return [-1];
    }
    // find the first element(from right to left) that's bigger than its prev element
    for ($i=sizeof($arr)-2; $i >= 0; $i--) { 
        if ($arr[$i] > $arr[$i+1]) {
            $end = $i+1;
            break;
        }
    }
    // check if arr is sorted
    if (isSorted($arr, $start, $end)) {
        return [$start, $end];
    }
    // find min and max value in start to end portion
    list($minValue, $maxValue) = [PHP_INT_MAX, PHP_INT_MIN];
    for ($i=$start; $i <= $end; $i++) { 
        if ($arr[$i] < $minValue) {
            $minValue = $arr[$i];
        }
        if ($arr[$i] > $maxValue) {
            $maxValue = $arr[$i];
        }
    }
    // on left side of $start, check if any value is bigger than $minValue
    for ($i=0; $i < $start; $i++) { 
        if ($arr[$i] > $minValue) {
            $start = $i;
            break;
        }
    }
    // on right side of $end,  check if any value is smaller than $maxValue
    for ($i=sizeof($arr)-1; $i > $end; $i--) { 
        if ($arr[$i] < $maxValue) {
            $end = $i;
            break;
        }
    }
    return [$start, $end];
}

/**
 * Sort the array from start index to end index only. Then check if the whole
 * array is sorted. If sorted, return true, else return false.
 * 
 */
function isSorted($arr, $start, $end) {
    $sortingArr = array_slice($arr, $start, $end - $start + 1);
    // sort part of this array given by start and end indexes
    sort($sortingArr);
    // put sorted portion back into original array
    for ($i=0; $i < sizeof($sortingArr); $i++) { 
        if ($start <= $end) {
            $arr[$start] = $sortingArr[$i];
        }
        $start++;
    }
    // check if arr is sorted
    for ($i=1; $i < sizeof($arr); $i++) { 
        if ($arr[$i] < $arr[$i-1]) {
            return False;
        }
    }
    return True;
}

/**
 * This WONT WORK FOR:
 * - duplicate sorted values
 * Find the elements that are smaller than prev number, and set start end accordingly.
 *
 */
function maxUnsorted($arr) {
    if (empty($arr)) {
        return [-1];
    }
    // init start end indexes
    list($start, $end) = [0, 0];
    for ($i=1; $i < sizeof($arr); $i++) { 
        if ($arr[$i] < $arr[$i-1]) {
            if ($start === 0) {
                $start = $i-1;
            }
            $end = $i;
        }
    }
    if ($start === 0 && $end === 0) {
        return [-1];
    }
    return [$start, $end];
}

$arr1 = [1, 3, 2, 4, 5];
$arr2 = [ 1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15 ]; // [4, 10]
$arr3 = [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60];
$arr4 = [ 4, 15, 4, 4, 15, 18, 20 ];

print_r(maxUnsortedV2($arr1));
print_r(maxUnsortedV2($arr2));
print_r(maxUnsortedV2($arr3));
print_r(maxUnsortedV2($arr4));