<?php

class User {
    private $name;

    public function __construct($name) {
        $this->name = $game;
    }

    public function selectCD($CDs) {
        if (empty($CDs)) {
            return;
        }
        return [$CDs[0], $CDs[2]];
    }

    public function chooseSongs($songs) {
        if (empty($songs)) {
            return;
        }
        return [$songs[1], $songs[3]];
    }
}