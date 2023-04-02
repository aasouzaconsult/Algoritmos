<?php

/**
 * You are implementing a binary tree class from scratch which, in addition to insert,
 * find, and delete, has a method getRandomNode() which returns a random node from
 * the tree. All nodes should be equally likely to be chosen. Design and implement an
 * algorithm to getRandomNode, and explain how you would implement the rest of the methods.
 */

class Node {
    public $data;
    public $left;
    public $right;

    public function __construct($data, $left=NULL, $right=NULL) {
        $this->data = $data;
        $this->left = $left;
        $this->right = $right;
    }
}

class BinaryTree {
    private $root;

    public function __construct($data, $left=NULL, $right=NULL) {
        $this->root = new Node($data, $left, $right);
        $this->nodeCount = 1;
    }

    public function insert($data) {
        // set as root if its empty
        if (empty($this->root)) {
            $this->root->data = $data;
            return;
        }
        $newNode = new Node($data);
        $queue = [$this->root];
        while (!empty($queue)) {
            $node = array_shift($queue);
            if (empty($node->left)) {
                $node->left = $newNode;
                break;
            } else {
                $queue[] = $node->left;
            }
            if (empty($node->right)) {
                $node->right = $newNode;
                break;
            } else {
                $queue[] = $node->right;
            }
        }
        $this->nodeCount++;
        return;
    }

    public function find($data) {
        if (empty($this->root)) {
            return;
        }
        $queue = [$this->root];
        while (!empty($queue)) {
            $node = array_shift($queue);
            if ($node->data == $data) {
                return $node;
            }
            if (!empty($node->left)) {
                $queue[] = $node->left;
            }
            if (!empty($node->right)) {
                $queue[] = $node->right;
            }
        }
        return;
    }

    private function getParentNode($node) {
        if (empty($node) || $this->root == $node) {
            return;
        }
        $queue = [$this->root];
        while (!empty($queue)) {
            $curr = array_shift($queue);            
            if (!empty($node->left)) {
                if ($curr->left == $node) {
                    return $curr;
                } else {
                    $queue[] = $curr->left;
                }
            }
            if (!empty($node->right)) {
                if ($curr->right == $node) {
                    return $curr;
                } else {
                    $queue[] = $curr->right;
                }
            }
        }
        return;
    }

    public function delete($data) {
        $node = $this->find($data);
        if (empty($node)) {
            return False;
        }
        $parent = $this->getParentNode($node);
        // case 0: 0 children
        // case 1: 1 children
        if (empty($node->left) || empty($node->right)) {
            $this->replace($parent, $node);
        } else {
            // case 2: 2 children
            $currParent = $node;
            $curr = $node->right;
            while (!empty($curr->left)) {
                $currParent = $curr;
                $curr = $curr->left;
            }
            $node->data = $curr->data;
            $this->replace($currParent, $curr);
        }
        $this->nodeCount--;
    }

    public function replace(&$parent, &$node) {
        if (empty($node->left)) {
            $child = $node->right;
        } else {
            $child = $node->left;
        }
        if ($node == $this->root) {
            $this->root = $child;
            return $this->root;
        } else {
            if ($parent->left == $node) {
                $parent->left = $child;
            } else {
                $parent->right = $child;
            }
        }
        return $this->root;
    }

    /**
     * Returns a random node based on the random integer generated.
     * Time: O(n)
     * Space:O(1)
     */
    public function getRandomNode() {
        if (empty($this->root)) {
            return;
        }
        $randInt = rand(0, $this->nodeCount-1);
        echo $randInt . PHP_EOL;
        return $this->getRandomNodeHelper($this->root, $randInt);
    }

    private function getRandomNodeHelper($node, &$number) {
        if (empty($node)) {
            return;
        }
        if ($number == 0) {
            return $node;
        } else {
            $number--;
        }
        $left = $this->getRandomNodeHelper($node->left, $number);
        $right = $this->getRandomNodeHelper($node->right, $number);
        if (empty($left)) {
            return $right;
        }
        return $left;
    }

    public function preorder($node, $callback) {
        if (empty($node)) {
            return;
        }
        $this->$callback($node);
        $this->preorder($node->left, $callback);
        $this->preorder($node->right, $callback);
    }

    public function inorder($node, $callback) {
        if (empty($node)) {
            return;
        }
        $this->inorder($node->left, $callback);
        $this->$callback($node);
        $this->inorder($node->right, $callback);    
    }

    public function postorder($node, $callback) {
        if (empty($node)) {
            return;
        }
        $this->postorder($node->left, $callback);
        $this->postorder($node->right, $callback);
        $this->$callback($node);
    }

    public function printNode($node) {
        if (empty($node)) {
            return;
        }
        echo $node->data . " ";
    }

    public function getRoot() {
        return $this->root;
    }

}

// $bt = new BinaryTree(1);
// $bt->insert(2);
// $bt->insert(3);
// $bt->insert(4);
// $bt->insert(5);
// $bt->insert(6);

// $root = $bt->getRoot();
// $bt->preorder($root, 'printNode');
// echo PHP_EOL;
// $bt->inorder($root, 'printNode');
// echo PHP_EOL;
// $bt->postorder($root, 'printNode');
// echo PHP_EOL;

// echo $bt->getRandomNode()->data . PHP_EOL;
