<?php

include "adjacency_list_2.php";

/**
 * Dijkstra algorithm.
 * Finds the shortest path between 2 vertices in a weighted graph.
 * The algorithm structure itself is very similar to Prim's algorithm.
 *
 * Similarity
 * Prim and Dijkstra are similar in that they both traverse through all available vertices
 * and maintains a set of inTree array.
 *
 * Difference
 * While Prim only cares about the smallest edge weight for each vertex, Dijkstra cares about
 * both the new edge weight and the distance from starting vertex it is adjacent to.
 *
 * Time Complexity: O(E lgV) - using adjacency list
 * Graph with adjacency matrix: O(V^2)
 * 
 * Space Complexity: O(3V + 2E)
 * O(V + V + V + 2E)
 */

function dijkstra(Graph $graph, $startIndex) {
    // init spt bool array to mark visited vertices
    // init dist array to mark distance between vertices from start
    // init parent array to all -1
    // set start dist to 0
    // set traverse ptr to start index
    // while not all vertices are visited
    //     put index into spt
    //     get edges of index
    //     loop through all edges of this index
    //         if distance to reach this vertex is bigger than this index dist + current weight
    //             set this vertex dist to this index dist + current weight
    //             set parent of this vertex to index
    //         advance to next edge
    //     loop through all vertices
    //         if stored dist is bigger than current vertex dist
    //             set dist to new smaller dist
    //             set index to the smaller dist
    $spt = array_fill(0, $graph->getVerticeCount(), False);
    $dist = array_fill(0, $graph->getVerticeCount(), PHP_INT_MAX);
    $parent = array_fill(0, $graph->getVerticeCount(), -1);

    $dist[$startIndex] = 0;
    $index = $startIndex;

    while (in_array(False, $spt)) {
        $spt[$index] = True;
        $curr = $graph->getEdges()[$index];
        while (!empty($curr)) {
            if ($dist[$curr->data] > $dist[$index] + $curr->weight) {
                $dist[$curr->data] = $dist[$index] + $curr->weight;
                $parent[$curr->data] = $index;
            }
            $curr = $curr->next;
        }
        $minDist = PHP_INT_MAX;
        for ($i=0; $i < $graph->getVerticeCount(); $i++) { 
            if (!$spt[$i] && $minDist > $dist[$i]) {
                $minDist = $dist[$i];
                $index = $i;
            }
        }
    }
    return $parent;
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

print_r(dijkstra($graph, 0));
