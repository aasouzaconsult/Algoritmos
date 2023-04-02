<?php

include "suffix_trie.php";

/**
 * Find and return the number of query string occurrences in base string.
 * Time complexity: O(n+m)
 * construct trie: O(n)
 * traverse query string: O(m)
 * traverse rest of the nodes below query string: O(n)
 */
function substringOccurrence(SuffixTrie $suffixTrie, $baseString, $queryString) {
    $count = 0;
    // construct suffix tree for baseString
    for ($i=0; $i < strlen($baseString) ; $i++) { 
        $suffixTrie->insert(substr($baseString, $i));
    }
    // set curr as root
    $curr = $suffixTrie->getRoot();
    // traverse querystring
    //     if char ptr not found, return 0
    for ($i=0; $i < strlen($queryString); $i++) { 
        $char = $queryString[$i];
        if (isset($curr->children[$char])) {
            $curr = $curr->children[$char];
        } else {
            // drop off. not a single occurrence found.
            return 0;
        }
    }
    $queue = [$curr];
    // $prev is the last node that ended with queryString
    while (!empty($queue)) {
        $node = array_shift($queue);
        if ($node->isCompleteWord) {
            $count++;
        }
        while (!empty($node->children)) {
            $queue[] = array_shift($node->children);
        }
    }
    return $count;
}

$st = new SuffixTrie();
echo substringOccurrence($st, 'banana', 'nana');