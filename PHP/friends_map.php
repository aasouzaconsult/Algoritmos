<?php

/**
 * Given an hashmap of friend lists in the format:
 * 'A' => ['B', 'C'],
 * 'B' => ['A', 'C'],
 * 'C' => ['A', 'B'],
 * 'D' => ['E'],
 * 'E' => ['D']
 *
 * Return the number of friend circles. A friend circle is defined as a group of friends
 * which are all conected with each other
 */

/**
 * Time: O(V + E) where V is the friends group size, E is the most number of friend one has.
 * Space: O(V)
 *
 */
function friendCircleCount($friendsMap) {
    if (sizeof($friendsMap) < 2) {
        return sizeof($friendsMap);
    }
    $visited = [];
    foreach ($friendsMap as $friend => $friendList) {
        $visited[$friend] = False;
    }
    $count = 0;
    foreach ($friendsMap as $friend => $friendList) {
        if (!$visited[$friend]) {
            $queue = [$friend];
            $count++;
        }
        while (!empty($queue)) {
            $myself = array_pop($queue);
            $visited[$myself] = True;
            foreach ($friendsMap[$myself] as $related) {
                if (!$visited[$related] && !isset($queue[$related])) {
                    $queue[] = $related;
                }
            }
        }        
    }
    return $count;
}

$friendsMap1 = [
    'A' => ['B', 'C'],
    'B' => ['A', 'C'],
    'C' => ['A', 'B'],
    'D' => ['E'],
    'E' => ['D']
];
$friendsMap2 = [
    'A' => [],
];

echo friendCircleCount($friendsMap1) . PHP_EOL;
echo friendCircleCount($friendsMap2) . PHP_EOL;