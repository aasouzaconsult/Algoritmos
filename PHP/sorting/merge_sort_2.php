<?php

/**
 * Given an unsorted array of integers, repeatedly split the elements until they are
 * each in an array, then merge them back to a sorted array.
 * Time: O(nlgn)
 * Space: O(n)
 */
function mergeSort(&$arr) {
    mergeSortRecur($arr, 0, sizeof($arr)-1);
    return $arr;
}

function mergeSortRecur(&$arr, $low, $high) {
    if ($low < $high) {
        $mid = floor(($low + $high) / 2);
        mergeSortRecur($arr, $low, $mid);
        mergeSortRecur($arr, $mid+1, $high);
        merge($arr, $low, $mid, $high);
    }
}

function merge(&$arr, $low, $mid, $high) {
    $temp = $arr;
    $leftStart = $low;
    $rightStart = $mid+1;
    $curr = $low;

    while ($leftStart <= $mid && $rightStart <= $high) {
        if ($arr[$leftStart] < $arr[$rightStart]) {
            $temp[$curr] = $arr[$leftStart];
            $leftStart++;
        } else {
            $temp[$curr] = $arr[$rightStart];
            $rightStart++;
        }
        $curr++;
    }
    while ($leftStart <= $mid) {
        $temp[$curr] = $arr[$leftStart];
        $leftStart++;
        $curr++;
    }
    while ($rightStart <= $mid) {
        $temp[$curr] = $arr[$rightStart];
        $rightStart++;
        $curr++;
    }
    for ($i=$low; $i <= $high; $i++) { 
        $arr[$i] = $temp[$i];
    }
}

function mergeSortRecurV2($arr) {
    if (sizeof($arr) <= 1) {
        return $arr;
    }
    $mid = floor((0 + sizeof($arr)-1) / 2);
    $left = array_slice($arr, 0, $mid+1);
    $right = array_slice($arr, $mid+1);
    $left = mergeSortRecurV2($left);
    $right = mergeSortRecurV2($right);

    return mergeV2($left, $right);
}

function mergeV2($left, $right) {
    if (empty($left)) {
        return $right;
    }
    if (empty($right)) {
        return $left;
    }
    if ($left[0] < $right[0]) {
        $value = array_shift($left);
        return array_merge([$value], mergeV2($left, $right));
    } else {
        $value = array_shift($right);
        return array_merge([$value], mergeV2($left, $right));
    }
}

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];

print_r(mergeSort($input1));
print_r(mergeSort($input2));
print_r(mergeSortRecurV2($input1));
print_r(mergeSortRecurV2($input2));

