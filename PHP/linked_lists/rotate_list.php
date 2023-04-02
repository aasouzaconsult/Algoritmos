<?php

// Given a list, rotate the list to the right by k places, where k is non-negative.

// For example:

// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.

function rotateList($head, $n) {
    if (empty($head)) {
        return;
    }

    $size = 1;
    $curr = $head;
    if (empty($curr->next)) { // list has only 1 element. so no matter how many times its rotated, its still the same.
        return $head;
    }
    // count number of elements in list
    while (!empty($curr->next)) {
        $size++;
        $curr = $curr->next;
    }
    if ($size > $n) {
        $diff = $size - $n;
    } else { // given $n is larger than size of list
        $modB = $n % $size;
        $diff = $size - $modB;
    }
    if ($diff == $size) {
        // no rotations are needed.
        return $head;
    }
    // find the last node by diff number of traversals
    $lastNode = $head;
    while ($diff > 1) {
        $diff--;
        $lastNode = $lastNode->next;
    }
    // set the node after last node as the new first node.
    // last node now points to NULL
    // newCurr to point to first node
    $firstNode = $lastNode->next;
    $lastNode->next = NULL;
    $newCurr = $firstNode;
    while (!empty($newCurr->next)) {
        $newCurr = $newCurr->next;
    }
    $newCurr->next = $head;
    $head = $firstNode;
    return $head;
}
