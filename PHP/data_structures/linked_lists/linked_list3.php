<?php

include_once("../../Utility.php");

/**
 * https://www.diycode.cc/projects/jwasham/google-interview-university
 * Practice linked list by implementing Linked list methods from the link above
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
    private $tail;
    private $size;

    public function __construct($data, $next=NULL) {
        $this->head = new Node($data, $next);
        $this->tail = $this->head;
        $this->size = 1;
    }

    public function size() {
        return $this->size;
    }

    public function isEmpty() {
        return $this->size == 0;
    }

    public function valueAt($index) {
        if ($index >= $this->size) {
            return;
        }
        $curr = $this->head;
        $i = 0;
        while ($i < $index) {
            $curr = $curr->next;
            $i++;
        }
        return $curr->data;
    }

    /**
     * Add item to front of list, O(1) time.
     */
    public function pushFront($value) {
        $node = new Node($value);
        $node->next = $this->head;
        $this->head = $node;
        $this->size++;
    }

    /**
     * Remove front item.
     */
    public function popFront() {
        if (empty($this->head)) {
            return;
        }
        $value = $this->head->data;
        $this->head = $this->head->next;
        $this->size--;
        return $value;
    }

    /**
     * Add item to the end.
     *
     */
    public function pushBack($value) {
        $node = new Node($value);
        $this->tail->next = $node;
        $this->tail = $node;
        $this->size++;
    }

    public function popBack() {
        $prev = NULL;
        $curr = $this->head;
        while (!empty($curr->next)) {
            $prev = $curr;
            $curr = $curr->next;
        }
        $prev->next = NULL;
        $this->tail = $prev;
        $this->size--;
    }

    public function front() {
        return $this->head->data;
    }

    public function back() {
        return $this->tail->data;
    }

    /**
     * Insert value at index.
     */
    public function insert($index, $value) {
        if ($index == 0) {
            $this->pushFront($value);
            return;
        } elseif ($index == $this->size - 1) {
            $this->pushBack($value);
            return;
        }
        $prev = NULL;
        $curr = $this->head;
        $i = 0;
        while ($i < $index) {
            $prev = $curr;
            $curr = $curr->next;
            $i++;
        }
        $node = new Node($value);
        $prev->next = $node;
        $node->next = $curr;
        $this->size++;
    }

    /**
     * Remove node at index.
     *
     */
    public function erase($index) {
        if ($index >= $this->size) {
            return False;
        }
        $prev = NULL;
        $curr = $this->head;

        for ($i=0; $i < $index; $i++) { 
            $prev = $curr;
            $curr = $curr->next;
        }
        $node = $prev->next;
        $prev->next = $prev->next->next;
        unset($node);
        $this->size--;
        return True;
    }

    /**
     * Return value node at nth position from end of list.
     * ie. 
     * 0th -> last node
     * 1st -> last 2nd node
     */
    public function nthToEnd($n) {
        if ($n >= $this->size) {
            return;
        }
        // calculate the number of times of traversal, starting from head node
        $lastIndex = $this->size - 1 ;
        $travCount = $lastIndex - $n - 1; // traverse 1 less time since starting from head node
        $curr = $this->head;

        for ($i=0; $i <= $travCount; $i++) { 
            $curr = $curr->next;
        }
        return $curr->data;
    }

    /**
     * Reverse the linked list.
     */
    public function reverse() {
        $prev = NULL;
        $curr = $this->head;
        $next = $this->head->next;
        $this->tail = $this->head;

        while (!empty($curr)) {
            $curr->next = $prev;
            $prev = $curr;
            $curr = $next;
            $next = $next->next;
        }
        $this->head = $prev;        
    }

    public function remove($value) {
        if ($value == $this->head->data) {
            $this->head = $this->head->next;
            $this->size--;
            return True;
        }
        $prev = $this->head;
        $curr = $this->head->next;
        while ($curr->data != $value && !empty($curr)) {
            $prev = $curr;
            $curr = $curr->next;
        }
        $prev->next = $curr->next;
        unset($curr);
        return True;
    }

    public function printList() {
        if (empty($this->head)) {
            return;
        }
        $curr = $this->head;
        while (!empty($curr)) {
            echo $curr->data . " ";
            $curr = $curr->next;
        }
        echo PHP_EOL;
    }
}

$util = new Utility();

$llist = new LinkedList(1);
$util->assertEqual(1, $llist->size());
$llist->pushFront(2);
$llist->pushFront(3);
$llist->pushFront(4);
$util->assertEqual(4, $llist->size());
// $llist->popFront();
// $util->assertEqual(3, $llist->size());
$llist->pushBack(5);
$util->assertEqual(5, $llist->size());
// $llist->popBack();
// $util->assertEqual(4, $llist->size());
$llist->printList();
// echo $llist->front();
// echo $llist->back();
$llist->insert(2, 10);
$util->assertEqual(6, $llist->size());
$llist->printList();
$llist->erase(2);
$util->assertEqual(5, $llist->size());
$llist->printList();
// echo $llist->nthToEnd(5);
$llist->reverse();
$llist->printList();
$llist->remove(5);
$llist->printList();
