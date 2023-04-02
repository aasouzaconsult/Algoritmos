<?php

// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.

/**
 * Walk throught the list
 *     if next node has same value as current node, current's next will point to next next node
 *     until the next node's value is different. after which mark the current as a special char.
 *     Do a second run through the list to remove nodes that has special characters.
 *
 * Time: O(n) where n is the size of the node
 * Space: O(1)
 */
function removeDuplicates($head) {
    if (empty($head)) {
        return $head;
    }
    $curr = $head;
    $prev = NULL;
    while (!empty($curr)) {
        if (!empty($curr->next) && $curr->data == $curr->next->data) {
            $trav = $curr;
            while (!empty($trav->next) && $trav->data == $trav->next->data) {
                $trav->next = $trav->next->next;
            }
            if (!empty($prev)) {
                $prev->next = $trav->next;
            } else {
                $head = $trav->next;
            }
        } else {
            $prev = $curr;
        }
        $curr = $curr->next;
    }
    return $head;
}