<?php

abstract class Vehicle {
    protected $model;
    protected $make;
    protected $type;

    public function getModel() {
        return $this->model;
    }

    public function getMake() {
        return $this->make;
    }

    public function getType() {
        return $this->type;
    }
}