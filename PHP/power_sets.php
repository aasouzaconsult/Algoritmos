<?php

// http://www.geeksforgeeks.org/power-set/

// Power Set Power set P(S) of a set S is the set of all subsets of S. For example S = {a, b, c} then P(s) = {{}, {a}, {b}, {c}, {a,b}, {a, c}, {b, c}, {a, b, c}}.

// If S has n elements in it then P(s) will have 2^n elements

// Algorithm:
// Input: Set[], set_size
// 1. Get the size of power set
//     powet_set_size = pow(2, set_size)
// 2  Loop for counter from 0 to pow_set_size
//      (a) Loop for i = 0 to set_size
//           (i) If ith bit in counter is set
//                Print ith element from set for this subset
//      (b) Print seperator for subsets i.e., newline

// Set  = [a,b,c]
// power_set_size = pow(2, 3) = 8
// Run for binary counter = 000 to 111

// Value of Counter            Subset
//     000                    -> Empty set
//     001                    -> a
//     011                    -> ab
//    100                     -> c
//    101                     -> ac
//    110                     -> bc
//    111                     -> abc

/**
 * Time: O(2^n)
 * Space: O(2^n)
 *
 */
function generateSets($arr) {
    if (empty($arr)) {
        return [[]];
    }
    $result = [];
    $setCount = pow(2, sizeof($arr));
    for ($value=0; $value < $setCount; $value++) { 
        echo $value . PHP_EOL;
        $temp = [];
        // loop for the number of bits in each value
        for ($j=0; $j < sizeof($arr); $j++) { 
            // generate subset based on current setcount value
            if ($value & (1 << $j)) { // if current bit is set
                $temp[] = $arr[$j];
            }
        }
        $result[] = $temp;
    }
    return $result;
}

$arr1 = ['a', 'b', 'c'];

print_r(generateSets($arr1));