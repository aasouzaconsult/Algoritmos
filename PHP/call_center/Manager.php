<?php

include_once("abstract.Employee.php");

class Manager extends Employee {

    public function __construct($name, $title) {
        $this->name = $name;
        $this->title = 'M';
        $this->isAvailable = True;
        $this->canHandle = True;
    }

    public function handle($call) {
        $this->isAvailable = False;
        $this->canHandle = False;
    }
}