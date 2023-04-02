<?php

/**
 * Write a method to compute all permutations of a string of unique characters.
 */

/**
 * Time: O(n^2*n!)
 * Space: O(n!)
 */
function getPermutations($str) {
    if (empty($str)) {
        return [];
    }
    $result = [];
    computePermutations($str, 0, $result);
    return $result;
}

function computePermutations($str, $index, &$result) {
    if ($index >= strlen($str)) {
        return;
    }
    if (empty($result)) {
        $result[] = $str[$index];
    } else {
        $temp = $result;
        $result = [];
        foreach ($temp as $baseStr) { // O(n-1)
            for ($i=0; $i <= strlen($baseStr) ; $i++) {
                $newStr = substr_replace($baseStr, $str[$index], $i, 0);
                if (!in_array($newStr, $result)) {
                    $result[] = $newStr;
                }
            }
        }
    }
    $index++;
    computePermutations($str, $index, $result);
}

$str1 = "abcd";
print_r(getPermutations($str1));