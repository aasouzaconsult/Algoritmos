<?php

// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

// Valid operators are +, -, *, /. Each operand may be an integer or another expression.

// Examples:

//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

/**
 * As long as expression is a number, put into a stack.
 * when a arithmetic expression is encountered, pop 2 elements from stack, perform
 * the operation and return back into the stack.
 * 
 * Time: O(n) where n is size of array.
 * Space: O(n)
 */

function evaluateExpression($arr) {
    if (sizeof($arr) < 1) {
        return 0;
    }
    $stack = [];

    for ($i=0; $i < sizeof($arr); $i++) { 
        if (is_numeric($arr[$i])) {
            $stack[] = $arr[$i];
        } else {
            $second = array_pop($stack);
            $first = array_pop($stack);
            if ($arr[$i] == "+") {
                $value = (int)$first + (int)$second;
            } elseif ($arr[$i] == "-") {
                $value = (int)$first - (int)$second;
            } elseif ($arr[$i] == "*") {
                $value = (int)$first * (int)$second;
            } else {
                $value = floor((int)$first / (int)$second);
            }
            $stack[] = $value;
        }
    }
    return $stack[0];
}

$arr1 = ["2", "1", "+", "3", "*"];
$arr2 = ["4", "13", "5", "/", "+"];
$arr3 = [ "5", "1", "2", "+", "4", "*", "+", "3", "-" ];
$arr4 = [ "-500", "-10", "/" ];

echo evaluateExpression($arr1) . PHP_EOL;
echo evaluateExpression($arr2) . PHP_EOL;
echo evaluateExpression($arr3) . PHP_EOL;
echo evaluateExpression($arr4) . PHP_EOL;