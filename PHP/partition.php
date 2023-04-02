<?php

/**
 * Write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes great than or equal to x. if x is contained
 * within the list, the values of x only need to be after the elements less than
 * x(see below). The partition element x can appear anywhere in the 'right partition';
 * it does not need to appear between the left and right partitions.
 * Example
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 (partition=5)
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */

include "linked_list.php";

/**
 * Maintain 2 new list, lessList and moreList to store values that are less / more
 * than the parition value.
 * Loop through the given list and put values in accordingly.
 * At the end of the traversal. point the less last node next pointer to head node
 * of more list. return the less list.
 * Time: O(n)
 * Space: O(n)
 */
function partition($list, $partition) {
    $head = $list->getHead();
    // init more and less lists
    $lessList = new LinkedList(NULL);
    $lessHead = $lessList->getHead();
    $moreList = new LinkedList(NULL);
    $moreHead = $moreList->getHead();

    // loop through the list and split more and less lists
    $curr = $head;
    while (!empty($curr)) {
        if ($curr->data < $partition) {
            if (empty($lessHead->data)) {
                $lessHead->data = $curr->data;
            } else {
                $newNode = new Node($curr->data);
                $newNode->next = $lessHead;
                $lessHead = $newNode;
            }
        } else {
            if (empty($moreHead->data)) {
                $moreHead->data = $curr->data;
            } else {
                $newNode = new Node($curr->data);
                $newNode->next = $moreHead;
                $moreHead = $newNode;
            }
        }
        $curr = $curr->next;
    }
    // point less last pointer to more list head
    $last = NULL;
    $lessCurr = $lessHead;
    while (!empty($lessCurr)) {
        $last = $lessCurr;
        $lessCurr = $lessCurr->next;
    }
    $last->next = $moreHead;
    return $lessHead;
}

function printList($head) {
    $curr = $head;
    while (!empty($curr)) {
        echo $curr->data . " ";
        $curr = $curr->next;
    }
    echo PHP_EOL;
}

$list = new LinkedList(1);
$list->insert(2);
$list->insert(10);
$list->insert(5);
$list->insert(8);
$list->insert(5);
$list->insert(3);
// $list->printList();

$result = partition($list, 5);
printList($result);