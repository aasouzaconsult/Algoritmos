<?php

/**
 * Validate BST.
 * Given the root of a binary tree, check if this tree is a binary search tree.
 */

/**
 * Binary search tree has the following properties:
 * - every key in left subtree is less than or equal to the node value
 * - every key in right subtree is more than the node value
 * Time: O(n)
 * Space: O(n). if its a balanced tree, space is O(lgn)
 */
function isBst($root) {
    $result = True;
    isBstHelper($root, PHP_INT_MIN, PHP_INT_MAX, $result);
    return $result;
}

function isBstHelper($node, $min, $max, &$result) {
    if (empty($node)) {
        return;
    }
    if ($node->data < $min || $node->data > $max) {
        $result = False;
        return;
    }
    isBstHelper($node->left, $min, $node->data, $result);
    isBstHelper($node->right, $node->data, $max, $result);
}

/**
 * In order traversal method. The method works if there's no duplicate values.
 * Time: O(n)
 * Space: O(n)
 */
function isBst($root) {
    $values = [];
    copyBst($root, $values);
    for ($i=1; $i < sizeof($values); $i++) { 
        if ($values[$i-1] >= $values[$i]) {
            return False;
        }
    }
    return True;
}

function copyBst($node, &$values) {
    if (empty($node)) {
        return;
    }
    copyBst($node->left, $values);
    $values[] = $node->data;
    copyBst($node->right, $values);
}

/**
 * In-order traversal method can be optimized by getting rid of the array that
 * holds all the values. We only need to compare the current value with the previous
 * value.
 * Time: O(n)
 * Space: O(n)
 */
function isBst($root) {
    $last = NULL;
    $isBst = True;
    checkBst($root, $last, &$isBst);
    return $isBst;
}

function checkBst($node, $last, $isBst) {
    if (empty($node)) {
        return;
    }
    checkBst($node->left, $last, $isBst);
    if (!empty($last) && $node->data <= $last) {
        $isBst = False;
        return;
    }
    $last = $node->data;
    checkBst($node->right, $last, $isBst);
    return;
}