<?php

include 'linked_list.php';

echo "============== reverse_linked_list.php" . PHP_EOL;
$a = new LinkedList(1);
$a->insert(2);
$a->insert(3);
$a->insert(4);
$a->printList();

/**
 * Reverse a linked list via creating a new head.
 * @param  [type] $head [description]
 * @return [type]       [description]
 */
function reverse($head) {
    if (is_null($head)) {
        return $head;
    }
    $newHead = new Node($head->getData());
    $curr = $head->getNext();
    while ($curr != NULL) {
        $newNode = new Node($curr->getData());
        $newNode->setNext($newHead);
        $newHead = $newNode;
        $curr = $curr->getNext();
    }
    $newCurr = $newHead;
    while ($newCurr != NULL) {
        echo $newCurr->getData() . PHP_EOL;
        $newCurr = $newCurr->getNext();
    }
}

/**
 * Reverse a linked list via pointer reallocation
 */
function reverseV2($head) {
    if (is_null($head)) {
        return $head;
    }
    $prev = NULL;
    $curr = $head;

    while (!is_null($curr)) {
        $next = $curr->getNext();
        $curr->setNext($prev);
        $prev = $curr;
        $curr = $next;
    }
    $head = $prev;

    $newCurr = $head;
    while (!is_null($newCurr)) {
        echo $newCurr->getData() . PHP_EOL;
        $newCurr = $newCurr->getNext();
    }
}

reverse($a->getHead());
reverseV2($a->getHead());