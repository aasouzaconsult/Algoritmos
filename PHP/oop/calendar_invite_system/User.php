<?php

class User {
    private $name;
    private $email;
    private $diary;    
    private $appts;

    public function __construct($name, Email $email, Diary $diary) {
        $this->name = $name;
        $this->email = $email;
        $this->diary = $diary;
        $this->appts = [];
    }

    public function setAppt($year, $month, $day, $slot) {
        $available = True;
        foreach ($this->appts as $appt) {
            if ($appt->getSlot() == $slot) {
                $available = False;
                break;
            }
        }
        if ($available) {
            $newAppt = new Appointment($year, $month, $day, $slot);
            $this->appts[] = $newAppt;
            return True;
        }
        return False;
    }

    public function getAppt($index) {
        return $this->appts[$index];
    }

    public function getAvailablity() {
        // set 8 slots initially
        // filter with $this->appts
        // return filtered slots.
    }
}