<?php

/**
 * Given 2 strings, write a method to decide if one is a permutation of the other.
 * Brute Force.
 * Get all the permutations of string1, then check string2 against each string1 permutation.
 * if a match is found, return True, else return false.
 * Time: O(n^2 * n!) THIS IS CRAZY
 * Space: O(n!) 
 */
function checkPermutations($string1, $string2) {
    $perms = getPermutations($string1);
    foreach ($perms as $value) {
        if ($string2 == $value) {
            return True;
        }
    }
    return False;
}

/**
 * Using a hashtable. 
 * Put each char in string1 into hashtable. 
 * Check string2 chars in the hashtable.
 * if any chars in string2 is not in hashtable or table is not empty at the end, return false
 * else return true.
 * Time: O(n+m) where n and m are length of string1 and string2 respectively
 * Space: O(n)
 */
function checkPermutationsV2($string1, $string2) {
    // return false if s1 length != s2 length
    // loop through s1
    //     if char not in table, put char => 1
    //     else
    //         table[char]++;
    // loop through s2
    //     if char not in table
    //         return false
    //     elseif table[char] == 1
    //         unset table[char]
    //     else
    //         table[char]--;
    // return false if table not empty
    if (strlen($string1) != strlen($string2)) {
        return False;
    }
    $table = [];
    for ($i=0; $i < strlen($string1); $i++) { 
        $char = $string1[$i];
        if (!isset($table[$char])) {
            $table[$char] = 1;
        } else {
            $table[$char]++;
        }
    }
    for ($i=0; $i < strlen($string2); $i++) { 
        $char = $string2[$i];
        if (!isset($table[$char])) {
            return False;
        } elseif ($table[$char] == 1) {
            unset($table[$char]);
        } else {
            $table[$char]--;
        }
    }
    return empty($table);
}

/**
 * Put each string into array. sort the array and check equality.
 * Time: O(nlgn+mlgm)
 * Space: O(n+m)
 */
function checkPermutationsV3($string1, $string2) {
    $arr1 = [];
    for ($i=0; $i < strlen($string1); $i++) { 
        $arr1[] = $string1[$i];
    }
    $arr2 = [];
    for ($i=0; $i < strlen($string2); $i++) { 
        $arr2[] = $string2[$i];
    }
    sort($arr1);
    sort($arr2);
    return $arr1 == $arr2;
}

/**
 * Given a string, return all permutations of the string.
 * Time: O(n^2 * (n-1)!) => O(n^2 * n!)
 * Space: O(n!)
 */
function getPermutations($string) {
    $permutations = [];

    for ($i=0; $i < strlen($string); $i++) { 
        if (empty($permutations)) {
            $permutations[] = $string[$i];
        } else {
            $temp = [];
            while (!empty($permutations)) {
                $str = array_shift($permutations);
                for ($j=0; $j < strlen($str)+1; $j++) { 
                    $temp[] = substr_replace($str, $string[$i], $j, 0);
                }
            }
            $permutations = $temp;
        }
    }
    return $permutations;
}

$string1 = "abcd";
$string2 = "bacd";
$string3 = "gfc";
$string4 = "fds";

echo checkPermutations($string1, $string2) . PHP_EOL;
echo checkPermutations($string3, $string4) . PHP_EOL;

echo checkPermutationsV2($string1, $string2) . PHP_EOL;
echo checkPermutationsV2($string3, $string4) . PHP_EOL;

echo checkPermutationsV3($string1, $string2) . PHP_EOL;
echo checkPermutationsV3($string3, $string4) . PHP_EOL;