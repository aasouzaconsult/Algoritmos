<?php

// Given a string, return recursively a "cleaned" string where adjacent
// chars that are the same have been reduced to a single char. So "yyzzza" yields "yza".

// stringClean("yyzzza") -> "yza"
// stringClean("abbbcdd") -> "abcd"
// stringClean("Hello") -> "Helo"
// 
// mission: given a string, remove adjacent duplicates and return the string.
// base case: end of string

function stringClean($string) {
    if (strlen($string) < 2) {
        return $string;
    }
    $index = 1;
    $result = $string[0];
    _stringClean($string, $index, $result);
    return $result;
}

function _stringClean($string, $index, &$result) {
    $char = $string[$index];
    if ($char != $string[$index-1]) {
        $result .= $char;
    }
    if (strlen($string)-1 == $index) {
        return;
    }
    _stringClean($string, ++$index, $result);
}

echo stringClean("yyzzza") . PHP_EOL;
echo stringClean("abbbcdd") . PHP_EOL;
echo stringClean("Hello") . PHP_EOL;