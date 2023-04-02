<?php

class CDplayer {
    private $playlist;
    private $currentSongIndex;

    public function __construct() {
        $this->playlist = [];
        $this->currentSongIndex = NULL;
    }

    public function isEmptyList() {
        return empty($this->playlist);
    }

    public function play() {
        if (empty($this->playlist)) {
            return NULL;
        }
        if (is_null($this->currentSongIndex)) {
            $this->currentSongIndex = 0;
        }
        return $this->playlist[$this->currentSongIndex];
    }

    public function currentSong() {
        return $this->playlist[$this->currentSongIndex];
    }

    public function nextSong() {
        if (isset($this->playlist[$this->currentSongIndex+1])) {
            $this->currentSongIndex++;
        } else {            
            return False;
        }
        $this->play();
        return True;
    }

    public function addSong($song) {
        $this->playlist[] = $song;
        return;
    }

    public function getPlaylist() {
        return $this->playlist;
    }

}