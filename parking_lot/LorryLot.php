<?php

include_once("Lot.php");
include_once("VehicleType.php");

class LorryLot extends Lot {

    public function __construct($number) {
        $this->number = $number;
        $this->type = VehicleType::LORRY;
        $this->isAvailable = True;
    }
}