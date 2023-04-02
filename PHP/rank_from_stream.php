<?php

/**
 * Imagine you are reading in a stream of integers. Periodically, you wish to be
 * able to look up the rank of number x (the number of values less than or equal
 * to x). Implement the data structures and algorithms to support these operations.
 * That is, implement the method 'track(int x)', which is called when each number
 * is generated, and the method 'getRankOfNumber(int x)', which returns the number
 * of values less than or equal to x(not including x itself).
 *
 * EXAMPLE
 * Stream(in order of appearance): 5, 1, 4, 4, 5, 9, 7, 13, 3
 *
 * getRankOfNumber(1) = 0
 * getRankOfNumber(3) = 1
 * getRankOfNumber(4) = 3
 */

include "../../../data_structures/binary_trees/binary_search_tree_4.php";
/**
 * Operations of a insertion sort can achieve this.
 */
class StreamRank {
    private $stream;
    private $bst;
    private $root;

    public function __construct($stream = []) {
        $this->stream = $stream;
        $this->bst = new BinarySearchTree(NULL);
        $this->root = $this->bst->getRoot();
    }

    public function getRoot() {
        return $this->root;
    }

    /**
     * Time to insert can be slow with array.
     * Can we insert faster? O(1) being optimal
     * Time: O(n^2)
     * 
     */
    public function track($value) {
        $this->stream[] = $value;
        if (sizeof($this->stream) == 1) {
            return;
        }
        for ($i=sizeof($this->stream)-1; $i > 0; $i--) { 
            if ($this->stream[$i] < $this->stream[$i-1]) {
                $this->swap($this->stream[$i], $this->stream[$i-1]);
            } else {
                break;
            }
        }
        // echo implode(" ", $this->stream) . PHP_EOL;
        return;
    }

    private function swap(&$value1, &$value2) {
        $temp = $value1;
        $value1 = $value2;
        $value2 = $temp;
    }

    /**
     * Time: O(lgn)
     * Space: O(n)
     *
     */
    public function trackV2($value) {
        if (empty($this->root->data)) {
            $this->root->data = $value;
            return;
        }
        $node = new Node($value);
        $this->insertNode($this->root, $node);
    }

    private function insertNode($root, $node) {
        if ($node->data < $root->data) {
            if (empty($root->left)) {
                $root->left = $node;
            } else {
                $this->insertNode($root->left, $node);
            }
        } else {
            if (empty($root->right)) {
                $root->right = $node;
            } else {
                $this->insertNode($root->right, $node);
            }
        }
        return;
    }

    /**
     * Time: O(n)
     * 
     */
    public function getRankOfNumberV2($value) {
        $count = -1;
        $this->inorder($this->root, $value, $count);
    }

    public function printInOrder($node) {
        if (empty($node)) {
            return;
        }
        $this->printInOrder($node->left);
        echo $node->data . " ";
        $this->printInOrder($node->right);
    }

    private function inorder($node, $value, &$count) {
        if (empty($node)) {
            return;
        }
        $this->inorder($node->left, $value, $count);
        $count++;
        if ($node->data == $value) {            
            echo $count;
            return;
        }
        $this->inorder($node->right, $value, $count);
    }

    /**
     * Time: O(lgn)
     *
     */
    public function getRankOfNumber($value) {
        return $this->binarySearch($this->stream, 0, sizeof($this->stream)-1, $value);
    }

    private function binarySearch($array, $start, $end, $value) {
        if ($start > $end) {
            return;
        }
        $mid = floor(($start + $end) / 2);
        if ($array[$mid] == $value) {
            return $mid;
        } elseif ($array[$mid] > $value) {
            return $this->binarySearch($array, $start, $mid-1, $value);
        } else {
            return $this->binarySearch($array, $mid+1, $end, $value);
        }
    }
}

$stream1 = [5, 1, 4, 4, 5, 9, 7, 13, 3];

$sr = new StreamRank();
$sr->track(5);
$sr->track(1);
$sr->track(4);
$sr->track(4);
$sr->track(5);
$sr->track(9);
$sr->track(7);
$sr->track(13);
$sr->track(3);

$sr->trackV2(5);
$sr->trackV2(1);
$sr->trackV2(4);
$sr->trackV2(4);
$sr->trackV2(5);
$sr->trackV2(9);
$sr->trackV2(7);
$sr->trackV2(13);
$sr->trackV2(3);

echo $sr->getRankOfNumber(1) . PHP_EOL;
echo $sr->getRankOfNumber(3) . PHP_EOL;
echo $sr->getRankOfNumber(4) . PHP_EOL;
echo $sr->getRankOfNumber(5) . PHP_EOL;

echo $sr->getRankOfNumberV2(1) . PHP_EOL;
echo $sr->getRankOfNumberV2(3) . PHP_EOL;
echo $sr->getRankOfNumberV2(4) . PHP_EOL;
echo $sr->getRankOfNumberV2(5) . PHP_EOL;
