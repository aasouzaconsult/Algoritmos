<?php

include_once("Fee.php");

class PaymentSystem {
    private static $instance = NULL;
    private $fee;

    public function __construct() {
        if (!self::$instance) {
            self::$instance = $this;
        }
        $this->fee = new Fee();
    }

    public function getInstance() {
        return self::$instance;
    }

    public function computeCharge(ParkStat $stat) {
        $rate = $this->fee->getVehicleFee($stat->vehicle->getType());
        return $stat->duration * $rate;
    }

    public function payCharge($charge) {
        // this can go into Display class
        if (!empty($charge)) {
            echo "Parking fee: " . $charge . PHP_EOL;
        } else {
            echo "No charge found." . PHP_EOL;
        }
    }
 }