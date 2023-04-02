<?php

function __autoload($className) {
    $filename = "./" . $className . ".php";
    include_once($filename);
}

function main() {
    $callCenter = new CallCenter();
    $callCenter->addEmployee('apple', 'R');
    $callCenter->addEmployee('pear', 'R');
    $callCenter->addEmployee('bob', 'R');
    $callCenter->addEmployee('roger', 'M');
    $callCenter->addEmployee('david', 'M');
    $callCenter->addEmployee('gary', 'D');

    $call1 = new Call(12345);
    $call2 = new Call(67890);

    $callCenter->handle($call1);
    $callCenter->handle($call2);
    $callCenter->handle($call2);
    $callCenter->handle($call2);
}

main();