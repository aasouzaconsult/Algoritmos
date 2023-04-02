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

class EdgeList {
    private $head;

    public function __construct($edgeArray) {
        if (empty($edgeArray)) {
            return;
        }
        $value = array_shift($edgeArray);
        $this->head = new EdgeNode($value);
        if (!is_null($value)) {
            $this->count = 1;
        }
        while (!empty($edgeArray)) {
            $newNode = new EdgeNode(array_shift($edgeArray));
            $curr = $this->head;
            while (!empty($curr->next)) {
                $curr = $curr->next;
            }
            $curr->next = $newNode;
            $this->count++;
        }
    }

    /**
     * Insert to the end of the node.
     */
    public function insert($data, $weight=0, $next=NULL) {
        $newEdgeNode = new EdgeNode($data, $weight, $next);
        $this->count++;
        if (empty($this->head)) {
            $this->head = $newEdgeNode;
        }
        $curr = $this->head;
        while (!empty($curr->next)) {
            $curr = $curr->next;
        }
        $curr->next = $newEdgeNode;
        return;
    }

    public function getHead() {
        return $this->head;
    }

    public function getSize() {
        return $this->count;
    }

    public function printList() {
        if (empty($this->head)) {
            return;
        }
        echo "Node count: " . $this->count . PHP_EOL;
        $curr = $this->head;
        while (!empty($curr)) {
            echo "{$curr->data} ";
            $curr = $curr->next;
        }
        echo PHP_EOL;
    } 
}

class Graph {
    private $edges; // adjacency info. array of head pointers to adj lists
    private $degrees; // outdegree of each vertex
    private $nVertices; // number of vertices
    private $nEdges; // number of edges
    private $directed; // is the graph directed?

    public function __construct($nVertices = 0, $nEdges = 0, $directed = false) {
        $this->nVertices = $nVertices;
        $this->edges = array_fill(0, $nVertices, NULL);
        $this->degrees = array_fill(0, $nVertices, 0);
        $this->nEdges = $nEdges;
        $this->directed = $directed;
    }

    public function insertEdge(EdgeList $edgeList) {
        if (empty($edgeList)) {
            return false;
        }
        foreach ($this->edges as $key => $ptr) {
            if (empty($ptr)) {
                $this->edges[$key] = $edgeList->getHead();
                $this->degrees[$key] = $edgeList->getSize();
                $this->nEdges += $edgeList->getSize();
                break;
            }
        }
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

// $graph = new Graph(5);

// $edgeList0 = new EdgeList([1,4]);
// $edgeList1 = new EdgeList([0,4,2,3]);
// $edgeList2 = new EdgeList([1,3]);
// $edgeList3 = new EdgeList([1,4,2]);
// $edgeList4 = new EdgeList([3,0,1]);

// $graph->insertEdge($edgeList0);
// $graph->insertEdge($edgeList1);
// $graph->insertEdge($edgeList2);
// $graph->insertEdge($edgeList3);
// $graph->insertEdge($edgeList4);
// $graph->printGraph();
