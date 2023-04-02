<?php

function radixSort($arr) {
    $maxValue = max($arr);

    $exp = 1;
    $result = $arr;
    while ($maxValue/$exp > 1) {
        $result = countingSort2($result, $exp);
        $exp *= 10;
    }
    return $result;
}

function countingSort($arr) {
    // check arr size less than 2
    if (sizeof($arr) < 2) {
        return $arr;
    }
    // find max value in arr
    $maxValue = max($arr);
    // init histogram array of size max value
    $histogram = array_fill(0, $maxValue+1, 0);
    // populate histogram
    for ($i=0; $i < sizeof($arr); $i++) { 
        $value = $arr[$i];
        $histogram[$value]++;
    }
    // cumulative sum array of histogram
    for ($i=1; $i < sizeof($histogram); $i++) { 
        $histogram[$i] += $histogram[$i-1];
    }
    // init result
    $result = array_fill(0, sizeof($arr), 0);
    // loop through arr to put values in correct index
    foreach ($arr as $value) {
        $index = $histogram[$value];
        $result[$index] = $value;
        $histogram[$value]--;
    }
    return $result;
}

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];

// echo implode(" ", radixSort($input1)) . PHP_EOL;
// echo implode(" ", radixSort($input2)) . PHP_EOL;