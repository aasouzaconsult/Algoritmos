<?php

/**
 * Implement an algorithm to print all valid(eg. properly opened and closed
 * combinations of n pairs of parentheses).
 * EXAMPLE
 * Input: 3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 */

/**
 * Construct the new parentesis in a DP approach.
 * Time: O(n^2 * n!)
 * Space: O(n!)
 */
function validParen($n) {
    if ($n <= 0) {
        return [];
    }
    list($paren, $result) = ["()", []];
    $result[$paren] = 1;
    computeValidParen(--$n, $paren, $result);
    return implode(" ", array_keys($result));
}

function computeValidParen($size, $paren, &$result) {
    if ($size == 0) {
        return;
    }
    $temp = array_keys($result);
    $result = [];
    foreach ($temp as $baseStr) {
        $result = computeNewParenSet($baseStr, $paren, $result);
    }
    computeValidParen(--$size, $paren, $result);
    return;
}

function computeNewParenSet($base, $paren, $result) {
    for ($i=0; $i <= strlen($base) ; $i++) { 
        $newStr = substr_replace($base, $paren, $i, 0);
        if (!isset($result[$newStr])) {
            $result[$newStr] = 1;
        }
    }
    return $result;
}

$n1 = 3;

echo validParen($n1) . PHP_EOL;
echo validParen(4) . PHP_EOL;