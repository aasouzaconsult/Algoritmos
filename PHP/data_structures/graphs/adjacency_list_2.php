<?php

class EdgeNode {
    public $data;
    public $weight;
    public $next;

    public function __construct($data, $weight=0, $next=NULL) {
        $this->data = $data;
        $this->weight = $weight;
        $this->next = $next;
    }
}

class Graph {
    private $edges; // adjacency info. array of head pointers to adj lists
    private $degrees; // outdegree of each vertex
    private $nVertices; // number of vertices
    private $nEdges; // number of edges
    private $directed; // is the graph directed?

    public function __construct($nVertices=0, $nEdges=0, $directed=False) {
        $this->nVertices = $nVertices;
        $this->edges = array_fill(0, $nVertices, NULL);
        $this->degrees = array_fill(0, $nVertices, 0);
        $this->nEdges = $nEdges;
        $this->directed = $directed;
    }

    public function insertEdge($index, $data, $weight=0, $next=NULL) {
        if ($index < 0 || $index >= $this->nVertices) {
            return false;
        }
        $newNode = new EdgeNode($data, $weight, $next);
        $this->degrees[$index]++;
        $this->nEdges++;
        if (empty($this->edges[$index])) {
            $this->edges[$index] = $newNode;
        } else {
            $curr = $this->edges[$index];
            while (!empty($curr->next)) {
                $curr = $curr->next;
            }
            $curr->next = $newNode;
        }
        return True;
    }

    public function getVerticeCount() {
        return $this->nVertices;
    }

    public function getEdges() {
        return $this->edges;
    }

    public function getDegrees() {
        return $this->degrees;
    }

    public function printGraph() {
        echo "===Graph Details===" . PHP_EOL;
        echo "==Edges==" . PHP_EOL;
        for ($i=0; $i<sizeof($this->edges); $i++) {
            $curr = $this->edges[$i];
            echo "edge {$i} with degree: ". $this->degrees[$i] . PHP_EOL;
            while (!empty($curr)) {
                echo "{$curr->data} ";
                $curr = $curr->next;
            }
            echo PHP_EOL;
        }
        echo "Vertice count: {$this->nVertices}" . PHP_EOL;
        echo "Edge count: {$this->nEdges}" . PHP_EOL;
        if ($this->directed) {
            echo "Directed: TRUE" . PHP_EOL;
        } else {
            echo "Directed: FALSE" . PHP_EOL;
        }
    }
}

// $graph = new Graph(9, 0, False);
// $graph->insertEdge(0, 1, 4);
// $graph->insertEdge(0, 7, 8);

// $graph->insertEdge(1, 2, 8);
// $graph->insertEdge(1, 7, 11);

// $graph->insertEdge(2, 1, 8);
// $graph->insertEdge(2, 3, 7);
// $graph->insertEdge(2, 5, 4);
// $graph->insertEdge(2, 8, 2);

// $graph->insertEdge(3, 2, 7);
// $graph->insertEdge(3, 4, 9);
// $graph->insertEdge(3, 5, 14);

// $graph->insertEdge(4, 3, 9);
// $graph->insertEdge(4, 5, 10);

// $graph->insertEdge(5, 2, 4);
// $graph->insertEdge(5, 3, 14);
// $graph->insertEdge(5, 4, 10);
// $graph->insertEdge(5, 6, 2);

// $graph->insertEdge(6, 5, 2);
// $graph->insertEdge(6, 7, 1);
// $graph->insertEdge(6, 8, 6);

// $graph->insertEdge(7, 0, 8);
// $graph->insertEdge(7, 1, 11);
// $graph->insertEdge(7, 8, 7);
// $graph->insertEdge(7, 6, 1);

// $graph->insertEdge(8, 2, 2);
// $graph->insertEdge(8, 6, 6);
// $graph->insertEdge(8, 7, 7);
// $graph->printGraph();