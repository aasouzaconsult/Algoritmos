<?php

// Given a linked list, remove the nth node from the end of list and return its head.

// For example,
// Given linked list: 1->2->3->4->5, and n = 2.
// After removing the second node from the end, the linked list becomes 1->2->3->5.

//  Note:
// * If n is greater than the size of the list, remove the first node of the list. 
// Try doing it using constant additional space.

/**
 * Time: O(n) where n is the size of the list
 * Space: O(1)
 *  
 */
function removeNthNode($head, $n) {
    // if list has 1 element or less, it doesn't matter what $n is. we always remove
    // the only element there is. resulting in returning none.
    if (empty($head) || empty($head->next)) {
        return;
    }
    $nthPrev = None;
    $nth = $head;
    $curr = $head;

    // move the curr pointer n - 1 times forward.
    while ($n > 1) {
        if (empty($curr)) {
            break;
        }
        $curr = $curr->next;
        $n--;
    }
    // if n is still bigger than 1 or current is empty. means the current size of $n
    // is bigger than size of the list
    if ($n > 1 || empty($curr)) {
        return $head->next;
    }
    // move both curr pointer, nth_prev pointer and nth pointer forward
    while (!empty($curr->next)) {
        $nthPrev = $nth;
        $nth = $nth->next;
        $curr = $curr->next;
    }
    // if nth_prev element is not moved, curr and nth pointer is not moved
    // this could be 1 of 2 cases:
    // 1. curr->next pointer is already empty
    // 2. $n is pointed at the first node
    if (empty($nthPrev)) {
        return $head->next;
    } else {
        // remove the nth node by pointing previous node to nth's next node
        $nthPrev->next = $nth->next;
    }
    return $head;
}