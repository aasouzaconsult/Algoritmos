<?php

/**
 * Find out the maximum sub-array of non negative numbers from an array.
 * The sub-array should be continuous. That is, a sub-array created by choosing
 * the second and fourth element and skipping the third element is invalid.
 * Maximum sub-array is defined in terms of the sum of the elements in the
 * sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
 *
 * Example:
 * A : [1, 2, 5, -7, 2, 3]
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3]
 * NOTE: If there is a tie, then compare with segment's length and return
 * segment which has maximum length
 * NOTE 2: If there is still a tie, then return the segment with minimum starting
 * index
 */

/**
 * Time: O(n)
 * Space: O(n)
 *
 */
function maxSubarray($arr) {
    if (empty($arr)) {
        return [];
    }
    list($start, $arrTable) = [0, []];
    // loop through array
    for ($i=0; $i < sizeof($arr); $i++) { 
        if ($arr[$i] < 0) {
            // handle -ve int case here
            if ($start <= $i-1) {
                // maybe something to add to table
                updateSubArrayTable($arr, $arrTable, $start, $i);
            }
            $start = $i + 1;
        } elseif ($i == sizeof($arr)-1) {
            $i++; // move index to next to cater for index offset
            updateSubArrayTable($arr, $arrTable, $start, $i);
        }
    }
    $maxKey = max(array_keys($arrTable));
    list($start, $end) = $arrTable[$maxKey];
    return array_slice($arr, $start, $end-$start+1);
}

function updateSubArrayTable($arr, &$arrTable, $start, $i) {
    $subArr = array_slice($arr, $start, $i - $start);       
    $sum = array_sum($subArr);
    if (!isset($arrTable[$sum])) {
        $arrTable[$sum] = [$start, $i-1];
    } else {
        // already exists, decide insertion by NOTE cases
        // subarr length is greater than existing
        if ($i - $start > $arrTable[$sum][1] - $arrTable[$sum][0] + 1) {
            $arrTable[$sum] = [$start, $i-1];
        } elseif ($start < $arrTable[$sum][0]) {
            $arrTable[$sum] = [$start, $i-1];
        }
    }
}

function maxSubarrayV2($arr) {
    if (empty($arr)) {
        return;
    }
    $subArrays = [];
    $subStartIndex = [];
    $temp = [];
    for ($i=0; $i < sizeof($arr); $i++) {
        if ($arr[$i] >= 0) {
            if (empty($temp)) {
                $subStartIndex[] = $i;
            }
            $temp[] = $arr[$i];
        } else {
            $subArrays[] = $temp;
            $temp = [];
        }
    }
    if (!empty($temp)) {
        $subArrays[] = $temp;
    }
    list($maxSum, $maxStartIndex, $maxSubarray) = [PHP_INT_MIN, PHP_INT_MAX, []];
    foreach ($subArrays as $key => $subArr) {
        $sum = array_sum($subArr);
        if ($sum > $maxSum) {
            $maxSum = $sum;
            $maxStartIndex = $key;
            $maxSubarray = $subArr;
        } elseif ($sum == $maxSum) {
            if (sizeof($subArr) > sizeof($maxSubarray)) {
                $maxSum = $sum;
                $maxStartIndex = $key;
                $maxSubarray = $subArr;
            } elseif ($subStartIndex[$key] < $maxStartIndex) {
                $maxSum = $sum;
                $maxStartIndex = $key;
                $maxSubarray = $subArr;
            }
        }
    }
    return $maxSubarray;
}

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

$arr1 = [1,2,5,-7,2,3];
$result1 = "1 2 5";

$arr2 = [ 1967513926, 1540383426, -1303455736, -521595368 ];

equals($result1, implode(" ", maxSubarray($arr1)));
echo implode(" ", maxSubarray($arr2)) . PHP_EOL;
echo implode(" ", maxSubarrayV2($arr1)) . PHP_EOL;
echo implode(" ", maxSubarrayV2($arr2)) . PHP_EOL;