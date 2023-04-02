<?php

include_once("adjacency_list_3.php");

/**
 * A graph is considered to be cyclic if there is a "back edge" that points to a
 * previous visited vertice.
 * Here we use DFS to traverse the graph, when a "back edge" is found, we return
 * True, else return False.
 *
 */
function hasCycle(Graph $graph, $startIndex) {
    $visited = array_fill(0, $graph->getVerticeCount(), False);
    $stack = [$startIndex];

    while (!empty($stack)) {
        $index = array_pop($stack);
        $visited[$index] = True;
        $edges = $graph->getEdges($index);
        for ($i=0; $i < sizeof($edges); $i++) { 
            if ($visited[$edges[$i]] || in_array($edges[$i], $stack)) {
                return True;
            } else {
                $stack[] = $edges[$i];
            }
        }
    }
    return False;
}

function hasCycleRecursion(Graph $graph, $startIndex) {
    $visited = array_fill(0, $graph->getVerticeCount(), False);
    return hasCycleRecur($graph, $startIndex, $visited);
}

function hasCycleRecur($graph, $index, &$visited) {
    if (!in_array(False, $visited)) {
        return False;
    }
    $visited[$index] = True;
    $edges = $graph->getEdges($index);
    for ($i=0; $i < sizeof($edges); $i++) { 
        if ($visited[$edges[$i]] || hasCycleRecur($graph, $edges[$i], $visited)) {
            return True;
        }
    }
}

$graph = new Graph();
$graph->addEdge(0, [1,2]);
$graph->addEdge(1, [2]);
$graph->addEdge(2, [0,3]);
$graph->addEdge(3, [3]);
$graph->printGraph();

echo hasCycle($graph, 3) . PHP_EOL;
echo hasCycleRecursion($graph, 3) . PHP_EOL;