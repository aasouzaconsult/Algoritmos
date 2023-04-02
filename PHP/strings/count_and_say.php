<?php

// The count-and-say sequence is the sequence of integers beginning as follows:

// 1, 11, 21, 1211, 111221, ...
// 1 is read off as one 1 or 11.
// 11 is read off as two 1s or 21.

// 21 is read off as one 2, then one 1 or 1211.

// Given an integer n, generate the nth sequence.

// Note: The sequence of integers will be represented as a string.

// Example:

// if n = 2,
// the sequence is 11.

/**
 * Time: O(n * m) where n is input number, m is the length of the result at sequence n.
 * Space: O(m)
 */
function sequence($n) {
    if ($n < 1) {
        return;
    }
    $result = '1';
    if ($n == 1) {
        return $result;
    }
    for ($i=2; $i <= $n; $i++) { 
        $temp = '';
        list($count, $char) = [0, ''];

        for ($j=0; $j < strlen($result); $j++) { 
            if (strlen($char) < 1) {
                $char = $result[$j];
                $count++;
            } elseif ($char == $result[$j]) {
                $count++;
            } else {
                $temp .= $count . $char;
                $count = 1;
                $char = $result[$j];
            }
        }
        if (!empty($char)) {
            $temp .= $count . $char;
        }
        $result = $temp;
    }
    return $result;
}
echo sequence(1) . PHP_EOL;
echo sequence(2) . PHP_EOL;
echo sequence(3) . PHP_EOL;
echo sequence(4) . PHP_EOL;
echo sequence(5) . PHP_EOL;
