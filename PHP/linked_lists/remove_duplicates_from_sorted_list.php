<?php

// Given a sorted linked list, delete all duplicates such that each element appear only once.

// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.

function removeDuplicates($head) {
    if (empty($head)) {
        return $head;
    }
    $curr = $head;
    while (!empty($curr)) {
        if (!empty($curr->next)) {
            while ($curr->data == $curr->next->data) {
                $curr->next = $curr->next->next;
            }
        }
        $curr = $curr->next;
    }
    return $head;
}