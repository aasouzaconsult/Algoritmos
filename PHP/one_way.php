<?php

/**
 * There are 3 types of edits that can be performed on strings:
 * - insert a character
 * - remove a character
 * - replace a character.
 * Given 2 strings, write a function to check if they are one edit(or zero edits) away.
 * Example:
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 *
 * Time: O(n+m), where n is size of smaller string, m is size of bigger string
 * Space: O(m)
 *
 * Can be optimized to achieve O(n) time.
 */

function one_way($str1, $str2) {
    // get length of str1 and str2
    // if size diff > 1, return false
    // elseif size diff == 1
    //     smaller str char must full match bigger str chars, else false
    // else size diff == 0
    //     init madeChange flag to false
    //     put str1 chars into histogram
    //     loop through str2
    //         if char not in histogram
    //             if madeChange is false, set to true
    //             else return fales
    $smallStr = $str1;
    $bigStr = $str2;
    if (strlen($str1) > strlen($str2)) {
        $smallStr = $str2;
        $bigStr = $str1;
    }
    $diff = strlen($bigStr) - strlen($smallStr);
    if ($diff > 1) {
        return False;
    }
    $histogram = [];
    for ($i=0; $i < strlen($bigStr); $i++) { 
        $char = $bigStr[$i];
        if (!isset($histogram[$char])) {
            $histogram[$char] = 1;
        } else {
            $histogram[$char]++;
        }
    }
    $madeChange = False;
    if ($diff == 1) {
        $madeChange = True;
    }
    for ($i=0; $i < strlen($smallStr); $i++) { 
        $char = $smallStr[$i];
        if (!isset($histogram[$char])) {
            if (!$madeChange) {
                $madeChange = True;
            } else {
                return False;
            }
        } else {
            if ($histogram[$char] == 1) {
                unset($histogram[$char]);
            } else {
                $histogram[$char]--;
            }
        }
    }
    return True;
}

$set1 = ["pale", "ple"];
$set2 = ["pales", "pale"];
$set3 = ["pale", "bale"];
$set4 = ["pale", "bake"];

echo one_way($set1[0], $set1[1]) . PHP_EOL;
echo one_way($set2[0], $set2[1]) . PHP_EOL;
echo one_way($set3[0], $set3[1]) . PHP_EOL;
echo one_way($set4[0], $set4[1]) . PHP_EOL;
