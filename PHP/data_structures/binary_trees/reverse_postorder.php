<?php

/**
 * The following algorithm prints node data in reverse post order.
 */

include "binary_tree.php";

function reversePostOrder($root) {
    if (!empty($root)) {
        echo "{$root->data} ";
        reversePostOrder($root->right);
        reversePostOrder($root->left);
    }
}

function reversePreOrder($root) {
    if (!empty($root)) {
        reversePreOrder($root->right);
        reversePreOrder($root->left);
        echo "{$root->data} ";
    }
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
echo "reverse postorder  : ";
reversePostOrder($root);
echo PHP_EOL;
echo "reverse preorder  : ";
reversePreOrder($root);
echo PHP_EOL;