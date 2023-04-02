<?php

function __autoload($className) {
    $filename = "./" . $className . ".php";
    include_once($filename);
}

function main() {
    $boonLay = new ParkingLot();
    $boonLay->setUp();
}

main();