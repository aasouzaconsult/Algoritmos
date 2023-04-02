<?php

// https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
// Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

// The largest rectangle is shown in the shaded area, which has area = 10 unit.

// For example,
// Given height = [2,1,5,6,2,3],
// return 10.

/**
 * Brute Force.
 * 1. loop through every element as the starting height
 * 2. a second loop goes through the rest of the elements to calculate the combined area.
 * 3. if area is larger than global max area, update max area.
 *
 * Time: O(n^2) where n is size of the heights array
 * Space: O(1)
 */
function largestRectangle($heights) {
    if (sizeof($heights) < 1) {
        return 0;
    }
    $largestArea = -100000000000000;
    for ($i=0; $i < sizeof($heights); $i++) { 
        $smallest = $heights[$i];
        for ($j=$i; $j < sizeof($heights); $j++) {
            if ($heights[$j] < $smallest) {
                $smallest = $heights[$j];
            }
            $area = $smallest * ($j - $i + 1);
            if ($area > $largestArea) {
                $largestArea = $area;
            }
        }
    }
    return $largestArea;
}

/**
 * OPTIMAL
 * Use a stack to maintain a set of heights to calculate the maxarea with this popped
 * height as the min height.
 * 
 * 1. init an empty stack.
 * 2. init a global max area variable to keep track of largest area
 * 3. loop through the heights
 * 3a.  if stack is empty OR current height is more than the stack top's height
 * 3b.  else, stack is not empty and current height is less than the stack top's height
 *         pop the height from stack, calculate the base with current index as the right
 *         boundary for area(not including) and the next top of stack as the left boundary
 *         for area. if stack is empty, then take the current index as the length.
 * 4. pop the remaining elements off of the stack and calculate the area with the calculations above.
 *
 * Time: O(n) where n is size of the array
 * Space: O(n)
 */
function largestRectangleV2($heights) {
    if (sizeof($heights) < 1) {
        return 0;
    }
    $maxArea = 0;
    $stack = [];
    $i = 0;
    while ($i < sizeof($heights)) {
        if (empty($stack) || $heights[end($stack)] <= $heights[$i]) {
            $stack[] = $i;
            $i++;
        } else {
            $currMinIndex = array_pop($stack);
            if (empty($stack)) {
                $base = $i;
            } else {
                $base = $i - end($stack) - 1;
            }
            $area = $heights[$currMinIndex] * $base;
            if ($area > $maxArea) {
                $maxArea = $area;
            }
        }
    }
    while (!empty($stack)) {
        $currMinIndex = array_pop($stack);
        if (empty($stack)) {
            $base = $i;
        } else {
            $base = $i - $stack[sizeof($stack) - 1] - 1;
        }
        $area = $heights[$currMinIndex] * $base;
        if ($area > $maxArea) {
            $maxArea = $area;
        }
    }
    return $maxArea;
}

$arr1 = [2,1,5,6,2,3];
$arr2 = [6, 1, 5, 4, 5, 2, 6];
$arr3 = [6, 2, 5, 4, 5, 1, 6];

echo largestRectangle($arr1) . PHP_EOL;
echo largestRectangle($arr2) . PHP_EOL;
echo largestRectangle($arr3) . PHP_EOL;

echo largestRectangleV2($arr1) . PHP_EOL;
echo largestRectangleV2($arr2) . PHP_EOL;
echo largestRectangleV2($arr3) . PHP_EOL;