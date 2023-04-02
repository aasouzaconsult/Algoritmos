<?php

include "adjacency_list_2.php";
include "set_union.php";

/**
 * Kruskal's algorithm.
 * This algorithm is a greedy algorithm,
 * - put all edges into a min heap ordered by edge weight.
 * - loop through all edges
 * -     for each edge, check if 2 vertices can form a cycle
 * -        if not, add edges to result
 * - result are all the edges required to create a minimum spanning tree.
 * 
 * Time Complexity: O(E lgE)
 * MinHeap + UnionFind structure
 * MinHeap: O(E lgE) time for E edges.
 * UnionFind: O(lgV) // component test for V vertices
 * Since expensive operation here is sorting the edges via minHeap, its complexity is the dominant worst case complexity
 *
 * Space Complexity: O(E + V)
 * MinHeap: O(E) // for number of E edges
 * UnionFind: O(2V) // for number of V vertices
 */

function kruskalMST(Graph $graph) {
    // put all edges in a queue ordered by weight
    $minHeap = new SplMinHeap();
    $setUnion = new SetUnion($graph->getVerticeCount());
    $result = [];

    for ($i=0; $i < $graph->getVerticeCount(); $i++) {
        $curr = $graph->getEdges()[$i];
        while (!empty($curr)) {
            $minHeap->insert([$curr->weight, $i, $curr->data]);
            $curr = $curr->next;
        }
    }
    // loop through all edges
    while (!$minHeap->isEmpty()) {
        // extract next min weight edge
        $value = $minHeap->extract();
        // if 2 vertices of this edge is not connected, connect them and store in result
        // component test here. O(lgn) time.
        if (!$setUnion->sameComponent($value[1], $value[2])) {
            $added = $setUnion->unionSets($value[1], $value[2]);
            // add to result if union operation is performed
            if ($added) {
                $result[] = [$value[1], $value[2], $value[0]];
            }
        }
    }

    return $result;
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

$result = kruskalMST($graph);
foreach ($result as $key => $value) {
    echo implode(" ", $value) . PHP_EOL;
}