<?php

// Given a linked list and a value x, partition it such that all nodes less than
// x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.

// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.

/**
 * Time: O(n) where n is the size of the list
 * Space: O(1)
 *
 */
function partitionList($head, $value) {
    if (empty($head)) {
        return $head;
    }
    $less = new Node(0);
    $more = new Node(0);
    $currLess = $less;
    $currMore = $more;
    $curr = $head;
    $next = NULL;
    while (!empty($curr)) {
        $next = $curr->next;
        if ($curr->data < $value) {
            $currLess->next = $curr;
            $currLess = $currLess->next;
            $currLess->next = NULL;
        } else {
            $currMore->next = $curr;
            $currMore = $currMore->next;
            $currMore->next = NULL;
        }
        $curr = $next;
    }
    $currLess->next = $more;
    return $less->next;
}
