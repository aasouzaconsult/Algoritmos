<?php

abstract class Lot {
    protected $number;
    protected $type;
    protected $isAvailable;

    public function getNumber() {
        return $this->number;
    }

    public function isAvailable() {
        return $this->isAvailable;
    }

    public function setUnavailable() {
        if ($this->isAvailable) {
            $this->isAvailable = !$this->isAvailable;
        }
    }

    public function setAvailable() {
        if (!$this->isAvailable) {
            $this->isAvailable = !$this->isAvailable;
        }
    }

    public function getType() {
        return $this->type;
    }
}