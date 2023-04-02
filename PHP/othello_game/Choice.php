<?php

/**
 * Choice is a container of coordinates defined by [row, col]
 */
class Choice {
    public $choices;

    public function __construct() {
        $this->choices = [];
    }

    public function add($coordinate) {
        $this->choices[] = $coordinate;
    }

    public function isEmpty() {
        return empty($this->choices);
    }

    public function getChoices() {
        return $this->choices;
    }
}