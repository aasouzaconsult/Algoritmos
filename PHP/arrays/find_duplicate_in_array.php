<?php

/**
 * Given a read only array of n + 1 integers between 1 and n, find one number that
 * repeats in linear time using less than O(n) space and traversing the stream 
 * sequentially O(1) times.
 *
 * Input:
 * [3 4 1 4 1]
 *
 * Output: 1
 *
 * If multiple possible answers, output anyone.
 * If there's no duplicate, output -1.
 */

/**
 * Time: O(n)
 * Space: O(1)
 *
 */
function findDuplicate($arr) {
    // handle empty array case
    if (empty($arr)) {
        return -1;
    }
    // loop through array
    //     index is element -1
    //     if arr index is positive, set negative
    //     else, element is already negative, return the absolute element
    for ($i=0; $i < sizeof($arr); $i++) { 
        $index = abs($arr[$i]) - 1;
        if ($arr[$index] > 0) {
            $arr[$index] = -$arr[$index];
        } else {
            return abs($arr[$i]);
        }
    }
    // loop finished. return -1
    return -1;
}

$arr1 = [3, 4, 1, 4, 1];
echo findDuplicate($arr1) . PHP_EOL;