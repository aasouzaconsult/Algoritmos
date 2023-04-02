<?php

abstract class Employee {
    protected $name;
    protected $title;
    protected $isAvailable;
    protected $canHandle;

    public function getName() {
        return $this->name;
    }

    public function getTitle() {
        return $this->title;
    }

    public function isAvailable() {
        return $this->isAvailable; 
    }

    public function canHandle() {
        return $this->canHandle;
    }

    abstract public function handle($call);
}