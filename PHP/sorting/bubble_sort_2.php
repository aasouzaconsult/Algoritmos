<?php

include_once("../Utility.php");

/**
 * Time: O(n^2)
 * Space: O(1)
 *
 */
function bubbleSort($arr) {
    if (sizeof($arr) < 2) {
        return $arr;
    }
    
    do {
        $swapped = False;
        for ($i=1; $i < sizeof($arr); $i++) { 
            if ($arr[$i] < $arr[$i-1]) {
                swap($arr[$i], $arr[$i-1]);
                $swapped = True;
            }
        }
    } while ($swapped);
    return $arr;
}

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];

function swap(&$value1, &$value2) {
    $temp = $value1;
    $value1 = $value2;
    $value2 = $temp;
}
print_r(bubbleSort($input1));
print_r(bubbleSort($input2));