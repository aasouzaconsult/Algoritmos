<?php

// You are given an array of N integers, A1, A2 , AN.
// Return maximum value of f(i, j) for all 1 <= i, j <= N.
// f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes
// absolute value of x.

// For example,

// A=[1, 3, -1]

// f(1, 1) = f(2, 2) = f(3, 3) = 0
// f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
// f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
// f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

// So, we return 5.

/**
 * Brute force solution.
 * Pair every set of elements together and calculate if
 * the abs difference is bigger than current biggest and update accordingly.
 * Time: O(n^2)
 * Space: O(1)
 */
function maxAbsoluteDiff($arr) {
    if (empty($arr)) {
        return 0;
    }
    // init localMax
    $largest = PHP_INT_MIN;
    // loop through arr
    //    for each element, pair with every other element and calculate abs diff
    //          if larger than localmax, update local max
    for ($i=0; $i < sizeof($arr)-1; $i++) {        
        for ($j=$i+1; $j < sizeof($arr); $j++) { 
            $temp = abs($arr[$i] - $arr[$j]) + abs($i - $j);
            if ($temp > $largest) {
                $largest = $temp;
            }
        }
    }
    // return localmax
    return $largest;
}

/**
 * WON'T WORK ENTIRELY. Edge case not handled
 * Sort the given arr from smallest to largest, maintain its original index.
 * use the calculate the abs value of smallest and largest element, along with
 * its index. return the value.
 * Time: O(nlgn) where n is size of arr. using a comparison based sort
 * Space: O(n)
 *
 */
function maxAbsoluteDiffV2($arr) {
    if (sizeof($arr) < 2) {
        return 0;
    }
    $indexedElements = [];
    for ($i=0; $i < sizeof($arr); $i++) { 
        $indexedElements[] = [$arr[$i], $i];
    }
    uasort($indexedElements, 'compare');
    $indexedElements = array_values($indexedElements);
    print_r($indexedElements);
    $largest = PHP_INT_MIN;
    for ($i=1; $i < sizeof($indexedElements); $i++) { 
        $temp = abs($indexedElements[0][0] - $indexedElements[$i][0]) + abs($indexedElements[0][1] - $indexedElements[$i][1]);
        if ($temp > $largest) {
            $largest = $temp;
        }
    }
    return $largest;
}

function compare($value1, $value2) {
    if ($value1[0] < $value2[0]) {
        return -1;
    }
    return 1;
}

/**
 * OPTIMAL SOLUTION.
 * 
 * the equation f(i,j) = |A[i] - A[j]| + |i-j| can be rewritten into the following ways
 * 1. (A[i] + i) - (A[j] + j)
 * 2. -(A[i] - i) + (A[j] - j) 
 * 3. (A[i] - i) - (A[j] - j) 
 * 4. -(A[i] + i) + (A[j] + j)
 * 
 * Note that case 1 and 4 are equivalent, as with case 2 and 3.
 *
 * Since i and j essentially represent the same things, the 2 cases shorten to
 * 1. A[i] + i
 * 2. A[i] - i
 *
 * We can construct 2 array based on this 2 expressions.
 * Once both arrays constructed, we find the max and min value in each of the 2 arrays.
 * The larger value difference between each of the arrays' max-min diff is the result
 *
 * Time: O(n) where n is size of array
 * Space: O(n) where we create 2 additional arrays of n size each
 */
function maxAbsoluteDiffV3($arr) {
    if (sizeof($arr) < 2) {
        return 0;
    }
    list($arrPlusi, $arrMinusi) = [[], []];
    for ($i=0; $i < sizeof($arr); $i++) { 
        $arrPlusi[] = $arr[$i] + $i;
        $arrMinusi[] = $arr[$i] - $i;
    }
    $arrPlusiMax = max($arrPlusi);
    $arrPlusiMin = min($arrPlusi);
    $arrPlusiDiff = $arrPlusiMax - $arrPlusiMin;

    $arrMinusiMax = max($arrMinusi);
    $arrMinusiMin = min($arrMinusi);
    $arrMinusiDiff = $arrMinusiMax - $arrMinusiMin;

    return $arrPlusiDiff > $arrMinusiDiff ? $arrPlusiDiff : $arrMinusiDiff;
}
$arr1 = [1, 3, -1];
$arr2 = [ 55, -8, 43, 52, 8, 59, -91, -79, -18, -94 ];
$arr3 = [ 86, 19, 46, 56, 14, 67, 19, 53, 15, 59 ];

echo maxAbsoluteDiff($arr1) . PHP_EOL;
echo maxAbsoluteDiff($arr2) . PHP_EOL;
echo maxAbsoluteDiff($arr3) . PHP_EOL;
// echo maxAbsoluteDiffV2($arr1) . PHP_EOL;
// echo maxAbsoluteDiffV2($arr2) . PHP_EOL;
// echo maxAbsoluteDiffV2($arr3) . PHP_EOL;

echo maxAbsoluteDiffV3($arr1) . PHP_EOL;
echo maxAbsoluteDiffV3($arr2) . PHP_EOL;
echo maxAbsoluteDiffV3($arr3) . PHP_EOL;