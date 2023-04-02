<?php

/**
 * In bubble sort, we start at the beginning of the array and swap the first two
 * elements if the first is greater than the second. Then we go to the next pair,
 * and so on. continuously making sweeps of the array until it is sorted. In doing
 * so, the smaller items slowly "bubble up" to the beginning of the list.
 */

/**
 * Time: O(n^2) where n is the number of elements to sort
 * Space: O(1)
 */
function bubbleSort($input) {
    // check input for less than 2 elements. nothing to sort, just return.
    if (sizeof($input) < 2) {
        return $input;
    }
    // while loop where swapped true
    //     set swapped to false
    //     for loop starting from 1st element to last
    //         if ith element is smaller than i-1th element
    //             swap both elements
    //             set swapped to true
    do {
        $swapped = False;
        for ($i=1; $i < sizeof($input); $i++) { 
            if ($input[$i] < $input[$i-1]) {
                swap($input[$i], $input[$i-1]);
                $swapped = True;
            }
        }
    } while ($swapped);
    // return input
    return $input;
}

function swap(&$value1, &$value2) {
    $temp = $value1;
    $value1 = $value2;
    $value2 = $temp;
}

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];

echo implode(" ", bubbleSort($input1)) . PHP_EOL;
echo implode(" ", bubbleSort($input2)) . PHP_EOL;
