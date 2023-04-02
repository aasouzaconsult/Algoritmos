<?php

/**
 * For a given binary tree, assign the sibling pointer of each node. A sibling is
 * always to its immediate right on the same level of the tree.
 */

/**
 * BFS to set siblings.
 * Time: O(N) where n is the number of nodes in tree
 * Space: O(1)
 *
 */
function assignSiblings($root) {
    if (empty($root)) {
        return;
    }
    // use a sibling pointer to maintain previous sibling
    $leftSibling = NULL;
    $height = 0;
    $queue = [[$height, $root]];

    while (!empty($queue)) {
        $package = array_shift($queue);
        list($height, $node) = $package;
        if (!empty($leftSibling) && $leftSibling[0] == $height) {
            $leftSibling[1]->sibling = $node;
        }
        // queue up left and right nodes if present
        if (!empty($node->left)) {
            $queue[] = [$height+1, $node->left];
        }
        if (!empty($node->right)) {
            $queue[] = [$height+1, $node->right];
        }
        // set left sibling to this new package
        $leftSibling = $package;
    }
    return $root;
}