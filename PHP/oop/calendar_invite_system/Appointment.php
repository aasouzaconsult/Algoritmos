<?php

class Appointment {
    private $slot;
    private $year;
    private $month;
    private $day;

    public function __construct($year, $month, $day, $slot) {
        $this->year = $year;
        $this->month = $month;
        $this->day = $day;
        $this->slot = $slot;
    }

    public function getSlot() {
        return $this->slot;
    }
}