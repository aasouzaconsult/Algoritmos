<?php

/**
 * Pattern matching.
 * Given a string of characters, find out if there is a substring match.
 * Return true if there is a match, false otherwise.
 *
 * Worst time complexity: O(nm)
 * Worst space complexity: O(1)
 */

$haysack = "aababba.";
$needle = "abba";

function hasString($haysack, $needle) {
    $hasMatch = false;
    for ($i=0; $i < sizeof($haysack); $i++) { // O(n)
        $matchSize = 0;
        for ($j=0; $j < sizeof($needle); $j++) { // O(m) where m is size of $needle
            if ($haysack[$i] === $needle[$j]) {
                $matchSize++;
            } else {
                break;
            }
        }
        if ($matchSize === sizeof($needle)) {
            $hasMatch = true;
        }
    }
    return $hasMatch;
}

if (hasString($haysack, $needle)) {
    echo 'Has match.' . PHP_EOL;
} else {
    echo 'No match.' . PHP_EOL;
}