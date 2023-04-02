<?php

/**
 * Write a method to return all subsets of a set.
 */

/**
 * Brute Force.
 * Time: O(n^2)
 * Space: O(n^2)
 */
function getSubsets($arr) {
    if (empty($arr)) {
        return [];
    }
    $result = [];
    for ($i=0; $i < sizeof($arr); $i++) { 
        
            $subArr = array_slice($arr, $i);
            if (!in_array($subArr, $result)) {
                $result[] = $subArr;
            }
        
    }
    return $result;
}

function getSubsetsV2($arr) {
    $result = [];
    getSubsetsUtil($arr, 0, $result);
    return $result;
}

function getSubsetsUtil($arr, $start, &$result) {
    if ($start > sizeof($arr)) {
        return;
    }
    $subArr = array_slice($arr, $start);
    $result[] = $subArr;
    getSubsetsUtil($arr, ++$start, $result);
}

$arr1 = [-8,-5,-3,1,2,3,4,6,8,10,15];

$res = getSubsets($arr1);
echo sizeof($res);
print_r($res);

$res2 = getSubsetsV2($arr1);
echo sizeof($res2);
print_r($res2);
