<?php

// Write a program to validate if the input string has redundant braces?
// Return 0/1 
//  0 -> NO 1 -> YES 

// Input will be always a valid expression

// and operators allowed are only + , * , - , /

// Example:

// ((a + b)) has redundant braces so answer will be 1
// (a + (a + b)) doesn't have have any redundant braces so answer will be 0

/**
 * Time: O(n) where n is size of string
 * Space: O(n)
 *
 */
function redundantBraces($string) {
    $stack = [];
    for ($i=0; $i < strlen($string); $i++) { 
        if ($string[$i] == ")") {
            $num2 = array_pop($stack);
            $op = array_pop($stack);
            $num1 = array_pop($stack);
            $openBrace = array_pop($stack);
            if (!is_numeric($num2) || !isOperand($op) || !is_numeric($num1) || $openBrace != "(") {
                return 1;
            } else {
                $stack[] = $num1;
            }
        } else {
            $stack[] = $string[$i];
        }
    }
    if (!in_array("(", $stack) && !in_array(")", $stack)) {
        return 0;
    }
    if (sizeof($stack) == 1 && is_numeric(array_pop($stack))) {
        return 0;
    }
    return 1;
}

function isOperand($char) {
    if ($char == "+" || $char == "-" || $char == "*" || $char == "/") {
        return True;
    }
    return False;
}

$str1 = "((1+3))";
$str2 = "(1+(1+3))";

echo redundantBraces($str1) . PHP_EOL;
echo redundantBraces($str2) . PHP_EOL;
