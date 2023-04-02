<?php

/**
 * Write an algorithm that returns the number of terminal nodes in a binary tree.
 */
include "binary_tree.php";

function terminalNodes($node) {
    if (empty($node)) {
        return 0;
    }
    $count = 0;
    terminalNodeCount($node, $count);
    return $count;
}

function terminalNodeCount($node, &$count) {
    if (empty($node)) {
        return;
    }
    if (isTerminalNode($node)) {
        $count++;
    }
    terminalNodeCount($node->left, $count);
    terminalNodeCount($node->right, $count);
}

function isTerminalNode($node) {
    if (empty($node->left) && empty($node->right)) {
        return true;
    }
    return false;
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

echo "Terminal nodes: " . terminalNodes($root) . PHP_EOL;