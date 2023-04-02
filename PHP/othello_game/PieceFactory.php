<?php

/**
 * Factory to produce othello pieces.
 */
class PieceFactory {
    private static $instance;

    public function __construct() {
        self::$instance = $this;
    }

    public function getInstance() {
        if (!self::$instance) {
            self::$instance = $this;
        }
        return self::$instance;
    }

    public function build($isWhite) {
        return new Piece($isWhite);
    }
}