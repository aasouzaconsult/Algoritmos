<?php

include "binary_search_tree_4.php";

function binaryTreePaths($root) {
    $paths = array_fill(0, 20, 0);
    $pathLen = 0;
    binaryTreePathsRecur($root, $paths, $pathLen);
}

function binaryTreePathsRecur($node, &$paths, $pathLen) {
    if (empty($node)) {
        return;
    }
    $paths[$pathLen] = $node->data;
    $pathLen++;
    if (empty($node->left) && empty($node->right)) {
        echo array_sum($paths) . PHP_EOL;
    } else {
        binaryTreePathsRecur($node->left, $paths, $pathLen);
        binaryTreePathsRecur($node->right, $paths, $pathLen);
    }
}

$bst2 = new BinarySearchTree(8);
$root2 = $bst2->getRoot();
$bst2->insert(3);
$bst2->insert(10);
$bst2->insert(1);
$bst2->insert(6);
$bst2->insert(4);
$bst2->insert(7);
$bst2->insert(14);
$bst2->insert(13);
binaryTreePaths($root2);