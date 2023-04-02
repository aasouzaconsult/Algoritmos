<?php

/**
 * Mergesort
 * Merge sort divides the array in half, sorts each of those halves, and then
 * merges them back together. Each of those halves has the same sorting algorithm
 * applied to it. Eventually, you are merging just two single element arrays.
 * It is the "merge" part that does all the heavy lifting.
 */

/**
 * Time: O(nlgn) where n is size of input array
 * Space: O(n)
 * @param  [type] $input [description]
 * @return [type]        [description]
 */
function mergeSort($input) {
    // check for less than 2 elements
    if (empty($input) || sizeof($input) < 2) {
        return $input;
    }
    // recursively call merge sort
    mergeSortRecur($input, 0, sizeof($input)-1);
    return $input;
}

function mergeSortRecur(&$input, $low, $high) {
    if ($low < $high) {
        $mid = floor(($low + $high) / 2);
        mergeSortRecur($input, $low, $mid);
        mergeSortRecur($input, $mid+1, $high);
        merge($input, $low, $mid, $high);
    }
}

function merge(&$input, $low, $mid, $high) {
    $tempArr = $input;
    $leftStart = $low;
    $rightStart = $mid + 1;
    $current = $low;

    while ($leftStart <= $mid && $rightStart <= $high) {
        if ($input[$leftStart] < $input[$rightStart]) {
            $tempArr[$current] = $input[$leftStart];
            $leftStart++;
        } else {
            $tempArr[$current] = $input[$rightStart];
            $rightStart++;
        }
        $current++;
    }
    // copy remainder of left into temp array
    while ($leftStart <= $mid) {
        $tempArr[$current] = $input[$leftStart];
        $leftStart++;
        $current++;
    }
    // copy remainder of right into temp array
    while ($rightStart <= $high) {
        $tempArr[$current] = $input[$rightStart];
        $rightStart++;
        $current++;
    }

    for ($i=$low; $i <= $high; $i++) { 
        $input[$i] = $tempArr[$i];
    }
}

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];

echo implode(" ", mergeSort($input1)) . PHP_EOL;
echo implode(" ", mergeSort($input2)) . PHP_EOL;