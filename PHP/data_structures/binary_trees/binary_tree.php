<?php

/**
 * Implementation of binary tree.
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

    public function __construct($data) {
        $this->root = new Node($data);
    }

    public function getRoot() {
        return $this->root;
    }

    public function preorder($node) {
        if (empty($node)) {
            return;
        }
        echo $node->data . " ";
        $this->preorder($node->left);
        $this->preorder($node->right);
    }

    public function inorder($node) {
        if (empty($node)) {
            return;
        }
        $this->inorder($node->left);
        echo $node->data . " ";
        $this->inorder($node->right);
    }

    public function postorder($node) {
        if (empty($node)) {
            return;
        }
        $this->postorder($node->left);
        $this->postorder($node->right);
        echo $node->data . " ";
    }

    public function nodeCount($node) {
        if (empty($node)) {
            return 0;
        }
        return 1 + $this->nodeCount($node->left) + $this->nodeCount($node->right);
    }
}

// $tree = new BinaryTree(1);
// $root = $tree->getRoot();

// $root->left = new Node(2);
// $node2 = $root->left;
// $root->right = new Node(3);
// $node3 = $root->right;

// $node2->right = new Node(4);

// $node3->left = new Node(5);
// $node5 = $node3->left;
// $node5->left = new Node(6);
// $node5->right = new Node(7);

// echo $tree->nodeCount($root);
// echo PHP_EOL;
// echo "preorder traversal: " ;
// $tree->preorder($root);
// echo PHP_EOL;
// echo "inorder traversal: ";
// $tree->inorder($root);
// echo PHP_EOL;
// echo "postorder traversal: ";
// $tree->postorder($root);
// echo PHP_EOL;