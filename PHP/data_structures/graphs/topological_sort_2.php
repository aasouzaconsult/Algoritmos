<?php

include_once("adjacency_list_3.php");

/**
 * Topological sort.
 * Time: O(V + E)
 * Space: O(V)
 *
 */
function topologicalSort($graph) {
    $visited = array_fill(0, $graph->getVerticeCount(), False);
    $result = [];

    for ($i=0; $i < sizeof($visited); $i++) { 
        if (!$visited[$i]) {
            topologicalSortRecur($graph, $visited, $result, $i);
        }
    }
    return $result;
}

function topologicalSortRecur($graph, &$visited, &$result, $index) {
    $visited[$index] = True;
    $edges = $graph->getEdges($index);
    for ($i=0; $i < sizeof($edges); $i++) { 
        if (!$visited[$edges[$i]]) {
            topologicalSortRecur($graph, $visited, $result, $edges[$i]);
        }
    }

    array_unshift($result, $index);
}

$graph = new Graph();
$graph->addEdge(0, [3,4]);
$graph->addEdge(1, [3]);
$graph->addEdge(2, []);
$graph->addEdge(3, []);
$graph->addEdge(4, [3,5]);
$graph->addEdge(5, []);
$graph->addEdge(6, [5,7]);
$graph->addEdge(7, [8]);
$graph->addEdge(8, []);
$graph->printGraph();

print_r(topologicalsort($graph));