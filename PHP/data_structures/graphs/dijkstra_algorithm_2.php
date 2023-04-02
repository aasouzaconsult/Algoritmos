<?php

include "adjacency_list_2.php";

function dijkstra(Graph $graph, $startIndex) {
    // visited array to mark a vertice as visited
    // dist tracks the current found distance to reach a vertice
    // parent track the parent of vertices
    $visited = array_fill(0, $graph->getVerticeCount(), False);
    $dist = array_fill(0, $graph->getVerticeCount(), PHP_INT_MAX);
    $parent = array_fill(0, $graph->getVerticeCount(), -1);

    $dist[$startIndex] = 0;
    $index = $startIndex;

    // continue as long as there's vertice not visited
    while (in_array(False, $visited)) {
        $visited[$index] = True;
        // find all the adjacent vertices and update the dist to neighbour vertice
        // if current found distance is smaller
        $curr = $graph->getEdges()[$index];
        while (!empty($curr)) {
            if ($dist[$curr->data] > $dist[$index] + $curr->weight) {
                $dist[$curr->data] = $dist[$index] + $curr->weight;
                $parent[$curr->data] = $index;
            }
            $curr = $curr->next;
        }
        // get next min index
        $minDist = PHP_INT_MAX;
        for ($i=0; $i < sizeof($dist); $i++) { 
            if (!$visited[$i] && $dist[$i] < $minDist) {
                $minDist = $dist[$i];
                $index = $i;
            }
        }
    }
    return $parent;
}

function dijkstraRecursion(Graph $graph, $startIndex) {
    $visited = array_fill(0, $graph->getVerticeCount(), False);
    $dist = array_fill(0, $graph->getVerticeCount(), PHP_INT_MAX);
    $parent = array_fill(0, $graph->getVerticeCount(), -1);

    $dist[$startIndex] = 0;
    dijkstraRecur($graph, $index, $visited, $dist, $parent);
    return $parent;
}

function dijkstraRecur($graph, $index, &$visited, &$dist, &$parent) {
    if (!in_array(False, $visited)) {
        return;
    }
    $visited[$index] = True;
    $curr = $graph->getEdges()[$index];
    updateNeighbourDist($curr, $index, $dist, $parent);

    // find the next min dist
    $minDist = PHP_INT_MAX;
    for ($i=0; $i < sizeof($dist); $i++) { 
        if (!$visited[$i] && $dist[$i] < $minDist) {
            $minDist = $dist[$i];
            $index = $i;
        }
    }
    dijkstraRecur($graph, $index, $visited, $dist, $parent);
}

function updateNeighbourDist($curr, $index, &$dist, &$parent) {
    if (empty($curr)) {
        return;
    }
    if ($dist[$curr->data] > $dist[$index] + $curr->weight) {
        $dist[$curr->data] = $dist[$index] + $curr->weight;
        $parent[$curr->data] = $index;
    }

    // get to next neighbour
    updateNeighbourDist($curr->next, $index, $dist, $parent);
}

$graph = new Graph(9, 0, False);
$graph->insertEdge(0, 1, 4);
$graph->insertEdge(0, 7, 8);

$graph->insertEdge(1, 2, 8);
$graph->insertEdge(1, 7, 11);

$graph->insertEdge(2, 1, 8);
$graph->insertEdge(2, 3, 7);
$graph->insertEdge(2, 5, 4);
$graph->insertEdge(2, 8, 2);

$graph->insertEdge(3, 2, 7);
$graph->insertEdge(3, 4, 9);
$graph->insertEdge(3, 5, 14);

$graph->insertEdge(4, 3, 9);
$graph->insertEdge(4, 5, 10);

$graph->insertEdge(5, 2, 4);
$graph->insertEdge(5, 3, 14);
$graph->insertEdge(5, 4, 10);
$graph->insertEdge(5, 6, 2);

$graph->insertEdge(6, 5, 2);
$graph->insertEdge(6, 7, 1);
$graph->insertEdge(6, 8, 6);

$graph->insertEdge(7, 0, 8);
$graph->insertEdge(7, 1, 11);
$graph->insertEdge(7, 8, 7);
$graph->insertEdge(7, 6, 1);

$graph->insertEdge(8, 2, 2);
$graph->insertEdge(8, 6, 6);
$graph->insertEdge(8, 7, 7);
$graph->printGraph();

// print_r(dijkstra($graph, 0));
print_r(dijkstraRecursion($graph, 0));