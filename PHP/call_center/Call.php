<?php

class Call {
    private $caller;

    public function __construct($caller) {
        $this->caller = $caller;
    }

    public function getCaller() {
        return $this->caller;
    }
}