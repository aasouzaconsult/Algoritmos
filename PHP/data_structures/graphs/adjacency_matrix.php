<?php

class Graph {
    const ACTIVE_EDGE = 1;
    const INACTIVE_EDGE = 0;

    private $matrix;

    public function __construct($vertices) {
        $row = array_fill(0, $vertices, self::INACTIVE_EDGE);
        $this->matrix = array_fill(0, $vertices, $row);
    }

    public function insertEdge($vertice1, $vertice2) {
        if ($vertice1 < 0 || $vertice2 < 0) {
            return false;
        }
        $this->matrix[$vertice1][$vertice2] = self::ACTIVE_EDGE;
        return true;
    }

    public function getMatrix() {
        return $this->matrix;
    }

    public function printMatrix() {
        for ($i=0; $i<sizeof($this->matrix); $i++) {
            echo implode(" ", $this->matrix[$i]) . PHP_EOL;
        }
    }
}

$graph = new Graph(5);
$graph->insertEdge(0,1);
$graph->insertEdge(0,4);
$graph->insertEdge(1,0);
$graph->insertEdge(1,2);
$graph->insertEdge(1,3);
$graph->insertEdge(1,4);
$graph->insertEdge(2,1);
$graph->insertEdge(2,3);
$graph->insertEdge(3,1);
$graph->insertEdge(3,2);
$graph->insertEdge(3,4);
$graph->insertEdge(4,0);
$graph->insertEdge(4,1);
$graph->insertEdge(4,3);
$graph->printMatrix();
