<?php

// Given a list of non negative integers, arrange them such that they form the largest number.

// For example:

// Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

// Note: The result may be very large, so you need to return a string instead of an integer.


function compareLarger($value1, $value2) {
    $v1v2 = (string) $value1 . (string) $value2;
    $v2v1 = (string) $value2 . (string) $value1;
    if ($v1v2 < $v2v1) {
        return 1;
    } else {
        return -1;
    }

}

function largestNumber2($arr) {
    uasort($arr, compareLarger);
    return implode("", $arr);
}

/**
 * Time: O(n*k) where is the size of the largest value, n is the size of array
 * Space: O(n)
 */
function largestNumber($arr) {
    $bucket = array_fill(0, 10, []);
    $exp = 1;
    for ($i=0; $i < sizeof($arr); $i++) { 
        $index = getHighestDigit($arr[$i]);
        array_push($bucket[$index], $arr[$i]);
    }
    $result = [];
    for ($i=sizeof($bucket)-1; $i >= 0; $i--) { 
        $arr = radixSortSkipHighest($arr);
        while (!empty($arr)) {
            $result[] = array_pop($arr);
        }
    }
    return implode("", $result);
}

function radixSortSkipHighest($arr) {
    if (sizeof($arr) < 2) {
        return $arr;
    }
    $maxValue = max($arr);
    $digits = 0;
    while ($maxValue > 1) {
        $digits++;
        $maxValue /= 10;
    }
    $exp = 1;
    for ($i=0; $i < $digits-1; $i++) { 
        $arr = countingSort2($arr, $exp);
        $exp *= 10;
    }
    return $arr;
}

function getHighestDigit($value) {
    $highest = 0;
    while ($value > 1) {
        $highest = $value % 10;
        $value /= 10;
    }
    return $highest;
}

function countingSort2($arr, $exp) {
    // chek arr size less than 2
    if (sizeof($arr) < 2) {
        return $arr;
    }
    // init histogram array of size 10. for every digit
    $histogram = array_fill(0, 10, 0);
    for ($i=0; $i < sizeof($arr); $i++) { 
        $index = $arr[$i] / $exp;
        $histogram[$index % 10]++;
    }    
    // cumulative histogram position so the value in histogram now contains the
    // actual index location of the value in final array
    for ($i=1; $i < sizeof($histogram); $i++) { 
        $histogram[$i] += $histogram[$i-1];
    }

    // init result
    $result = array_fill(0, sizeof($arr), 0);

    // build result array
    for ($i=sizeof($arr)-1; $i >= 0; $i--) { 
        $index = $arr[$i] / $exp;
        $result[$histogram[$index % 10]-1] = $arr[$i];
        $histogram[$index % 10]--;
    }
    return $result;
}

$input3 = [3, 30, 34, 5, 9];

// echo largestNumber($input3) . PHP_EOL;
echo largestNumber2($input3);