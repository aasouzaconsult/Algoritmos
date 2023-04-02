<?php

/**
 * Given 2 strings, find the longest common subsequence in this 2 strings.
 * string1 = "GVCEKST"
 * string2 = "GDVEGTA"
 *
 * mission: get the common substring among 2 strings.
 * base case:
 * given i and j as string index string1 and string2 respectively
 * C as number of common string value up to now
 * case 1: if i=0 or j=0, C = 0
 * case 2: if $string1[i] == $string[j], 1 + C[i-1][j-1]
 * case 3: if $string1[i] !== $string[j], max(C[i-1][j], C[i][j-1])
 */

function longestCommonSubsequence($string1, $string2) {
    if (empty($string1) || empty($string2)) {
        return 0;
    }
    $temp = array_fill(0, strlen($string1)+1, -1);
    $table = array_fill(0, strlen($string2)+1, $temp);

    // if either of the substring is 0 length, then the common subsequence is 0
    for ($i=0; $i <sizeof($table) ; $i++) { 
        $table[0][$i] = 0;
        $table[$i][0] = 0;
    }

    for ($i=1; $i < sizeof($table); $i++) {
        for ($j=1; $j < sizeof($table[$i]); $j++) {
            if ($string1[$i-1] === $string2[$j-1]) {
                $table[$i][$j] = 1 + $table[$i-1][$j-1];
            } else {
                $table[$i][$j] = max($table[$i-1][$j], $table[$i][$j-1]);
            }
        }
    }
    printSequence($string1, strlen($string1), strlen($string2), $table);
}
function printSequence($string1, $len1, $len2, $table) {
    if ($table[$len1][$len2] == 0) {
        return;
    }
    if ($table[$len1][$len2] == $table[$len1-1][$len2]) {
        printSequence($string1, $len1-1, $len2, $table);
    } elseif ($table[$len1][$len2] == $table[$len1][$len2-1]) {
        printSequence($string1, $len1, $len2-1, $table);
    } else {
        printSequence($string1, $len1-1, $len2-1, $table);
        echo $string1[$len1-1];
    }
}

function print2Darray($arr) {
    for ($i=0; $i < sizeof($arr); $i++) { 
        echo implode(" ", $arr[$i]) . PHP_EOL;
    }
}

$string2 = "GVCEKST";
$string1 = "GDVEGTA";

longestCommonSubsequence($string1, $string2);