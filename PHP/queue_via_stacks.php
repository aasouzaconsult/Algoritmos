<?php

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 */

class MyQueue {
    private $enqStack;
    private $deqStack;

    public function __construct() {
        $this->enqStack = [];
        $this->deqStack = [];
    }

    public function enqueue($data) {
        $this->enqStack[] = $data;
    }

    public function dequeue() {
        while (!empty($this->enqStack)) {
            $this->deqStack[] = array_pop($this->enqStack);
        }
        $result = array_pop($this->deqStack);
        while (!empty($this->deqStack)) {
            $this->enqStack[] = array_pop($this->deqStack);
        }
        return $result;
    }
}

$queue = new MyQueue();
$queue->enqueue(5);
$queue->enqueue(4);
$queue->enqueue(3);
$queue->enqueue(1);
$queue->enqueue(9);
$queue->enqueue(6);
$queue->enqueue(8);
$queue->enqueue(7);

echo $queue->dequeue();
echo $queue->dequeue();
echo $queue->dequeue();
echo $queue->dequeue();
echo $queue->dequeue();
echo $queue->dequeue();
echo $queue->dequeue();
echo $queue->dequeue();