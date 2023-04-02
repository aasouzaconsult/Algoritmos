<?php

/**
 * Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 */

include "../../../data_structures/graphs/adjacency_list_2.php";

/**
 * Find out if 2 vertices has a route between them using BFS.
 * Time: O(|V|+ |E|)
 * Space: O(|V|)
 */
function hasRoute($graph, $vertice1, $vertice2) {
    $visited = array_fill(0, $graph->getVerticeCount(), False);
    $queue = [$vertice1];
    $visited[$vertice1] = True;

    while (!empty($queue)) {
        $index = array_shift($queue);
        if ($index == $vertice2) {
            return True;
        }
        $curr = $graph->getEdges()[$index];
        while (!empty($curr)) {
            if (!$visited[$curr->data]) {
                $visited[$curr->data] = True;
                $queue[] = $curr->data;
            }
            $curr = $curr->next;
        }
    }
    return False;
}

$graph = new Graph(6, 0, True);
$graph->insertEdge(0, 1, 1);
$graph->insertEdge(0, 4, 1);
$graph->insertEdge(0, 5, 1);

$graph->insertEdge(1, 3, 1);
$graph->insertEdge(1, 4, 1);

$graph->insertEdge(2, 1, 1);

$graph->insertEdge(3, 2, 1);
$graph->insertEdge(3, 4, 1);
// $graph->printGraph();

echo hasRoute($graph, 0, 1) . PHP_EOL; // true
echo hasRoute($graph, 0, 2) . PHP_EOL; // true
echo hasRoute($graph, 1, 5) . PHP_EOL; // false
echo hasRoute($graph, 1, 4) . PHP_EOL; // true
echo hasRoute($graph, 1, 3) . PHP_EOL; // true
echo hasRoute($graph, 4, 5) . PHP_EOL; // false
