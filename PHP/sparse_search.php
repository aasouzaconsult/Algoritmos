<?php

/**
 * Given a sorted array of strings that is interspersed with empty strings, write
 * a method to find the location of a given string.
 *
 * EXAMPLE
 * Input: ball, ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""]
 * Output: 4
 */

/**
 * Since its sorted, we can use a version of binary search.
 * 1. get mid index
 * 2. if mid index value is empty check +1 index value
 * 3. when we hit a non empty index value, if value bigger than search item, get left side of index
 * 4. else get right side of index
 * 5. do binary search
 *
 * Time: O(n) where n is size of array. averge case is O(n)
 * Space: O(1)
 */
function sparseSearch($array, $value) {
    return binarySearch($array, 0, sizeof($array)-1, $value);
}

function binarySearch($array, $start, $end, $value) {
    if ($start > $end) {
        return;
    }
    $mid = floor(($start + $end) / 2);
    $i = $mid;
    while ($array[$i] == "") {
        $i++;
    }
    if ($array[$i] == $value) {
        return $i;
    } elseif ($array[$i] > $value) {
        return binarySearch($array, $start, $mid-1, $value);
    } else {
        return binarySearch($array, $i+1, $end, $value);
    }
}

$array1 = ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""];

echo sparseSearch($array1, "ball") . PHP_EOL;