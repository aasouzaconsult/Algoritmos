<?php

/**
 * Implmenting a graph using adjacency list, but using array instead.
 */

class Graph {
    private $adjList;

    public function __construct() {
        $this->adjList = [];
    }

    public function addEdge($vertice, $neighbours) {
        $this->adjList[$vertice] = $neighbours;
        return;
    }

    public function getEdges($index) {
        return $this->adjList[$index];
    }

    public function getVerticeCount() {
        return sizeof($this->adjList);
    }

    public function printGraph() {
        foreach ($this->adjList as $key => $value) {
            echo $key . ": " . "[" . implode(" ", $value) . "]" . PHP_EOL;
        }
    }

    public function bfs($start) {
        $visited = array_fill(0, sizeof($this->adjList), False);
        $visitOrder = [];
        $queue = [$start];

        while (!empty($queue)) {
            $vertice = array_shift($queue);
            $visitOrder[] = $vertice;
            $visited[$vertice] = True;
            for ($i=0; $i < sizeof($this->adjList[$vertice]); $i++) { 
                if (!$visited[$this->adjList[$vertice][$i]] &&
                    !in_array($this->adjList[$vertice][$i], $queue)) {
                        $queue[] = $this->adjList[$vertice][$i];
                }
            }
        }
        return $visitOrder;
    }

    public function dfsIterative($start) {
        $visited = array_fill(0, sizeof($this->adjList), False);
        $visitOrder = [];
        $stack = [$start];

        while (!empty($stack)) {
            $vertice = array_pop($stack);
            $visitOrder[] = $vertice;
            $visited[$vertice] = True;
            for ($i=0; $i < sizeof($this->adjList[$vertice]); $i++) { 
                if (!$visited[$this->adjList[$vertice][$i]] &&
                    !in_array($this->adjList[$vertice][$i], $stack)) {
                        $stack[] = $this->adjList[$vertice][$i];
                }
            }
        }
        return $visitOrder;
    }

    public function dfsRecursive($start) {
        $visited = array_fill(0, sizeof($this->adjList), False);
        $visitOrder = [];
        $this->dfsRecur($visited, $visitOrder, $start);
        return $visitOrder;
    }

    private function dfsRecur(&$visited, &$visitOrder, $start) {
        $visitOrder[] = $start;
        $visited[$start] = True;

        for ($i=0; $i < sizeof($this->adjList[$start]); $i++) { 
            if (!$visited[$this->adjList[$start][$i]]) {
                $this->dfsRecur($visited, $visitOrder, $this->adjList[$start][$i]);
            }
        }
    }
}

// $graph = new Graph();
// $graph->addEdge(0, [1,4]);
// $graph->addEdge(1, [0,2,3,4]);
// $graph->addEdge(2, [1,3]);
// $graph->addEdge(3, [1,4,2]);
// $graph->addEdge(4, [3,0,1]);
// $graph->printGraph();
// print_r($graph->bfs(0));
// print_r($graph->dfsIterative(0));
// print_r($graph->dfsRecursive(0));