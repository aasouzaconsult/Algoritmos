<?php

/**
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP. How would you solve this problem if a temp buffer is not allowed.
 */

include "linked_list.php";

/**
 * Traverse through the linked list. Store each data in array if its new. if data not new, delete the current node
 * with the repeated data.
 *
 * Time: O(n) where n is size of the linked list.
 * Space: o(n)
 */
function removeDuplicates(&$head) {
    if (empty($head)) {
        return;
    }
    $data = [];
    $prev = NULL;
    $curr = $head;

    while (!empty($curr)) {
        if (!isset($data[$curr->data])) {
            $data[$curr->data] = 1;
            $prev = $curr;
            $curr = $curr->next;
        } else {
            $prev->next = $curr->next;
            $curr = $prev->next;
        }
    }
    return $head;
}

/**
 * Maintains a peek pointer that checks every subsequent nodes for same data in the current node.
 * If peek pointer found a repeat node, it deletes the node.
 * Time: O(n^2)
 * Space: O(1)
 */
function removeDuplicatesV2(&$head) {
    if (empty($head)) {
        return;
    }
    $curr = $head;

    while (!empty($curr)) {
        $prev = $curr;
        $peek = $curr->next;
        while (!empty($peek)) {
            if ($peek->data == $curr->data) {
                $prev->next = $peek->next;
                $peek = $prev->next;
            } else {
                $prev = $peek;
                $peek = $peek->next;
            }
        }
        $curr = $curr->next;
    }
    return $head;
}

$list = new LinkedList(1);
$list->insert(2);
$list->insert(3);
$list->insert(4);
$list->insert(5);
$list->insert(4);
$list->printList();

$newHead = removeDuplicates($list->getHead());
$newHead2 = removeDuplicatesV2($list->getHead());
$newCurr = $newHead2;

while (!empty($newCurr)) {
    echo $newCurr->data . " ";
    $newCurr = $newCurr->next;
}
echo PHP_EOL;