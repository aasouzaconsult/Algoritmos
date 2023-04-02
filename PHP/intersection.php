<?php

/**
 * Given two singly linked lists, determine if the two lists intersect. Return
 * the intersecting node. Note that the intersection is defined based on reference,
 * not value. That is, if the Kth node of the first linked list is the exact same
 * node(by reference) as the jth node of the second linked list, Then they are intersecting.
 */

/**
 * Brute force.
 * For every node in list1, compare with every node in list2.
 * if same node is found, return true, else return false.
 * Time: O(n * m) where n is size of list1, m is size of list2
 * Space: O(1)
 */
function intersection($list1, $list2) {
    $curr1 = $list1->getHead();

    while (!empty($curr1)) {
        $curr2 = $list2->getHead();
        while (!empty($curr2)) {
            if ($curr1 === $curr2) {
                return $curr1;
            }
            $curr2 = $curr2->next;
        }
        $curr1 = $curr1->next;
    }
    return False;
}

/**
 * add a wild character to every node in list1. 
 * Then search for this wild character in every node in list2.
 * If found, return the node. else return false;
 * Time: O(n+m)
 * Space: O(1)
 */
function hasIntersectionV2($list1, $list2) {

}

/**
 * loop through list1, put each node into hashtable with
 * data => $node.
 * loop through list2, checking via key and value.
 * return node if found, else return false
 *
 * Note: This is assuming there are no duplicate data values in both lists.
 */
function intersectionV3($list1, $list2) {
    $curr1 = $list1->getHead();
    $table = [];
    while (!empty($curr1)) {
        $table[$curr1->data] = $curr1;
        $curr1 = $curr1->next;
    }
    $curr2 = $list2->getHead();
    while (!empty($curr2)) {
        if (isset($table[$curr2->data]) && $table[$curr2->data] === $curr2) {
            return $curr2;
        }
        $curr2 = $curr2->next;
    }
    return False;
}

/**
 * If 2 lists intersect, they must have the same last node
 * return true if last node from 2 lists are the same.
 * Time: O(n+m)
 * Space: O(1)
 */
function hasIntersectionV4($list1, $list2) {
    $curr1 = $list1->getHead();
    while (!empty($curr1)) {
        $curr1 = $curr1->next;
    }
    $curr2 = $list2->getHead();
    while (!empty($curr2)) {
        $curr2 = $curr2->next;
    }
    return $curr1 === $curr2;
}

/**
 * Get the size of list1 and list2.
 * if they are the same size, traverse and compare equality of each node
 * if they are not same size, move forward the longer list by difference amount of nodes
 * then compare as if the lists are equal.
 */
function intersectionV5($list1, $list2) {
    $curr1 = $list1->getHead();
    $curr2 = $list2->getHead();
    if (empty($curr1) || empty($curr2)) {
        return False;
    }
    $size1 = 0;
    while (!empty($curr1)) {
        $size1++;
        $curr1 = $curr1->next;
    }
    $size2 = 0;
    while (!empty($curr2)) {
        $size2++;
        $curr2 = $curr2->next;
    }
    $curr1 = $list1->getHead();
    $curr2 = $list2->getHead();
    if ($size1 === $size2) {
        while (!empty($curr1)) {
            if ($curr1 === $curr2) {
                return $curr1;
            }
            $curr1 = $curr1->next;
            $curr2 = $curr2->next;
        }
    } else {
        $compareSet = new CompareSet($curr1, $curr2, $size1, $size2);
        $count = $compareSet->count;
        $larger = $compareSet->larger;
        $smaller = $compareSet->smaller;

        for ($i=0; $i < $count; $i++) { 
            $larger = $larger->next;
        }
        while (!empty($larger)) {
            if ($larger === $smaller) {
                return $larger;
            }
            $larger = $larger->next;
            $smaller = $smaller->next;
        }
    }
    return False;
}

class CompareSet {
    public $larger;
    public $smaller;
    public $count;

    public function __construct($node1, $node2, $size1, $size2) {
        $this->larger = $node2;
        $this->smaller = $node1;
        $this->count = $size2 - $size1;
        if ($size1 > $size2) {
            $this->larger = $node1;
            $this->smaller = $node2;
            $this->count = $size1 - $size2;
        }
    }
}