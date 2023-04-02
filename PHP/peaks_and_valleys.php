<?php

/**
 * In an array of integers, a "peak" is an element which is greater than or equal
 * to the adjacent integers and a "valley" is an element which is less than or
 * equal to the adjacent integers. For example, [5,8,6,2,3,4,6], {8,6} are peaks
 * and {5,2} are valleys. Given an array of integers, sort the array into an
 * alternating sequence of peaks and valleys.
 * EXAMPLE
 * Input: [5,3,1,2,3]
 * Output: [5,1,3,2,3]
 */

/**
 * Let's sort the array first. we can use merge sort to achieve O(nlgn) complexity.
 * Time: O(nlgn) from mergesort. where n is size of array
 * Space: O(n)
 */
function peakAndValley($array) {
    if (sizeof($array) < 2) {
        return $array;
    }
    $array = mergesort($array);
    for ($i=sizeof($array)-1; $i > 0; $i-= 2) { 
        swap($array[$i], $array[$i-1]);
    }
    return $array;
}

function mergesort($array) {
    mergeSortRecur($array, 0, sizeof($array)-1);
    return $array;
}

function mergeSortRecur(&$array, $start, $end) {
    if ($start < $end) {
        $mid = floor(($start + $end) / 2);
        mergeSortRecur($array, $start, $mid);
        mergeSortRecur($array, $mid+1, $end);
        merge($array, $start, $mid, $end);
    }
}

function merge(&$array, $low, $mid, $high) {
    $leftStart = $low;
    $rightStart = $mid + 1;
    $temp = $array;
    $current = $low;

    while ($leftStart <= $mid && $rightStart <= $high) {
        if ($array[$leftStart] < $array[$rightStart]) {
            $temp[$current] = $array[$leftStart];
            $leftStart++;
        } else {
            $temp[$current] = $array[$rightStart];
            $rightStart++;
        }
        $current++;
    }
    while ($leftStart <= $mid) {
        $temp[] = $array[$leftStart];
        $leftStart++;
        $current++;
    }
    while ($rightStart <= $high) {
        $temp[] = $array[$leftStart];
        $rightStart++;
        $current++;
    }
    for ($i=$low; $i <= $high; $i++) { 
        $array[$i] = $temp[$i];
    }
    return;
}

function swap(&$value1, &$value2) {
    $temp = $value1;
    $value1 = $value2;
    $value2 = $temp;
}

/**
 * Optimal way.
 * The optimal way to solve is to fix the array without first sorting the array.
 * We can achieve this by having the middle of 3 integers always be a peak, ie the
 * largest element among the 3. in such a way, for each set of 3 integers, we maintain
 * that the middle is always a 'highest' peak. 
 * We then jump to the next set of 3. note that there will be a left integer overlap
 * as we jump 2 elements to the right.
 */
function peakAndValley($array) {

}

$array1 = [5,3,1,2,3];

echo implode(" ", peakAndValley($array1)) . PHP_EOL;