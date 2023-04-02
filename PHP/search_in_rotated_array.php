<?php

/**
 * Given a sorted array of n integers that has been rotated an unknown number of
 * times, write code to find an element in the array. You may assume that the array
 * was original sorted in increasing order.
 *
 * EXAMPLE:
 * Input: find 5 in [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14]
 * Output: 8(the index of 5 in the array)
 */

/**
 * Brute Force.
 *
 * Loop through the array to find the element.
 * Time: O(n)
 * Space: O(1)
 * While this works, we are definitely not looking for this solution.
 *
 */
function search($array, $value) {
    foreach ($array as $key => $element) {
        if ($value == $element) {
            return $key;
        }
    }
    return;
}

/**
 * A version of binary search.
 * Time: O(n/2 + lgn)
 * Space: O(1)
 */
function searchV2($array, $value) {
    // check for less than 1 value
    if (sizeof($array) < 1) {
        return;
    }
    $mid = floor((0 + sizeof($array)-1) / 2);

    $start = $mid;
    $end = $mid;
    while ($start >= 0 && $end <= sizeof($array)-1) {
        if ($array[$start] == $value) {
            return $start;
        } elseif ($array[$end] == $value) {
            return $end;
        }
        if (isset($array[$start-1])) {
            if ($array[$start-1] <= $array[$start]) {
                $start--;
            }
        } else {
            break;
        }
        if (isset($array[$end+1])) {
            if ($array[$end+1] >= $array[$end]) {
                $end++;
            }
        } else {
            break;
        }
    }

    if ($start == 0) {
        return binarySearch($array, $end+1, sizeof($array)-1, $value);
    } elseif ($end == sizeof($array)-1) {
        return binarySearch($array, 0, $start-1, $value);
    }
}

function binarySearch($array, $start, $end, $value) {
    if ($start > $end) {
        return;
    }
    $mid = floor(($start + $end) / 2);
    if ($array[$mid] == $value) {
        return $mid;
    } elseif ($array[$mid] > $value) {
        return binarySearch($array, $start, $mid-1, $value);
    } else {
        return binarySearch($array, $mid+1, $end, $value);
    }
}

$array1 = [15,16,19,20,25,1,3,4,5,7,10,14];

// echo search($array1, 5) . PHP_EOL;
echo searchV2($array1, 16) . PHP_EOL;
