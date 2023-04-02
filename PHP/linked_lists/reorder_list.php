<?php

// Given a singly linked list

//     L: L0 → L1 → … → Ln-1 → Ln,
// reorder it to:

//     L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
// You must do this in-place without altering the nodes’ values.

// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.

function reorderList($head) {
    // get the mid point of the list
    // break the list into list1(first part), and list2(2nd part)
    // reverse list2
    // zig zag connect list1 and new list2
    // return head of list1
    if (empty($head)) {
        return $head;
    }
    $slow = $head;
    $fast = $head;
    while (!empty($fast)) {
        if (empty($fast->next) || empty($fast->next->next)) {
            break;
        }
        $slow = $slow->next;
        $fast = $fast->next->next;
    }
    $list2Head = $slow->next;
    $slow->next = NULL;

    $list2Head = reverseList($list2Head);

    $curr1 = $head;
    $next1 = NULL;
    $curr2 = $list2Head;
    $next2 = NULL;
    while (!empty($curr2)) {
        $next1 = $curr1->next;
        $next2 = $curr2->next;
        $curr1->next = $curr2;
        $curr2->next = $next1;
        $curr1 = $next1;
        $curr2 = $next2;
    }
    return $head;
}

/**
 * Takes in a linked list and reverse the list.
 * Time: O(n)
 * Space: O(1)
 */
function reverseList($head) {
    if (empty($head) ) {
        return $head;
    }
    $prev = NULL;
    $next = NULL;
    $curr = $head;
    while (!empty($curr)) {
        $next = $curr->next;
        $curr->next = $prev;
        $prev = $curr;
        $curr = $next;
    }
    return $prev;
}