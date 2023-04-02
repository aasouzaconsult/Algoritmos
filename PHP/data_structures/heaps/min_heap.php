<?php

/**
 * Implementing a min heap with array.
 */

class MinHeap {
    private $heap;

    public function __construct($heap=array()) {
        $this->heap = $heap;
    }

    public function insert($data) {
        $this->heap[] = $data;
        $i = sizeof($this->heap)-1;
        $parentIndex = $this->getParentIndex($i);

        while ($parentIndex >= 0 && $i > 0) {
            if ($this->heap[$parentIndex] > $data) {
                $this->heap[$i] = $this->heap[$parentIndex];
            } else {
                break;
            }
            $i = $parentIndex;
            $parentIndex = $this->getParentIndex($i);
        }
        $this->heap[$i] = $data;
    }

    public function delete() {
        if (empty($this->heap)) {
            return;
        }

        // swap root node element and last element
        $this->swap($this->heap[0], $this->heap[sizeof($this->heap)-1]);
        $largest = array_pop($this->heap);
        if (!empty($this->heap)) {
            $this->siftDown(0);
        }
        return $largest;
    }

    private function swap(&$value1, &$value2) {
        $temp = $value1;
        $value1 = $value2;
        $value2 = $temp;
    }

    /**
     * Sift down value at given index repeatedly so the max heap structure is maintained.
     */
    private function siftDown($index) {
        if ($index > sizeof($this->heap)) {
            return;
        }
        // set temp value to compare with
        $temp = $this->heap[$index];
        $i = $index;
        $childIndex = $this->getLeftChildIndex($index);

        while ($childIndex < sizeof($this->heap)) {
            // check if right child is bigger than left child and set child index correctly
            if ($childIndex+1 < sizeof($this->heap) &&
                $this->heap[$childIndex+1] < $this->heap[$childIndex]) {
                $childIndex++;
            }
            // if child value is smaller than temp, set current index value to child value, else break
            if ($temp > $this->heap[$childIndex]) {
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
}

$arr = [10,15,30,40,50,100,40];
$minHeap = new MinHeap($arr);
print_r($minHeap->getHeap());
// $minHeap->delete();
// print_r($minHeap->getHeap());
// $minHeap->delete();
// print_r($minHeap->getHeap());
