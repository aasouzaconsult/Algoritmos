<?php

/**
 * Counting sort.
 * Counting sort counts the number of occurrences of each number in the array then
 * puts then in sorted order using an auxillary array.
 */

/**
 * Time: O(n+k) where n is size of input, k is size of max value in input element
 * Space: O(n+k)
 * 
 */
function countingSort($input) {
    // check less than 2 elements
    if (sizeof($input) < 2) {
        return $input;
    }
    // find the max value in the array and init an array that size
    $maxElement = PHP_INT_MIN;
    for ($i=0; $i < sizeof($input); $i++) { 
        if ($input[$i] > $maxElement) {
            $maxElement = $input[$i];
        }
    }
    $table = array_fill(0, $maxElement+1, 0);
    // populate the array
    for ($i=0; $i < sizeof($input); $i++) { 
        $value = $input[$i];
        $table[$value]++;
    }
    // cumulative sum the array from left to right
    for ($j=1; $j < sizeof($table); $j++) { 
        $table[$j] += $table[$j-1];
    }
    // init result array same size as input
    $result = array_fill(0, sizeof($input), NULL);
    // loop through input and use aux array to figure out where to put final value.
    for ($i=0; $i < sizeof($input); $i++) { 
        $value = $input[$i];
        $index = $table[$value];
        $result[$index] = $value;
        $table[$value]--;
    }
    return $result;
}

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];

echo implode(" ", countingSort($input1)) . PHP_EOL;
echo implode(" ", countingSort($input2)) . PHP_EOL;
