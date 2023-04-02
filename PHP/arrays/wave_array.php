<?php

/**
 * Given an array of integers, sort the array into a wave like array and return it, 
 * In other words, arrange the elements into a sequence such that
 * a1 >= a2 <= a3 >= a4 <= a5.....
 *
 * Given [1, 2, 3, 4]
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 */

/**
 * Time: O(n)
 * Space: O(1)
 */
function waveArray($arr) {
    if (empty($arr)) {
        return $arr;
    }
    sort($arr);
    for ($i=1; $i < sizeof($arr); $i+=2) { 
        swap($arr[$i-1], $arr[$i]);
    }
    return $arr;
}

function swap(&$value1, &$value2) {
    $temp = $value1;
    $value1 = $value2;
    $value2 = $temp;
}

$arr1 = [1,2,3,4];

echo implode(" ", waveArray($arr1)) . PHP_EOL;