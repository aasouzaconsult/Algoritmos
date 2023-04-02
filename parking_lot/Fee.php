<?php

include_once("VehicleType.php");

class Fee {
    private $feeChart;

    public function __construct() {
        $this->feeChart = [
            VehicleType::MOTORCYCLE => 0.50,
            VehicleType::SEDAN => 1.00,
            VehicleType::LORRY => 2.00,
            VehicleType::SUV => 1.50
        ];
    }

    public function getFeeChart() {
        return $this->feeChart;
    }

    public function getVehicleFee(VehicleType $vehicleType) {
        return $this->feeChart[$vehicleType];
    }
}