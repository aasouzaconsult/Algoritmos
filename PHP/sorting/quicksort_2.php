<?php

/**
 * Quicksort.
 * 1. Randomly choose an index and set as pivot
 * 2. put this pivot to the end of the array
 * 3. maintain left side to be smaller than pivot, right side bigger than pivot
 * 4. after this sorting around pivot, put pivot at the intersection between left and right
 * 5. return this pivot index.
 * 6. recursively sort left and right side of the pivot. 
 *
 * Time: O(nlgn)
 * Space: O(1)
 */
function quickSort(&$arr) {
    if (sizeof($arr) < 2) {
        return $arr;
    }
    quickSortRecur($arr, 0, sizeof($arr)-1);
    return $arr;
}

function quickSortRecur(&$arr, $low, $high) {
    if ($low < $high) {
        $pivot = partition($arr, $low, $high);
        quickSortRecur($arr, $low, $pivot-1);
        quickSortRecur($arr, $pivot+1, $high);
    }
}

function partition(&$arr, $low, $high) {
    // get random index
    $index = rand($low, $high);
    // put pivot element to the end
    swap($arr[$index], $arr[$high]);
    $index = $high;
    // set last smaller index pointer to before the first element
    $lastSmallerIndex = $low-1;
    for ($i=$low; $i < $high; $i++) { 
        // if current element is less than pivot element, increment lastSmallerIndex and swap
        // this element with lastSmallerIndex element
        if ($arr[$i] < $arr[$index]) {
            $lastSmallerIndex++;
            swap($arr[$i], $arr[$lastSmallerIndex]);
        }
    }
    // put pivot element in its rightful place
    swap($arr[$lastSmallerIndex+1], $arr[$index]);
    $index = $lastSmallerIndex+1;
    return $index;
}

function swap(&$value1, &$value2) {
    $temp = $value1;
    $value1 = $value2;
    $value2 = $temp;
}

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];

print_r(quickSort($input1));
print_r(quickSort($input2));
