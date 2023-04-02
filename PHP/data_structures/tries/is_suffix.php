<?php

include "suffix_trie.php";

/**
 * Check if query string is a suffix of base string.
 * True if query string is is suffix, false otherwise.
 * 
 * Time complexity: O(n^2)
 * suffix trie insertion - O(n^2)
 * search - O(m) where m is length of querystring
 */
function isSuffix(SuffixTrie $suffixTrie, $baseString, $queryString) {
    for ($i=0; $i < strlen($baseString) ; $i++) { 
        $suffixTrie->insert(substr($baseString, $i));
    }
    return $suffixTrie->search($queryString);
}

$st = new SuffixTrie();
echo isSuffix($st, 'banana', 'banana') . PHP_EOL;
echo isSuffix($st, 'banana', 'apple') . PHP_EOL;
echo isSuffix($st, 'banana', 'anana') . PHP_EOL;
echo isSuffix($st, 'banana', 'nan') . PHP_EOL;
echo isSuffix($st, 'banana', 'nana') . PHP_EOL;
echo isSuffix($st, 'banana', 'ana') . PHP_EOL;
echo isSuffix($st, 'banana', 'na') . PHP_EOL;
echo isSuffix($st, 'banana', 'a') . PHP_EOL;