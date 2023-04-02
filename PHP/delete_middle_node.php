<?php

/**
 * Impement an algorithm to delete a node in the middle(ie, any node but the first and last node,
 * not necessarily the exact middle) of a singly linked list, given only access to that node.
 * EXAMPLE
 * Input: the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a->b->d->e->f
 */

include "linked_list.php";

/**
 * Since we are given only the node to delete, we cannot access the previous node that points
 * to this node. But to achieve the result linked list, we are saying c data is no longer accessible.
 * Since a node without its data is essentially meaningless, we can soft delete the node by just deleting
 * the data. So result looks like this:
 * Result: a->b->' '->d->e->f
 * Time: O(1)
 * Space: O(1)
 */
function deleteNode(&$nodeToDelete) {
    $nodeToDelete->data = NULL;
    return;
}

function deleteNodeV2(&$nodeToDelete) {
    $curr = $nodeToDelete;
    $prev = NULL;
    while (!empty($curr)) {
        $curr->data = $curr->next->data;
        $prev = $curr;
        $curr = $curr->next;
    }
    $prev = NULL;
    return;
}


$list = new LinkedList('f');
$list->insert('e');
$list->insert('d');
$list->insert('c');
$list->insert('b');
$list->insert('a');
$list->printList();
$node = $list->search('c');
// deleteNode($node);
deleteNodeV2($node);
$list->printList();