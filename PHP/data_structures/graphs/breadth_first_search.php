<?php

include "adjacency_list.php";

/**
 * BFS.
 * Time: O(|V| + |E|) where V is the number of vertices, E is the number of edges
 * Space: O(|V|) since we have to create visited, parent arrays according to the
 * number of vertices
 */
function breadthFirstSearch(Graph $graph, $startIndex, $callback) {
    // mark every vertex as undiscovered and unprocessed and parent to null
    // mark startindex as discovered.
    // put startindex node into queue.
    // while queue is not empty
    //     set dequeue element variable
    //     process dequeue element
    //     get edges of dequeued element
    //     while loop traverse through the edges
    //          check process edge status
    //          check discovered edge status
    //          move to next edge
    //     mark dequeued element as processed
    $discovered = array_fill(0, $graph->getVerticeCount(), False);
    $processed = array_fill(0, $graph->getVerticeCount(), False);
    $parent = array_fill(0, $graph->getVerticeCount(), NULL);

    $discovered[$startIndex] = True;
    $queue = [$startIndex];

    while (!empty($queue)) {
        $index = array_shift($queue);
        $callback($index);
        $curr = $graph->getEdges()[$index];
        while (!empty($curr)) {
            if (!$discovered[$curr->data]) {
                $discovered[$curr->data] = True;
                $parent[$curr->data] = $index;
                $queue[] = $curr->data;
            }
            $curr = $curr->next;
        }
        $processed[$index] = True;
    }
}

function breadthFirstSearchV2(Graph $graph, $startIndex, $callback) {
    // init visited reference array
    // mark start index as visited
    // init queue and enqueue start index
    // while queue is not empty
    //     pop first 'item' in queue
    //     callback visit 'item'
    //     get 'item's edges
    //     while traverse the edges
    //         if curr edge vertice not visited
    //             mark as visited
    //             enqueue vertice
    //         move to next edge
    $visited = array_fill(0, $graph->getVerticeCount(), False);
    $parent = array_fill(0, $graph->getVerticeCount(), NULL);

    $visited[$startIndex] = True;
    $queue = [$startIndex];

    while (!empty($queue)) {
        $index = array_shift($queue);
        $callback($index);
        $curr = $graph->getEdges()[$index];
        while(!empty($curr)) {
            if (!$visited[$curr->data]) {
                $visited[$curr->data] = True;
                $parent[$curr->data] = $index;
                $queue[] = $curr->data;
            }
            $curr = $curr->next;
        }
    }
    print_r($parent);
    findPath(0, 11, $parent);
    echo PHP_EOL;
    findPathIterative(0, 11, $parent);
}

function findPath($start, $end, $parents) {
    if ($start == $end || $end < 0) {
        echo "{$start} ";
    } else {
        findPath($start, $parents[$end], $parents);
        echo "{$end} ";
    }
}

function findPathIterative($start, $end, $parents) {
    $curr = $end;
    while (!is_null($parents[$curr])) {
        echo "{$curr} ";
        $curr = $parents[$curr];
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

breadthFirstSearch($graph, 0, 'printData');
echo PHP_EOL;
breadthFirstSearchV2($graph, 0, 'printData');
echo PHP_EOL;