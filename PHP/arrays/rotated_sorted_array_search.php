<?php

// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
// (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

// You are given a target value to search. If found in the array, return its index, otherwise return -1.
// You may assume no duplicate exists in the array.

// Input : [4 5 6 7 0 1 2] and target = 4
// Output : 0

/**
 * Brute Force.
 * Linear search the array, if found return the index, else return -1
 * Time: O(n)
 * Space: O(1)
 */
function findElement($arr, $value) {
    if (empty($arr)) {
        return -1;
    }
    for ($i=0; $i < sizeof($arr); $i++) { 
        if ($arr[$i] == $value) {
            return $i;
        }
    }
    return -1;
}

/**
 * Use binary search.
 *
 * 1. get mid index for low, high range
 * 2. check if low, mid, high index elements are equal to value. if found, return the associated index
 * 3. check if left side or right side is ordered.
 * 4. if left is orderd, and value is within left range, search left. else search right.
 * 5. if right is ordered, and value is within right range, search right. else search left.
 *
 * DUPLICATE CASE.
 * 1. we check if left 1st element and mid element are the same.
 * 2. if same, and value is not equal mid, we check if right last element is also the same as mid.
 * 3. if right not same as mid, we search the right side for value
 * 4. otherwise, we cannot determine where is the ordered portion, we have to search both
 * left and right side.
 * 
 * Case when there's no duplicate values:
 * Time: O(logn)
 * Space: O(1)
 *
 * Case when there are duplicate values:
 * Time: O(n)
 * Space: O(1)
 */
function findElementV2($arr, $value) {
    if (empty($arr)) {
        return -1;
    }
    $result = findElementRecur($arr, $value, 0, sizeof($arr)-1);
    if (!is_numeric($result)) {
        return -1;
    }
    return $result;
}

function findElementRecur($arr, $value, $low, $high) {
    if ($low > $high) {
        return;
    }
    $mid = floor(($low+$high) / 2);
    if ($arr[$low] == $value) {
        return $low;
    } elseif ($arr[$mid] == $value) {
        return $mid;
    } elseif ($arr[$high] == $value) {
        return $high;
    }
    if ($arr[$low] < $arr[$mid]) { // left is ordered
        // use value to determine if we need to find in left or right half
        if ($value > $arr[$low] && $value < $arr[$mid]) {
            // find value in sorted left half
            return findElementRecur($arr, $value, $low+1, $mid-1);
        } else {
            // find value in right half
            return findElementRecur($arr, $value, $mid+1, $high-1);
        }
    } elseif ($arr[$low] == $arr[$mid]) { // left and mid value are the same (have duplicates)
        if ($arr[$mid] != $arr[$high]) {
            return findElementRecur($arr, $value, $mid+1, $high-1);
        } else {
            // cannot determine range, have to search both halves. this results in O(n) time worst case
            $result = findElementRecur($arr, $value, $low+1, $mid-1);
            if (!is_numeric($result)) {
                $result = findElementRecur($arr, $value, $mid+1, $high-1);
            }
            return $result;
        }
    } else { // right is ordered
        if ($value > $arr[$mid] && $value < $arr[$high]) {
            // find value in sorted right half
            return findElementRecur($arr, $value, $mid+1, $high-1);
        } else {
            // find value in left half
            return findElementRecur($arr, $value, $low+1, $mid-1);
        }
    }
}

$array1 = [15,16,19,20,25,1,3,4,5,7,10,14];
$array2 = [4, 5, 6, 7, 0, 1, 2];
$array3 = [2,2,2,3,4,2];

echo findElementV2($array1, 15) . PHP_EOL;
echo findElementV2($array1, 16) . PHP_EOL;
echo findElementV2($array1, 19) . PHP_EOL;
echo findElementV2($array1, 20) . PHP_EOL;
echo findElementV2($array1, 25) . PHP_EOL;
echo findElementV2($array1, 1) . PHP_EOL;
echo findElementV2($array1, 3) . PHP_EOL;
echo findElementV2($array1, 4) . PHP_EOL;
echo findElementV2($array1, 5) . PHP_EOL;
echo findElementV2($array1, 7) . PHP_EOL;
echo findElementV2($array1, 10) . PHP_EOL;
echo findElementV2($array1, 14) . PHP_EOL;
echo PHP_EOL;
echo findElementV2($array2, 4) . PHP_EOL;
echo findElementV2($array2, 5) . PHP_EOL;
echo findElementV2($array2, 6) . PHP_EOL;
echo findElementV2($array2, 7) . PHP_EOL;
echo findElementV2($array2, 0) . PHP_EOL;
echo findElementV2($array2, 1) . PHP_EOL;
echo findElementV2($array2, 2) . PHP_EOL;
echo PHP_EOL;
echo findElementV2($array3, 2) . PHP_EOL;
echo findElementV2($array3, 3) . PHP_EOL;
echo findElementV2($array3, 4) . PHP_EOL;