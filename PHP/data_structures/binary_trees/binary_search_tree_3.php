<?php

/**
 * Implementation of binary search tree.
 */
class Node {
    public $data;
    public $left;
    public $right;

    public function __construct($data, $left=NULL, $right=NULL) {
        $this->data = $data;
        $this->left = $left;
        $this->right = $right;
    }
}

class BinarySearchTree {
    private $root;

    public function __construct($data, $left=NULL, $right=NULL) {
        $this->root = new Node($data, $left, $right);
    }

    public function getRoot() {
        return $this->root;
    }

    public function insert($data) {
        $newNode = new Node($data);
        if (empty($this->root)) {
            $this->root = $newNode;
            return $this->root;
        }
        $this->insertNode($this->root, $newNode);
        return $this->root;
    }

    private function insertNode(Node $parent, Node $node) {
        if ($node->data < $parent->data) {
            if (empty($parent->left)) {
                $parent->left = $node;
            } else {
                $this->insertNode($parent->left, $node);
            }
        } else {
            if (empty($parent->right)) {
                $parent->right = $node;
            } else {
                $this->insertNode($parent->right, $node);
            }
        }
    }

    public function delete($data) {
        // findNode that represents the data
        list($node, $parent) = $this->findNodeAndParent($data);
        if (empty($this->root) || empty($node)) {
            return false;
        }
        // case 0: 0 child
        // case 1: 1 child
        if (empty($node->left) || empty($node->right)) {
            $this->replace($parent, $node);
        } else { // case 2: 2 child
            // find the next smallest element from node's right child
            // next smallest element data to replace node's data
            // use replace on the node position of the next smallest node 
            $currParent = $node;
            $curr = $node->right;
            while(!empty($curr->left)) {
                $currParent = $curr;
                $curr = $curr->left;
            }
            $node->data = $curr->data;
            $this->replace($currParent, $curr);
        }

    }

    private function replace(&$parent, &$node) {
        // set child node to replace with
        if (empty($node->left)) {
            $child = $node->right;
        } else {
            $child = $node->left;
        }
        if ($node == $this->root) {
            $this->root = $child;
        } elseif ($parent->left == $node) {
            $parent->left = $child;
        } else {
            $parent->right = $child;
        }
        unset($node);
        return $this->root;
    }

    private function findNodeAndParent($data) {
        if (empty($this->root)) {
            return [NULL, NULL];
        }
        $parent = NULL;
        $curr = $this->root;
        while (!empty($curr)) {
            if ($curr->data == $data) {
                return [$curr, $parent];
            } else {
                $parent = $curr;
                if ($data < $curr->data) {
                    $curr = $curr->left;
                } else {
                    $curr = $curr->right;
                }
            }
        }
    }

    public function printData($node) {
        echo "{$node->data} ";
    }

    public function preorder($node, $callback) {
        if (empty($node)) {
            return;
        }
        $this->$callback($node);
        $this->preorder($node->left, $callback);
        $this->preorder($node->right, $callback);
    }

    public function inorder($node, $callback) {
        if (empty($node)) {
            return;
        }
        $this->inorder($node->left, $callback);
        $this->$callback($node);
        $this->inorder($node->right, $callback);
    }

    public function postorder($node, $callback) {
        if (empty($node)) {
            return;
        }
        $this->postorder($node->left, $callback);
        $this->postorder($node->right, $callback);
        $this->$callback($node);
    }

    public function levelorder($node, $callback) {
        if (empty($node)) {
            return;
        }
        $queue = [$node];
        while (!empty($queue)) {
            $curr = array_shift($queue);
            $this->$callback($curr);

            if (!empty($curr->left)) {
                $queue[] = $curr->left;
            }
            if (!empty($curr->right)) {
                $queue[] = $curr->right;
            }
        }
    }
}

$bst = new BinarySearchTree(40);
$root = $bst->getRoot();
$bst->insert(13);
$bst->insert(57);
$bst->insert(7);
$bst->insert(37);
$bst->insert(49);
$bst->insert(67);
$bst->insert(34);
$bst->insert(39);
$bst->insert(63);
$bst->insert(28);
$bst->insert(38);
$bst->insert(60);
$bst->insert(65);
$bst->insert(30);
$bst->insert(29);
$bst->insert(32);
$bst->preorder($root, 'printData');
echo PHP_EOL;
$bst->inorder($root, 'printData');
echo PHP_EOL;
$bst->postorder($root, 'printData');
echo PHP_EOL;
$bst->delete(63);
$bst->preorder($root, 'printData');
echo PHP_EOL;
$bst->inorder($root, 'printData');
echo PHP_EOL;
$bst->postorder($root, 'printData');
echo PHP_EOL;