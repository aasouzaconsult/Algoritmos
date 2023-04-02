<?php

/**
 * Given a sorted(increasing order) array with unique integer elements, write an
 * algorithm to create a binary search tree with minimal height.
 * Minimal tree: a binary search tree with the height being Log(n+1)-1. O(lgn)
 * Binary search tree: value less than root to left, value equal/more than root to right
 * 
 */

include "../../../data_structures/binary_trees/binary_search_tree_4.php";

/**
 * Based on a version of mergesort. repeatedly put the middle of the shorter array
 * into the binary search tree.
 * Time: O(lgn)
 * Space: O(1)
 */
function constructBst(&$tree, $arr) {
    if (empty($arr)) {
        return;
    }
    _constructBst($tree, $arr, 0, sizeof($arr)-1);
}

function _constructBst(&$tree, $arr, $start, $end) {
    if ($start > $end) {
        return;
    }
    $mid = floor(($start + $end)/2);
    $root = $tree->getRoot();
    if (empty($root->data)) {
        $root->data = $arr[$mid];
    } else {
        insert($root, $arr[$mid]);
    }
    _constructBst($tree, $arr, $start, $mid-1);
    _constructBst($tree, $arr, $mid+1, $end);
}

function insert(&$root, $data) {
    $node = new Node($data);
    insertNode($root, $node);
}

function insertNode(&$root, $node) {
    if ($node->data < $root->data) {
        // left
        if (empty($root->left)) {
            $root->left = $node;
        } else {
            insertNode($root->left, $node);
        }
    } else {
        // right
        if (empty($root->right)) {
            $root->right = $node;
        } else {
            insertNode($root->right, $node);
        }
    }
}

$bst = new BinarySearchTree(NULL);
$arr1 = [1,3,4,5,6,7,8,9];

constructBst($bst, $arr1);
$root = $bst->getRoot();

// $bst->preorder($root, 'printData');
// echo PHP_EOL;
// $bst->inorder($root, 'printData');
// echo PHP_EOL;
// $bst->postorder($root, 'printData');
// echo PHP_EOL;