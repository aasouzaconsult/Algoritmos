<?php

/**
 * Heapsort.
 * Alter the input into a heap structure. Then repeatedly remove the largest element
 * from the heap and put them in non decreasing sorted order.
 * Time complexity: O(n lgn)
 * Space complexity: O(n)
 */

$input1 = [4,12,30,16,5,15];

function heapsort($input) {
    heapify($input);
    $result = [];

    while (!empty($input)) {
        // swap
        swap($input[0], $input[sizeof($input)-1]);

        array_unshift($result, array_pop($input));
        if (!empty($input)) {
            siftDown($input, 0);
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
    if ($index >=sizeof($array)) {
        return;
    }
    $temp = $array[$index];
    $i = $index;
    $childIndex = getLeftChildIndex($i);

    while ($childIndex < sizeof($array)) {
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

print_r(heapsort($input1));
