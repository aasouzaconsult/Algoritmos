<?php

/**
 * How would you design a stack which, in addition to push and pop, has a function
 * 'min' which returns the minimum element? Push, pop and min should all operate in
 * O(1) time.
 */

// Approach 1
// have a structure for stack element
class StackNode {
    public $data;
    public $min;

    public function __construct($data, $min) {
        $this->data = $data;
        $this->min = $min;
    }
}

class MinStack {
    private $stack;

    public function __construct() {
        $this->stack = [];
    }

    public function push($data) {
        $node = new StackNode($data, $data);
        if (empty($this->stack)) {
            $this->stack[] = $node;
            return;
        }
        $topElement = $this->stack[sizeof($this->stack)-1];
        if ($data > $topElement->min) {
            $node->min = $topElement->min;
        }
        $this->stack[] = $node;
    }

    public function pop() {
        return array_pop($this->stack);
    }

    public function min() {
        if (empty($this->stack)) {
            return;
        }
        $minIndex = NULL;
        $topElement = $this->stack[sizeof($this->stack)-1];
        // find topElement->min as data in stack
        for ($i=0; $i < sizeof($this->stack); $i++) {
            if ($topElement->min == $this->stack[$i]->data) {
                $minIndex == $i;
                break;
            }
        }
        // delete node and get the result node.
        $result = $this->stack[$minIndex];
        unset($this->stack[$minIndex]);
        $this->stack = array_values($this->stack);

        // for all index higher, recalculate min
        if ($minIndex != 0) {
            for ($i=$minIndex; $i < sizeof($this->stack); $i++) { 
                if ($this->stack[$i]->data < $this->stack[$i-1]->min) {
                    $this->stack[$i]->min = $this->stack[$i]->data;
                } else {
                    $this->stack[$i]->min = $this->stack[$i-1]->min;
                }
            }
        }
        return $result->data;
    }
}