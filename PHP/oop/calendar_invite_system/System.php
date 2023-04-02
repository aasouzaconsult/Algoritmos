<?php

class System {
    private $users;
    private $emailer;

    public function __construct() {
        $this->users = [];
        $this->emailer = new Emailer('gmail');
    }

    public function addUser(User $user, $name) {
        if (!isset($this->users[$name])) {
            $this->users[$name] = $user;
            return True;
        }
        return False;
    }

    public function userAvailable(User $user, Appointment $appt) {
        $userSlots = $user->getAvailability();
        $apptSlot = $appt->getSlot();
        if (in_array($apptSlot, $userSlots)) {
            return True;
        }
        return False;
    }

    public function sendEmail(Email $sender, Email $receipient, $subject, $body, Template $template) {
        $this->emailer->send($sender, $receipient, $subject, $body, $template);
    }

    public function getUserSlots($name) {
        if (!isset($this->users[$name])) {
            return;
        }
        return $this->users[$name]->getSlots();
    }
}