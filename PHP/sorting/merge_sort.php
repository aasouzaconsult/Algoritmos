<?php

/**
 * Merge sort.
 * Typical divide and conquer approach.
 * Recursively divide the array to half the size until there is only 1 element
 * left in each subarray. Then merge the subarrays in ascending/descending order
 * until the original array is merged back in ascending/descending order.
 *
 * Worst time complexity: O(nlgn)
 * Worst space complexity: O(n)
 */

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];

function mergesort($input) {
    if (sizeof($input) <= 1) {
        return $input;
    }

    $mid = (int) (sizeof($input) / 2);
    $left = array_slice($input, 0, $mid-0+1);
    $right = array_slice($input, $mid+1);
    $left = mergesort($left);
    $right = mergesort($right);
    return merge($left, $right);
}
function merge($left, $right) {
    $result = [];

    while (!empty($left) && !empty($right)) {
        if ($left[0] < $right[0]) {
            $result[] = array_shift($left);
        } else {
            $result[] = array_shift($right);
        }
    }
    if (!empty($left)) {
        $result = array_merge($result, $left);
    }
    if (!empty($right)) {
        $result = array_merge($result, $right);
    }
    return $result;
}

/**
 * CLRS textbook solution.
 *
 */
function mergeSortV2($arr) {
    if (sizeof($arr) < 2) {
        return $arr;
    }
    mergeSortRecur($arr, 0, sizeof($arr)-1);
    return $arr;
}

function mergeSortRecur(&$arr, $low, $high) {
    if ($low < $high) {
        $mid = floor(($low + $high) / 2);
        mergeSortRecur($arr, $low, $mid);
        mergeSortRecur($arr, $mid+1, $high);
        mergeV2($arr, $low, $mid, $high);
    }
}

function mergeV2(&$arr, $low, $mid, $high) {
    list($temp, $leftStart, $rightStart, $current) = [$arr, $low, $mid+1, $low];

    while ($leftStart <= $mid && $rightStart <= $high) {
        if ($arr[$leftStart] < $arr[$rightStart]) {
            $temp[$current] = $arr[$leftStart];
            $leftStart++;
        } else {
            $temp[$current] = $arr[$rightStart];
            $rightStart++;
        }
        $current++;
    }
    // copy left side remainder into array
    while ($leftStart <= $mid) {
        $temp[$current] = $arr[$leftStart];
        $leftStart++;
        $current++;
    }
    // copy right side remainder into array
    while ($rightStart <= $high) {
        $temp[$current] = $arr[$rightStart];
        $rightStart++;
        $current++;
    }
    // put back into array
    for ($i=$low; $i <= $high; $i++) { 
        $arr[$i] = $temp[$i];
    }
}

function mergeRecur($left, $right) {
    if (empty($left)) {
        return $right;
    }
    if (empty($right)) {
        return $left;
    }
    if ($left[0] < $right[0]) {
        $first = array_shift($left);
        return array_merge([$first], mergeRecur($left, $right));
    } else {
        $first = array_shift($right);
        return array_merge([$first], mergeRecur($left, $right));
    }
}
$left = [1,5,6,8];
$right = [2,8,11,17];
print_r(mergeRecur($left, $right));
print_r(mergesort($input1));
print_r(mergesortV2($input1));