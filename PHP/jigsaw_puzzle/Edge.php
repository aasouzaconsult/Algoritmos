<?php

class Edge {
    private $shape;
    private $parentPiece;

    public function __construct() {

    }

    public function fitsWith(Edge $edge) {
        return False; // if given $edge does not fit with $this edge
        return True; // if given $edge fits with $this edge
    }
}