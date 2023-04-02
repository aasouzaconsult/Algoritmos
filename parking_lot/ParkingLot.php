<?php

include_once("abstract.Vehicle.php");
include_once("VehicleType.php");
include_once("MotorcycleLot.php");
include_once("LorryLot.php");
include_once("SedanLot.php");
include_once("SUVLot.php");

class ParkingLot {
    private $lots;
    private $isFull;
    private $count;
    private $paymentSystem;
    private $parkStat;

    public function __construct($lots=[], $paymentSystem=NULL) {
        $this->lots = $lots;
        $this->count = 0;
        $this->isFull = False;
        $this->paymentSystem = $paymentSystem;
        $this->parkStat = new ParkStat();
    }

    public function setUp() {
        $this->paymentSystem = new PaymentSystem();
        $mcLots = [
            new MotorcycleLot(1),
            new MotorcycleLot(2),
            new MotorcycleLot(3)
        ];
        $lorryLots = [
            new LorryLot(1),
            new LorryLot(2),
            new LorryLot(3),
        ];
        $sedanLots = [
            new SedanLot(1),
            new SedanLot(2),
            new SedanLot(3),
            new SedanLot(4),
            new SedanLot(5),
            new SedanLot(6),
        ];
        $SUVLots = [
            new SUVLot(1),
            new SUVLot(2),
            new SUVLot(3),
            new SUVLot(4),
        ];
        $lots = [$mcLots, $lorryLots, $sedanLots, $SUVLots];
        foreach ($lots as $lotCategory) {
            $type = $lotCategory[0]->getType();
            foreach ($lotCategory as $lot) {
                $this->lots[$type][] = $lot;
            }
        }
    }

    public function admit(Vehicle $vehicle) {
        $type = $vehicle->getType();
        $typeLots = $this->lots[$type];

        foreach ($typeLots as $key => $lot) {
            if ($lot->isAvailable()) {
                $lot->setUnavailable();
                $this->parkStat->setStat($vehicle);
                return True;
            }
        }
    }

    public function leave(Vehicle $vehicle) {
        $type = $vehicle->getType();
        $typeLots = $this->lots[$type];

        foreach ($typeLots as $key => $lot) {
            if ($lot->occupiedVehicle() == $vehicle) {
                $stat = $this->parkStat->getVehicleStat($vehicle);
                $charge = $this->paymentSystem->computeCharge($stat);
                $this->paymentSystem->payCharge($charge);
                echo "Vehicle exited. Have a good day!" . PHP_EOL;
            }
        }
    }
}