<?php

/**
 * Implementation of a basic binary tree
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
    }

    public function insertLeft(&$parent, $data) {
        if (empty($parent)) {
            return;
        }
        $newNode = new Node($data);
        $parent->left = $newnode;
        return $this->root;
    }

    public function insertRight(&$parent, $data) {
        if (empty($parent)) {
            return;
        }
        $newNode = new Node($data);
        $parent->right = $newNode;
        return $this->root;
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

    public function levelorder($node, $callback) {
        if (empty($node)) {
            return;
        }
        $queue = [$node];

        while (!empty($queue)) {
            $curr = array_shift($queue);
            $this->$callback($curr);
            if (!empty($curr->left)) {
                $queue[] = $curr->left;
            }
            if (!empty($curr->right)) {
                $queue[] = $curr->right;
            }
        }
        return;
    }
}