<?php

/**
 * Write a method to sort an array of strings so that all the anagrams are next
 * to each other.
 */

/**
 * Compute the ASCII value of each string and store in hashtable with sum as key.
 * Loop through the result and serialize the table elements.
 * Time: O(n)
 * Space: O(n)
 */
function groupAnagrams($array) {
    // check for less than 2 elements
    if (sizeof($array) < 2) {
        return $array;
    }
    // loop through array
    //     compute ASCII index of each string
    //     put into hashtable with total_ascii_value => (string1, string2, ...)
    $table = [];
    foreach ($array as $value) {
        $sum = 0;
        for ($i=0; $i < strlen($value); $i++) { 
            $sum += ord($value[$i]);
        }
        if (!isset($table[$sum])) {
            $table[$sum] = [$value];
        } else {
            array_push($table[$sum], $value);
        }
    }
    $result = [];
    // loop through hashtable and serialize into result array
    foreach ($table as $value) {
        $result = array_merge($result, $value);
    }
    // return result
    return $result;
}

$array1 = ["cat", "dog", "tac", "god", "act"];

echo implode(" ", groupAnagrams($array1)) . PHP_EOL;