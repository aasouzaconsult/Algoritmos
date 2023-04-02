<?php

/**
 * Write an algorithm to find the "next" node(ie. in-order successor) of a given
 * node in a binary search tree. You may assume that each node has a link to its
 * parent.
 */

/**
 * 3 cases we should consider:
 * 
 * 1. node is leaf node, node is a left child
 * successor: parent of node
 *
 * 2. node is NOT leaf node. node has right child
 * successor: get leftmost of right children
 *
 * 3. node is leaf node, node is a right child
 * successor: traverse up the parents until parent node is left child of grandparent,
 * return the grandparent
 *
 * Time: O(lgn)
 * Space: O(1)
 */
function successor($node) {
    if (empty($node)) {
        return;
    }
    if (empty($node->left) && empty($node->right)) {
        if ($node->parent->left == $node) {
            return $node->parent;
        } else {
            $trav = $node->parent;
            while ($trav == $trav->parent->right) {
                $trav = $trav->parent;
            }
            return $trav->parent;
        }
    } elseif (!empty($node->right)) {
        $trav = $node->right;
        while (!empty($trav->left)) {
            $trav = $trav->left;
        }
        return $trav;
    }
}