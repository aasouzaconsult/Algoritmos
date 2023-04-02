<?php

/**
 * Write an efficient program to find the sum of contiguous subarray within a one-
 * dimensional array of numbers which has the largest sum.
 */

/**
 * Kadane's algorithm to finding the largest continuous sequence
 * Time: O(n^2)
 * Space: O(n)
 *
 */
function largestContSubarray($arr) {
    if (empty($arr)) {
        return [];
    }
    $largest = $arr;
    $largestIndex = [];
    for ($i=0; $i < sizeof($arr); $i++) { 
        $largestIndex[] = $i;
    }
    
    for ($i=0; $i < sizeof($arr); $i++) { 
        if ($arr[$i] >= 0) {
            $localMax = $arr[$i];
            for ($j=$i; $j < sizeof($arr); $j++) { 
                if ($j == $i) {
                    continue;
                }
                $localMax += $arr[$j];
                if ($localMax > $largest[$i]) {
                    $largest[$i] = $localMax;
                    $largestIndex[$i] = $j;
                } elseif ($localMax < 0) {
                    break;
                }
            }
        }
    }
    $maxs = array_keys($largest, max($largest));
    $key = $maxs[0];
    return array_slice($arr, $key, $largestIndex[$key] - $key + 1);
}

$arr1 = [-2,-3,4,-1,-2,1,5,-3];
$result1 = [4,-1,-2,1,5];

$arr2 = [-2,1,-3,4,-1,2,1,-5,4];
$result2 = [4,-1,2,1];

function equals($expected, $actual) {
    if ($expected === $actual) {
        echo "Success!" . PHP_EOL;
        return;
    }
    echo "Failed." . PHP_EOL;
    echo "Expected: " . PHP_EOL;
    print_r($expected);
    echo PHP_EOL;
    echo "Actual: " . PHP_EOL;
    print_r($actual);
    echo PHP_EOL;
}

equals($result1, largestContSubarray($arr1));
equals($result2, largestContSubarray($arr2));
