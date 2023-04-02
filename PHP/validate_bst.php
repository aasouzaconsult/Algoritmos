<?php

/**
 * Impement a function to check if a binary tree is a binary search tree.
 */

/**
 * Level order traversal through each node and check if node left is less than node,
 * node right is more than node. if any of such check fails, its not a binary search
 * tree. return false. If none of the check fails, tree is a binary search tree.
 * Time: O(n) where n is number of nodes
 * Space: O(n) to store n nodes.
 */
function isBinarySearchTree($tree) {
    $curr = $tree->getRoot();
    if (empty($curr)) {
        return False;
    }
    $queue = [$curr];
    while (!empty($queue)) {
        $node = array_shift($queue);

        if (!empty($node->left)) {
            if ($node->left->data > $node->data) {
                return False;
            } else {
                $queue[] = $node->left;
            }
        }
        if (!empty($node->right)) {
            if ($node->right->data < $node->data) {
                return False;
            } else {
                $queue[] = $node->right;
            }
        }
    }
    return True;
}

/** Preorder traversal of node
 * Time: O(n)
 * Space: O(1)
 */
function isBinarySearchTree($tree) {
    $root = $tree->getRoot();
    return _isBinarySearchTree($root);
}

function _isBinarySearchTree($node) {
    if (empty($node)) {
        return True;
    }
    if (!empty($node->left)) {
        if ($node->left->data > $node->data) {
            return False;
        }
    }
    if (!empty($node->right)) {
        if ($node->right->data < $node->data) {
            return False;
        }
    }
    _isBinarySearchTree($node->left);
    _isBinarySearchTree($node->right);
}