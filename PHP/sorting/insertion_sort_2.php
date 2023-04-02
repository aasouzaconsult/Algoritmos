<?php

/**
 * Given an unsorted array of integers, repeatedly move the elements to its right position.
 * Time: O(n^2)
 * Space: O(1)
 */
function insertionSort($arr) {
    if (sizeof($arr) < 2) {
        return $arr;
    }
    // loop through the array
    //    while loop look for the correct index this item should be in.
    //    swap current loop index with correct index
    for ($i=1; $i < sizeof($arr); $i++) { 
        $index = $i;        
        while ($arr[$index] < $arr[$index-1] && $index > 0) {
            swap($arr[$index], $arr[$index-1]);
            $index--;
        }
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

print_r(insertionSort($input1));
print_r(insertionSort($input2));
