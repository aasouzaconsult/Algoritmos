<?php

/**
 * Given a binary tree, design an algorithm which creates a linked list of all
 * the nodes at each depth (eg. if you have a tree with depthD, you'll have D
 * linked lists).
 */

include "minimal_tree.php";

class NodeHeight {
    public $node;
    public $height;

    public function __construct($node, $height) {
        $this->node = $node;
        $this->height = $height;
    }
}

/**
 * Level order traversal of the tree.
 * Create a new struct, NodeHeight that keeps track of the node's height.
 * for every node's child, Put into a queue and increment the height by 1.
 * when visiting the node, check if node height already has an associated linked list.
 * if not, create a new linked list.
 * Time: O(n + 2^h) where n is the number of nodes in the tree and h is the height
 * that has the most number of nodes.
 * Space: O(n)
 */
function listOfDepths($tree) {
    $curr = $tree->getRoot();
    if (empty($curr)) {
        return;
    }
    $depthLists = [];
    $rootNodeHeight = new NodeHeight($curr, 0);
    $queue = [$rootNodeHeight];
    while (!empty($queue)) {
        $nodeHeight = array_shift($queue);
        // visit the current node
        if (!isset($depthLists[$nodeHeight->height])) {
            $depthLists[$nodeHeight->height] = $nodeHeight->node;
        } else {
            $trav = $depthLists[$nodeHeight->height];
            while (!empty($trav->next)) {
                $trav = $trav->next;
            }
            $trav->next = $nodeHeight->node;
        }
        // put child nodes into queue
        if (!empty($nodeHeight->node->left)) {
            $queue[] = new NodeHeight(
                $nodeHeight->node->left,
                $nodeHeight->height + 1
            );
        }
        if (!empty($nodeHeight->node->right)) {
            $queue[] = new NodeHeight(
                $nodeHeight->node->right,
                $nodeHeight->height + 1
            );
        }
    }
    return $depthLists;
}

$depths = listOfDepths($bst);

foreach ($depths as $curr) {
    while (!empty($curr)) {
        echo $curr->data . " ";
        $curr = $curr->next;
    }
    echo PHP_EOL;
}

// $bst->preorder($root, 'printData');
// echo PHP_EOL;
// $bst->inorder($root, 'printData');
// echo PHP_EOL;
// $bst->postorder($root, 'printData');
// echo PHP_EOL;


// linked list local implementation
class LinedListNode {
    public $data;
    public $next;

    public function __construct($data, $next=NULL) {
        $this->data = $data;
        $this->next = $next;
    }
}

class LinkedList {
    private $head;

    public function __construct($data, $next=NULL) {
        $this->head = new LinedListNode($data, $next);
    }

    public function insert($data) {
        $node = new LinedListNode($data);
        if (empty($this->head)) {
            $this->head = $node;
            return $this->head;
        }
        $node->next = $this->head;
        $this->head = $node;
        return $this->head;
    }

    public function delete($data) {
        $node = $this->search($data);
        if (empty($this->head) || empty($node)) {
            return False;
        } elseif ($this->head == $node) {
            $this->head = $node->next;
            unset($node);
            return True;
        }
        $prev = $this->getPrevNode($node);
        $prev->next = $node->next;
        unset($node);
        return True;
    }

    public function search($data) {
        if (empty($this->head)) {
            return;
        }
        $curr = $this->head;
        while ($curr != NULL) {
            if ($curr->data == $data) {
                return $curr;
            }
            $curr = $curr->next;
        }
        return NULL;
    }

    public function getHead() {
        return $this->head;
    }

    public function printList() {
        if (empty($this->head)) {
            return;
        }
        $curr = $this->head;
        while ($curr != NULL) {
            echo $curr->data . " ";
            $curr = $curr->next;
        }
        echo PHP_EOL;
    }

    public function getPrevNode(&$node) {
        if (empty($this->head)) {
            return;
        }
        $prev = NULL;
        $curr = $this->head;
        while (!empty($curr)) {
            if ($curr->data == $node->data) {
                return $prev;
            }
            $prev = $curr;
            $curr = $curr->next;
        }
        return NULL;
    }

    public function reverse() {
        if (empty($this->head)) {
            return;
        }
        $prev = NULL;
        $curr = $this->head;
        while (!empty($curr)) {
            $temp = $curr->next;
            $curr->next = $prev;
            $prev = $curr;
            $curr = $temp;
        }
        $this->head = $prev;
    }
}