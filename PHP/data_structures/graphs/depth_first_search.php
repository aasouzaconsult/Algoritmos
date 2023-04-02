<?php

include "adjacency_list.php";

function depthFirstSearchIterative(Graph $graph, $startIndex, $callback) {
    // init visited ref array
    // mark start index as visited
    // init stack and put start index into stack
    // while stack is not empty
    //     pop element index from stack
    //     'visit' index
    //     get index's edge vertices
    //     while traversal of edge vertices
    //         if curr vertice is not visited
    //             mark as visited
    //             put into stack
    //         move to next edge
    $visited = array_fill(0, $graph->getVerticeCount(), False);
    $parents = array_fill(0, $graph->getVerticeCount(), NULL);

    $visited[$startIndex] = True;
    $stack = [$startIndex];

    while (!empty($stack)) {
        $index = array_pop($stack);
        $callback($index);
        $curr = $graph->getEdges()[$index];
        $tempQueue = [];
        while (!empty($curr)) {
            if (!$visited[$curr->data]) {
                $parents[$curr->data] = $index;
                $visited[$curr->data] = True;
                // $stack[] = $curr->data;
                $tempQueue[] = $curr->data;
            }
            $curr = $curr->next;
        }
        while (!empty($tempQueue)) { // using this here so the order of visiting is in sequential order with the input edges 
            $stack[] = array_pop($tempQueue);
        }
    }
}

function depthFirstSearchRecursive(Graph $graph, $startIndex, $callback) {
    // init visited ref array
    $visited = array_fill(0, $graph->getVerticeCount(), False);
    $parents = array_fill(0, $graph->getVerticeCount(), NULL);
    // recursive call dfs
    _depthFirstSearchRecursive($graph, $startIndex, $visited, $parents, $callback);
}

function _depthFirstSearchRecursive(Graph $graph, $startIndex, &$visited, &$parents, $callback) {
    // mark startindex as visited
    // 'visit' startindex
    // get startindex's edge vertices
    // while traversal of edge vertices
    //     if  curr vertice is not visited
    //         mark as visited
    //         set parents index
    //         recursive call dfs with curr->data
    $visited[$startIndex] = True;
    $callback($startIndex);
    $curr = $graph->getEdges()[$startIndex];
    while (!empty($curr)) {
        if (!$visited[$curr->data]) {
            $visited[$curr->data] = True;
            $parents[$curr->data] = $startIndex;
            _depthFirstSearchRecursive($graph, $curr->data, $visited, $parents, $callback);
        }
        $curr = $curr->next;
    }
}

function findPath($start, $end, $parents) {
    if ($start == $end || $end < $start) {
        echo "{$start} ";
    } else {
        findPath($start, $parents[$end], $parents);
        echo "{$end} ";
    }
}

function printData($data) {
    echo "{$data} ";
}

$graph = new Graph(12);

$edgeList0 = new EdgeList([1,2,3]);
$edgeList1 = new EdgeList([0,4,5]);
$edgeList2 = new EdgeList([0]);
$edgeList3 = new EdgeList([0,6,7]);
$edgeList4 = new EdgeList([1,8,9]);
$edgeList5 = new EdgeList([1]);
$edgeList6 = new EdgeList([3,10,11]);
$edgeList7 = new EdgeList([3]);
$edgeList8 = new EdgeList([4]);
$edgeList9 = new EdgeList([4]);
$edgeList10 = new EdgeList([6]);
$edgeList11 = new EdgeList([6]);

$graph->insertEdge($edgeList0);
$graph->insertEdge($edgeList1);
$graph->insertEdge($edgeList2);
$graph->insertEdge($edgeList3);
$graph->insertEdge($edgeList4);
$graph->insertEdge($edgeList5);
$graph->insertEdge($edgeList6);
$graph->insertEdge($edgeList7);
$graph->insertEdge($edgeList8);
$graph->insertEdge($edgeList9);
$graph->insertEdge($edgeList10);
$graph->insertEdge($edgeList11);
$graph->printGraph();

depthFirstSearchIterative($graph, 0, 'printData');
echo PHP_EOL;
depthFirstSearchRecursive($graph, 0, 'printData');
echo PHP_EOL;