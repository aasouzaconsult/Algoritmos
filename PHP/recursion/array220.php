<?php

// Given an array of ints, compute recursively if the array contains
// somewhere a value followed in the array by that value times 10. We'll
// use the convention of considering only the part of the array that begins
// at the given index. In this way, a recursive call can pass index+1 to move
// down the array. The initial call will pass in index as 0.

// array220([1, 2, 20], 0) -> true
// array220([3, 30], 0) -> true
// array220([3], 0) -> false

// mission: given an array, find if the current value is 10 times of the previous value.
// base case: 
// - end of the array,
// - 10 value found.

function array220($arr, $index) {
    if ($index !== 0) {
     if ($arr[$index-1] * 10 == $arr[$index]) {
            return True;
        }
    }
    if ($index == sizeof($arr)-1) {
        return False;
    }
    return array220($arr, ++$index);
}

echo array220([1, 2, 20], 0). PHP_EOL;
echo array220([3, 30], 0). PHP_EOL;
echo array220([3], 0) . PHP_EOL;
