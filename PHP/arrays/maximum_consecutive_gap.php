<?php

// https://www.interviewbit.com/problems/maximum-consecutive-gap/
// Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

// Try to solve it in linear time/space.

// Example :

// Input : [1, 10, 5]
// Output : 5 
// Return 0 if the array contains less than 2 elements.

// You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
// You may also assume that the difference will not overflow.

/**
 * PigeonHole principle.
 * Time: O(n)
 * Space: O(n)
 *
 */
function maxGap($arr) {
    if (sizeof($arr) < 2) {
        return 0;
    }
    // get max and min value in array
    $maxValue = max($arr);
    $minValue = min($arr);
    
    // calculate interval and number of buckets
    $interval = (int) ceil(($maxValue - $minValue) / (sizeof($arr) - 1));
    if ($interval == 0) {
        $interval = 1;
    }

    // create the buckets
    $bucketCount = ($maxValue - $minValue) / $interval + 1;    
    $buckets = [];
    for ($i=0; $i < $bucketCount; $i++) { 
        $buckets[] = new Bucket();
    }

    // iterate through the array and assign elements into buckets
    for ($i=0; $i < sizeof($arr); $i++) { 
        $bucketNum = ($arr[$i] - $minValue) / $interval;
        if ($arr[$i] > $buckets[$bucketNum]->max) {
            $buckets[$bucketNum]->max = $arr[$i];
        }
        if ($arr[$i] < $buckets[$bucketNum]->min) {
            $buckets[$bucketNum]->min = $arr[$i];
        }
    }

    // iterate through the buckets and get the maximal gap
    $prev = $buckets[0]->max;
    $maxGap = 0;
    for ($i=1; $i < sizeof($buckets); $i++) { 
        if ($prev != PHP_INT_MIN && $buckets[$i]->min != PHP_INT_MAX) {
            $maxGap = max($maxGap, $buckets[$i]->min - $prev);
            $prev = $buckets[$i]->max;
        }
    }

    return $maxGap;
}

class Bucket {
    public $min;
    public $max;

    public function __construct() {
        $this->min = PHP_INT_MAX;
        $this->max = PHP_INT_MIN;
    }
}

$arr1 = [1,8,3,5,11,16];
$arr2 = [1,10,5];
$arr3 = [1, 7, 3, 4];

echo maxGap($arr1) . PHP_EOL;
echo maxGap($arr2) . PHP_EOL;
echo maxGap($arr3) . PHP_EOL;