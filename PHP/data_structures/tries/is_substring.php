<?php

include "suffix_trie.php";

/**
 * Check if query string is a subset of base string.
 * True if query string is is subset, false otherwise.
 * 
 * Time complexity: O(n^2)
 * suffix trie insertion - O(n^2)
 * search - O(m) where m is length of querystring
 */
function isSubstring(SuffixTrie $suffixTrie, $baseString, $queryString) {
    for ($i=0; $i < strlen($baseString) ; $i++) { 
        $suffixTrie->insert(substr($baseString, $i));
    }
    $curr = $suffixTrie->getRoot();
    for ($i=0; $i < strlen($queryString); $i++) { 
        $char = $queryString[$i];
        if (isset($curr->children[$char])) {
            $curr = $curr->children[$char];
        } else {
            return False;
        }
    }
    return True;
}

$st = new SuffixTrie();
echo isSubString($st, 'banana', 'banana') . PHP_EOL;
echo isSubString($st, 'banana', 'apple') . PHP_EOL;
echo isSubString($st, 'banana', 'anana') . PHP_EOL;
echo isSubString($st, 'banana', 'nan') . PHP_EOL;
echo isSubString($st, 'banana', 'nana') . PHP_EOL;
echo isSubString($st, 'banana', 'ana') . PHP_EOL;
echo isSubString($st, 'banana', 'na') . PHP_EOL;
echo isSubString($st, 'banana', 'a') . PHP_EOL;