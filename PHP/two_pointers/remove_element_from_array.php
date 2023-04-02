<?php

// Remove Element

// Given an array and a value, remove all the instances of that value in the array. 
// Also return the number of elements left in the array after the operation.
// It does not matter what is left beyond the expected length.

//  Example:
// If array A is [4, 1, 1, 2, 1, 3]
// and value elem is 1, 
// then new length is 3, and A is now [4, 2, 3] 
// Try to do it in less than linear additional space complexity.

function removeElement($arr, $num) {
    if (empty($arr)) {
        return $arr;
    }
    for ($i=0; $i < sizeof($arr); $i++) { 
        if ($arr[$i] == $num) {
            $j = $i;
            while ($j > 0) {
                if ($arr[$j-1] == $num) {
                    break;
                }
                swap($arr[$j], $arr[$j-1]);
                $j--;
            }
        }
    }
    return array_slice($arr, $j+1);
}

function swap(&$v1, &$v2) {
    $temp = $v1;
    $v1 = $v2;
    $v2 = $temp;
}

$arr1 = [4, 1, 1, 2, 1, 3];
$arr2 = [ 2, 0, 1, 2, 0, 3, 2, 2, 2, 1, 0, 0, 0, 1, 0, 0, 2, 2, 2, 3, 2, 3, 1, 2, 1, 2, 2, 3, 2, 3, 0, 3, 0, 2, 1, 2, 0, 0, 3, 2, 3, 0, 3, 0, 2, 3, 2, 2, 3, 1, 3, 3, 0, 3, 3, 0, 3, 3, 2, 0, 0, 0, 0, 1, 3, 0, 3, 1, 3, 1, 0, 2, 3, 3, 3, 2, 3, 3, 2, 2, 3, 3, 3, 1, 3, 2, 1, 0, 0, 0, 1, 0, 3, 2, 1, 0, 2, 3, 0, 2, 1, 1, 3, 2, 0, 1, 1, 3, 3, 0, 1, 2, 1, 2, 2, 3, 1, 1, 3, 0, 2, 2, 2, 2, 1, 0, 2, 2, 2, 1, 3, 1, 3, 1, 1, 0, 2, 2, 0, 2, 3, 0, 1, 2, 1, 1, 3, 0, 2, 3, 2, 3, 2, 0, 2, 2, 3, 2, 2, 0, 2, 1, 3, 0, 2, 0, 2, 1, 3, 1, 1, 0, 0, 3, 0, 1, 2, 2, 1, 2, 0, 1, 0, 0, 0, 1, 1, 0, 3, 2, 3, 0, 1, 3, 0, 0, 1, 0, 1, 0, 0, 0, 0, 3, 2, 2, 0, 0, 1, 2, 0, 3, 0, 3, 3, 3, 0, 3, 3, 1, 0, 1, 2, 1, 0, 0, 2, 3, 1, 1, 3, 2 ];

print_r(removeElement($arr1, 1));
print_r(removeElement($arr2, 2));