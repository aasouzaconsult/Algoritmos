<?php

class Display {
    public function __construct() {

    }

    public function nowPlaying($current) {
        if ($current) {
            echo "Now playing " . $current . PHP_EOL;
            return;
        }
        $this->emptyList();
    }

    public function emptyList() {
        echo "Playlist empty. Add new songs." . PHP_EOL;
    }

    public function displayPlaylist($list) {
        print_r($list);
    }
}