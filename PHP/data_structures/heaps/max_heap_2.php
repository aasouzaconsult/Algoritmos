<?php

/**
 * Implementation of max heap.
 * Time Complexity:
 * Peek: O(1)
 * Search: O(n)
 * Insert: O(lgn)
 * Delete: O(lgn)
 * Space Complexity: O(n)
 * 
 */
class MaxHeap {
    private $arr;
    private $size;

    public function __construct($arr) {
        $this->arr = $arr;
        $this->size = sizeof($arr);
        $this->heapify();
    }

    public function insert($value) {
        $this->arr[] = $value;
        $index = sizeof($this->arr) - 1;
        $parentIndex = $this->getParentIndex($index);

        while ($parentIndex >= 0) {
            if ($this->arr[$parentIndex] < $value) {
                $this->arr[$index] = $this->arr[$parentIndex];
            } else {
                break;
            }
            $index = $parentIndex;
            $parentIndex = $this->getParentIndex($index);
        }
        $this->arr[$index] = $value;
        $this->size++;
        return;
    }

    public function pop() {
        if (empty($this->arr)) {
            return;
        }
        $this->swap($this->arr[0], $this->arr[$this->size - 1]);
        $result = array_pop($this->arr);
        $this->size--;
        if (!empty($this->arr)) {
            $this->siftDown(0);
        }        
        return $result;
    }

    public function getHeap() {
        return $this->arr;
    }

    public function heapify() {
        $index = sizeof($this->arr) - 1;
        while ($index >= 0) {
            $this->siftDown($index);
            $index--;
        }
    }

    private function siftDown($index) {
        if ($index < 0 || $index >= $this->size) {
            return;
        }
        $value = $this->arr[$index];
        $childIndex = $this->getLeftChildIndex($index);
        while ($childIndex < $this->size) {
            if ($childIndex+1 < $this->size &&
                $this->arr[$childIndex+1] > $this->arr[$childIndex]) {
                    $childIndex++;
            }
            if ($this->arr[$childIndex] > $value) {
                $this->arr[$index] = $this->arr[$childIndex];
            } else {
                break;
            }
            $index = $childIndex;
            $childIndex = $this->getLeftChildIndex($index);
        }
        $this->arr[$index] = $value;
        return;
    }

    private function getLeftChildIndex($index) {
        return $index * 2 + 1;
    }

    private function getParentIndex($index) {
        return floor(($index-1) / 2);
    }

    private function swap(&$value1, &$value2) {
        $temp = $value1;
        $value1 = $value2;
        $value2 = $temp;
    }
}
$arr = [19,36,100,17,7,2,25,1,3];
$maxHeap = new MaxHeap($arr);
// $maxHeap->insert(19);
// $maxHeap->insert(36);
// $maxHeap->insert(100);
// $maxHeap->insert(17);
// $maxHeap->insert(7);
// $maxHeap->insert(2);
// $maxHeap->insert(25);
// $maxHeap->insert(1);
// $maxHeap->insert(3);
print_r($maxHeap->getHeap());

echo $maxHeap->pop() . PHP_EOL;
echo $maxHeap->pop() . PHP_EOL;
echo $maxHeap->pop() . PHP_EOL;
echo $maxHeap->pop() . PHP_EOL;
echo $maxHeap->pop() . PHP_EOL;
echo $maxHeap->pop() . PHP_EOL;
echo $maxHeap->pop() . PHP_EOL;
echo $maxHeap->pop() . PHP_EOL;
echo $maxHeap->pop() . PHP_EOL;
echo $maxHeap->pop() . PHP_EOL;

