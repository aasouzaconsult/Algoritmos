<?php

/**
 * Write a linear-time algorithm that swaps te left and right children of each
 * node in a binary tree.
 */

include "binary_tree.php";

function invertBinaryTree(&$root) {
    if (empty($root)) {
        return $root;
    }
    // traverse in level order
    $queue = [];
    $queue[] = $root;

    while (!empty($queue)) {
        $curr = array_shift($queue);
        swap($curr);
        if (!empty($curr->left)) {
            $queue[] = $curr->left;
        }
        if (!empty($curr->right)) {
            $queue[] = $curr->right;
        }
    }
    return $root;
}

function swap(&$node) {
    $temp = $node->left;
    $node->left = $node->right;
    $node->right = $temp;
}

function levelOrderTraverse($root) {
    $queue = [];
    $queue[] = $root;

    while (!empty($queue)) {
        $curr = array_shift($queue);
        echo "{$curr->data} ";
        if (!empty($curr->left)) {
            $queue[] = $curr->left;
        }
        if (!empty($curr->right)) {
            $queue[] = $curr->right;
        }
    }
    echo PHP_EOL;
}

$tree = new BinaryTree(1);
$root = $tree->getRoot();

$root->left = new Node(2);
$node2 = $root->left;
$root->right = new Node(3);
$node3 = $root->right;

$node2->right = new Node(4);

$node3->left = new Node(5);
$node5 = $node3->left;
$node5->left = new Node(6);
$node5->right = new Node(7);

echo $tree->nodeCount($root);
echo PHP_EOL;
echo "preorder traversal: " ;
$tree->preorder($root);
echo PHP_EOL;
echo "inorder traversal: ";
$tree->inorder($root);
echo PHP_EOL;
echo "postorder traversal: ";
$tree->postorder($root);
echo PHP_EOL;
invertBinaryTree($root);
echo "================" . PHP_EOL;
echo "preorder traversal: " ;
$tree->preorder($root);
echo PHP_EOL;
echo "inorder traversal: ";
$tree->inorder($root);
echo PHP_EOL;
echo "postorder traversal: ";
$tree->postorder($root);
echo PHP_EOL;