<?php

include_once("abstract.Membership.php");

class PremiumMembership extends Membership {

    public function  __construct() {
        $this->expiry = 2017;
        $this->cost = 20;
        $this->maxActiveBook = 2;
        $this->activeBooks = [];
    }
}