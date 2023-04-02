<?php

// Given an array of ints, compute recursively if the array contains a 6.
// We'll use the convention of considering only the part of the array that
// begins at the given index. In this way, a recursive call can pass index+1
// to move down the array. The initial call will pass in index as 0.

// array6([1, 6, 4], 0) -> true
// array6([1, 4], 0) -> false
// array6([6], 0) -> true

// mission: given an array, find out if the array contains 6. if yes, return true
// base case: end of the array, array index is 6 

function array6($arr, $index) {
    if ($arr[$index] == 6) {
        return True;
    } elseif (sizeof($arr)-1 == $index) {
        return False;
    }
    return array6($arr, ++$index);
}

echo array6([1,6,4], 0) . PHP_EOL;
echo array6([1,4], 0) . PHP_EOL;
echo array6([6], 0) . PHP_EOL;