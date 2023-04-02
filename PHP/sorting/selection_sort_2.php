<?php

/**
 * Divide the arr into sorted and unsorted portion, find the smallest element in
 * unsorted portion and put into sorted portion.
 * Time: O(n^2)
 * Space: O(1)
 */
function selectionSort($arr) {
    if (sizeof($arr) < 2) {
        return $arr;
    }
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

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];

print_r(selectionSort($input1));
print_r(selectionSort($input2));