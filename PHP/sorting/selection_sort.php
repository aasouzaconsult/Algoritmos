<?php

/**
 * Selection sort.
 * Given an array of unsorted integers, splitting the array into sorted and
 * unsorted portion, repeatedly find the smallest remaining unsorted element
 * and puts it at the end of the sorted portion of the array.
 *
 * Worst time complexity: O(n^2)
 * Worst space complexity: O(1)
 */

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];

function selectionSort($arr) {
    if (sizeof($arr) < 2) {
        return $arr;
    }
    // loop through array, with $i as the last sorted index
    for ($i=0; $i < sizeof($arr); $i++) { 
        $smallestIndex = $i;
        for ($j=$i+1; $j < sizeof($arr); $j++) { 
            if ($arr[$j] < $arr[$smallestIndex]) {
                $smallestIndex = $j;
            }
        }
        swap($arr[$i], $arr[$smallestIndex]);
    }
    return $arr;
}

function swap(&$value1, &$value2) {
    $temp = $value1;
    $value1 = $value2;
    $value2 = $temp;
}

print_r(selectionSort($input1));
print_r(selectionSort($input2));