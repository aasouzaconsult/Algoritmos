<?php

// Merge two sorted linked lists and return it as a new list. 
// The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

// For example, given following linked lists :

//   5 -> 8 -> 20 
//   4 -> 11 -> 15
// The merged list should be :

// 4 -> 5 -> 8 -> 11 -> 15 -> 20

/**
 * Time: O(n+m) where n is size of smaller list, m size of bigger list
 * Space: O(n+m)
 */
function mergeLists($head1, $head2) {
    if (empty($head1)) {
        return $head2;
    } elseif (empty($head2)) {
        return $head1;
    }
    $queue = queueNodes($head1, $head2);

    list($prev, $head) = [NULL, NULL];
    while (!empty($queue)) {
        $node = array_shift($queue);
        if (is_null($prev) && is_null($head)) {
            $prev = $node;
            $head = $node;
            continue;
        }
        $prev->next = $node;
        $prev = $node;
    }
    return $head;
}