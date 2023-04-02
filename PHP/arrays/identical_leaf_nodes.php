<?php

#T1:
#
#    A
#  / | \
# B  C  D
#
#T2:
#
#    X
#  / | \
# M  C  Q
# |     |
# B     D
#
#Leaves of T1: BCD
#Leaves of T2: BCD

# write a function that determines whether the two trees have identical
# leaf nodes.
# left to right order
# max height = 10
# any number of childs

# Node class for node structure
# Tree class
# insertion
# L1 = [B,C,D]
# L2 = [B,C,D]
# L1 == L2 then True, otherwise False
# Time complexity = O(n)

function identicalLeafNodes($root1, $root2) {
    // inorder traversal of binary tree, if node is leaf node, put in array
    // compare if array are the same
    $leaves1 = getLeaves($root1);
    $leaves2 = getLeaves($root2);
    return $leaves1 == $leaves2;
}

function getLeaves($root) {
    $curr = $root;
    $leaves = [];
    $stack = [$curr];
    while (!empty($stack)) {
        $node = array_pop($stack);
        if (empty($node->left) && empty($node->mid) && empty($node->right)) {
            $leaves[] = $node->data;
        } else {
            if (!empty($node->right)) {
                $stack[] = $node->right;
            }
            if (!empty($node->mid)) {
                $stack[] = $node->mid;
            }
            if (!empty($node->left)) {
                $stack[] = $node->left;
            }
        }        
    }
    return $leaves;
}