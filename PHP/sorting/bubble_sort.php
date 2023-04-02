<?php

/**
 * Bubble sort
 * Given an unsorted array of integers, repeatedly swap adjacent pairs until
 * the array is in sorted order.
 *
 * Worst time complexity: O(n^2)
 * Worst space complexity: O(1)
 */

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];

function bubbleSort($input) {
    // check input size more than 2
    if (sizeof($input) < 2) {
        return $input;
    }
    do {
        $swapped = false;
        for ($i=1; $i < sizeof($input); $i++) { // O(n)            
            if ($input[$i] < $input[$i-1]) {
                swap($input[$i], $input[$i-1]);
                $swapped = true;
            }
        }
    } while ($swapped);
    return $input;
}

function swap(&$value1, &$value2) {
    $temp = $value1;
    $value1 = $value2;
    $value2 = $temp;
}

print_r(bubbleSort($input1));
print_r(bubbleSort($input2));