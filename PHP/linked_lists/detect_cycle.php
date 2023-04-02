<?php

// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

// Try solving it using constant additional space.

// Example :

// Input : 

//                   ______
//                  |     |
//                  \/    |
//         1 -> 2 -> 3 -> 4

// Return the node corresponding to node 3. 

/**
 * Time: O(n) where n is the size of the list.
 * Space: O(1)
 *
 */
function findCycleStartNode($head) {
    if (empty($head)) {
        return $head;
    } elseif (!empty($head->next) and $head->next->next == $head) {
        return $head;
    }
    $slow = $head;
    $fast = $head;
    $count = 0;
    while (!empty($fast)) {
        if (empty($fast->next) || empty($fast->next->next)) {
            return;
        } elseif ($slow == $fast && $count != 0) {
            $slow = $head;
            break;
        }
        $count++;
        $slow = $slow->next;
        $fast = $fast->next;
    }
    while (!empty($slow)) {
        if ($slow == $fast) {
            return $slow;
        }
        $slow = $slow->next;
        $fast = $fast->next;
    }
    return;
}