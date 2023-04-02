<?php

include_once("abstract.Employee.php");

class Respondent extends Employee {

    public function __construct($name, $title) {
        $this->name = $name;
        $this->title = 'R';
        $this->isAvailable = True;
        $this->canHandle = True;
    }

    public function handle($call) {
        $this->isAvailable = False;
        $this->canHandle = False;
    }
}