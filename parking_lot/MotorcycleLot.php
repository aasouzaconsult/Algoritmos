<?php

include_once("Lot.php");
include_once("VehicleType.php");

class MotorcycleLot extends Lot {

    public function __construct($number) {
        $this->number = $number;
        $this->type = VehicleType::MOTORCYCLE;
        $this->isAvailable = True;
    }
}