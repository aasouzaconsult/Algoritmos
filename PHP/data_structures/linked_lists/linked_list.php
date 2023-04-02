<?php

/**
 * Implementation of a basic linked list.
 */
class Node {
    private $data;
    private $next;

    public function __construct($data, &$next=NULL) {
        $this->data = $data;
        $this->next = $next;
    }

    public function getData() {
        return $this->data;
    }

    public function getNext() {
        return $this->next;
    }

    public function setNext($node) {
        $this->next = $node;
    }
}

class LinkedList {
    private $head;

    public function __construct($data) {
        $this->head = new Node($data);
    }

    /**
     * Insert a new node into list.
     * Takes O(n) time.
     */
    public function insert($data) {
        $newNode = new Node($data);
        $curr = $this->head;
        while ($curr->getNext() != NULL) {
            $curr = $curr->getNext();
        }
        $curr->setNext($newNode);
    }

    public function search($data) {
        $curr = $this->head;
        $result = "{$data} not found." . PHP_EOL;
        $pos = 0;
        while ($curr != NULL) {
            if ($curr->getData() == $data) {
                $result = "{$data} found at position " . $pos . PHP_EOL; 
                break;
            }
            $curr = $curr->getNext();
            $pos++;
        }
        return $result;
    }

    public function delete($data) {
        // handle case where data is head node
        if ($this->head->getData() == $data) {
            $delNode = $this->head;
            $this->head = $this->head->getNext();
            unset($delNode);
            return "{$data} deleted." . PHP_EOL;
        } else if(!$this->hasData($data)) {
            return "Data {$data} not found in list." . PHP_EOL;
        }        
        // handle case where data is mid/last node
        $prevNode = $this->getPrevNode($data);
        $delNode = $prevNode->getNext();
        $prevNode->setNext($delNode->getNext());
        unset($delNode);
        return "{$data} deleted." . PHP_EOL;
    }

    public function getHead() {
        return $this->head;
    }

    public function printList() {
        $curr = $this->head;
        while ($curr != NULL) {
            echo $curr->getData() . "->";
            $curr = $curr->getNext();
        }
        echo "NULL" . PHP_EOL;
    }

    private function getPrevNode($data) {
        $prev = $this->head;
        $curr = $this->head->getNext();
        while ($curr != NULL) {
            if ($curr->getData() == $data) {
                return $prev;
            }
            $prev = $curr;
            $curr = $curr->getNext();
        }
        return NULL;
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


$linkedList = new LinkedList(1);
$linkedList->insert(2);
$linkedList->insert(3);
$linkedList->insert(4);
$linkedList->insert(5);
$linkedList->insert(6);
$linkedList->printList();
echo $linkedList->search(1);
echo $linkedList->search(3);
echo $linkedList->search(6);
echo $linkedList->search(8);
echo $linkedList->delete(4);
$linkedList->printList();