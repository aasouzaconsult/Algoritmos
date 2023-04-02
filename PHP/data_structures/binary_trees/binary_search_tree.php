<?php

/**
 * Implementation of a binary search tree.
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

    public function __construct($data) {
        $this->root = new Node($data);
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

    protected function insertNode($parentNode, $newNode) {
        if ($newNode->data <= $parentNode->data) {
            if (empty($parentNode->left)) {
                $parentNode->left = $newNode;
            } else {
                $this->insertNode($parentNode->left, $newNode);
            }
        } else {
            if (empty($parentNode->right)) {
                $parentNode->right = $newNode;
            } else {
                $this->insertNode($parentNode->right, $newNode);
            }
        }
    }

    public function delete($data) {
        if (empty($this->root)) {
            return false;
        }
        $node = $this->findNode($data);
        // case 1: 0 children
        if (empty($node->left) && empty($node->right)) {
            return $this->deleteLeafNode($node, $this->root);
        } else if (empty($node->left) || empty($node->right)) { // case 2: 1 children
            return $this->deleteSingleChildNode($node, $this->root);
        } else { // case 3: 2 children
            // get right child's smallest node 
            $deleteNode = $this->findSmallestNode($node->right);
            // swap right child smallest node with $node.
            $this->swap($node, $deleteNode);
            echo "after swap: {$node->data} : {$deleteNode->data}" . PHP_EOL;
            // delete the $deleteNode which has 0 or 1 child only.
            if ($this->isLeafNode($deleteNode)) {
                if ($node->right == $deleteNode) {
                    $node->right = NULL;
                } else {
                    return $this->deleteLeafNode($deleteNode, $node->right);
                }
            } else {
                return $this->deleteSingleChildNode($deleteNode, $node->right);
            }
        }
    }

    private function swap(&$node1, &$node2) {
        $temp = $node1->data;
        $node1->data = $node2->data;
        $node2->data = $temp;
        return;
    }

    private function isLeafNode(&$node) {
        if (empty($node->left) && empty($node->right)) {
            return true;
        }
        return false;
    }

    private function deleteSingleChildNode(&$node, &$ancestorNode) {
        if (empty($node) ||
            (empty($node->left) && empty($node->right)) ||
            (!empty($node->left && !empty($node->right)))) {
            return false;
        }
        $parent = $this->_findParentNode($ancestorNode, $node);
        if ($node == $this->root) {
            if (!empty($node->left)) {
                $this->root = $node->left;
            } else{
                $this->root = $node->right;
            }
        } else if ($parent->left == $node) {
            if (!empty($node->left)) {
                $parent->left = $node->left;
            } else {
                $parent->left = $node->right;
            }
        } else if ($parent->right == $node) {
            if (!empty($node->left)) {
                $parent->right = $node->left;
            } else {
                $parent->right = $node->right;
            }
        }
        return true;
    }

    private function deleteLeafNode(&$node, &$ancestorNode) {
        if (!empty($node->left) || !empty($node->right) || empty($node)) {
            return false;
        }

        $parent = $this->_findParentNode($ancestorNode, $node);
        if ($node == $this->root) {
            $this->root = NULL;
        } else if($parent->left == $node) {
            $parent->left = NULL;
        } else {
            $parent->right = NULL;
        }
        return true;
    }    

    private function findSmallestNode(&$node) {
        if (empty($node)) {
            return NULL;
        }
        $curr = $node;
        while (!empty($curr->left)) {
            $curr = $curr->left;
        }
        return $curr;
    }

    private function _findParentNode($startNode, $node) {
        if (empty($startNode) || empty($node)) {
            return NULL;
        } else if ($startNode == $node) {

        }
        $prev = NULL;
        $curr = $startNode;

        while ($curr != NULL) {
            if ($curr->data == $node->data) {
                return $prev;
            }
            $prev = $curr;
            if ($node->data < $curr->data) {
                $curr = $curr->left;
            } else {
                $curr = $curr->right;
            }
        }
    }

    public function find($data) {
        if (empty($this->root)) {
            return false;
        }
        $found = false;
        $curr = $this->root;
        while ($curr != NULL) {
            if ($curr->data == $data) {
                $found = true;
                break;
            } else {
                if ($data < $curr->data) {
                    if ($curr->left != NULL) {
                        $curr = $curr->left;
                    } else {
                        $found = false;
                        break;
                    }
                } else {
                    if ($curr->right != NULL) {
                        $curr = $curr->right;
                    } else {
                        $found = false;
                        break;
                    }
                }
            }
        }
        return $found;
    }

    public function findNode($data) {
        return $this->_findNode($this->root, $data);
    }

    private function _findNode($node, $data) {
        if (empty($node)) {
            return NULL;
        }
        if ($node->data == $data) {
            return $node;
        } else if ($data < $node->data) {
            return $this->_findNode($node->left, $data);
        } else {
            return $this->_findNode($node->right, $data);
        }
    }

    public function getRoot() {
        return $this->root;
    }

    public function preorder($node) {
        if (empty($node)) {
            return;
        }
        echo $node->data . " ";
        $this->preorder($node->left);
        $this->preorder($node->right);
    }

    public function inorder($node) {
        if (empty($node)) {
            return;
        }
        $this->inorder($node->left);
        echo $node->data . " ";
        $this->inorder($node->right);
    }

    public function postorder($node) {
        if (empty($node)) {
            return;
        }
        $this->postorder($node->left);
        $this->postorder($node->right);
        echo $node->data . " ";
    }

    public function levelorder($node) {
        if (empty($node)) {
            return;
        }
        $queue = [$node];
        while (!empty($queue)) {
            $curr = array_shift($queue);
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

$bst->preorder($root);
echo PHP_EOL;
$bst->inorder($root);
echo PHP_EOL;
$bst->postorder($root);
echo PHP_EOL;
$bst->levelorder($root);
echo PHP_EOL;
$bst->find(29);
$bst->find(32);

// $bst->delete(32);
// $bst->preorder($root);
// echo PHP_EOL;
// $bst->inorder($root);
// echo PHP_EOL;
// $bst->postorder($root);
// echo PHP_EOL;