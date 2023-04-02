<?php

// Given two sorted integer arrays A and B, merge B into A as one sorted array.

//  Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
// TIP: C users, please malloc the result into a new array and return the result. 
// If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n

// Example :

// Input : 
//          A : [1 5 8]
//          B : [6 9]

// Modified A : [1 5 6 8 9]

/**
 * Time: O(n+m) where n is size of arr1, m size of arr2
 * Space: O(n+m)
 *
 */
function merge($arr1, $arr2) {
    $temp = [];
    $left = 0;
    $right = 0;

    while ($left < sizeof($arr1) && $right < sizeof($arr2)) {
        if ($arr1[$left] < $arr2[$right]) {
            $temp[] = $arr1[$left];
            $left++;
        } else {
            $temp[] = $arr2[$right];
            $right++;
        }
    }
    while ($left < sizeof($arr1)) {
        $temp[] = $arr1[$left];
        $left++;
    }
    while ($right < sizeof($arr2)) {
        $temp[] = $arr2[$right];
        $right++;
    }
    return $temp;
}

$arr1 = [1,5,8];
$arr2 = [6,9];

print_r(merge($arr1, $arr2));