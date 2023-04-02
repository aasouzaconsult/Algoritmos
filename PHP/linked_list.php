<?php

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

    public function insert($data) {
        $node = new Node($data);
        if (empty($this->head)) {
            $this->head = $node;
            return $this->head;
        }
        $node->next = $this->head;
        $this->head = $node;
        return $this->head;
    }

    public function delete($data) {
        $node = $this->search($data);
        if (empty($this->head) || empty($node)) {
            return False;
        } elseif ($this->head == $node) {
            $this->head = $node->next;
            unset($node);
            return True;
        }
        $prev = $this->getPrevNode($node);
        $prev->next = $node->next;
        unset($node);
        return True;
    }

    public function search($data) {
        if (empty($this->head)) {
            return;
        }
        $curr = $this->head;
        while ($curr != NULL) {
            if ($curr->data == $data) {
                return $curr;
            }
            $curr = $curr->next;
        }
        return NULL;
    }

    public function getHead() {
        return $this->head;
    }

    public function printList() {
        if (empty($this->head)) {
            return;
        }
        $curr = $this->head;
        while ($curr != NULL) {
            echo $curr->data . " ";
            $curr = $curr->next;
        }
        echo PHP_EOL;
    }

    public function getPrevNode(&$node) {
        if (empty($this->head)) {
            return;
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

    public function reverse() {
        if (empty($this->head)) {
            return;
        }
        $prev = NULL;
        $curr = $this->head;
        while (!empty($curr)) {
            $temp = $curr->next;
            $curr->next = $prev;
            $prev = $curr;
            $curr = $temp;
        }
        $this->head = $prev;
    }
}

// $list = new LinkedList(1);
// $list->insert(2);
// $list->insert(3);
// $list->insert(4);
// $list->printList();
// $list->reverse();
// $list->printList();