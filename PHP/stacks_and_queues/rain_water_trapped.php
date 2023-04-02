<?php

// Given n non-negative integers representing an elevation map where the width
// of each bar is 1, compute how much water it is able to trap after raining.

// Example :

// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.



// The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
// In this case, 6 units of rain water (blue section) are being trapped.

/**
 * Brute force.
 * 1. loop through the array
 * 2. for each element, find the left and right boundary
 * 3. if a boundary is formed and there are at least 1 block in between, calculate the area
 * and put into global result.
 * 4. return result.
 *
 * Time: O(n^2)
 * Space:O(1)
 */
function waterTrapped($arr) {
    if (sizeof($arr) < 1) {
        return 0;
    }
    $result = 0;
    for ($i=1; $i < sizeof($arr)-1; $i++) { 
        list($left, $right) = [$i, $i];
        while ($left - 1 >= 0 && $arr[$left-1] >= $arr[$left]) {
            $left--;
        }
        while ($right + 1 < sizeof($arr) && $arr[$right + 1] >= $arr[$right]) {
            $right++;
        }
        
        if ($right - $left > 1) { // more than 1 bar in between
            $minHeight = min($arr[$left], $arr[$right]);
            $area = 0;
            for ($j=$left+1; $j < $right; $j++) { 
                $area += $minHeight - $arr[$j];
            }
            $result += $area;
        }
    }
    return $result;
}

$arr1 = [0,1,0,2,1,0,1,3,2,1,2,1];

echo waterTrapped($arr1) . PHP_EOL;