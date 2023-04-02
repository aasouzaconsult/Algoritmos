<?php

class SetUnion {
    private $parent;
    private $elementSize;
    private $unionSize;

    public function __construct($unionSize) {
        $this->unionSize = $unionSize;
        $this->parent = [];
        $this->elementSize = [];
        for ($i=0; $i < $unionSize; $i++) { 
            $this->parent[] = $i;
            $this->elementSize[] = 1;
        }
    }

    public function printUnion() {
        echo "====================" . PHP_EOL;
        echo implode(" ", $this->parent) . PHP_EOL;
        echo implode(" ", $this->elementSize) . PHP_EOL;
    }

    /**
     * Given index value, find the root parent of this index.
     */
    public function findRoot($index) {
        if ($this->parent[$index] == $index) {
            return $this->parent[$index];
        } else {
            return $this->findRoot($this->parent[$index]);
        }
    }

    /**
     * Join 2 sets together.
     */
    public function unionSets($index1, $index2) {
        // find root of both indexes
        $root1 = $this->findRoot($index1);
        $root2 = $this->findRoot($index2);
        // handle condition where both index are already in same set
        if ($root1 == $root2) {
            return False;
        }

        if ($this->elementSize[$root1] >= $this->elementSize[$root2]) {
            $this->elementSize[$root1] += $this->elementSize[$root2];
            $this->parent[$root2] = $root1;
        } else {
            $this->elementSize[$root2] += $this->elementSize[$root1];
            $this->parent[$root1] = $root2;
        }
        return True;
    }

    /**
     * Check if 2 indexes belong to the same component.
     * return true if same component, false otherwise.
     */
    public function sameComponent($index1, $index2) {
        return ($this->findRoot($index1) == $this->findRoot($index2));
    }

    public function getParents() {
        return $this->parent;
    }

    public function getSize() {
        return $this->elementSize;
    }
}

// $setUnion = new SetUnion(9);
// $setUnion->printUnion();
// $setUnion->unionSets(6,7);
// $setUnion->printUnion();
// $setUnion->sameComponent(6,7);

// $setUnion->printUnion();
// $setUnion->sameComponent(6,5);
// $setUnion->unionSets(6,5);
// $setUnion->printUnion();

// $setUnion->unionSets(0,1);
// $setUnion->printUnion();

// $setUnion->unionSets(2,8);
// $setUnion->printUnion();

// $setUnion->unionSets(5,2);
// $setUnion->printUnion();

// $setUnion->unionSets(1,2);
// $setUnion->printUnion();

// $setUnion->unionSets(3,4);
// $setUnion->printUnion();

// $setUnion->unionSets(5,4);
// $setUnion->printUnion();