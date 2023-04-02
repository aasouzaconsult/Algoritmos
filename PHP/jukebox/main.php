<?php

function __autoload($className) {
    $filename = "./" . $className . ".php";
    include_once($filename);
}

function main() {
    $jukeBox = new Jukebox();
    $jukeBox->setUp();
    $jukeBox->queueSongs(0, [0,3,4]);
    $jukeBox->queueSongs(1, [0,1,3]);
    $jukeBox->getPlaylist();

    $jukeBox->play();
    $jukeBox->next();
}

main();