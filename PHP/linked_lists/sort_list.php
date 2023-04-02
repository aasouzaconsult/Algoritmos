<?php

// Sort a linked list in O(n log n) time using constant space complexity.

// Example :

// Input : 1 -> 5 -> 4 -> 3

// Returned list : 1 -> 3 -> 4 -> 5

/**
 * Time: O(nlogn)
 * Space: O(1)
 * 
 */
function sortList($head) {
    if (empty($head)) {
        return $head;
    }
    // recursively split the elements into 
    return sortListHelper($head);
}

function sortListHelper($head) {
    if (empty($head->next)) {
        return $head;
    }
    $slow = $head;
    $fast = $head;
    while (!empty($fast)) {
        if (empty($fast->next) || empty($fast->next->next)) {
            break;
        }
        $slow = $slow->next;
        $fast = $fast->next->next;
    }
    $list2 = $slow->next;
    $slow->next = NULL;
    $head = sortListHelper($head);
    $list2 = sortListHelper($list2);
    return mergeList($head, $list2);
}

function mergeList($head1, $head2) {
    if (empty($head1)) {
        return $head2;
    } elseif (empty($head2)) {
        return $head1;
    }
    $curr1 = $head1;
    $next1 = NULL;
    $curr2 = $head2;
    $next2 = NULL;

    if ($curr1->data < $curr2->data) {
        $result = $head1;
    } else {
        $result = $head2;
    }
    while (!empty($curr1) && !empty($curr2)) {
        $next1 = $curr1->next;
        $next2 = $curr2->next;

        if ($curr1->data < $curr2->data) {
            $curr1->next = $curr2;
            if (!empty($next1) && !empty($next2)) {
                if ($next1->data < $next2->data) {
                    $curr2->next = $next1;
                }
            } elseif (!empty($next1)) {
                $curr2->next = $next1;
            }
        } else { // $curr1->data >= $curr2->data
            $curr2->next = $curr1;
            if (!empty($next1) && !empty($next2)) {
                if ($next2->data < $next1->data) {
                    $curr1->next = $next2;
                }
            } elseif (!empty($next2)) {
                $curr1->next = $next2;
            }
        }
        $curr1 = $next1;
        $curr2 = $next2;
    }
    return $result;
}

function mergeList($head1, $head2) {
    if (empty($head1)) {
        return $head2;
    } elseif (empty($head2)) {
        return $head1;
    }
    $result = new Node(0);
    $resultCurr = $result;
    $curr1 = $head1;
    $next1 = NULL;    
    $curr2 = $head2;
    $next2 = NULL;
    while (!empty($curr1) && !empty($curr2)) {
        $next1 = $curr1->next;
        $next2 = $curr2->next;
        if ($curr1->data < $curr2->data) {
            $resultCurr->next = $curr1;
            $curr1 = $next1;
        } else {
            $resultCurr->next = $curr2;
            $curr2 = $next2;
        }
        $resultCurr = $resultCurr->next;
    }

    if (!empty($curr1)) {
        $resultCurr->next = $curr1;
    }
    if (!empty($curr2)) {
        $resultCurr->next = $curr2;
    }
    return $result->next;
}