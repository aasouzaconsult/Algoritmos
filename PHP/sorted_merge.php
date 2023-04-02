<?php

/**
 * You are given two sorted arrays, A and B, where A has a large enough buffer at
 * the end to hold B. Write a method to merge B into A in sorted order.
 */

/**
 * Time: O(n+m) where n is size of large array, m is size of small array
 * Space: O(n+m)
 * 
 */
function sortedMerge($large, $small) {
    // put small array into bigger array
    $smallIndex = -1;
    for ($i=0; $i < sizeof($large); $i++) { 
        if (empty($large[$i])) {
            if ($smallIndex == -1) {
                $smallIndex = $i;
            }
            $large[$i] = array_shift($small);
        }
    }
    // merge them into 1 array with merge part of merge sort
    return merge($large, $smallIndex);
}

function merge($array, $rightIndex) {
    $temp = [];
    $leftStart = 0;
    $leftEnd = $rightIndex - 1;
    $rightEnd = sizeof($array) - 1;
    while ($leftStart <= $leftEnd && $rightIndex <= $rightEnd) {
        if ($array[$leftStart] < $array[$rightIndex]) {
            $temp[] = $array[$leftStart];
            $leftStart++;
        } else {
            $temp[] = $array[$rightIndex];
            $rightIndex++;
        }
    }
    while ($leftStart <= $leftEnd) {
        $temp[] = $array[$leftStart];
        $leftStart++;
    }
    while ($rightIndex <= $rightEnd) {
        $temp[] = $array[$rightIndex];
        $rightIndex++;
    }
    return $temp;
}

/**
 * move large array element to flush against the back array.
 * then iterate through large and small index, placing the smaller of 2 elements
 * into the front of the array.
 * when small index has emptied, the array is merge sorted.
 * Time: O(n) where n is size of large array
 * Space: O(1)
 */
function sortedMergeV2($large, $small) {

}

$input1 = [10, 14, 19, 27, 33, 35, 42, 44, NULL, NULL, NULL, NULL, NULL];
$input2 = [11, 12, 22, 25, 64];

echo implode(" ", sortedMerge($input1, $input2)) . PHP_EOL;
