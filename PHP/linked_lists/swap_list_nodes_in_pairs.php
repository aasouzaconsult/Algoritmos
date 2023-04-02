<?php


// Given a linked list, swap every two adjacent nodes and return its head.

// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.

// Your algorithm should use only constant space. You may not modify the values
// in the list, only nodes itself can be changed.

function swapNodePairs($head) {
    if (empty($head) || empty($head->next)) {
        return $head;
    }
    $prev = NULL;
    $curr = $head;
    $next1 = NULL;
    $next2 = NULL;
    $newHead = $head->next;
    while (!empty($curr)) {
        $next1 = $curr->next;
        $next2 = $curr->next->next;

        $curr->next = $curr->next->next;
        $next1->next = $curr;

        $prev = $curr;
        $curr = $next2;
    }
}