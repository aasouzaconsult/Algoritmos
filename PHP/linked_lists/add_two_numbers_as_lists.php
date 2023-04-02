<?php

// You are given two linked lists representing two non-negative numbers. The
// digits are stored in reverse order and each of their nodes contain a single
// digit. Add the two numbers and return it as a linked list.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

//     342 + 465 = 807
// Make sure there are no trailing zeros in the output list
// So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
// assuming both integer lists are of equal length.

/**
 * OPTIMAL
 * Time: O(m) where m is the size of the longer list
 * Space: O(m)
 * 
 */
function addNumbers($head1, $head2) {
    if (empty($head1)) {
        return $head2;
    } elseif (empty($head2)) {
        return $head1;
    }
    $carry = 0;
    $curr1 = $head1;
    $curr2 = $head2;
    $result = new Node(0);
    $trav = $result;
    while (!empty($curr1) && !empty($curr2)) {
        $value = $curr1->data + $curr2->data + $carry;
        if ($value >= 10) {
            $carry = 1;
        } else {
            $carry = 0;
        }
        $value %= 10;

        $node = new Node($value);
        $trav->next = $node;
        $trav = $trav->next;
        $curr1 = $curr1->next;
        $curr2 = $curr2->next;
    }
    if (!empty($curr1)) {
        $joinNode = $curr1;
        $prev = None;
        while (!empty($curr1)) {
            $value = $curr1->data + $carry;
            if ($value >= 10) {
                $carry = 1;
            } else {
                $carry = 0;
            }
            $value %= 10;
            $curr1->data = $value;
            $prev = $curr1;
            $curr1 = $curr1->next;
        }
        if ($carry == 1) {
            $prev->next = new Node(1);
        }
        $trav->next = $joinNode;
        return $result->next;
    } elseif (!empty($curr2)){
        $joinNode = $curr2;
        $prev = None;
        while (!empty($curr2)) {
            $value = $curr2->data + $carry;
            if ($value >= 10) {
                $carry = 1;
            } else {
                $carry = 0;
            }
            $value %= 10;
            $curr2->data = $value;
            $prev = $curr2;
            $curr2 = $curr2->next;
        }
        if ($carry == 1) {
            $prev->next = new Node(1);
        }
        $trav->next = $joinNode;
        return $result->next;
    }

    if ($carry == 1) {
        $trav->next = new Node(1);
    }
    return $result->next;
}