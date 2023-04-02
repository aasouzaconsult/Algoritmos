<?php

class CD {
    private $title;
    private $songs;

    public function __construct($title, $songs) {
        $this->title = $title;
        $this->songs = $songs;
    }

    public function getTitle() {
        return $this->title;
    }

    public function getSongs() {
        return $this->songs;
    }
}