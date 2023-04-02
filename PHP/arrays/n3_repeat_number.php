<?php

// You’re given a read only array of n integers. Find out if any integer occurs
// more than n/3 times in the array in linear time and constant additional space.

// If so, return the integer. If not, return -1.

// If there are multiple solutions, return any one.

// Example :

// Input : [1 2 3 1 1]
// Output : 1 
// 1 occurs 3 times which is more than 5/3 times.

// We will solve for a more general case of this question here.
// Given an array of of size n and a number k, find all elements that appear
// more than n/k times

/**
 * Method 1
 *
 * Loop through elements one by one, for each element, loop through the rest of 
 * the array to find count of this element. once this element occurs more than n/3
 * times, return result.
 *
 * Time: O(n^2)
 * Space: O(1)
 */
function nBy3Number($arr) {
    if (empty($arr)) {
        return;
    }
    $limit = ceil(sizeof($arr)/3);
    for ($i=0; $i < sizeof($arr); $i++) { 
        $count = 1;
        for ($j=$i+1; $j < sizeof($arr); $j++) { 
            if ($arr[$i] === $arr[$j]) {
                $count++;
            }
            if ($count >= $limit) {
                return $arr[$i];
            }
        }
    }
    return;
}

/**
 * Method 2
 * Sorting with a O(nlgn) algorithm. eg. mergesort
 * Time: O(nlgn)
 * Space: O(n)
 */
function nBy3NumberV2($arr) {
    if (empty($arr)) {
        return;
    }
    mergeSort($arr, 0, sizeof($arr)-1);
    $limit = ceil(sizeof($arr) / 3);
    $count = 1;
    for ($i=1; $i < sizeof($arr); $i++) { 
        if ($arr[$i] == $arr[$i-1]) {
            $count++;
        } else {
            $count = 1;
        }
        if ($count >= $limit) {
            return $arr[$i];
        }
    }
    return;
}

function mergeSort(&$arr, $low, $high) {
    if ($low >= $high) {
        return;
    }
    $mid = floor(($low + $high) / 2);
    mergeSort($arr, $low, $mid);
    mergeSort($arr, $mid+1, $high);
    merge($arr, $low, $mid, $high);
}

function merge(&$arr, $low, $mid, $high) {
    $tempArr = $arr;
    $leftStart = $low;
    $rightStart = $mid + 1;
    $curr = $low;

    while ($leftStart <= $mid && $rightStart <= $high) {
        if ($arr[$leftStart] < $arr[$rightStart]) {
            $tempArr[$curr] = $arr[$leftStart];
            $leftStart++;
        } else {
            $tempArr[$curr] = $arr[$rightStart];
            $rightStart++;
        }
        $curr++;
    }
    while ($leftStart <= $mid) {
        $tempArr[$curr] = $arr[$leftStart];
        $leftStart++;
        $curr++;
    }
    while ($rightStart <= $high) {
        $tempArr[$curr] = $arr[$rightStart];
        $rightStart++;
        $curr++;
    }
    for ($i=$low; $i <= $high; $i++) { 
        $arr[$i] = $tempArr[$i];
    }
}

class ElementCount {
    public $element;
    public $count;

    public function __construct() {
        $this->element = NULL;
        $this->count = 0;
    }
}
/**
 * Tetris method
 * 1. create an temp array of size K-1 to store elements and their counts.
 * 2. traverse through the array and update the temp array
 *     if it is equal to either candidate, increment the corresponding count
 *     else if there is an empty slot (i.e. a slot with count 0), put it in that
 *     slot and set the count to 1 else reduce all counters by 1
 * 3. iterate over k-1 elements and check each element in array for actual count
 *
 * Time: O(nk) where n is size of array, k is the number to divide
 * Space: O(k)
 */
function nBy3NumberV3($arr) {
    if (empty($arr)) {
        return;
    }
    $limit = ceil(sizeof($arr)/3);
    // create temp array of 3-1 size
    $temp[] = new ElementCount();
    $temp[] = new ElementCount();
    
    // loop through array to populate temp array
    for ($i=0; $i < sizeof($arr); $i++) {
        // if arr[i] already present in either elecount, increment count
        for ($j=0; $j < sizeof($temp); $j++) { 
            if ($arr[$i] == $temp[$j]->element) {
                $temp[$j]->count++;
                break;
            }
        }
        // arr[i] not present in temp array
        if ($j == sizeof($temp)) {
            // if there's empty position, put this element in the position and set
            // count to 1
            for ($k=0; $k < sizeof($temp); $k++) { 
                if (is_null($temp[$k]->element)) {
                    $temp[$k]->element = $arr[$i];
                    $temp[$k]->count++;
                    break;
                }
            }
            // all positions are filled, decrement all counts by 1
            if ($k == sizeof($temp)) {
                for ($m=0; $m < sizeof($temp); $m++) { 
                    $temp[$m]->count--;
                    if ($temp[$m]->count == 0) {
                        $temp[$m]->element = NULL;
                    }
                }
            }
        }
    }

    // step 3, find the actual count of the elements in temp array
    $result = [];
    for ($i=0; $i < sizeof($temp); $i++) { 
        $count = 0;
        for ($j=0; $j < sizeof($arr); $j++) { 
            if ($arr[$j] == $temp[$i]->element) {
                $count++;
            }
            if ($count >= $limit) {
                $result[] = $arr[$j];
                break;
            }
        }        
    }
    return $result;
}

$arr1 = [1,2,3,1,1];

echo nBy3Number($arr1) . PHP_EOL;
echo nBy3NumberV2($arr1) . PHP_EOL;
print_r(nBy3NumberV3($arr1));
