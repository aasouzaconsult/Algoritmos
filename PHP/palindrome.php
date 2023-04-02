<?php

/**
 * Implement a function to check if a linked list is a palindrome.
 */

include "linked_list.php";

/**
 * Use a hashtable to determine the contents of the list.
 * Time: O(n)
 * Space: O(n)
 */
function isPalindrome($list) {
    $curr = $list->getHead();
    if (empty($curr)) {
        return False;
    }
    $histogram = [];
    $isOdd = False;
    while (!empty($curr)) {
        if (empty($histogram[$curr->data])) {
            $histogram[$curr->data] = 1;
        } else {
            unset($histogram[$curr->data]);
        }
        $isOdd = !$isOdd;
        $curr = $curr->next;
    }
    if ($isOdd) {
        return sizeof($histogram) === 1;
    } else {
        return empty($histogram);
    }

}

$list1 = new LinkedList(7);
$list1->insert(1);
$list1->insert(1);
$list1->insert(7);

$list2 = new LinkedList(5);
$list2->insert(5);
$list2->insert(5);

$list3 = new LinkedList(7);

$list4 = new LinkedList(7);
$list4->insert(1);
$list4->insert(3);
$list4->insert(7);

echo isPalindrome($list1) . PHP_EOL;
echo isPalindrome($list2) . PHP_EOL;
echo isPalindrome($list3) . PHP_EOL;
echo isPalindrome($list4) . PHP_EOL;