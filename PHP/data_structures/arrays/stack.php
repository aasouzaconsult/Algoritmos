<?php

/**
 * Implement a stack data structure with arrays
 */

class Stack {
    private $arr;

    public function __construct() {
        $this->arr = [];
    }

    public function push($data) {
        $this->arr[] = $data;
        return;
    }

    public function pop() {
        if ($this->isEmpty()) {
            echo "Stack is empty." . PHP_EOL;
            return;
        }
        return array_pop($this->arr);
    }

    public function top() {
        return end($this->arr);
    }

    public function isEmpty() {
        return empty($this->arr);
    }

    public function printStack() {
        echo implode(" ", $this->arr) . PHP_EOL;
    }
}

$stack = new Stack();
$stack->push(1);
$stack->push(2);
$stack->push(3);
$stack->push(4);
$stack->push(5);
$stack->printStack();
$stack->pop();
$stack->printStack();
$stack->pop();
$stack->printStack();
$stack->pop();
$stack->printStack();
$stack->pop();
$stack->printStack();
$stack->pop();
$stack->printStack();
$stack->pop();
$stack->printStack();
