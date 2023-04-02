<?php

/**
 * Implementing a suffix trie.
 */

class Node {
    public $children;
    public $isCompleteWord;

    public function __construct($isCompleteWord=False) {
        $this->children = [];
        $this->isCompleteWord = $isCompleteWord;
    }
}

class SuffixTrie {
    private $root;

    public function __construct() {
        $this->root = new Node(False);
    }

    public function getRoot() {
        return $this->root;
    }

    /**
     * Time: O(n) where n is the length of the word.
     */
    public function insert($word) {
        if (empty($word)) {
            return False;
        }

        $curr = $this->root;
        for ($i=0; $i < strlen($word); $i++) { 
            $char = $word[$i];
            if (!isset($curr->children[$char])) {
                $newNode = new Node(False);
                $curr->children[$char] = $newNode;
            }
            $curr = $curr->children[$char];
        }
        $curr->isCompleteWord = True;
        return True;
    }

    public function delete($word) {
        if (empty($word) || !$this->search($word)) {
            return False;
        }

        // set curr to start at root
        $curr = $this->root;
        // init a stack to store nodes to check after word deletion
        $stack = [];
        // traverse the word chars, with each char traversing the trie
        //     put curr node into stack
        //     curr advance to next char pointer
        // end of loop, curr is now pointed at the word's end node
        for ($i=0; $i < strlen($word); $i++) { 
            $char = $word[$i];
            $stack[] = [$curr, $char];
            $curr = $curr->children[$char];
        }
        // set isCompleteWord bool to false
        $curr->isCompleteWord = False;
        // if this node has no children
        //     delete this node
        //     while stack not empty
        //         pop a node from stack
        //         unset node pointer given in popped first index
        //         if popped node is empty
        //             unset this node
        //         else
        //             break
        if (empty($curr->children)) {
            unset($curr);
            while (!empty($stack)) {
                $element = array_pop($stack);
                $node = $element[0];
                $char = $element[1];
                unset($node->children[$char]);
                if (empty($node->children)) {
                    unset($node);
                } else {
                    break;
                }
            }
        }
        return True;
    }

    public function deleteRecursive($word) {
        $this->_deleteRecursive($this->root, $word, 0);
    }

    private function _deleteRecursive(Node $curr, $word, $index) {
        // base case: check if index has reached word length - ie. gone past the last index
        //     if curr->isCompleteWord is false, its not a complete word
        //         return false
        //     set curr->isCompleteWord to false
        //     return true/false if curr->children is empty
        if ($index >= strlen($word)) {
            if (!$curr->isCompleteWord) {
                return False;
            }
            $curr->isCompleteWord = False;
            return empty($curr->children);
        }
        // get char at index
        $char = $word[$index];
        // get node for char
        $node = $curr->children[$char];
        // if node is null, not complete word,
        //     return false
        if (empty($node)) {
            return False;
        }
        // shouldDeleteNode = recursive on next index
        $shouldDeleteNode = $this->_deleteRecursive($node, $word, $index+1);
        // if should delete node
        //     unset node->children[char]
        //     return check if current node child is empty 
        if ($shouldDeleteNode) {
            unset($node->children[$char]);
            return empty($node->children);
        }
        return False;
    }

    /**
     * Check if given word is in the suffix trie.
     * True if word is in trie, false otherwise.
     * Time: O(n) where n is the length of the word.
     */
    public function search($word) {
        if (empty($word)) {
            return False;
        }
        $curr = $this->root;
        for ($i=0; $i < strlen($word); $i++) { 
            $char = $word[$i];
            if (!isset($curr->children[$char])) {
                return False;
            } else {
                $curr = $curr->children[$char];
            }
        }
        if ($curr->isCompleteWord) {
            return True;
        }
        return False;
    }
}

// $st = new SuffixTrie();
// $st->insert('abc');
// $st->insert('abgl');
// $st->insert('cdf');
// $st->insert('abcd');
// $st->insert('lmn');
// $st->delete('abgl');
// echo $st->search('abc');
// echo $st->search('abcd');