<?php

/**
 * Implementation of basic linked list
 */

class Node {
    public $data;
    public $next;

    public function __construct($data, $next=NULL) {
        $this->data = $data;
        $this->next = $next;
    }
}

class LinkedList {
    private $head;

    public function __construct($data, $next=NULL) {
        $this->head = new Node($data, $next);
    }

    /**
     * Insert into linked list.
     * Time O(n)
     * @param  [type] $data [description]
     * @return [type]       [description]
     */
    public function insert($data) {
        $newNode = new Node($data);
        if (empty($this->head)) {
            $this->head = $newNode;
            return $this->head;
        }
        $curr = $this->head;
        while (!empty($curr->next)) {
            $curr = $curr->next;
        }
        $curr->next = $newNode;
        return $this->head;
    }

    public function search($data) {
        if (empty($this->head)) {
            return NULL;
        }
        $curr = $this->head;
        while (!empty($curr)) {
            if ($curr->data == $data) {
                return $curr;
            }
            $curr = $curr->next;
        }
        return NULL;
    }

    public function delete($data) {
        if (empty($this->head)) {
            return false;
        }
        $curr = $this->head;
        while (!empty($curr)) {
            if ($curr->data == $data) {
                break;
            }
            $curr = $curr->next;
        }
        $prev = $this->getPrevNode($curr);
        $prev->next = $curr->next;
        unset($curr);
        return true;
    }

    public function getHead() {
        return $this->head;
    }

    public function printList() {
        if (empty($this->head)) {
            return NULL;
        }
        $curr = $this->head;
        while (!empty($curr)) {
            echo "{$curr->data} ";
            $curr = $curr->next;
        }
        echo PHP_EOL;
    }

    public function getPrevNode(&$node) {
        if (empty($this->head)) {
            return NULL;
        }
        $prev = NULL;
        $curr = $this->head;

        while (!empty($curr)) {
            if ($curr->data == $node->data) {
                return $prev;
            }
            $prev = $curr;
            $curr = $curr->next;
        }
        return NULL;
    }
}