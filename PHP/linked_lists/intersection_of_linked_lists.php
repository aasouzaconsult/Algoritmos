<?php

// Write a program to find the node at which the intersection of two singly linked lists begins.

// For example, the following two linked lists:


// A:          a1 → a2
//                    ↘
//                      c1 → c2 → c3
//                    ↗
// B:     b1 → b2 → b3

// begin to intersect at node c1.

//  Notes:
// If the two linked lists have no intersection at all, return null.
// The linked lists must retain their original structure after the function returns.
// You may assume there are no cycles anywhere in the entire linked structure.
// Your code should preferably run in O(n) time and use only O(1) memory.

/**
 * Move the bigger list pointer ahead until both lists are of the same size.
 * then move both lists together until the end or a common node is found.
 *
 * Time: O(n) where n is the size of the bigger list.
 * Space: O(1)
 */
function getIntersectionNode($head1, $head2) {
    if (empty($head1) || empty($head2)) {
        return NULL;
    }
    $sizeA = getListSize($head1);
    $sizeB = getListSize($head2);
    $currA = $head1;
    $currB = $head2;
    while (!empty($currA) && $sizeA > $sizeB) {
        $sizeA--;
        $currA = $currA->next;
    }
    while (!empty($currB) && $sizeB > $sizeA) {
        $sizeB--;
        $currB = $currB->next;
    }
    for ($i=0; $i < $sizeA; $i++) { 
        if ($currA == $currB){
            return $currA;
        }
        $currA = $currA->next;
        $currB = $currB->next;
        if (empty($currA) || empty($currB)) {
            break;
        }
    }
    return NULL;
}

/**
 * Time: O(n) where n is size of linked list.
 * Space: O(1)
 *
 */
function getListSize($head) {
    $count = 0;
    while (!empty($head)) {
        $count++;
        $head = $head->next;
    }
    return $count;
}