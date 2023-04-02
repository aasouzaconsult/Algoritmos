<?php

// Sort a linked list using insertion sort.

// We have explained Insertion Sort at Slide 7 of Arrays

// Insertion Sort Wiki has some details on Insertion Sort as well.

// Example :

// Input : 1 -> 3 -> 2
// Return 1 -> 2 -> 3

/**
 * Time: O(n^2) where n is the size of the list.
 * Space: O(1)
 */
function sortList($head) {
    if (empty($head)) {
        return $head;
    }
    $curr = $head;
    while (!empty($curr)) {
        sortListHelper($curr);
        $curr = $curr->next;
    }
    return $head;
}

function sortListHelper(&$node) {
    while (True) {        
        $smallestNode = None;
        $curr = $node->next;
        while (!empty($curr)) {
            if ($curr->data < $node->data) {
                $smallestNode = $curr;
            }
            $curr = $curr->next;
        }
        // swap smallestnode values and node value
        if (empty($smallestNode)) {
            break;
        } else {
            $temp = $smallestNode->data;
            $smallestNode->data = $node->data;
            $node->data = $temp;
        }
    }
}