<?php

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

class BinarySearchTree {
    private $root;

    public function __construct($data) {
        $this->root = new Node($data);
    }

    public function getRoot() {
        return $this->root;
    }

    public function insert($value) {
        $node = new Node($value);
        if (empty($this->root)) {
            $this->root = $node;
            return;
        }
        $this->insertNode($this->root, $node);
        return;
    }

    private function insertNode($node, $newNode) {
        if ($newNode->data < $node->data) {
            if (empty($node->left)) {
                $node->left = $newNode;
                return;
            } else {
                $this->insertNode($node->left, $newNode);
            }
        } else {
            if (empty($node->right)) {
                $node->right = $newNode;
                return;
            } else {
                $this->insertNode($node->right, $newNode);
            }
        }
    }

    public function findNode($node, $value) {
        if (empty($node)) {
            return;
        }
        if ($node->data == $value) {
            return $node;
        } elseif ($value < $node->data) {
            return $this->findNode($node->left, $value);
        } else {
            return $this->findNode($node->right, $value);
        }
    }

    public function delete($value) {
        $node = $this->findNode($this->root, $value);
        if (empty($node)) {
            return;
        }
        $parent = $this->findParentNode($this->root, $node);
        // case 0: 0 child
        // case 1: 1 child
        if (empty($node->left) || empty($node->right)) {
            if (empty($parent)) {
                $this->root = $node;
            } else {
                $this->replace($parent, $node);
            }            
        } else {
            // case 2: 2 child
            // find the right child left most node to swap with this node value
            // keep track of the parent
            $replaceParent = $node;
            $replace = $node->right;
            while (!empty($replace->left)) {
                $replaceParent = $replace;
                $replace = $replace->left;
            }
            $node->data = $replace->data;
            $this->replace($replaceParent, $replace);
        }
        return True;
    }

    private function replace($parent, $node) {
        if (empty($node->left)) {
            $replacement = $node->right;
        } else {
            $replacement = $node->left;
        }
        if ($parent->left == $node) {
            $parent->left = $replacement;
        } else {
            $parent->right = $replacement;
        }
        unset($node);
    }

    private function findParentNode($root, $node) {
        if ($root == $node || empty($root)) {
            return NULL;
        }
        if ($node->data < $root->data) {
            if ($root->left == $node) {
                return $root;
            } else {
                return $this->findParentNode($root->left, $node);
            }
        } else {
            if ($root->right == $node) {
                return $root;
            } else {
                return $this->findParentNode($root->right, $node);
            }
        }
    }

    public function getHeight() {
        return $this->getHeightRecur($this->root);
    }

    private function getHeightRecur($node) {
        if (empty($node->left) && empty($node->right)) {
            return 1;
        }
        return max($this->getHeightRecur($node->left), $this->getHeightRecur($node->right)) + 1;
    }

    public function getMax() {
        if (empty($this->root)) {
            return;
        }
        $curr = $this->root;
        while (!empty($curr->right)) {
            $curr = $curr->right;
        }
        return $curr->data;
    }

    public function getMin() {
        if (empty($this->root)) {
            return;
        }
        $curr = $this->root;
        while (!empty($curr->left)) {
            $curr = $curr->left;
        }
        return $curr->data;
    }

    public function preOrder($node) {
        if (empty($node)) {
            return;
        }
        echo $node->data . " ";
        $this->preOrder($node->left);
        $this->preOrder($node->right);
    }

    public function inOrder($node) {
        if (empty($node)) {
            return;
        }
        $this->inOrder($node->left);
        echo $node->data . " ";
        $this->inOrder($node->right);
    }

    public function postOrder($node) {
        if (empty($node)) {
            return;
        }
        $this->postOrder($node->left);
        $this->postOrder($node->right);
        echo $node->data . " ";
    }
}

$bst = new BinarySearchTree(8);
$bst->insert(3);
$bst->insert(10);
$bst->insert(1);
$bst->insert(6);
$bst->insert(4);
$bst->insert(7);
$bst->insert(14);
$bst->insert(13);
$root = $bst->getRoot();
$bst->delete(6);
$bst->preOrder($root);
echo PHP_EOL;
$bst->inOrder($root);
echo PHP_EOL;
$bst->postOrder($root);
echo PHP_EOL;
echo $bst->getHeight() . PHP_EOL;
echo $bst->getMax() . PHP_EOL;
echo $bst->getMin() . PHP_EOL;