<?php

/**
 * Write a method to compute all permutations of a string whose characters are not
 * necessarily unique. The list of permutations should not have duplicates.
 */

/**
 * We have to check if the newly constructed string already exists in result
 * before inserting into result set.
 * 
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

/**
 *
 */
function getPermutationsV2($str) {
    if (empty($str)) {
        return [];
    }
    return computePermutationsV2($str);
}

function computePermutationsV2($str) {
    if (strlen($str) <= 1) {
        return [$str];
    } elseif (strlen($str) == 2) {
        return [$str, strrev($str)];
    }
    $result = [];
    for ($i=0; $i < strlen($str) ; $i++) { 
        $sub = substr_replace($str, "", $i, 1);
        $subArr = computePermutationsV2($sub);
        foreach ($subArr as $baseStr) {
            $newStr = $str[$i] . $baseStr;
            if (!in_array($newStr, $result)) {
                $result[] = $newStr;
            }
        }
    }
    return $result;
}

$str1 = "abbd";
$str2 = "ccc";
print_r(getPermutations($str1));
print_r(getPermutationsV2($str1));
print_r(getPermutationsV2($str2));
