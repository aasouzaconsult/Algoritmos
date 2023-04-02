<?php

/**
 * Implements a dynamic array from a fixed array.
 */

class DynamicArray {

    private $size;
    private $arr;
    private $currentIndex;

    public function __construct($size=5) {
        $this->size = $size;
        $this->currentIndex = 0;
        $this->arr = new SplFixedArray($this->size);
    }

    public function add($element) {
        if ($this->currentIndex >= $this->size) {
            // enlarge size
            $newSize = $this->size * 2;
            $newArray = new SplFixedArray($newSize);
            for ($i=0; $i<$this->size; $i++) {
                $newArray[$i] = $this->arr[$i];
            }
            $this->arr = $newArray;
            $this->size = $newSize;
        }

        $this->arr[$this->currentIndex] = $element;
        $this->currentIndex++;
    }

    public function printArray() {
        for ($i=0; $i<$this->size; $i++) {
            echo $this->arr[$i] . " ";
        }
        echo PHP_EOL;
    }
}

$array = new DynamicArray();
$array->add('a');
$array->add('b');
$array->add('c');
$array->add('d');
$array->add('e');
$array->add('f');
$array->printArray();
