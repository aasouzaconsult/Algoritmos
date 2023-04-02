<?php

/**
 * Given a circular linked list, implement an algorithm that returns the node at
 * the beginning of the loop.
 * DEFINITION
 * Circular linked list: A(corrupt) linked list in which a node's next pointer points
 * to an earlier node, so as to make a loop in the linked list.
 *
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C (the same C as earlier)
 * Output: C
 */

include "linked_list.php";

/**
 * Using a hash table.
 * Traverse through the list, put each node into hashtable with
 * node memory address => node
 * if the memory address is not previously set.
 * Once we encounter an address which is already set. that is the beginning of
 * the circular loop.
 * Return that node.
 */
function getLoopHead($list) {

}

/**
 * Have a subroutine function to check if given head(a list) contains a loop.
 * starting from the head node, successively have head pointer point to next node
 * and unset the previous head node.
 * pass in the new head to subrounte to check for loop. for the node that no longer
 * contains a loop, the previously deleted head node is the beginning of the head node.
 * Time: O()
 * Space: O()
 */
function getLoopHeadV2($list) {
    $head = $list->getHead();
    $prev = NULL;

    while (!empty($head)) {
        if (hasLoop($head, 100)) {
            $prev = $head;
            $temp = $head->next;
            $head->next = NULL;
            $head = $temp;
        } else {
            break;
        }
    }
    return $prev;
}

function hasLoop($head, $maxSize) {
    $tortise = $head;
    $hare = $head;
    $count = 0;
    while (!empty($hare)) {
        if ($tortise === $hare) {
            return True;
        }
        if ($count >= $maxSize) {
            break;
        }
        $count++;
        $tortise->next;
        $hare = $hare->next;
        $hare = $hare->next;
    }
    return False;
}

function setCircularList($list) {
    $curr = $list->getHead();
    while (!empty($curr->next)) {
        $curr = $curr->next;
    }
    $node = $list->search('c');
    $curr->next = $node;
}

$list1 = new LinkedList('e');
$list1->insert('d');
$list1->insert('c');
$list1->insert('b');
$list1->insert('a');

setCircularList($list1);
echo hasLoop($list1->getHead(), 1000) . PHP_EOL;
echo getLoopHeadV2($list1)->data . PHP_EOL;
// $list1->printList();