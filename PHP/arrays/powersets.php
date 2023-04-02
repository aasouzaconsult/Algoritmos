<?php

/**
 * Given an array of characters, generate every combination of character sequence.
 */

/**
 * Iterative approach to generating powersets.
 * Time: O(2^n * n)
 * Space: O(2^n * n)
 */
function generatePowersets($array) {
    $result = [[]];
    if (empty($array)) {
        return $result;
    }
    for ($i=0; $i < sizeof($array); $i++) { 
        $temp = [[]];
        foreach ($result as $value) {
            $value[] = $array[$i];
            $temp[] = $value;
        }
        foreach ($temp as $set) {
            if (!in_array($set, $result)) {
                $result[] = $set;
            }
        }
    }
    return $result;
}

/**
 * Recursive approach to generating powersets.
 * Time: O(2^n * n)
 * Space: O(2^n * n)
 */
function generatePowersetsRecursion($array) {
    $result = [[]];
    if (empty($array)) {
        return $result;
    }
    generatePowersetHelper($array, $result, 0);
    return $result;
}

function generatePowersetHelper($array, &$result, $index) {
    if ($index >= sizeof($array)) {
        return;
    }
    $temp = [[]];
    // add new char to each of the result elements
    foreach ($result as $value) {
        $value[] = $array[$index];
        $temp[] = $value;
    }
    // put elements into result if its new
    foreach ($temp as $set) {
        if (!in_array($set, $result)) {
            $result[] = $set;
        }
    }
    generatePowersetHelper($array, $result, ++$index);
}

/**
 * Recursive approach to generating powersets without using for loop in recursion.
 * Time: O(2^n * n)
 * Space: O(2^n * n)
 */
function generatePowersetsRecursionV2($array) {
    $result = [[]];
    if (empty($array)) {
        return $result;
    }
    for ($i=0; $i < sizeof($array); $i++) { 
        generatePowersetHelperV2($array, $result, 0, $i);
    }

    return $result;
}

function generatePowersetHelperV2($array, &$result, $resultIndex, $arrayIndex) {
    // if current result element already has the new char, terminate
    if ($array[$arrayIndex] == end($result[$resultIndex])) {
        return;
    }
    // new element is not in current result
    // append new element to end of current result element
    $temp = $result[$resultIndex];
    $temp[] = $array[$arrayIndex];    
    $result[] = $temp;

    generatePowersetHelperV2($array, $result, ++$resultIndex, $arrayIndex);
}

// def solve(elements):
//   result = []
//   def helper(idx, current, leftover):
//     if not leftover:
//       result.append(current)
//     else:
//       # include the current element
//       helper(current[:] + [leftover[0]], leftover[1:])
//       # exclude the current element
//       helper(current[:], leftover[1:])


$arr1 = ['A', 'B'];

// print_r(generatePowersets($arr1));
// print_r(generatePowersetsRecursion($arr1));
print_r(generatePowersetsRecursionV2($arr1));