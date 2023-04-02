<?php

/**
 * Given an integer array and a number, find the 2 elements in the integer array
 * that makes up the given number and return them.
 *
 * - elements can range from -ve infinity to positive infinity
 * - if there are multiple answers, return any of them.
 *
 * eg. 
 * Input: [3,5,8,7,2,1], 5
 * Output: [3,2]
 */

/**
 * Brute Force.
 * 
 * 1. Loop through the array
 * 2. For each element, loop through the rest of the array looking for the complement
 * value.
 * 3. if complement found, return the current element and the found complement.
 * 4. else, at end of loop return [];
 *
 * Time: O(n^2) where n is the size of the array
 * Space: O(1)
 */
function twoSumBrute($arr, $num) {
    if (sizeof($arr) < 2) {
        return [];
    }
    for ($i=0; $i < sizeof($arr); $i++) { 
        $comp = $num - $arr[$i];
        for ($j=$i+1; $j < sizeof($arr); $j++) { 
            if ($arr[$j] == $comp) {
                return [$arr[$i], $comp];
            }
        }
    }
    return [];
}

/**
 * Use hashtable.
 * 1. init a hashtable.
 * 2. loop through the array
 * 3. for each element, first find if the complemnt of the elment is in the table
 * 4. if found in table, return current element and the complement.
 * 5. else, store the complement of the current element into table.
 *
 * Time: O(n)
 * Space: O(n)
 */
function twoSumsHashtable($arr, $num) {
    if (sizeof($arr) < 2) {
        return [];
    }
    $table = [];
    for ($i=0; $i < sizeof($arr); $i++) { 
        $comp = $num - $arr[$i];
        if (isset($table[$arr[$i]])) {
            return [$table[$arr[$i]], $arr[$i]];
        }
        $table[$comp] = $arr[$i];
    }
    return [];
}

/**
 * Use sorting.
 * 1. sort the array in ascending order using an O(nlogn) algorithm
 * 2. init 2 pointers i and j. i point to array left, j to array right
 * 3. for each i element, j pointer decrements to attempt to find the complement number
 * 4. At each j element, 3 scenarios can happen:
 * j element == complement : return i and j element
 * j element > complement : move j pointer left
 * j element < complement : stop and increment i instead
 * 5. terminating condition is when i == j.
 * 6. end of loop means no result is found, return empty array.
 *
 * Time: O(nlogn) contributed by sorting. otherwise complexity is O(n)
 * Space: O(1)
 */
function twoSumSorting($arr, $num) {
    if (sizeof($arr) < 2) {
        return [];
    }
    mergeSort($arr);
    // quicksort($arr);

    $i = 0;
    $j = sizeof($arr) - 1;
    while ($i < $j) {
        $comp = $num - $arr[$i];
        if ($arr[$j] == $comp) {
            return [$arr[$i], $arr[$j]];
        } elseif ($arr[$j] > $comp) {
            $j--;
        } else {
            $i++;
        }
    }
    return [];
}

/**
 * Typical mergesort
 * Time: O(nlogn)
 * Space: O(n)
 */
function mergeSort(&$arr) {
    if (sizeof($arr) < 2) {
        return $arr;
    }
    mergeSortRecur($arr, 0, sizeof($arr)-1);
}

function mergeSortRecur(&$arr, $low, $high) {
    if ($low < $high) {
        $mid = floor(($low + $high) / 2);
        mergeSortRecur($arr, $low, $mid);
        mergeSortRecur($arr, $mid+1, $high);
        merge($arr, $low, $mid, $high);
    }
}

function merge(&$arr, $low, $mid, $high) {
    $leftStart = $low;
    $rightStart = $mid+1;
    $curr = $low;
    $temp = $arr;

    while ($leftStart <= $mid && $rightStart <= $high) {
        if ($arr[$leftStart] < $arr[$rightStart]) {
            $temp[$curr] = $arr[$leftStart];
            $leftStart++;
        } else {
            $temp[$curr] = $arr[$rightStart];
            $rightStart++;
        }
        $curr++;
    }
    while ($leftStart <= $mid) {
        $temp[$curr] = $arr[$leftStart];
        $leftStart++;
        $curr++;
    }
    while ($rightStart <= $high) {
        $temp[$curr] = $arr[$rightStart];
        $rightStart++;
        $curr++;
    }
    for ($i=$low; $i <= $high; $i++) { 
        $arr[$i] = $temp[$i];
    }
}

function quicksort(&$arr) {
    if (sizeof($arr) < 2) {
        return $arr;
    }
    quicksortHelper($arr, 0, sizeof($arr)-1);
}

function quicksortHelper(&$arr, $low, $high) {
    if ($low < $high) {
        $pivot = partition($arr, $low, $high);
        quicksortHelper($arr, $low, $pivot-1);
        quicksortHelper($arr, $pivot+1, $high);
    }
}

function partition(&$arr, $low, $high) {
    $pivot = rand($low, $high);
    swap($arr[$pivot], $arr[$high]);
    $pivot = $high;
    $smallEnd = -1;
    for ($i=0; $i < sizeof($arr)-1; $i++) { 
        if ($arr[$i] < $arr[$pivot]) {
            $smallEnd++;
            swap($arr[$smallEnd], $arr[$i]);
        }
    }
    swap($arr[$pivot], $arr[$smallEnd+1]);
    $pivot = $smallEnd+1;
    return $pivot;
}

function swap(&$value1, &$value2) {
    $temp = $value1;
    $value1 = $value2;
    $value2 = $temp;
}

$arr1 = [3,5,8,7,2,1];
$arr2 = [1,2,2,5,6];

print_r(twoSumBrute($arr1, 5));
print_r(twoSumsHashtable($arr1, 5));
print_r(twoSumSorting($arr1, 5));
print_r(twoSumSorting($arr2, 4));
