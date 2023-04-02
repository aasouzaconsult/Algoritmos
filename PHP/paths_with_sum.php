<?php

/**
 * You are given a binary tree in which each node contians an integer value (which
 * might be positive or negative). Design an algorithm to count the number of paths
 * that sum to a given value. The path does not need to start or end at the root or
 * a leaf, but it must go downwards(traveling only from parent nodes to child nodes).
 */
// TODO: find optimal solution.

include "random_node.php";

/**
 * Brute Force.
 * Get all the paths from root to each leaf. Then use double loop to find each set
 * of sum equal to value.
 *
 * Time: O(n^3)
 * Space: O(n)
 */
function pathToSum($root, $value) {
    // put all paths into an array
    $temp = [];
    $paths = [];
    $result = [];
    // O(n) time
    getPaths($root, $temp, $paths, 0);

    // loop through each of the paths
    //     find the paths that sum to value and store that path.
    foreach ($paths as $path) {
        for ($i=0; $i < sizeof($path); $i++) { 
            $count = 0;
            $temp = [];
            for ($j=$i; $j < sizeof($path); $j++) { 
                $count += $path[$j];
                $temp[] = $path[$j];
                if ($count == $value) {
                    $result[] = $temp;
                    break;
                } elseif ($count > $value) {
                    break;
                }
            }
        }
    }
    return $result;
}

function getPaths($root, $arr, &$paths, $len) {
    if (empty($root)) {
        return;
    }
    $arr[$len] = $root->data;
    $len++;
    if (empty($root->left) && empty($root->right)) {
        $paths[] = $arr;
    } else {
        getPaths($root->left, $arr, $paths, $len);
        getPaths($root->right, $arr, $paths, $len);
    }
}

function printPaths($paths) {
    foreach ($paths as $value) {
        echo implode(" ", $value) . PHP_EOL;
    }
}

/**
 * Using a version of preorder traversal. Compute the sum at each node. If sum is
 * target sum, increment path count.
 * Time: O(lgn)
 */
function countPathsWithSum($root, $targetSum) {
    if (empty($root)) {
        return 0;
    }
    $pathsFromRoot = countPathsWithSumFromNode($root, $targetSum, 0);

    $pathsFromLeft = countPathsWithSum($root->left, $targetSum);
    $pathsFromRight = countPathsWithSum($root->right, $targetSum);
    return $pathsFromRoot + $pathsFromLeft + $pathsFromRight;
}

function countPathsWithSumFromNode($node, $targetSum, &$currentSum) {
    if (empty($node)) {
        return 0;
    }
    $currentSum += $node->data;
    $paths = 0;
    if ($currentSum == $targetSum) {
        $paths++;
    }
    $paths += countPathsWithSumFromNode($node->left, $targetSum, $currentSum);
    $paths += countPathsWithSumFromNode($node->right, $targetSum, $currentSum);
    return $paths;
}

$bt = new BinaryTree(1);
$bt->insert(2);
$bt->insert(3);
$bt->insert(4);
$bt->insert(5);
$bt->insert(6);
$root = $bt->getRoot();

$paths = pathToSum($root, 4);
printPaths($paths);