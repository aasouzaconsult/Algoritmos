<?php

/**
 * Selection sort is the child's algorithm: simple, but inefficient. Find the smallest
 * element using a linear scan and move it to the front(swapping it with the front
 * element). Then find the second smallest and move it, again doing a linear scan.
 * Continue doing this until all the elements are in place.
 */

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];

/**
 * Time: O(n^2)
 * Space: O(1)
 */
function selectionSort($input) {
    // check for less than 2 elements, just return input
    if (sizeof($input) < 2) {
        return $input;
    }
    // while lastSorted index has not reached the end
    //     set smallest index
    //     set smallest variable
    //     if current element smaller than smallest var
    //         reset both variables above
    //     swap lastSorted index with smallest index
    for ($i=0; $i < sizeof($input); $i++) { 
        $smallestIndex = $i;
        $smallest = $input[$i];
        for ($j=$i+1; $j < sizeof($input); $j++) { 
            if ($input[$j] < $smallest) {
                $smallestIndex = $j;
                $smallest = $input[$j];
            }
        }
        swap($input[$smallestIndex], $input[$i]);
    }
    return $input;
}

function swap(&$value1, &$value2) {
    $temp = $value1;
    $value1 = $value2;
    $value2 = $temp;
}

echo implode(" ", selectionSort($input1)) . PHP_EOL;
echo implode(" ", selectionSort($input2)) . PHP_EOL;
