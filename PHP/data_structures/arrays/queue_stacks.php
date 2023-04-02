<?php

include "stack.php";
/**
 * Implement a queue using 2 stacks.
 */

class Queue {
    private $enqueueStack;
    private $dequeueStack;

    public function __construct() {
        $this->enqueueStack = new Stack();
        $this->dequeueStack = new Stack();
    }

    public function enqueue($data) {
        $this->enqueueStack->push($data);
    }

    public function dequeue() {
        while (!$this->enqueueStack->isEmpty()) {
            $this->dequeueStack[] = $this->enqueueStack->pop();
        }
        $result = $this->dequeueStack->pop();
        while(!$this->dequeueStack->isEmpty()) {
            $this->enqueueStack[] = $this->dequeueStack->pop();
        }
        return $result;
    }

    public function lookup() {
        if ($this->enqueueStack->isEmpty()) {
            return NULL;
        } else {
            return $this->enqueueStack[0];
        }
    }

    public function isEmpty() {
        if (empty($this->enqueueStack) && empty($this->dequeueStack)) {
            return true;
        }
        return false;
    }
}