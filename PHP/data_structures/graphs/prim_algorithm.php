<?php

include "adjacency_list_2.php";

/**
 * Prim's algorithm finds the minimum spanning tree of a Directed Acyclic Graph(DAG)
 * This algorithm is a greedy algorithm,
 * - init mst array to check if all vertices are visited
 * - init weight array to store min weight between vertices. initially infinite distance.
 * - init parents array to store parent of a vertice
 * - from starting vertice, visit a vertice if its not visited
 * - for this vertice's edges update the min weight
 * - loop through the weight array and use the next min weight index to repeat the above
 * - stop when all vertices are visited.
 * 
 * Time Complexity: O(V lgV)
 * MinHeap: O(V lgV) time for V vertices.
 * Getting the min weight index is the expensive operation here. this is the dominant time complexity
 *
 * Space complexity: O(3n)
 * O(n + n + n) = O(3n)
 */

function primMST(Graph $graph, $startIndex) {
    // init mst bool array
    // init keys array to store weight values of all vertices
    // init parents array to store indexes of parent nodes mst
    $mst = array_fill(0, $graph->getVerticeCount(), False);
    $keys = array_fill(0, $graph->getVerticeCount(), PHP_INT_MAX);
    $parents = array_fill(0, $graph->getVerticeCount(), NULL);
    
    // set startindex key to 0
    $keys[$startIndex] = 0;
    $index = $startIndex;
    // while there are vertices not visited
    while (in_array(False, $mst)) {
        // set this vertice as visited
        $mst[$index] = True;
        // update adjacent edge vertices of this vertex
        $curr = $graph->getEdges()[$index];
        while (!empty($curr)) {
            // if current vertex is not visited, and found weight is lesser than key weight
            //     set found weight to key weight
            //     set current vertex parent to index vertex above
            if (!$mst[$curr->data] && $keys[$curr->data] > $curr->weight) {
                $keys[$curr->data] = $curr->weight;
                $parents[$curr->data] = $index;
            }
            // move to next edge
            $curr = $curr->next;
        }
        // find the minimum weight and set it's index
        $index = getMinWeightIndex($graph, $mst, $keys);
    }
    return $parents;
}

function getMinWeightIndex(Graph $graph, $mst, $keys) {
    $minDist = PHP_INT_MAX;
    $index = -1;
    for ($i=0; $i < $graph->getVerticeCount(); $i++) { 
        if(!$mst[$i] && $minDist > $keys[$i]) {
            $minDist = $keys[$i];
            $index = $i;
        }
    }
    return $index;
}

function primMSTV2(Graph $graph, $startIndex) {
    // init mst bool array to keep track of visited vertices
    // init weights array to keep track of vertice traversal weights
    // init parents array to keep track of vertice traversal parent
    $mst = array_fill(0, $graph->getVerticeCount(), False);
    $weights = array_fill(0, $graph->getVerticeCount(), PHP_INT_MAX);
    $parents = array_fill(0, $graph->getVerticeCount(), -1);

    // set startIndex weight to 0
    $weight[$startIndex] = 0;
    $index = $startIndex;

    // while not all vertices are visited
    //     set index vertice to visited
    //     get edges of index vertice
    //     traversal through edges
    //         if current edge vertex is not visited and index weight is bigger than current weight
    //             set index weight to current weight
    //             set current edge vertex parent to index
    //         move to next edge
    //     find the smallest weight vertex and use that as index for next iteration
    while (in_array(False, $mst)) {
        $mst[$index] = True;
        $curr = $graph->getEdges()[$index];
        while (!empty($curr)) {
            if (!$mst[$curr->data] && $weights[$curr->data] > $curr->weight) {
                $weights[$curr->data] = $curr->weight;
                $parents[$curr->data] = $index;
            }
            $curr = $curr->next;
        }
        $index = getMinWeightIndex($graph, $mst, $weights);
    }
    // return parents array
    return $parents;
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

echo implode(" ", primMST($graph, 0)) . PHP_EOL;
echo implode(" ", primMSTV2($graph, 0)) . PHP_EOL;
