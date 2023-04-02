<?php

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes
 * in a binary tree. Avoid storing additional nodes in a data structure. NOTE:
 * This is not necessarily a binary search tree.
 */

/**
 * The first common ancestor is the deepest node that has 1st node on its left, 
 * 2nd node on its right. vice versa. So we basically need to find the node where
 * 1 node found on left and other node found on right.
 * we can use an aux function, inTree() to help us search. return true if node is
 * found, return false if not found.
 */

/**
 * Assuming no parent pointers.
 * Time: O(n)
 * Space: O(1)
 */
function firstCommonAncestor($root, $node1, $node2) {
    if (empty($root) || $root == $node1 || $root == $node2) {
        return $root;
    }
    if (inTree($root, $node1) && inTree($root, $node2)) {
        if (inTree($root->left, $node1) && inTree($root->right, $node2)) {
            return $root;
        } elseif (inTree($root->left, $node1) && inTree($root->left, $node2)) {
            return firstCommonAncestor($root->left, $node1, $node2);
        } elseif (inTree($root->right, $node1) && inTree($root->right, $node2)) {
            return firstCommonAncestor($root->right, $node1, $node2);
        }
    } elseif (inTree($root, $node1)) {
        return $node1;
    } elseif (inTree($root, $node2)) {
        return $node2;
    } else {
        return;
    }
}

function inTree($root, $node) {
    if (empty($root) || empty($node)) {
        return False;
    }
    if ($root == $node) {
        return True;
    } 
    if (!empty($root->left)) {
        return inTree($root->left, $node);
    }
    if (!empty($root->right)) {
        return inTree($root->right, $node);
    }
}