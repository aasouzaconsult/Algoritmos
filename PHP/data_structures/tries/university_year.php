<?php

/**
 * Using a Trie data structure, we want to store the university and the year it was built.
 *
 * Operations:
 * - init() - initialize a trie data structure
 * - insert(year, schoolname) - insert a new school into the trie
 * - search($year) - check if this year has a school in trie. if exists, return true, else return false.
 * - getSchool($year) - given a year, return the school name if it exists in the trie.
 *
 * Note: Normally a hashtable with key as year and value as schoolname will be pretty
 * optimal as lookup is O(1). For practice purposes, we will use a trie DS instead.
 */

class Node {
    public $data;
    public $pointers;

    public function __construct($data=NULL) {
        $this->data = $data;
        $this->pointers = array_fill(0, 10, NULL);
    }
}

class UniversityYear {
    private $root;

    public function __construct($data=NULL) {
        $this->root = new Node($data);
    }

    public function insert($year, $school) {
        if (empty($year) || empty($school)) {
            return False;
        }
        // extract year digits for trie traversing
        $yearDigits = $this->getYearDigits($year);
        // set traverse pointer start from root
        // traverse through the digits
        //     for each digit, check if current node pointer digit is filled
        //     if pointer digit is filled, advance with this pointer
        //     else 
        //         add a new node and set this pointer digit to node.
        //         advance next with this node
        // after traversal, set current node data to the school name if the node data is null.
        // return true
        $curr = $this->root;
        foreach ($yearDigits as $value) {
            if (empty($curr->pointers[$value])) {
                $newNode = new Node();
                $curr->pointers[$value] = $newNode;
                $curr = $newNode;
            } else {
                $curr = $curr->pointers[$value];
            }
        }
        if (empty($curr->data)) {
            $curr->data = $school;
        } elseif ($curr->data !== $school) {
            return False;
        }
        return True;
    }

    public function search($year) {
        // extract year digits for trie traversing
        $yearDigits = $this->getYearDigits($year);
        $curr = $this->root;

        foreach ($yearDigits as $value) {
            if (!empty($curr->pointers[$value])) {
                $curr = $curr->pointers[$value];
            } else {
                return False;
            }
        }
        return True;
    }

    public function getSchool($year) {
        // extract year digits for trie traversing
        $yearDigits = $this->getYearDigits($year);
        $curr = $this->root;

        foreach ($yearDigits as $value) {
            if (!empty($curr->pointers[$value])) {
                $curr = $curr->pointers[$value];
            } else {
                return NULL;
            }
        }
        return $curr->data;
    }

    /**
     * Given a year in integer type, convert to an array of integers from left to right.
     * For example:
     * $year = 1948;
     * $returnValue = [1,9,4,8];
     */
    private function getYearDigits($year) {
        if (empty($year)) {
            return [];
        }
        $result = [];
        $pivot = 10;
        while ($year > 0) {
            array_unshift($result, $year % $pivot);
            $year = (int) ($year / $pivot);
        }
        return $result;
    }
}

$uy = new UniversityYear();
$uy->insert(1958, 'harvard');
$uy->insert(1701, 'yale');
$uy->insert(1769, 'dartmouth');

echo $uy->getSchool(1958) . PHP_EOL;
echo $uy->getSchool(1701) . PHP_EOL;
echo $uy->getSchool(1769) . PHP_EOL;