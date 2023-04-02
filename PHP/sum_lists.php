<?php

/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1's digit
 * is at the head of the list. Write a function that adds two numbers and returns
 * the sum as a linked list.
 * Example:
 * Input: (7->1->6) + (5->9->2), That is, 617 + 295
 * Output: 2->1->9. That is, 912.
 *
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * Example:
 * Input: (6->1->7) + (2->9->5). That is, 617 + 295
 * Output: 9 -> 1 -> 2. That is, 912.
 * 
 */

include "linked_list.php";

/**
 * Time: O(n+m) where n is size of list1, m is size of list2
 * Space: O(m) assume m is the longer list.
 */
function sumLists($list1, $list2) {
    $head1 = $list1->getHead();
    $head2 = $list2->getHead();
    $resultList = new LinkedList(NULL);
    $currResult = $resultList->getHead();
    
    $carry = 0;
    $curr1 = $head1;
    $curr2 = $head2;
    while (!empty($curr1) || !empty($curr2)) {
        $sum = $curr1->data + $curr2->data + $carry;
        if ($sum >= 10) {
            $carry = 1;
            $sum -= 10;
        } else {
            $carry = 0;
        }

        if (empty($currResult->data)) {
            $currResult->data = $sum;
        } else {
            $resultList->insert($sum);
        }
        $curr1 = $curr1->next;
        $curr2 = $curr2->next;
    }
    // fill rest of curr1 if not empty
    while (!empty($curr1)) {
        $sum = $curr1->data + $carry;
        if ($sum >= 10) {
            $carry = 1;
            $sum -= 10;
        } else {
            $carry = 0;
        }
        $resultList->insert($sum);
        $curr1 = $curr1->next;
    }
    // fill rest of curr2 if not empty
    while (!empty($curr2)) {
        $sum = $curr2->data + $carry;
        if ($sum >= 10) {
            $carry = 1;
            $sum -= 10;
        } else {
            $carry = 0;
        }
        $resultList->insert($sum);
        $curr2 = $curr2->next;
    }
    // check carry
    if ($carry !== 0) {
        $resultList->insert($sum);
    }
    $resultList->reverse();
    return $resultList;
}

/**
 * Given 2 lists in reverse, where 1's digit is last.
 * We can reuse what we have above.
 * 
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * Example:
 * Input: (6->1->7) + (2->9->5). That is, 617 + 295
 * Output: 9 -> 1 -> 2. That is, 912.
 */
function sumListsReverse($list1, $list2) {
    $list1->reverse();
    $list2->reverse();
    return sumLists($list1, $list2);
}

$list1 = new LinkedList(6);
$list1->insert(1);
$list1->insert(7);
$list1->printList();

$list2 = new LinkedList(2);
$list2->insert(9);
$list2->insert(5);
$list2->printList();

sumLists($list1, $list2)->printList();

$list3 = new LinkedList(7);
$list3->insert(1);
$list3->insert(6);
$list3->printList();

$list4 = new LinkedList(5);
$list4->insert(9);
$list4->insert(2);
$list4->printList();

$resultList = sumListsReverse($list3, $list4);
$resultList->reverse();
$resultList->printList();
