<?php

/**
 * Return Kth to last. Implement an algorithm to find the kth to last element of a singly linked list.
 */

include "linked_list.php";

/**
 * Brute force.
 * Maintain Kth previous pointers and progress forward like a snake until the first pointer
 * reaches the end. then return the last pointer at Kth position.
 * Time: O(n)
 * Space: O(n)
 */

/**
 * Optimized solution.
 *
 * Maintain a counter that gets decremented while k decrements.
 * When k decrements to 1. start pointing the pointer to head node, then use a sliding window
 * approach. As the forward pointer moves ahead, so does the back pointer. Return the data of
 * the back pointer.
 * Time: O(n)
 * Space: O(1)
 */
function kthToLast($head, $k) {
    if (empty($head) || $k < 0) {
        return;
    }
    $curr = $head;
    $kthNode = NULL;
    while (!empty($curr)) {
        if ($k > 0) {
            $k--;
        } else {
            if (empty($kthNode)) {
                $kthNode = $head;
            } else {
                $kthNode = $kthNode->next;
            }
        }
        $curr = $curr->next;
    }
    return $kthNode;
}

function kthToLastV2($head, $k) {
    $p1 = $head;
    $p2 = $head;

    for ($i=0; $i <= $k; $i++) { 
        if (empty($p1)) {
            return;
        }
        $p1 = $p1->next;
    }
    while (!empty($p1)) {
        $p1 = $p1->next;
        $p2 = $p2->next;
    }
    return $p2;
}

$list = new LinkedList(1);
$list->insert(2);
$list->insert(3);
$list->insert(4);
$list->insert(5);
$list->printList();

echo kthToLast($list->getHead(), 3)->data . PHP_EOL;
echo kthToLastV2($list->getHead(), 3)->data . PHP_EOL;
