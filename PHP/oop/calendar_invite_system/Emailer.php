<?php

class Emailer {
    private $host;

    public function __construct($host) {
        $this->host = $host;
    }

    public function send(Email $sender, Email $receipient, $subject, $body, $template) {
        $this->host->sendEmail($sender, $receipient, $subject, $body, $template);
    }

    public function sendMultiple(Email $sender, $receipients, $subject, $body, $template) {
        foreach ($receipients as $receipient) {
            $this->send($sender, $receipient, $subject, $body, $template);
        }
    }
}