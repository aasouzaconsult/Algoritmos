<?php

// Construct Tree from given Inorder and Preorder traversals
// Let us consider the below traversals:

// Inorder sequence: D B E A F C
// Preorder sequence: A B D E C F

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

function buildTree($preOrder, $inOrder, &$preIndex, $inStart, $inEnd) {
    if ($inStart > $inEnd) {
        return;
    }
    $node = new Node($preOrder[$preIndex]);
    $preIndex++;

    // if this node has no children then return the node
    if ($inStart == $inEnd) {
        return $node;
    }
    // else find the index of this node in inorder traversal
    $inIndex = searchIndex($inOrder, $inStart, $inEnd, $node->data);

    // using inIndex in inorder traversal, construct left and right subtrees
    $node->left = buildTree($preOrder, $inOrder, $preIndex, $inStart, $inIndex-1);
    $node->right = buildTree($preOrder, $inOrder, $preIndex, $inIndex+1, $inEnd);
    return $node;
}

function searchIndex($inOrder, $start, $end, $value) {
    for ($i=$start; $i <= $end ; $i++) { 
        if ($inOrder[$i] == $value) {
            return $i;
        }
    }
}

function inOrder($root) {
    if (empty($root)) {
        return;
    }
    inOrder($root->left);
    echo $root->data . " ";
    inOrder($root->right);
}

function preOrder($root) {
    if (empty($root)) {
        return;
    }
    echo $root->data . " ";
    preOrder($root->left);
    preOrder($root->right);
}

$inOrderSequence = ["D", "B", "E", "A", "F", "C"];
$preOrderSequence = ["A", "B", "D", "E", "C", "F"];

$preIndex = 0;
$root = buildTree($preOrderSequence, $inOrderSequence, $preIndex, 0, sizeof($inOrderSequence)-1);

inOrder($root);
echo PHP_EOL;
preOrder($root);
echo PHP_EOL;