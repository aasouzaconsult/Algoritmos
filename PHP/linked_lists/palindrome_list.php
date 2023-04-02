<?php

// Given a singly linked list, determine if its a palindrome. Return 1 or 0
// denoting if its a palindrome or not, respectively.

// Notes: 
// - Expected solution is linear in time and constant in space.
// Time: O(n)
// Space: O(1)
// 
// For example,

// List 1-->2-->1 is a palindrome.
// List 1-->2-->3 is not a palindrome.

/**
 * OPTIMAL.
 *
 * To determine the palindrome, we need to find out if left and right are the same.
 * To do that we need to find the mid point for the palindrome.
 * We use a tortise and hare pointer. when hare has reached the end of the list, tortise
 * is at the halfway mark.
 * We split the 2nd part of the list and reverse the list to compare with the first part.
 * If all values return the same for the length of the 2nd list, return 1. else return 0.
 * 
 * Time: O(n) where n is the size of the list
 * Space: O(1)
 * 
 */
function isPalindrome($head) {
    if (empty($head)) {
        return $head;
    }
    $tortise = $head;
    $hare = $head;

    while (!empty($hare)) {
        if (empty($hare->next) || empty($hare->next->next)) {
            break;
        }
        $tortise = $tortise->next;
        $hare = $hare->next->next;
    }
    $list2Head = $tortise->next;
    $tortise->next = NULL;
    $list2Head = reverseList($list2Head);

    $curr1 = $head;
    $curr2 = $list2Head;
    while (!empty($curr2)) {
        if ($curr2->data != $curr1->data) {
            return 0;
        }
        $curr1 = $curr1->next;
        $curr2 = $curr2->next;
    }
    return 1;
}

/**
 * Takes in a linked list and reverse the list.
 * Time: O(n)
 * Space: O(1)
 */
function reverseList($head) {
    if (empty($head)) {
        return $head;
    }
    $prev = NULL;
    $next = NULL;
    $curr = $head;
    while (!empty($curr)) {
        $next = $curr->next;
        $curr->next = $prev;
        $prev = $curr;
        $curr = $next;
    }
    return $prev;
}