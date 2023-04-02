<?php

/**
 * Implementing a graph using an adjacency matrix.
 * Vertice number start from 0.
 */

class Graph {
    private $matrix;

    public function __construct($verticeCount) {
        $this->matrix = array_fill(0, 5, array_fill(0, 5, 0));
    }

    public function addEdge($vertice1, $vertice2) {
        $this->matrix[$vertice1][$vertice2] = 1;
    }

    public function bfs($start) {
        $visited = array_fill(0, sizeof($this->matrix), False);
        $visitOrder = [];
        $queue = [$start];

        while (!empty($queue)) {
            $vertice = array_shift($queue);
            $visitOrder[] = $vertice;
            $visited[$vertice] = True;
            for ($i=0; $i < sizeof($this->matrix[$vertice]); $i++) { 
                if ($this->matrix[$vertice][$i] != 0) {
                    if (!$visited[$i] && !in_array($i, $queue)) {
                        $queue[] = $i;
                    }
                }
            }
        }
        return $visitOrder;
    }

    public function dfsIterative($start) {
        $visited = array_fill(0, sizeof($this->matrix), False);
        $visitOrder = [];
        $stack = [$start];

        while (!empty($stack)) {
            $vertice = array_pop($stack);
            $visitOrder[] = $vertice;
            $visited[$vertice] = True;
            for ($i=0; $i < sizeof($this->matrix[$vertice]); $i++) { 
                if ($this->matrix[$vertice][$i] != 0) {
                    if (!$visited[$i] && !in_array($i, $stack)) {
                        $stack[] = $i;
                    }
                }
            }
        }
        return $visitOrder;
    }

    public function dfsRecursive($start) {
        $visited = array_fill(0, sizeof($this->matrix), False);
        $visitOrder = [];
        $this->dfsRecur($visited, $visitOrder, $start);
        return $visitOrder;
    }

    private function dfsRecur(&$visited, &$visitOrder, $start) {
        $visitOrder[] = $start;
        $visited[$start] = True;
        for ($i=0; $i < sizeof($this->matrix[$start]); $i++) { 
            if ($this->matrix[$start][$i] != 0) {
                if (!$visited[$i]) {
                    $this->dfsRecur($visited, $visitOrder, $i);
                }
            }
        }
    }

    public function printMatrix() {
        for ($row=0; $row < sizeof($this->matrix); $row++) { 
            for ($col=0; $col < sizeof($this->matrix[$row]); $col++) { 
                echo $this->matrix[$row][$col] . " ";
            }
            echo PHP_EOL;
        }
    }
}

$graph = new Graph(5);
$graph->addEdge(0,1);
$graph->addEdge(0,4);
$graph->addEdge(1,0);
$graph->addEdge(1,4);
$graph->addEdge(1,2);
$graph->addEdge(1,3);
$graph->addEdge(2,1);
$graph->addEdge(2,3);
$graph->addEdge(3,1);
$graph->addEdge(3,4);
$graph->addEdge(3,2);
$graph->addEdge(4,3);
$graph->addEdge(4,0);
$graph->addEdge(4,1);
$graph->printMatrix();
print_r($graph->bfs(0));
print_r($graph->dfsIterative(0));
print_r($graph->dfsRecursive(0));