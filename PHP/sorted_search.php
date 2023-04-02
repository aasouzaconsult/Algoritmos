<?php

/**
 * You are given an array-like data structure Listy which lacks a size method. It
 * does, however, have an 'elementAt(i)' method that returns the element at index i
 * in O(1) time. If i is beyond the bound of the data structure, it returns -1.
 * (For this reason, that data structure only supports positive integers). Given a
 * Listy which contains sorted, positive integers, find the index at which an element
 * x occurs. If x occurs multiple times, you may return any index.
 */

/**
 * Sorted search.
 * Basically the elements are sorted, we are looking to optimize by having the
 * least calls with 'elementAt(i)' to return the index at which element x occurs.
 * The BCR is O(lgn), binary search.
 * In other words, this question is asking to trace through the list of index accesses
 * in a binary search.
 * cannot use sizeof. so we don't know the size of the array.
 * Time: O(lgn)
 * Space: O(1)
 */
function sortedSearch(Listy $listy, $value) {
    $left = 0;
    $start = 1;
    $element = $listy->elementAt($start);
    $count = 1;
    while ($element != -1) {        
        if ($element == $value) {
            echo "elementAt called: " . $count . PHP_EOL;
            return $start;
        } elseif ($element < $value) {
            $left = $start+1;
        } else {
            break;
        }
        $start *= 2;
        $element = $listy->elementAt($start);
        $count++;
    }
    
    $element = $listy->elementAt($left);
    $count++;
    while ($element != -1) {
        $count++;
        if ($element == $value) {
            echo "elementAt called: " . $count . PHP_EOL;
            return $left;
        }
        $left++;
        $element = $listy->elementAt($left);
    }
    return;
}

class Listy {
    private $list;

    public function __construct($list = []) {
        $this->list = $list;
    }

    public function elementAt($index) {
        if ($index < 0 || $index > sizeof($this->list)-1) {
            return -1;
        }
        return $this->list[$index];
    }
}

$array1 = [1,3,4,5,7,10,14,15,16,19,20,25];
$listy1 = new Listy($array1);

echo sortedSearch($listy1, 25) . PHP_EOL;