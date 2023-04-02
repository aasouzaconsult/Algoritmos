<?php

class Node {
    public $data;
    public $isRed;
    public $left;
    public $right;

    public function __construct($data, $isRed=true, $left=NULL, $right=NULL) {
        $this->data = $data;
        $this->isRed = $isRed;
        $this->left = $left;
        $this->right = $right;
    }
}

class RedBlackTree {
    private $root;

    public function __construct($data, $isRed=false, $left=NULL, $right=NULL) {
        $this->root = new Node($data, $isRed, $left, $right);
    }

    public function insert($data) {
        // insert new data as a red node
        $newNode = new Node($data, true);
        if (empty($this->root)) {
            $this->root = $newNode;
        }
        $this->insertNode($this->root, $newNode);
        $this->insertFixUp($newNode);
        return $this->root;
    }

    private function insertNode(&$targetNode, &$newNode) {
        if ($newNode->data < $targetNode->data) {
            if (empty($targetNode->left)) {
                $targetNode->left = $newNode;
            } else {
                $this->insertNode($targetNode->left, $newNode);
            }
        } else {
            if (empty($targetNode->right)) {
                $targetNode->right = $newNode;
            } else {
                $this->insertNode($targetNode->right, $newNode);
            }
        }
    }

    /**
     * Restore red black tree properties after an insert operation.
     */
    private function insertFixUp(&$node) {
        $parent = $this->getParentNode($node);
        $grandParent = $this->getParentNode($parent);
        while ($parent->isRed) {
            if ($parent == $grandParent->left) {
                // node's parent is a left child
                $uncle = $grandParent->right;

                if ($uncle->isRed) {
                    // case 1: inserted node and its parent are red, uncle is red
                    // set parent and uncle to black
                    // set grandparent to red
                    // move node reference to grandparent
                    $parent->isRed = false;
                    $uncle->isRed = false;
                    $grandParent->isRed = true;
                    $node = $grandParent;
                } elseif ($node == $parent->right) { // node is a right child
                    // case 2: node is a right child, uncle is black
                    // left rotate on node's parent
                    $node = $parent;
                    $this->leftRotate($node);
                }
                // case 3: node is left child, uncle is black
                // set parent to black
                // set grandparent to red and rotate right on grandparent
                $parent->isRed = false;
                $grandParent->isRed = true;
                $this->rightRotate($grandparent);
            } else { // $parent is a right child of $grandParent
                $uncle = $grandParent->left;

                if ($uncle->isRed) {
                    // case 4: inserted node and its parent are red, uncle is red
                    // set parent and uncle to black
                    // set grandparent to red
                    // move node reference to grandparent
                    $parent->isRed = false;
                    $uncle->isRed = false;
                    $grandParent->isRed = true;
                    $node = $grandParent;
                } elseif ($node == $parent->left) { // node is left child
                    // case 5: node is a left child, uncle is black
                    // right rotate on parent
                    $node = $parent;
                    $this->rightRotate($node);
                }
                // case 6: node is a right child, uncle is black
                // set parent to black
                // set grandparent to red and rotate left on grandparent
                $parent->isRed = false;
                $grandParent->isRed = true;
                $this->leftRotate($grandParent);
            }
        }
        $this->root->isRed = false;
    }

    public function delete($data) {
        if (empty($this->root)) {
            return false;
        }

        $node = $this->findNode($this->root, $data);
        if (empty($node->left)) {
            $childNode = $node->right;
            $this->transplant($node, $node->right);
        } elseif (empty($node->right)) {
            $childNode = $node->left;
            $this->transplant($node, $node->left);
        } else {
            $minNode = $this->minNode($node->right);
            $childNode = $node->right;
            $childNodeParent = $this->getParentNode($childNode);
            if ($chidlNodeParent == $node) {
                $childNode = $node;
            } else {
                $this->transplant($node, $node->right);
                // ...
            }
            // $this->transplant()
            // ... INCOMPLETE
        }
        if ($node->isRed == false) {
            $this->deleteFixUp(childNode);
        }

    }

    private function deleteFixUp($node) {
        $parent = $this->getParentNode($node);
        while ($node !== $this->root && $node->isRed == false) {
            if ($parent->left == $node) {
                $sibling = $parent->right;

                if ($sibling->isRed) {
                    $sibling->isRed = false;
                    $parent->isRed = true;
                    $this->leftRotate($parent);
                    $sibling = $parent->right;
                }
                if ($sibling->left->isRed == false && $sibling->right->isRed == false) {
                    $sibling->isRed = true;
                    $node = $parent;
                } elseif ($sibling->right->isRed == false) {
                    $sibling->left->isRed = false;
                    $sibling->isRed = true;
                    $this->rightRotate($sibling);
                    $sibling = $parent->right;
                }
                $sibling->isRed = $parent->isRed;
                $parent->isred = false;
                $sibling->right->isred = false;
                $this->leftRotate($parent);
                $node = $this->root;
            } else {
                // handle case for $parent->right == node
            }
        }
        $node->isRed = false;
    }

    /**
     * Get the smallest node below node
     */
    private function minNode($node) {
        $curr = $node;
        while (!empty($curr->left)) {
            $curr = $curr->left;
        }
        return $curr;
    }

    private function findNode($node, $data) {
        if (empty($node)) {
            return NULL;
        }
        if ($node->data == $data) {
            return $node;
        } else if ($data < $node->data) {
            return $this->findNode($node->left, $data);
        } else {
            return $this->findNode($node->right, $data);
        }
    }

    private function transplant($deleteNode, $childNode) {
        $parent = $this->getParentNode($deleteNode);
        if ($deleteNode == $this->root) {
            $this->root = $childNode;
        } elseif ($deleteNode == $parent->left) {
            $parent->left = $childNode;
        } else {
            $parent->right = $childNode;
        }
    }

    private function leftRotate(&$node) {
        // set y reference to node's right child
        $rightNode = $node->right;
        // set node's right child to y's left child
        $node->right = $rightNode->left;
        // get node's parent, if parent is null. its root case. root pointer is now pointed to y
        $parent = $this->getParentNode($node);
        if (empty($parent)) {
            $this->root = $rightNode;
        } elseif ($parent->left == $node) { // set node's parent to y's parent now. determine parent.left or parent.right
            $parent->left = $rightNode;
        } else {
            $parent->right = $rightNode;
        }
        // set y be parent of node
        $rightNode->left = $node;
    }

    private function rightRotate(&$node) {
        // set y as node.left reference
        // set node.left to y.right
        // find parent node
        // handle root node case
        // set parent to point to new leftNode
        // leftnode.right = node
        $leftNode = $node->left;
        $node->left = $leftNode->right;

        $parent = $this->getParentNode($node);
        if (empty($parent)) {
            $this->root = $leftNode;
        } elseif ($parent->left == $node) {
            $parent->left = $leftNode;
        } else {
            $parent->right = $leftNode;
        }
        $leftNode->right = $node;
    }

    private function getParentNode($node) {
        if (empty($this->root) && empty($node)) {
            return NULL;
        }
        $parent = NULL;
        $curr = $this->root;
        while (!empty($curr)) {
            if ($node->data == $curr->data) {
                return $parent;
            }
            $parent = $curr;
            if ($node->data < $curr->data) {
                $curr = $curr->left;
            } else {
                $curr = $curr->right;
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
}