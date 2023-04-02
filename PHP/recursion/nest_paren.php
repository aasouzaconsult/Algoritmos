<?php

// Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like "(())" or "((()))". Suggestion: check the first and last chars, and then recur on what's inside them.

// nestParen("(())")-> true
// nestParen("((()))")-> true
// nestParen("(((x))") ->false

// mission: given a string, check if string contains valid pair of parens, any other char will result in false
// base case: first index larger or equal to last index

function nestParen($string) {
    if (strlen($string) % 2 == 1) {
        return False;
    }
    $leftIndex = 0;
    $rightIndex = strlen($string)-1;
    return _nestParen($string, $leftIndex, $rightIndex);
}

function _nestParen($string, $leftIndex, $rightIndex) {
    if ($leftIndex > $rightIndex) {
        return True;
    }
    if ($string[$leftIndex] !== "(" || $string[$rightIndex] !== ")") {
        return False;
    }
    return _nestParen($string, ++$leftIndex, --$rightIndex);
}

echo nestParen("(())") . PHP_EOL;
echo nestParen("((()))") . PHP_EOL;
echo nestParen("(((x))")  . PHP_EOL;