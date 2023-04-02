<?php

include_once("Respondent.php");
include_once("Manager.php");
include_once("Director.php");

class EmployeeFactory {
    const RESPONDENT = 'R';
    const MANAGER = 'M';
    const DIRECTOR = 'D';

    public function __construct() {}

    public function buildEmployee($name, $title) {
        if ($title == self::RESPONDENT) {
            return new Respondent($name, $title);
        } elseif ($title == self::MANAGER) {
            return new Manager($name, $title);
        } elseif ($title == self::DIRECTOR) {
            return new Director($name, $title);
        } else {
            return NULL;
        }
    }
}