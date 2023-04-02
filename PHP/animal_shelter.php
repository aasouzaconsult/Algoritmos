<?php

/**
 * An animal shelter, which holds only dogs and cats, operates on a strictly "first
 * in, first out" basis. People must adopt either the "oldest" (based on arrival
 * time) of all animals at the shelter, or they can select whether they would prefer
 * a dog or a cat(and will receive the oldest animal of that type). They cannot
 * select which specific animal they would like. Create the data structures to
 * maintain this system and implement operations such as enqueue, dequeueAny,
 * dequeueDog and dequeueCat. You may use the built-in LinkedList data structure.
 */

class Animal {
    public $type;
    public $name;

    public function __construct($name, $type) {
        $this->type = $type;
        $this->name = $name;
    }
}
class AnimalShelter {
    private $queue;
    private $tempStack;

    public function __construct() {
        $this->queue = new SplQueue();
        $this->tempStack = new SplStack();
    }

    public function enqueue($name, $type) {
        $animal = new Animal($name, $type);
        $this->queue->enqueue($animal);
    }

    public function dequeueAny() {
        return $this->queue->dequeue();
    }

    public function dequeueDog() {
        while ($this->queue->bottom()->type != 'dog') {
            $this->tempStack->push($this->queue->dequeue());
        }
        $result = $this->queue->dequeue();
        while (!$this->tempStack->isEmpty()) {
            $this->queue->unshift($this->tempStack->pop());
        }
        return $result;
    }

    public function dequeueCat() {
        while ($this->queue->bottom()->type != 'cat') {
            $this->tempStack->push($this->queue->dequeue());
        }
        $result = $this->queue->dequeue();
        while (!$this->tempStack->isEmpty()) {
            $this->queue->unshift($this->tempStack->pop());
        }
        return $result;
    }
}

$shelter = new AnimalShelter();
$shelter->enqueue('a', 'cat');
$shelter->enqueue('a', 'cat');
$shelter->enqueue('a', 'dog');
$shelter->enqueue('a', 'cat');
$shelter->enqueue('a', 'dog');
$shelter->enqueue('a', 'cat');
$shelter->enqueue('a', 'dog');
$shelter->enqueue('a', 'cat');

echo $shelter->dequeueDog()->type . PHP_EOL;
echo $shelter->dequeueDog()->type . PHP_EOL;
echo $shelter->dequeueDog()->type . PHP_EOL;