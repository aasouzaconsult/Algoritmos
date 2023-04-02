<?php

// Find the intersection of two sorted arrays.
// OR in other words,
// Given 2 sorted arrays, find all the elements which occur in both the arrays.

// Example :

// Input : 
//     A : [1 2 3 3 4 5 6]
//     B : [3 3 5]

// Output : [3 3 5]

// Input : 
//     A : [1 2 3 3 4 5 6]
//     B : [3 5]

// Output : [3 5]

/**
 * Time: O(n+m)
 * Space: O(n) assuming n is the shorter of 2 array
 *
 */
function intersections($arr1, $arr2) {
    if (empty($arr1) || empty($arr2)) {
        return [];
    }
    $result = [];
    $left = 0;
    $right = 0;

    while ($left < sizeof($arr1) && $right < sizeof($arr2)) {
        if ($arr1[$left] == $arr2[$right]) {
            $result[] = $arr1[$left];
            $left++;
            $right++;
        } elseif ($arr1[$left] < $arr2[$right]) {
            $left++;
        } else {
            $right++;
        }
    }
    return $result;
}

$a = [1, 2, 3, 3, 4, 5, 6];
$b = [3, 3, 5];

$c = [1, 2, 3, 3, 4, 5, 6];
$d = [3, 5];

print_r(intersections($a, $b));
print_r(intersections($c, $d));
