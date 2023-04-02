<?php

/**
 * Quick sort.
 * Divide and conquer approach.
 * Divide by choosing the last element as pivot element. Then Conquer by going
 * through the unsorted portion and split them between elements less than or
 * equal(on the left) to pivot or more than pivot(on the right). Once split is
 * done, move the pivot to in between the two sides.
 * Do above steps recursively.
 *
 * Although quick sort has worst case complexity equal to that of insertion sort,
 * selection sort. but amortized running complexity is actually much faster than
 * sometimes even mergesort.
 *
 * Worst time complexity: O(n^2)
 * Best time complexity: O(nlgn)
 * Worst space complexity: O(1)
 */

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];

function quicksort($input) {
    $start = 0;
    $end = sizeof($input) - 1;

    return _quicksort($input, $start, $end);
}

function _quicksort(&$input, $start, $end) {
    if ($end-$start > 0) {
        $pivot = partition($input, $start, $end);
        _quicksort($input, $start, $pivot-1);
        _quicksort($input, $pivot+1, $end);
    }
    return $input;
}

// use last index as pivot
function partition(&$input, $start, $end) {
    $resultIndex = $start;
    $nextIndex = $start;

    while ($nextIndex < $end) {
        if ($input[$nextIndex] < $input[$end]) {
            swap($input[$resultIndex], $input[$nextIndex]);
            $resultIndex++;
        }
        $nextIndex++;
    }    
    $temp = $input[$end];
    $input[$end] = $input[$resultIndex];
    $input[$resultIndex] = $temp;
    return $resultIndex;
}

function swap(&$value1, &$value2) {
    $temp = $value1;
    $value1 = $value2;
    $value2 = $temp;
}

// quicksort php style
function quicksortV3($input) {
    if (sizeof($input) < 2) {
        return $input;
    }
    $left = $right = [];
    reset($input);
    $pivotKey = key($input);
    $pivot = array_shift($input);

    foreach ($input as $key => $value) {
        if ($value <= $pivot) {
            $left[$key] = $value;
        } else {
            $right[$key] = $value;
        }
    }
    return array_merge(quicksortV3($left), [$pivotKey => $pivot], quicksortV3($right));
}

print_r(quicksort($input1));
print_r(quicksort($input2));

print_r(quicksortV3($input1));
print_r(quicksortV3($input2));