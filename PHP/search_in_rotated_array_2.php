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
 * Time: O(n)
 * Space: O(1)
 */
function search($array, $value) {
    // check for empty array
    if (empty($array)) {
        return;
    }
    // iterate through array, looking for the value
    //     if value found, return the index.
    for ($i=0; $i < sizeof($array); $i++) { 
        if ($value == $array[$i]) {
            return $i;
        }
    }
}

/**
 * 1. go to the middle value
 * 2. get the portion of increasing order sequence from the middle value. iterative
 * 3. if value is found in this section, return the index
 * 4. if not, we do a binary search on other half of the array. return index if found else return false
 *
 * Time: O(n + lgn)
 */
function searchV2($array, $value) {
    if (empty($array) || empty($value)) {
        return;
    }
    $mid = floor((0 + sizeof($array)-1) / 2);
    $start = $mid;
    $end = $mid;
    while ($start >= 0 && $end < sizeof($array)) {
        if ($array[$start] == $value) {
            return $start;
        } elseif ($array[$end] == $value) {
            return $end;
        }
        if (isset($array[$start-1])) {
            if ($array[$start-1] < $array[$start]) {
                $start--;
            }
        } else {
            break;
        }
        if (isset($array[$end+1])) {
            if ($array[$end+1] > $array[$end]) {
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

function binarySearch($array, $low, $high, $value) {
    if ($low > $high) {
        return;
    }
    $mid = floor(($low+$high) / 2);
    if ($array[$mid] == $value) {
        return $mid;
    } elseif ($value < $array[$mid]) {
        return binarySearch($array, $low, $mid-1, $value);
    } else {
        return binarySearch($array, $mid+1, $high, $value);
    }
}

function searchV3($array, $value) {
    // check empty array or value
    if (empty($array) || empty($value)) {
        return;
    }
    return searchV3Recur($array, 0, sizeof($array)-1, $value);
}

/**
 * Time: O(lgn) where n is size of array. If there are duplicates at either end,
 * the complexity goes up to O(n).
 * Space: O(1)
 */
function searchV3Recur($array, $start, $end, $value) {    
    if ($start > $end) {
        return;
    }
    // get mid index.
    $mid = floor(($start + $end) / 2);
    // if 1st left < mid value:
    //     left is ordered normally
    //     determine which side to search
    //     if value >= 1st left && value < mid
    //         search left side
    //     else 
    //         search right side
    // else
    //     right is ordered normally
    //     determine which side to search
    //     if value >= mid+1 && value <= end
    //         search right side
    //     else
    //         search left side
    if ($array[$mid] == $value) {
        return $mid;
    } elseif ($array[$start] < $array[$mid]) {
        // left is ordered normally
        if ($value >= $array[$start] && $value < $array[$mid]) {
            // search left side
            return searchV3Recur($array, $start, $mid-1, $value);
        } else {
            // search right side
            return searchV3Recur($array, $mid+1, $end, $value);
        }
    } elseif ($array[mid] < $array[$end]) {
        // right is ordered normally
        if ($value > $array[$mid] && $value <= $array[$end]) {
            // search right side
            return searchV3Recur($array, $mid+1, $end, $value);
        } else {
            // search left side
            return searchV3Recur($array, $start, $mid-1, $value);
        }
    } elseif ($array[$start] == $array[$mid]) {
        // left half is all repeats
        if ($array[$mid] !== $array[$right]) {
            // search right
            return searchV3Recur($array, $mid+1, $end, $value);
        } else {
            // we have to search both halves
            $result = searchV3Recur($array, $start, $mid-1, $value);
            if (empty($result)) {
                return searchV3Recur($array, $mid+1, $end, $value);
            } else {
                return $result;
            }
        }
    }
    return;
}

$array1 = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14];

// echo search($array1, 19) . PHP_EOL;
// echo search($array1, 5) . PHP_EOL;

// echo searchV2($array1, 14) . PHP_EOL;

echo searchV3($array1, 15) . PHP_EOL;
echo searchV3($array1, 16) . PHP_EOL;
echo searchV3($array1, 19) . PHP_EOL;
echo searchV3($array1, 20) . PHP_EOL;
echo searchV3($array1, 25) . PHP_EOL;
echo searchV3($array1, 1) . PHP_EOL;
echo searchV3($array1, 3) . PHP_EOL;
echo searchV3($array1, 4) . PHP_EOL;
echo searchV3($array1, 5) . PHP_EOL;
echo searchV3($array1, 7) . PHP_EOL;
echo searchV3($array1, 10) . PHP_EOL;
echo searchV3($array1, 14) . PHP_EOL;
