<?php

include "suffix_trie.php";

/**
 * Given a binary matrix, print all unique rows of the given matrix.
 * http://www.geeksforgeeks.org/print-unique-rows/
 * 
 * Time complexity: O(nm)
 * construct trie: O(nm) where n is number of rows and m is number of columns
 *
 */
function printUniqueRows(SuffixTrie $st, $input) {
    $inserted = False;

    for ($i=0; $i < sizeof($input); $i++) { 
        $curr = $st->getRoot();
        for ($j=0; $j < sizeof($input[$i]); $j++) { 
            $char = $input[$i][$j];
            if (!isset($curr->children[$char])) {
                $inserted = True;
                $newNode = new Node();
                $curr->children[$char] = $newNode;
            }
            $curr = $curr->children[$char];
        }
        if ($inserted) {
            echo implode(" ", $input[$i]) . PHP_EOL;
        }
        $inserted = False;
    }
}
$st = new SuffixTrie();

$input = [
    [0, 1, 0, 0, 1],
    [1, 0, 1, 1, 0],
    [0, 1, 0, 0, 1],
    [1, 1, 1, 0, 0]
];
printUniqueRows($st, $input);