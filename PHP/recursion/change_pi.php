<?php

// Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".

// changePi("xpix") -> "x3.14x"
// changePi("pipi") -> "3.143.14"
// changePi("pip") -> "3.14p"

// mission: given a string, whenever a 'pi' is found, replace it with 3.14 return the new string
// base case: reach end of string.

function change_pi($string) {
    if (strlen($string) < 2) {
        return $string;
    }
    $index = 0;
    $result = "";
    $prev = "";
    _change_pi($string, $index, $prev, $result);
    return $result;
}

function _change_pi($string, $index, $prev, &$result) {
    $char = $string[$index];
    if ($prev == "p" && $char == "i") {
        $char = "3.14";
        $prev = "";
        $result = substr($result, 0, -1);
    } elseif ($char == "p") {
        $prev = $char;
    }
    $result .= $char;
    if ($index == strlen($string)-1) {
        return;
    }
    return _change_pi($string, ++$index, $prev, $result);
}

echo change_pi('xpix') . PHP_EOL;
echo change_pi('pipi') . PHP_EOL;
echo change_pi('pip') . PHP_EOL;