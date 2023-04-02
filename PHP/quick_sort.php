<?php

/**
 * Quicksort.
 * In quick sort, we pick a random element and partition the array, such that all
 * numbers that are less than the partitioning element comes before all elements
 * that are greater than it. The partitioning can be performed efficiently through
 * a series of swaps.
 */

/**
 * Time: O(nlgn). worst case O(n^2) but less likely if random element is chosen.
 * Space: O(1)
 * 
 */
function quicksort($input) {
    // check for less than 2 elements
    if (sizeof($input) < 2) {
        return $input;
    }
    quickSortRecur($input, 0, sizeof($input)-1);
    return $input;
}

function quickSortRecur(&$input, $start, $end) {
    if ($start < $end) {
        $pivot = partition($input, $start, $end);
        quickSortRecur($input, $start, $pivot-1);
        quickSortRecur($input, $pivot+1, $end);
    }
}

function partition(&$input, $start, $end) {
    // chooses a random index as pivot
    $pivot = rand($start, $end);
    // put that element to the end
    swap($input[$pivot], $input[$end]);
    // pivot is now at the end index
    $pivot = $end;
    // last element where index value smaller than pivot
    $left = $start-1;

    for ($i=$start; $i < $end; $i++) { 
        if ($input[$i] < $input[$pivot]) {
            $left++;
            swap($input[$left], $input[$i]);
        }
    }
    swap($input[$pivot], $input[$left+1]);
    return $left+1;
} 

function swap(&$value1, &$value2) {
    $temp = $value1;
    $value1 = $value2;
    $value2 = $temp;
}

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];

echo implode(" ", quicksort($input1)) . PHP_EOL;
echo implode(" ", quicksort($input2)) . PHP_EOL;
