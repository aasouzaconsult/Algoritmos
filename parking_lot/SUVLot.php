<?php

include_once("Lot.php");
include_once("VehicleType.php");

class SUVLot extends Lot {

    public function __construct($number) {
        $this->number = $number;
        $this->type = VehicleType::SUV;
        $this->isAvailable = True;
    }
}