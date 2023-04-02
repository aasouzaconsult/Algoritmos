<?php

include_once("abstract.Membership.php");

class BaseMembership extends Membership {

    public function  __construct() {
        $this->expiry = 2017;
        $this->cost = 0;
        $this->maxActiveBook = 1;
        $this->activeBooks = [];
    }

}