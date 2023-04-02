<?php

/**
 * T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create
 * an algorithm to determine if T2 is a subtree of T1.
 *
 * A tree T2 is a subtree of T1 if there exists a node in T1 such that the subtree of n
 * is identical to T2. That is, if you cut off the tree at node n, the two trees would
 * be identical.
 */

/**
 * Check if tree1($root2) is a subtree of tree1($root1).
 * Return True if yes, else False.
 * Time: O(n+m) where n is size of root1, m is size of root2
 * Space: O(n+m)
 */
function isSubtree($root1, $root2) {
    $s1 = "";
    $s2 = "";

    getOrderString($root1, $s1);
    getOrderString($root2, $s2);

    $pos = strpos($s1, $s2);
    if ($pos >= 0) {
        return True;
    }
    return False;
}

function getOrderString($node, &$str) {
    if (empty($node)) {
        $str .= "X";
    }
    $str .= $node->data . " ";
    getOrderString($node->left, $str);
    getOrderString($node->right, $str);
}

/**
 * We can do better by reducing the Space complexity above.
 * We run node by node check for t2 nodes in t1 each time the root matches.
 * So this can be called k times, where k is the number of times t2 root occurs in t1.
 * Time: O(n+km) where k is the number of occurrences of root2 data in root1
 * Space: O(lgn + lgm)
 */
function isSubtree($root1, $root2) {
    if (empty($root2)) {
        return True;
    }
    return subTree($root1, $root2);
}

function subTree($root1, $root2) {
    if (empty($root1)) {
        return False;
    }
    if ($root1->data == $root2->data && matchTree($root1, $root2)) {
        return True;
    }
    return subTree($root->left, $root2) || subTree($root->right, $root2);
}

function matchTree($root1, $root2) {
    if (empty($root1) && empty($root2)) {
        return True;
    } elseif (empty($root1) || empty($root2)) {
        return False;
    } elseif ($root1->data !== $root2->data) {
        return False;
    } else {
        return matchTree($root1->left, $root2->left) || matchTree($root1->left, $root2->left);
    }
}