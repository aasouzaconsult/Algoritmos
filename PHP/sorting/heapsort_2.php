<?php

/**
 * Heapsort.
 * 1. Heapify the input array.
 * 2. Repeatedly remove the largest element from the heap and put them in result
 * array in ascending sorted order.
 *
 * Time: O(nlgn)
 * Space: O(n)
 */

function heapsort(&$arr) {
    if (sizeof($arr) < 2) {
        return $arr;
    }
    heapify($arr);
    $result = [];

    while (!empty($arr)) {
        // swap first and last element, so we can remvoe last element
        swap($arr[0], $arr[sizeof($arr)-1]);
        // pop last element from arr and put into result
        array_unshift($result, array_pop($arr));
        if (!empty($arr)) {
            siftDown($arr, 0);
        }
    }
    return $result;
}

function heapify(&$input) {
    $parentIndex = getParentIndex(sizeof($input)-1);

    while ($parentIndex >= 0) {

        siftDown($input, $parentIndex);
        $parentIndex--;
    }
}

function siftDown(&$array, $index) {
    if ($index >= sizeof($array)) {
        return;
    }
    $temp = $array[$index];
    $i = $index;
    $childIndex = getLeftChildIndex($i);

    while ($childIndex < sizeof($array)) {
        // if right chidl is bigger than left child, set index to right child
        if ($childIndex+1 < sizeof($array) && $array[$childIndex+1] > $array[$childIndex]) {
            $childIndex++;
        }
        
        if ($temp < $array[$childIndex]) {
            $array[$i] = $array[$childIndex];
        } else {
            break;
        }
        $i = $childIndex;
        $childIndex = getLeftChildIndex($i);
    }
    $array[$i] = $temp;
}

function getLeftChildIndex($index) {
    return $index * 2 + 1;
}

function getParentIndex($index) {
    return floor(($index-1) / 2);
}

function swap(&$value1, &$value2) {
    $temp = $value1;
    $value1 = $value2;
    $value2 = $temp;
}

$input1 = [14, 33, 27, 10, 35, 19, 42, 44];
$input2 = [64, 25, 12, 22, 11];
$input3 = [4,12,30,16,5,15];

print_r(heapsort($input1));
print_r(heapsort($input2));
print_r(heapsort($input3));