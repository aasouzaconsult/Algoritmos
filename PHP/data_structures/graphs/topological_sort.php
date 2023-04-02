<?php

include "adjacency_list.php";

/**
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of
 * vertices such that for every directed edge uv, vertex u comes before v in
 * the ordering. Topological Sorting for a graph is not possible if the graph
 * is not a DAG.
 */

function topologicalSortIterative(Graph $graph) {
    // init visited ref array
    // init resultStack
    // loop through all vertices one by one
    //     if vertice not visited
    //         mark vertice as visited
    //         loop through all vertices adj to this vertex
    //             if this vertex not visited
    //                 visit the vertex
    //         finished visited all vertices adj to this vertex
    //         put vertex into resultStack
    $visited = array_fill(0, $graph->getVerticeCount(), False);
    $stack = [];
    $traverseStack = [];
    $flipStack = [];
    for ($i=0; $i < $graph->getVerticeCount(); $i++) {
        if (!in_array($i, $traverseStack) && !$visited[$i]) {
            $traverseStack[] = $i;
        }
        while (!empty($traverseStack)) {
            $index = array_pop($traverseStack);
            if (!$visited[$index]) {
                $visited[$index] = True;
                $curr = $graph->getEdges()[$index];
                while (!empty($curr) && !is_null($curr->data)) {
                    if (!$visited[$curr->data]) {
                        $visited[$curr->data] = True;
                        $flipStack[] = $curr->data;
                    }
                    $curr = $curr->next;
                }
                $traverseStack = array_merge($traverseStack, array_reverse($flipStack));
                $flipStack = [];
            }
            $stack[] = $index;
        }
    }
    return implode(" ", array_reverse($stack));
}

function topologicalSortV2(Graph $graph) {
    $visited = array_fill(0, $graph->getVerticeCount(), False);
    $result = [];
    $traverseStack = [];

    for ($i=0; $i < $graph->getVerticeCount(); $i++) { 
        if (!in_array($i, $traverseStack) && !$visited[$i]) {
            $traverseStack[] = $i;
        }
        while (!empty($traverseStack)) {
            $index = array_pop($traverseStack);
            if (!$visited[$index]) {
                $visited[$index] = True;
                $curr = $graph->getEdges()[$index];

                while (!empty($curr) && !is_null($curr->data)) {
                    if (!$visited[$curr->data]) {
                        $visited[$curr->data] = True;
                        $traverseStack[] = $curr->data;
                    }
                    $curr = $curr->next;
                }
            }
            $result[] = $index;
        }
    }
    return implode(" ", array_reverse($result));
}

function topologicalSort(Graph $graph) {
    // init visited ref array
    // init stack
    // loop through all vertices one by one
    //     if vertice is not visited
    //         visit the vertice
    // print the stack top to bottom
    $visited = array_fill(0, $graph->getVerticeCount(), False);
    $stack = [];

    for($i=0; $i < $graph->getVerticeCount(); $i++) {
        if (!$visited[$i]) {
            topoSortVisit($graph, $i, $visited, $stack);
        }
    }
    return implode(" ", array_reverse($stack));
}

function topoSortVisit($graph, $index, &$visited, &$stack) {
    // mark visited index true
    // loop through all vertices adjacent to this vertex
    //     if this vertex not visited
    //         visit the vertex
    // finished visiting all vertices adjacent to this vertex
    // put vertex into stack
    $visited[$index] = True;
    $curr = $graph->getEdges()[$index];
    while (!empty($curr) && !is_null($curr->data)) {
        if (!$visited[$curr->data]) {
            topoSortVisit($graph, $curr->data, $visited, $stack);
        }
        $curr = $curr->next;
    }
    $stack[] = $index;
}

$graph = new Graph(6, 0, True);

$edgeList0 = new EdgeList([NULL]);
$edgeList1 = new EdgeList([NULL]);
$edgeList2 = new EdgeList([3]);
$edgeList3 = new EdgeList([1]);
$edgeList4 = new EdgeList([0,1]);
$edgeList5 = new EdgeList([0,2]);

$graph->insertEdge($edgeList0);
$graph->insertEdge($edgeList1);
$graph->insertEdge($edgeList2);
$graph->insertEdge($edgeList3);
$graph->insertEdge($edgeList4);
$graph->insertEdge($edgeList5);
$graph->printGraph();

echo topologicalSort($graph) . PHP_EOL;
echo topologicalSortV2($graph) . PHP_EOL;
echo topologicalSortIterative($graph) . PHP_EOL;