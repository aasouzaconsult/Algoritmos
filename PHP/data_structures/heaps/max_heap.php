<?php

/**
 * Implementing a min heap with array.
 */

class MaxHeap {
    private $heap;

    public function __construct($heap=array()) {
        $this->heap = $heap;
    }

    /**
     * Insert element into the heap.
     * Time: O(lg n). where n is size of the heap
     */
    public function insert($data) {
        $this->heap[] = $data;
        $i = sizeof($this->heap) - 1;
        $parentIndex = $this->getParentIndex($i);

        while ($parentIndex >= 0 && $i > 0) {
            if ($this->heap[$parentIndex] < $data) {
                $this->heap[$i] = $this->heap[$parentIndex];
            } else {
                break;
            }
            $i = $parentIndex;
            $parentIndex = $this->getParentIndex($i);
        }
        $this->heap[$i] = $data;
    }

    /**
     * Delete the largest element from the heap.
     * Time: O(lg n). where n is size of the heap
     */
    public function delete() {
        // check empty heap
        if (empty($this->heap)) {
            return false;
        }
        // swap first and last index
        $this->swap($this->heap[0], $this->heap[sizeof($this->heap)-1]);

        // delete last index element
        $largest = array_pop($this->heap);
        // siftdown the new first index
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
     * Make the heap a max heap.
     * Time: O(n)
     */
    public function heapify() {
        if (empty($this->heap)) {
            return;
        }
        // get parent node of the last node
        $parentIndex = $this->getParentIndex(sizeof($this->heap)-1);
        // from the parent node until root node, repeat sift down
        while ($parentIndex >= 0) {
            $this->siftDown($parentIndex);
            $parentIndex--;
        }
    }

    /**
     * Sift down value at given index repeatedly so the max heap structure is maintained.
     * Time: O(lg n). where n is size of the heap
     */
    private function siftDown($siftIndex) {
        if ($siftIndex >= sizeof($this->heap)) {
            return;
        }
        // set temp for sift index value
        $temp = $this->heap[$siftIndex];

        $i = $siftIndex;
        $childIndex = $this->getLeftChildIndex($i);

        // while loop on there is a left child
        while ($childIndex < sizeof($this->heap)) {
            // right child bigger than left child
            if ($childIndex+1 < sizeof($this->heap) &&
                $this->heap[$childIndex+1] > $this->heap[$childIndex]) {
                $childIndex++;
            }
            if ($temp < $this->heap[$childIndex]) {
                $this->heap[$i] = $this->heap[$childIndex];
            } else {
                break;
            }
            $i = $childIndex;
            $childIndex = $this->getLeftChildIndex($i);
        }
        // insert temp into the correct spot
        $this->heap[$i] = $temp;
    }

    public function getHeap() {
        return $this->heap;
    }

    private function getParentIndex($index) {
        if ($index == 0) {
            return NULL;
        }
        return floor(($index-1) / 2);
    }

    private function getLeftChildIndex($index) {
        return $index*2 + 1;
    }

    private function getRightChildIndex($index) {
        return $index*2 + 2;
    }
}

$presetArray = [104,71,24,66,27,23,8,5,32,25,18,22];
$nonMaxHeapArray = [3,6,10,18,8,7,25,400];
$maxHeap = new MaxHeap($nonMaxHeapArray);

// print_r($maxHeap->getHeap());
// echo $maxHeap->delete();
// print_r($maxHeap->getHeap());
// echo $maxHeap->delete();
// print_r($maxHeap->getHeap());

// $maxHeap->insert(50);
// print_r($maxHeap->getHeap());
// $maxHeap->insert(91);
// print_r($maxHeap->getHeap());
// $maxHeap->insert(150);
// print_r($maxHeap->getHeap());

// $maxHeap->heapify();
// print_r($maxHeap->getHeap());
