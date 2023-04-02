<?php

/**
 * https://www.hackerrank.com/challenges/tree-top-view
 * 
 */

include "binary_tree.php";

function topView($root) {
    if (empty($root)) {
        return;
    }
    $leftNodes = [];
    $curr = $root;
    while (!empty($curr)) {
        $leftNodes[] = $curr->data;
        $curr = $curr->left;
    }

    $rightNodes = [];
    $curr = $root->right;
    while (!empty($curr)) {
        $rightNodes[] = $curr->data;
        $curr = $curr->right;
    }
    while (!empty($leftNodes)) {
        echo array_pop($leftNodes) . " ";
    }
    while (!empty($rightNodes)) {
        echo array_shift($rightNodes) . " ";
    }
    return;
}

$tree = new BinaryTree(3);
$root = $tree->getRoot();

$root->left = new Node(5);
$node2 = $root->left;
$root->right = new Node(2);
$node3 = $root->right;

$node2->left = new Node(1);
$node2->right = new Node(4);

$node3->left = new Node(6);
$node3->right = new Node(7);

$node4 = $node3->right;
$node4->left = new Node(8);

$node5 = $node2->left;
$node5->right = new Node(9);

echo "preorder traversal: " ;
$tree->preorder($root);
echo PHP_EOL;
echo "inorder traversal: ";
$tree->inorder($root);
echo PHP_EOL;
echo "postorder traversal: ";
$tree->postorder($root);
echo PHP_EOL;
topView($root);
echo PHP_EOL;