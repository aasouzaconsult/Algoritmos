<?php

class Email {
    private $username;
    private $domain;

    public function __construct($username, $domain) {
        $this->username = $username;
        $this->domain = $domain;
    }

    public function getEmail() {
        return $this->username . "@" . $this->domain; 
    }
}