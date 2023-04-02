<?php

class Diary {
    private $year;
    private $month;
    private $day;
    private $slots;

    public function __construct() {
        $this->year = [1, ..., 12];
        $this->month = [1, ..., 12];
        $this->day = [1,...,31];
        for ($i=0; $i < $this->year; $i++) { 
            for ($j=0; $j < $this->month; $j++) { 
                for ($k=0; $k < $this->day; $k++) { 
                    $this->slots[$i][$j][$k] = [1,...,8];
                }
            }
        }
    }

    public function getSlots($year, $month, $day) {
        $year--;
        $month--;
        $day--;
        return $this->slots[$year][$month][$day];
    }
}