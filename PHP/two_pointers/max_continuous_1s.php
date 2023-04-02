<?php

// You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
// Find the position of zeros which when flipped will produce maximum continuous series of 1s.

// For this problem, return the indices of maximum continuous series of 1s in order.

// Example:

// Input : 
// Array = {1 1 0 1 1 0 0 1 1 1 } 
// M = 1

// Output : 
// [0, 1, 2, 3, 4] 

// If there are multiple possible solutions, return the sequence which has the minimum start index.

/**
 * Maintain a queue for each index that has a 0.
 * dequeue the idx and traverse starting from this index, counting the number of
 * 1s. for each 0 encountered, decrese flips count by 1. When flips is left with
 * 0. update the result if applicable.
 *
 * Time: O(n * m) where n is array size, m is the number of zeros in range
 */
function maxContinuousOne($arr, $m) {
    if (sizeof($arr) < 1) {
        return [];
    }
    $queue = [0];
    $result = [];

    while (!empty($queue)) {
        $idx = array_shift($queue);
        if ($idx >= sizeof($arr)) {
            continue;
        }
        $temp = [];
        $flips = $m;
        for ($i=$idx; $i < sizeof($arr); $i++) {
            if ($arr[$i] == 1) {
                $temp[] = $i;
            } else { // $arr[$i] == 0
                $queue[] = $i + 1;
                if ($flips > 0) {
                    $flips--;
                    $temp[] = $i;
                } else {
                    if (sizeof($temp) > sizeof($result)) {
                        $result = $temp;
                    }
                    break;
                }
            }
        }
        if (sizeof($temp) > sizeof($result)) {
            $result = $temp;
        }
    }
    return $result;
}

/**
 * OPTIMAL
 * Time: O(n) where n is size of array.
 * Space: O(1)
 */
function maxContinuousOneV2($arr, $m) {
    if (sizeof($arr) < 1) {
        return [];
    }
    list($left, $right) = [0, 0];
    list($bestLeft, $bestRight) = [0, 0];
    $windowZeros = 0;
    if ($arr[$right] == 0) {
        $windowZeros++;
    }
    while ($right < sizeof($arr)) {
        if ($windowZeros <= $m) {
            $right++;
            if ($arr[$right] == 0) {
                $windowZeros++;
            }
        }
        if ($windowZeros > $m) {
            if ($arr[$left] == 0) {
                $windowZeros--;
            }
            $left++;
        }
        if ($right >= sizeof($arr)) {
            if (sizeof($arr)-1-$left > $bestRight - $bestLeft) {
                $bestLeft = $left;
                $bestRight = sizeof($arr) - 1;
            }
        } elseif ($right - $left > $bestRight - $bestLeft) {
            $bestRight = $right;
            $bestLeft = $left;
        }
    }
    $result = [];
    for ($i=$bestLeft; $i <= $bestRight; $i++) { 
        $result[] = $i;
    }
    return $result;
}

$arr1 = [1, 1, 0, 1, 1, 0, 0, 1, 1, 1];
$arr2 = [ 0, 1, 1, 1 ];
$arr3 = [ 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0 ];

// print_r(maxContinuousOne($arr1, 1));
// print_r(maxContinuousOne($arr2, 0));
// print_r(maxContinuousOne($arr3, 7));
print_r(maxContinuousOneV2($arr1, 1));
print_r(maxContinuousOneV2($arr2, 0));
print_r(maxContinuousOneV2($arr3, 7));
