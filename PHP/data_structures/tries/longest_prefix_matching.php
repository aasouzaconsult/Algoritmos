<?php

include "suffix_trie.php";

/**
 * Find the longest prefix match for a query tring from a dictionary.
 * Time complexity: O(nm + p)
 * construct trie: O(nm) where n is size of longest word in dictionary, m is the number of
 * words to insert into dictionary
 * loop through query string: O(p) where p is size of query string
 * Space complexity: O(n+m)
 * trie space: O(n+m) where n is size of longest word in dictionary, m is number of words
 * to insert into dictionary
 */
function longestPrefixMatching(SuffixTrie $suffixTrie, $dictionary, $queryString) {
    foreach ($dictionary as $value) {
        $suffixTrie->insert($value);
    }
    $result = "";
    $temp = "";
    $curr = $suffixTrie->getRoot();
    for ($i=0; $i < strlen($queryString); $i++) { 
        $char = $queryString[$i];
        if (isset($curr->children[$char])) {
            $temp .= $char;
        } else {
            break;
        }
        $curr = $curr->children[$char];
        if ($curr->isCompleteWord) {
            $result = $temp;
        }
    }
    return $result;
}

$st = new SuffixTrie();
$dict = ['are', 'area', 'base', 'cat', 'cater', 'children', 'basement'];

echo longestPrefixMatching($st, $dict, 'caterer') . PHP_EOL;
echo longestPrefixMatching($st, $dict, 'basemexy') . PHP_EOL;
echo longestPrefixMatching($st, $dict, 'child') . PHP_EOL;
echo longestPrefixMatching($st, $dict, 'are') . PHP_EOL;
echo longestPrefixMatching($st, $dict, 'arex') . PHP_EOL;
echo longestPrefixMatching($st, $dict, 'xyz') . PHP_EOL;
echo longestPrefixMatching($st, $dict, 'basement') . PHP_EOL;

// caterer:   cater
// basement:   basement
// are:   are
// arex:   are
// basemexz:   base
// xyz:   