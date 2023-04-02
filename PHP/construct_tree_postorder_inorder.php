<?php

// Construct Tree from given Inorder and Preorder traversals
// Let us consider the below traversals:

// Inorder sequence  : D B E A F C
// Postorder sequence: D E B F C A


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

function buildTree($postOrder, $inOrder, &$postIndex, $inStart, $inEnd) {
    if ($inStart > $inEnd) {
        return;
    }
    $node = new Node($postOrder[$postIndex]);
    $postIndex--;

    // node with no children, so just return node
    if ($inStart == $inEnd) {
        return $node;
    }
    // find the inorderIndex of this node data
    $inIndex = search($inOrder, $inStart, $inEnd, $node->data);

    // populate right child first then left child
    $node->right = buildTree($postOrder, $inOrder, $postIndex, $inIndex+1, $inEnd);
    $node->left = buildTree($postOrder, $inOrder, $postIndex, $inStart, $inIndex-1);
    return $node;
}

function search($inOrder, $start, $end, $value) {
    for ($i=$start; $i <=$end ; $i++) { 
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

function postOrder($root) {
    if (empty($root)) {
        return;
    }
    postOrder($root->left);
    postOrder($root->right);
    echo $root->data . " ";
}

$inOrderSequence = ["D", "B", "E", "A", "F", "C"];
$postOrderSequence = ["D", "E", "B", "F", "C", "A"];

$postIndex = sizeof($postOrderSequence) - 1;
$root = buildTree($postOrderSequence, $inOrderSequence, $postIndex, 0, sizeof($inOrderSequence)-1);

inOrder($root);
echo PHP_EOL;
preOrder($root);
echo PHP_EOL;
postOrder($root);
echo PHP_EOL;