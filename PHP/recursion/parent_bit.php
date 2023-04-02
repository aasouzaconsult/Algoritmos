<?php

// Given a string that contains a single pair of parenthesis,
// compute recursively a new string made of only of the parenthesis
// and their contents, so "xyz(abc)123" yields "(abc)".

// parenBit("xyz(abc)123") -> "(abc)"
// parenBit("x(hello)") -> "(hello)"
// parenBit("(xy)1") -> "(xy)"

// mission: extract everything within brackets, including brackets
// base case:
// - end of string
// - end of bracket

function parentBit($string) {
    if (empty($string)) {
        return $string;
    }
    $index = 0;
    $result = "";
    _parentBit($string, $index, $result);
    return $result;
}

function _parentBit($string, $index, &$result) {
    $char = $string[$index];
    if ($char == "(" || !empty($result) || $char == ")") {
        $result .= $char;
    }
    if (strlen($string)-1 == $index || $char == ")") {
        return;
    }
    _parentBit($string, ++$index, $result);
}

echo parentBit("xyz(abc)123") . PHP_EOL;
echo parentBit("x(hello)") . PHP_EOL;
echo parentBit("(xy)1") . PHP_EOL;