<?php

/**
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy the elements
 * into any other data structure (such as an array). The stack supports the
 * following operation: push, pop, peek and isEmpty.
 */

/**
 * Use a tempStack and temp variable as auxillary places to sort values in increasing order,
 * having smallest value at top of the stack.
 *
 * Time: O(n^2)
 * Space: O(n)
 */
function sortStack($stack) {
    $tempStack = [];
    $temp = NULL;

    // stop at first instance stack is empty
    while (!empty($stack)) {
        // decide what to put into temp stack
        if (empty($tempStack)) {
            if (!empty($temp)) {
                $tempStack[] = $temp;
                $temp = NULL;
            } else {
                $tempStack[] = array_pop($stack);
            }
        } elseif ($stack[sizeof($stack)-1] >= $tempStack[sizeof($tempStack)-1]) {
            // top of stack is bigger than top of tempStack
            $tempStack[] = array_pop($stack);
        } else {
            // top of stack smaller than top of tempstack
            // so we move the smaller value to temp variable
            $temp = array_pop($stack);
            // move all values bigger than temp back into stack to clear way for temp
            // to move into tempStack
            moveBiggerValues($stack, $tempStack, $temp);
            // found a place for temp to move into tempStack
            $tempStack[] = $temp;
            $temp = NULL;
        }
    }
    if (!empty($temp)) {
        moveBiggerValues($stack, $tempStack, $temp);
        $stack[] = $temp;
        $temp = NULL;
    }
    while (!empty($tempStack)) {
        $stack[] = array_pop($tempStack);
    }
    return $stack;
}

// move values bigger than pivot from stack2 into stack1.
function moveBiggerValues(&$stack1, &$stack2, $pivot) {
    while ($stack2[sizeof($stack2)-1] >= $pivot) {
        $stack1[] = array_pop($stack2);
        if (empty($stack2)) {
            break;
        }
    }
}

$stack1 = [5,4,3,1,9,6,8,7];
print_r(sortStack($stack1));