<?php

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack
 * exceeds some threshold. Implement a data structure 'SetOfStacks' that mimics this.
 * 'SetOfStacks' should be composed of several stacks and should create a new stack
 * once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a
 * single stack. (that is, pop() should return the same values as it would if there were
 * just a single stack.)
 *
 * FOLLOW UP
 * Implement a function 'popAt(int index)' which performs pop operation on a
 * specific sub-stack.
 */

class SetOfStacks {
    private $stackSet;
    private $currStackIndex; 
    private $singleStackSize;

    public function __construct() {
        $this->stackSet = [];
        $this->currStackIndex = 0;
        $this->singleStackSize = 5;
    }

    public function push($data) {
        if (empty($this->stackSet)) {
            $this->stackSet[] = [$data];
        } elseif (sizeof($this->stackSet[$this->currStackIndex]) < $this->singleStackSize) {
            array_push($this->stackSet[$this->currStackIndex], $data);
        } else {
            $this->stackSet[] = [$data];
            $this->currStackIndex++;
        }
    }

    public function pop() {
        if (empty($this->stackSet)) {
            return;
        } else {
            $result = array_pop($this->stackSet[$this->currStackIndex]);
        }
        if (empty($this->stackSet[$this->currStackIndex])) {
            array_pop($this->stackSet);
            $this->currStackIndex--;
        }
        return $result;
    }

    public function printStacks() {
        print_r($this->stackSet);
    }

    public function popAt($index) {
        if ($index > $this->currStackIndex) {
            return;
        } elseif (empty($this->stackSet[$index])) {
            return;
        } else {
            $result = array_pop($this->stackSet[$index]);
            $nextStackIndex = $index+1;
            while ($nextStackIndex <= $this->currStackIndex) {
                $shiftElement = array_shift($this->stackSet[$nextStackIndex]);
                array_push($this->stackSet[$nextStackIndex-1], $shiftElement);
                $nextStackIndex++;
            }
            if (empty($this->stackSet[$this->currStackIndex])) {
                array_pop($this->stackSet);
                $this->currStackIndex--;
            }
        }
    }
}

$ss = new SetOfStacks();
$ss->push(1);
$ss->push(2);
$ss->push(3);
$ss->push(4);
$ss->push(5);
$ss->push(6);
$ss->push(7);
$ss->push(8);
$ss->push(9);
$ss->push(10);
$ss->push(11);
$ss->printStacks();
$ss->pop();
$ss->printStacks();
$ss->popAt(0);
$ss->printStacks();