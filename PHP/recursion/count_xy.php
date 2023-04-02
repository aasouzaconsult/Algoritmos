<?php

// Given a string, compute recursively (no loops) a new string where all the
// lowercase 'x' chars have been changed to 'y' chars.

// changeXY("codex") -> "codey"
// changeXY("xxhixx") -> "yyhiyy"
// changeXY("xhixhix") -> "yhiyhiy"

// mission: given a string, return a string where all lowercase x is changed to y.
// base case: the end of string

function changeXY($string) {
    $result = "";
    $index = 0;
    _changeXY($string, $index, $result);
    return $result;
}

function _changeXY($string, $index, &$result) {
    $char = $string[$index];
    if ($char == "x") {
        $char = "y";
    }
    $result .= $char;
    if ($index == strlen($string)-1) {
        return;
    }
    _changeXY($string, ++$index, $result);
}

echo changeXY("codex") . PHP_EOL;
echo changeXY("xxhixx") . PHP_EOL;
echo changeXY("xhixhix") . PHP_EOL;