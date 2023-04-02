<?php

class Packet {
    public $key;
    public $data;

    public function __construct($key=NULL, $data=NULL) {
        $this->key = $key;
        $this->data = $data;
    }
}

class MinHeap {
    private $head;

    public function __construct($heap=array()) {
        $this->head = $heap;
    }

    public function insert(Packet $packet) {
        // insert packet to end of heap
        $this->heap[] = $packet;
        // get index of newly inserted element
        $i = sizeof($this->heap)-1;
        // get its parent
        $parentIndex = $this->getParentIndex($i);
        // traverse up successive parents
        //     if parent key is bigger than packet key
        //         move parent packet down
        //     else break
        //     get the new parentindex
        while ($parentIndex >= 0 && $i > 0) {
            if ($this->heap[$parentIndex]->key > $packet->key) {
                $this->heap[$i] = $this->heap[$parentIndex];
            } else {
                break;
            }
            $i = $parentIndex;
            $parentIndex = $this->getParentIndex($i);
        }
        // put inserted packet into its right place. referenced by index
        $this->heap[$i] = $packet;
    }

    public function delete() {
        // handle empty heap
        if (empty($this->heap)) {
            return NULL;
        }
        // swap root node element with last element
        $this->swap($this->heap[0], $this->heap[sizeof($this->heap)-1]);
        // pop the last element
        $smallest = array_pop($this->heap);
        // if heap is not empty, siftdown
        if (!empty($this->heap)) {
            $this->siftDown(0);
        }
        // return smallest
        return $smallest;
    }

    private function swap(&$value1,&$value2) {
        $temp = $value1;
        $value1 = $value2;
        $value2 = $temp;
    }

    public function siftDown($index) {
        if ($index > sizeof($this->heap)) {
            return;
        }
        // set temp value to compare with
        $temp = $this->heap[$index];
        $i = $index;
        $childIndex = $this->getLeftChildIndex($index);

        while ($childIndex < sizeof($this->heap)) {
            // check if right child is smaller than left child and set child index correctly
            if ($childIndex+1 < sizeof($this->heap) &&
                $this->heap[$childIndex+1]->key < $this->heap[childIndex]->key) {
                $childIndex++;
            }
            // if child is smaller than temp, set current index value to child value, else break
            if ($temp->key > $this->heap[$childIndex]->key) {
                $this->heap[$i] = $this->heap[$childIndex];
            } else {
                break;
            }
            // progress current index downward, progress child index downward
            $i = $childIndex;
            $childIndex = $this->getLeftChildIndex($i);
        }
        // set temp value to index value
        $this->heap[$i] = $temp;
    }

    private function getParentIndex($index) {
        if ($index == 0) {
            return NULL;
        }
        return floor(($index-1) / 2);
    }

    private function getLeftChildIndex($index) {
        return $index * 2 + 1;
    }

    private function getRightChildIndex($index) {
        return $index * 2 + 2;
    }

    public function getHeap() {
        return $this->heap;
    }

    public function heapify() {
        if (empty($this->heap)) {
            return;
        }
        $parentIndex = $this->getParentIndex(sizeof($this->heap)-1);

        while ($parentIndex >= 0) {
            $this->siftDown($parentIndex);
            $parentIndex--;
        }
    }

    public function printHeap() {
        foreach ($this->heap as $key => $value) {
            $key = $value->key;
            $value1 = $value->data[0];
            $value2 = $value->data[1];
            echo "{$key} [{$value1}, {$value2}]" . PHP_EOL;
        }
    }
}
$packets = [
    new Packet(1,[7,6]),
    new Packet(1,[6,7]),
    new Packet(2,[2,8]),
    new Packet(2,[8,2]),
    new Packet(2,[5,6]),
    new Packet(2,[6,5]),
    new Packet(4,[0,1]),
    new Packet(4,[1,0]),
    new Packet(4,[2,5]),
    new Packet(4,[5,2]),
    new Packet(6,[6,8]),
    new Packet(6,[8,6]),
    new Packet(7,[2,3]),
    new Packet(7,[3,2]),
    new Packet(7,[7,8]),
    new Packet(7,[8,7]),
    new Packet(8,[0,7]),
    new Packet(8,[7,0]),
    new Packet(8,[1,2]),
    new Packet(8,[2,1]),
    new Packet(9,[3,4]),
    new Packet(9,[4,3]),
    new Packet(10,[4,5]),
    new Packet(10,[5,4]),
    new Packet(11,[1,7]),
    new Packet(11,[7,1]),
    new Packet(14,[3,5]),
    new Packet(14,[5,3]),
];
$minHeap = new MinHeap();
foreach ($packets as $key => $value) {
    $minHeap->insert($value);
}
$minHeap->printHeap();
