<?php

/**
 * Given 2 strings, find the longest common subsequence in this 2 strings.
 * string1 = "GVCEKST"
 * string2 = "GDVEGTA"
 */

/**
 * Brute Force.
 * For every subsequence of sequence X, check if it is the subsequence of
 * sequence Y, therefore identify whether it is a common subsequence of X and Y,
 * and record the longest one during this procedure. After all the subsequences
 * of X is examined, we get the LCS of X and Y. For a sequence X with m elements,
 * denoted by index as {1,2,...,m}, its subsequence can be denoted as a
 * subsequence of {1,2,...,m}. We can infer from this that X has 2^m subsequences,
 * so the complexity of brute force is exponential (2^n).
 * 
 * Generate all subsequences of string1
 * Generate all subsequence of string2.
 * Compare the 2 result sets, find and return the longest common subsequence there
 *
 * Time: O(2^n) where n is the size of the longer string. so the more accurate complexity
 * should be O(2^n + 2^m)
 * Space: O(2^n + 2^m)
 */
function LCSBrute($str1, $str2) {
    
}

/**
 * Recursive solution
 * Say i is the index for string1, j is index for string2.
 * if either of the strings are 0, then there are no common subsequence. ie 0.
 * if string1[i] == string2[j], then we have 1 additional common subsequence, we
 * must also add in the previous results of common substrings, which can be characterized
 * by string[i-1] and string[j-1].
 * if char at i and j don't match, we want to find the previous match at:
 * i-1, j
 * i, j-1
 * the max common subsequence of the 2 is the one we want.
 * Time: O(2^n) where n is the size of longer string, m is size of smaller string.
 * Space: O(2^n + 2^m)
 *
 * NOTE: There's a bug here. This solution gives us the correct length of the common
 * subsequence but not the correct subsequence, as we do not count duplicates in the
 * result set. How can we get the actual sequence from the recursive solution method?
 */
function LCS($str1, $str2) {
    // if either string empty, no common subsequence
    if (empty($str1) || empty($str2)) {
        return 0;
    }
    $result = [];
    $size = LCSHelper($str1, $str2, strlen($str1)-1, strlen($str2)-1, $result);
    $result = implode(" ", $result);
    return [$size, $result];
}

function LCSHelper($str1, $str2, $index1, $index2, &$result) {
    // base case. since we start from end of string, we should stop when either of
    // the string goes past first element, ie. less than 0.
    if ($index1 < 0 || $index2 < 0) {
        return 0;
    }
    // if char i and char j are the same, they contribute an additional result
    // we add the char to result and add the count.
    // else
    //     we look at the previous comparisons, which are (i-1, j) and (i, j-1)
    //     and choose the max of the 2 comparison
    if ($str1[$index1] == $str2[$index2]) {
        if (!in_array($str1[$index1], $result)) {
            $result[] = $str1[$index1];            
        }
        return 1 + LCSHelper($str1, $str2, $index1-1, $index2-1, $result);
    }
    return max(LCSHelper($str1, $str2, $index1-1, $index2, $result),
        LCSHelper($str1, $str2, $index1, $index2-1, $result));
    
    
}

/**
 * From analysis, we know that problem has an optimal substructure and has overlapping
 * subproblems. This ticks off the box that the problem can be solved by DP.
 * From analysis, we get the following outcome:
 * if either string is empty, common subsequence is 0
 * C[i,j] = 0  if i = 0, or j = 0
 * C[i,j] = 1 + C[i-1, j-1]  if s1[i] == s2[j]
 * C[i,j] = max(C[i-1,j], C[i,j-1]) if s1[i] != s2[j]
 *
 * With this recurrence relation, its easy to see that we can construct a matrix
 * to compute the solution. then the value at C[i,j], where i is length of s1, j
 * is length of s2 will be the digit of longest common subsequence
 *
 * Time: O(nm) where n is size of string1, m is size of string2
 * Space: O(nm)
 */
function LCSV2($str1, $str2) {
    // we add in the case where string could be empty, in this case a placeholder
    // in front of str1 and str2 to indicate when the string is empty
    $offset = 1;
    $temp = array_fill(0, strlen($str2) + $offset, NULL); // col
    $matrix = array_fill(0, strlen($str1) + $offset, $temp); // row

    for ($row=0; $row < strlen($str1)+$offset; $row++) { 
        for ($col=0; $col < strlen($str2)+$offset; $col++) { 
            if ($row == 0 || $col == 0) {
                $matrix[$row][$col] = 0;
            } elseif ($str1[$row-$offset] == $str2[$col-$offset]) {
                $matrix[$row][$col] = 1 + $matrix[$row-1][$col-1];
            } else {
                $matrix[$row][$col] = max($matrix[$row-1][$col], $matrix[$row][$col-1]);
            }
        }
    }
    $result = [];
    computeCommonSubsequence($matrix, $str1, strlen($str1), strlen($str2), $result);
    return $result;
}

function computeCommonSubsequence($matrix, $str1, $row, $col, &$result) {
    if ($matrix[$row][$col] == 0) {
        return $result;
    }
    if ($matrix[$row][$col] > $matrix[$row-1][$col] &&
        $matrix[$row][$col] > $matrix[$row][$col-1]) {
        // array_unshift($result, $str1[$row]);
        computeCommonSubsequence($matrix, $str1, $row-1, $col-1, $result);
        $result[] = $str1[$row-1]; // - 1 to circumvent the offset between matrix table and string
    } elseif ($matrix[$row][$col] == $matrix[$row-1][$col] ) {
        computeCommonSubsequence($matrix, $str1, $row-1, $col, $result);
    } elseif ($matrix[$row][$col] == $matrix[$row][$col-1]) {
        computeCommonSubsequence($matrix, $str1, $row, $col-1, $result);
    }
}

function printMatrix($matrix) {
    for ($i=0; $i < sizeof($matrix); $i++) { 
        for ($j=0; $j < sizeof($matrix[$i]); $j++) { 
            echo $matrix[$i][$j] . " ";
        }
        echo PHP_EOL;
    }
}

$string1 = "GVCEKST";
$string2 = "GDVEGTA";

// echo implode(" ", LCS($string1, $string2)) . PHP_EOL;
echo implode(" ", LCSV2($string1, $string2)) . PHP_EOL;