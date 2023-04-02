<?php

/**
 * https://www.hackerrank.com/challenges/binary-search-tree-insertion
 * Implementing insertion into a binary search tree.
 */

function insert(&$root, $data) {
    $node = new Node($data);
    if (empty($root)) {
        $root = $node;
    }
    insertNode($root, $node);
    return $root;
}

function insertNode(&$root, &$node) {
    if ($node->data < $root->data) {
        if (empty($root->left)) {
            $root->left = $node;
        } else {
            insertNode($root->left, $node);
        }
    } else {
        if (empty($root->right)) {
            $root->right = $node;
        } else {
            insertNode($root->right, $node);
        }
    }
}