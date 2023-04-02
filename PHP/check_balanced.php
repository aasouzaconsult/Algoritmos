<?php

/**
 * Implement a function to check if a binary tree is balanced. For the purposes
 * of this question, a balanced tree is defined to be a tree such that the heights
 * of the two subtrees of any node never differ by more than one.
 */

/**
 * For each node in the tree, get the left and right height and if their height
 * differ by more than 1, return false. If none of such cases found return True.
 * Note: an empty tree is also considered balanced.
 * 
 * Time: O(n^2lgn)
 * Space: O(n^2)
 */
function isBalanced($root) {
    if (empty($root)) {
        return True;
    }
    $left = getHeight($root->left);
    $right = getHeight($root->right);
    if (abs($left - $right) > 1) {
        return False;
    } else {
        $checkLeft = isBalanced($root->left);
        $checkRight = isBalanced($root->right);
        if (!$checkLeft || !$checkRight) {
            return False;
        }
    }
    return True;
}

function getHeight($node) {
    if (empty($node)) {
        return 0;
    }
    $left = getHeight($node->left) + 1;
    $right = getHeight($node->right) + 1;
    return 1 + max($left, $right);
}