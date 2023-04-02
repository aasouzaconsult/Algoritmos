<?php

/**
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 */

/**
 * Brute Froce.
 * 1. check for either string empty
 * 2. generate all substring of s1
 * 3. generate all substring of s2
 * 4. compare every s1 substring with s2 substring
 * 5. if they match && longer than previous match, set as new match rest
 * 6. return result
 *
 * Time: O((nm)^2) where n is size of str1, m is size of str2
 * Space: O(n^2 + m^2)
 */
function LCSBrute($str1, $str2) {
    if (empty($str1) || empty($str2)) {
        return [0, ''];
    }
    $s1Subs = getSubstrings($str1); // O(n^2)
    $s2Subs = getSubstrings($str2); // O(m^2)
    
    $match = "";
    for ($i=0; $i < sizeof($s1Subs); $i++) { // O(n^2) 
        for ($j=0; $j < sizeof($s2Subs); $j++) { // O(m^2)
            if ($s1Subs[$i] == $s2Subs[$j] && strlen($s1Subs[$i]) > strlen($match)) {
                $match = $s1Subs[$i];
            }
        }
    }
    return [strlen($match), $match];
}

function getSubstrings($string) {
    $result = [];
    if (empty($string)) {
        return $result;
    }
    for ($i=0; $i < strlen($string); $i++) { 
        for ($j=$i; $j < strlen($string); $j++) { 
            $sub = substr($string, $i, $j-$i+1);
            if (!in_array($sub, $result)) {
                $result[] = $sub;
            }
        }
    }
    return $result;
}

/**
 * DP Solution.
 *
 * Recurrence relation:
 * 
 * DP[$row][$col] = 0,  if $row == 0 or $col == 0
 * DP[$row][$col] = 1 + DP[$row-1][$col-1],  if $str1[$row] == $str2[$col]
 * DP[$row][$col] = 0,  otherwise
 *
 * Time: O(n*m) where n is size of str1, m is size of str2
 * Space: O(n*m)
 *
 * The BCR is O(n*m) so we know that we have an optimal solution in terms of time.
 * We can further optimize on Space complexity to O(1), since each computation of table
 * element only requires the top left corner value. Using a variable for that top left
 * value and get rid of the table will give us O(1) space complexity.
 */
function LCSV1($str1, $str2) {
    if (empty($str1) || empty($str2)) {
        return [0, ''];
    }
    $s1 = '%' . $str1;
    $s2 = '%' . $str2;
    $tableCol = array_fill(0, strlen($s2), -1);
    $table = array_fill(0, strlen($s1), $tableCol);

    list($maxLen, $maxRow, $maxCol) = [0, 0, 0];

    for ($row=0; $row < sizeof($table); $row++) { 
        for ($col=0; $col < sizeof($tableCol); $col++) { 
            if ($row == 0 || $col == 0 || $s1[$row] != $s2[$col]) {
                $table[$row][$col] = 0;
            } elseif ($s1[$row] == $s2[$col]) {
                $table[$row][$col] = 1 + $table[$row-1][$col-1];
            }
            if ($maxLen < $table[$row][$col]) {
                $maxLen = $table[$row][$col];
                $maxRow = $row;
                $maxCol = $col;
            }
        }
    }
    $result = "";
    computeCommonSubString($table, $s1, $maxRow, $maxCol, $result);
    return [$maxLen, $result];
}

function computeCommonSubString($table, $str, $row, $col, &$result) {
    if ($table[$row][$col] == 0) {
        return;
    }
    computeCommonSubString($table, $str, $row-1, $col-1, $result);
    $result .= $str[$row];
}

function printMatrix($matrix) {
    for ($i=0; $i < sizeof($matrix); $i++) { 
        for ($j=0; $j < sizeof($matrix[$i]); $j++) { 
            echo $matrix[$i][$j] . " ";
        }
        echo PHP_EOL;
    }
}

// The longest common substring is "Geeks" and is of length 5.
$string1 = "GeeksforGeeks";
$string2 = "GeeksQuiz";

// The longest common substring is "abcd" and is of length 4.
$string3 = "abcdxyz"; 
$string4 = "xyzabcd";

// The longest common substring is "abcdez" and is of length 6.
$string5 = "zxabcdezy"; 
$string6 = "yzabcdezx";

// The longest common substring is "BABC" and is of length 4.
$string7 = "BABCA";
$string8 = "ABABC";

echo implode(" ", LCSBrute($string1, $string2)) . PHP_EOL;
echo implode(" ", LCSBrute($string3, $string4)) . PHP_EOL;
echo implode(" ", LCSBrute($string5, $string6)) . PHP_EOL;
echo implode(" ", LCSBrute($string7, $string8)) . PHP_EOL;

echo implode(" ", LCSV1($string1, $string2)) . PHP_EOL;
echo implode(" ", LCSV1($string3, $string4)) . PHP_EOL;
echo implode(" ", LCSV1($string5, $string6)) . PHP_EOL;
echo implode(" ", LCSV1($string7, $string8)) . PHP_EOL;
