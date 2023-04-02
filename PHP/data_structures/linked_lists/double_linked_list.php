<?php

/**
 * Implementation of a double linked list.
 */

class Node {
    private $data;
    private $next;
    private $prev;

    public function  __construct($data, &$next=NULL, &$prev=NULL) {
        $this->data = $data;
        $this->next = $next;
        $this->prev = $prev;
    }

    public function getData() {
        return $this->data;
    }

    public function getNext() {
        return $this->next;
    }

    public function getPrev() {
        return $this->prev;
    }

    public function setNext($node) {
        $this->next = $node;
    }

    public function setPrev($node) {
        $this->prev = $node;
    } 
}

class DoubleLinkedList {
    private $head;

    public function __construct($data) {
        $this->head = new Node($data);
    }

    public function insert($data) {
        $newNode = new Node($data);
        $curr = $this->head;

        while ($curr->getNext() != NULL) {
            $curr = $curr->getNext();
        }
        $curr->setNext($newNode);
        $newNode->setPrev($curr);
    }

    public function search($data) {
        $curr = $this->head;
        $result = "{$data} not found." . PHP_EOL;
        $pos = 0;
        while ($curr != NULL) {
            if ($curr->getData() == $data) {
                $result = "{$data} found at position {$pos}." . PHP_EOL;
            }
            $curr = $curr->getNext();
            $pos++;
        }
        return $result;
    }

    public function delete($data) {
        if ($this->head->getData() == $data) {
            $delNode = $this->head;
            $this->head = $this->head->getNext();
            $this->head->setPrev(NULL);
            unset($delNode);
            return "{$data} deleted." . PHP_EOL;
        } else if (!$this->hasData($data)) {
            return "Data {$data} not found in list." . PHP_EOL;
        }
        // handle the case where data is mid/last node
        $curr = $this->head;
        while ($curr->getNext() != NULL) {
            if ($curr->getData() == $data) {
                break;
            }
            $curr = $curr->getNext();
        }
        $delNode = $curr;
        $prevNode = $curr->getPrev();
        $nextNode = $curr->getNext();
        $prevNode->setNext($nextNode);
        if ($nextNode != NULL) {
            $nextNode->setPrev($prevNode);
        }
        unset($delNode);
        return "{$data} deleted." . PHP_EOL;
    }

    public function printList() {
        $curr = $this->head;

        while ($curr != NULL) {
            echo $curr->getData() . "->";
            $curr = $curr->getNext();
        }
        echo "NULL" . PHP_EOL;
    }

    private function hasData($data) {
        $curr = $this->head;

        while ($curr != NULL) {
            if ($curr->getData() == $data) {
                return true;
            }
            $curr = $curr->getNext();
        }
        return false;
    }
}

$dblLinkedList = new DoubleLinkedList(1);
$dblLinkedList->insert(2);
$dblLinkedList->insert(3);
$dblLinkedList->insert(4);
$dblLinkedList->insert(5);
$dblLinkedList->insert(6);
$dblLinkedList->printList();
echo $dblLinkedList->search(4);
echo $dblLinkedList->search(5);
echo $dblLinkedList->search(6);
echo $dblLinkedList->search(7);
echo $dblLinkedList->delete(6);
$dblLinkedList->printList();