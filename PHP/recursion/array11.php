<?php

// Given an array of ints, compute recursively the number of times that the value 11 appears in the array.
// We'll use the convention of considering only the part of the array that begins at the given index.
// In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.

// array11([1, 2, 11], 0) -> 1
// array11([11, 11], 0) -> 2
// array11([1, 2, 3, 4], 0) -> 0

// mission: find the number of 11s in the array and return the count
// base case: end of the array

function array11($arr, $index) {
    $count = 0;
    if ($arr[$index] == 11) {
        $count++;
    }
    if ($index == sizeof($arr)-1) {
        return $count;
    }
    return array11($arr, ++$index) + $count;
}

echo array11([1,2,11], 0) . PHP_EOL;
echo array11([11,11], 0) . PHP_EOL;
echo array11([1,2,3,4], 0) . PHP_EOL;