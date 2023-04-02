<?php

/**
 * Print a binary expression tree with parentesis.
 */

include "binary_tree.php";

function printExpressionTree($root) {
    if (empty($root)) {
        return;
    }
    if (isLeafNode($root)) {
        echo $root->data . " ";
    } else {
        echo "( ";
        printExpressionTree($root->left);
        echo $root->data . " ";
        printExpressionTree($root->right);
        echo " )";
    }
}

function isLeafNode($node) {
    if (empty($node->left) && empty($node->right)) {
        return true;
    }
    return false;
}

$tree = new BinaryTree('*');
$root = $tree->getRoot();

$root->left = new Node('+');
$node2 = $root->left;
$root->right = new Node('-');
$node3 = $root->right;

$node2->left = new Node(3);
$node2->right = new Node(1);

$node3->left = new Node(4);
$node3->right = new Node(5);

$tree->inorder($root);
echo PHP_EOL;

printExpressionTree($root);
echo PHP_EOL;