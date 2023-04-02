<?php

include_once("Lot.php");
include_once("VehicleType.php");

class SedanLot extends Lot {

    public function __construct($number) {
        $this->number = $number;
        $this->type = VehicleType::SEDAN;
        $this->isAvailable = True;
    }
}