<?php

// Reverse a linked list from position m to n. Do it in-place and in one-pass.

// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,

// return 1->4->3->2->5->NULL.

//  Note:
// Given m, n satisfy the following condition:
// 1 ≤ m ≤ n ≤ length of list. Note 2:
// Usually the version often seen in the interviews is reversing the whole linked
// list which is obviously an easier version of this question. 

/**
 * OPTIMAL
 * Plug out the section of the linked list and reverse it using a reverselist method.
 * Then put back into the original list by plugging the front and back to the list.
 * 
 * Time: O(n)
 * Space: O(1)
 *
 */
function reverseListSection($head, $m, $n) {
    if (empty($head)) {
        return $head;
    }
    $count = 1;
    list($start, $startPrev) = [NULL, NULL];
    list($end, $endNext) = [NULL, NULL];

    $curr = $head;
    while (!empty($curr)) {
        if ($count == $m) {
            $start = $curr;
        } elseif ($count < $m) {
            $startPrev = $curr;
        }
        if ($count == $n) {
            $end = $curr;
            $endNext = $curr->next;
            break;
        }
        $count++;
        $curr = $curr->next;
    }
    $end->next = NULL;
    $reversed = reverseList($start);
    $startPrev->next = $reversed;

    $trav = $reversed;
    while (!empty($trav->next)) {
        $trav = $trav->next;
    }
    $trav->next = $endNext;
    return $head;
}

/**
 * Takes in a linked list and reverse the list.
 * Time: O(n)
 * Space: O(1)
 */
function reverseList($head) {
    if (empty($head) ) {
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