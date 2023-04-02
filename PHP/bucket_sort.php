<?php

/**
 * Bucket sort.
 *
 * Bucket sort assumes the input is drawn from a uniform distribution that has an
 * average running time on O(n).
 * Divide the interval into n equal size intervals, or buckets. Then distributes
 * n input numbers into the buckets.
 */

/**
 * Time: O(n+k)
 * Space: O(n+k)
 * 
 */
function bucketSort($input) {
    // check smaller than 2 elements
    if (sizeof($input) < 2) {
        return $input;
    }
    // get largest size of input
    $largest = PHP_INT_MIN;
    for ($i=0; $i < sizeof($input); $i++) { 
        if ($input[$i] > $largest) {
            $largest = $input[$i];
        }
    }
    // create buckets for the size of input
    $table = array_fill(0, $largest+1, NULL);
    // put elements into bucket
    for ($i=0; $i < sizeof($input); $i++) { 
        $table[$input[$i]] = $input[$i];
    }
    $start = 0;
    for ($i=0; $i < sizeof($table); $i++) { 
        if (!empty($table[$i])) {
            $input[$start] = $table[$i];
            $start++;
        }
    }
    // return input
    return $input;
}

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];

echo implode(" ", bucketSort($input1)) . PHP_EOL;
echo implode(" ", bucketSort($input2)) . PHP_EOL;