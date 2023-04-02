<?php

// Given an array A of integers, find the maximum of j - i subjected to the
// constraint of A[i] <= A[j].

// If there is no solution possible, return -1.

// Example :

// A : [3 5 4 2]

// Output : 2 
// for the pair (3, 4)

/**
 * Brute Force.
 *
 * 1. loop through array from right to left
 * 2.     for each element, check every element before
 * 3.          if currentelement is less than or equal pivot element, j - i
 * 4.              if j - i is larger than so far, update largest value
 *
 * Time: O(n^2)
 * Space: O(1)
 */
function maxDistance($arr) {
    if (empty($arr)) {
        return -1;
    }
    $maxDist = PHP_INT_MIN;
    for ($i=0; $i < sizeof($arr)-1; $i++) { 
        for ($j=$i+1; $j < sizeof($arr); $j++) { 
            if ($arr[$i] <= $arr[$j]) {
                if ($j - $i > $maxDist) {
                    $maxDist = $j - $i;
                }
            }
        }
    }
    return $maxDist;
}

/**
 * Sort the given array while still maintaining the original element index.
 * Then for each element in sorted array, find the biggest original index for all its 
 * right elements.
 * Time: O(nlgn)
 * Space: O(n)
 *  
 */
function maxDistanceV2($arr) {
    if (empty($arr)) {
        return -1;
    }
    $indexElements = [];
    for ($i=0; $i < sizeof($arr); $i++) { 
        $indexElements[] = [$arr[$i], $i];
    }
    uasort($indexElements, compare);
    print_r($indexElements);
    $indexElements = array_values($indexElements);
    $maxDist = PHP_INT_MIN;
    for ($i=0; $i < sizeof($indexElements)-1; $i++) { 
        for ($j=$i+1; $j < sizeof($indexElements); $j++) { 
            if ($indexElements[$j][1] - $indexElements[$i][1] > $maxDist) {
                $maxDist = $indexElements[$j][1] - $indexElements[$i][1];
            }
        }
    }
    return $maxDist;
}

function compare($v1, $v2) {
    if ($v1[0] < $v2[0]) {
        return -1;
    }
    return 1;
}

$arr1 = [3,5,4,2];

echo maxDistance($arr1) . PHP_EOL;
echo maxDistanceV2($arr1) . PHP_EOL;