<?php

/**
 * Utility class is a collection of helper methods to facilitate coding exercises. 
 */
class Utility {
    /**
     * Swapping of 2 values by reference.
     *
     */
    public function swap(&$value1, &$value2) {
        $temp = $value1;
        $value1 = $value2;
        $value2 = $temp;
    }

    /**
     * Print a 2D array.
     */
    public function print2DArray($matrix) {
        if (empty($matrix)) {
            throw new Exception("Input parameter is empty");
        }
        for ($row=0; $row < sizeof($matrix); $row++) { 
            for ($col=0; $col < sizeof($matrix[$row]); $col++) { 
                echo $matrix[$row][$col] . " ";
            }
            echo PHP_EOL;
        }
    }

    /**
     * Check if 2 parameters are equal.
     */
    public function assertEqual($expected, $actual) {
        if ($expected === $actual) {
            echo "SUCCESS" . PHP_EOL;
            return;
        }
        echo "FAILED" . PHP_EOL;
        echo "Expected: {$expected}.  Actual: {$actual}" . PHP_EOL;
    }

    /**
     * Preorder traversal of a binary tree and print the node data at each node visit.
     * This is assumed the node has the following structure:
     * $node->data
     * $node->left
     * $node->right
     */
    public function preOrder($node) {
        if (empty($node)) {
            return;
        }
        echo $node->data . " ";
        preOrder($node->left);
        preOrder($node->right);
    }

    /**
     * Inorder traversal of a binary tree and print the node data at each node visite.
     * This is assumed the node has the following structure:
     * $node->data
     * $node->left
     * $node->right
     */
    public function inOrder($node) {
        if (empty($node)) {
            return;
        }
        inOrder($node->left);
        echo $node->data . " ";
        inOrder($node->right);
    }

    /**
     * Postorder traversal of a binary tree and print the node data at each node visit.
     * This is assumed the node has the following structure:
     * $node->data
     * $node->left
     * $node->right
     */
    public function postOrder($node) {
        if (empty($node)) {
            return;
        }
        postOrder($node->left);
        postOrder($node->right);
        echo $node->data . " ";
    }

    /**
     * Levelorder traversal of a binary tree and print the node data at each node visit.
     * This is assumed the node has the following structure:
     * $node->data
     * $node->left
     * $node->right
     */
    public function levelOrder($node) {
        if (empty($node)) {
            return;
        }
        $queue = [$node];
        while (!empty($queue)) {
            $curr = array_pop($queue);
            echo $curr->data . " ";
            if (!empty($curr->left)) {
                $queue[] = $curr->left;
            }
            if (!empty($curr->right)) {
                $queue[] = $curr->right;
            }
        }
    }
}