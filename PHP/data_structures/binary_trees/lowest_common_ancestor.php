<?php

/**
 * https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor
 * You are given pointer to the root of the binary search tree and two values $value1
 * and $value2. You need to return the lowest common ancestor of both values in the
 * binary search tree.
 * Return the node representing the lowest common ancestor.
 * O(n^2)
 */
/**
 * Get path for each value. then compare each set of value to find the common node from
 * bottom up. 
 */
function lowestCommonAncestor($root, $value1, $value2) {
    if (empty($root)) {
        return;
    } else if ($root->data == $value1 || $root->data == $value2) {
        return;
    }
    $value1Path = getValuePath($root, $value1);
    $value2Path = getValuePath($root, $value2);

    for ($i=sizeof($value1Path)-1; $i >= 0; $i--) {
        for ($j=sizeof($value2Path)-1; $j >= 0; $j--) {
            if ($value2Path[$j]->data == $value1Path[$i]->data) {
                return $value2Path[$j];
            }
        }
    }
    return;
}

/**
 * Traverse through each node of the binary tree. For every node, assuming $value1 < $value2 of the following
 * condition can happen.
 * 1. $dataValue < $value1 < $value2
 *     move to the left node and repeat process
 * 2. $value1 < $value2 < $dataValue
 *     move to right node and repeat process
 * 3. $value1 < $dataValue < $value2
 *     $dataValue node is the lowest common ancestor.
 * Time complexity: O(lgn)
 */
function lowestCommonAncestorV2 ($root, $value1, $value2) {
    if (empty($root)) {
        return;
    }
    if ($value1 < $value2) {
        $smallerValue = $value1;
        $biggerValue = $value2;
    } else {
        $smallerValue = $value2;
        $biggerValue = $value1;
    }
    $curr = $root;
    while (!empty($curr)) {
        echo "value in question: " . $curr->data . PHP_EOL;
        if ($curr->data < $biggerValue &&
            $curr->data > $smallerValue) {
            return $curr;
        } else if ($biggerValue < $curr->data) {
            $curr = $curr->left;
        } else if ($smallerValue > $curr->data) {
            $curr = $curr->right;
        }
    }
    return;
}

function getValuePath(&$node, $value) {
    if (empty($node)) {
        return;
    }
    $valuePath = [];
    $curr = $node;
    while (!empty($curr)) {
        if ($curr->data == $value) {
            break;
        } else {
            $valuePath[] = $curr;
        }
        if ($value < $curr->data) {
            $curr = $curr->left;
        } else {
            $curr = $curr->right;
        }
    }
    return $valuePath;
}

function getValuePathRecursive(&$node, $value, &$container) {
    if (empty($node) || $node->data == $value) {
        return $container;
    }
    $container[] = $node;
    if ($value < $node->data) {
        getValuePathRecursive($node->left, $value, $container);
    } else {
        getValuePathRecursive($node->right, $value, $container);
    }
}