<?php

include_once("CDplayer.php");
include_once("Display.php");
include_once("CD.php");

class Jukebox {
    private $CDplayer;
    private $display;
    private $CDs;

    public function __construct() {
        $this->CDplayer = new CDplayer();
        $this->display = new Display();
        $this->CDs = [];
    }

    public function addCD(CD $cd) {
        $this->CDs[] = $cd;
    }
    public function getCDs() {
        return $this->getCDs;
    }

    public function getSongs($cdId) {
        if (empty($this->CDs[$cdId])) {
            return;
        }
        return $this->CDs[$cdId]->getSongs();
    }

    public function queueSongs($cdId, $songIds) {        
        $songs = $this->CDs[$cdId]->getSongs();
        foreach ($songIds as $id) {
            $this->CDplayer->addSong($songs[$id]);
        }
        return True;
    }

    public function getPlaylist() {
        $this->display->displayPlaylist($this->CDplayer->getPlaylist());
    }

    public function play() {
        if ($this->CDplayer->isEmptyList()) {
            return;
        }
        $result = $this->CDplayer->play();        
        $this->display->nowPlaying($result);
        return;
    }

    public function next() {
        $this->CDplayer->nextSong();
        $this->display->nowPlaying($this->CDplayer->currentSong());
    }

    public function currentSong() {
        $current = $this->CDplayer->currentSong();
        $this->display->nowPlaying($result);
        return;
    }

    public function nextSong() {
        $next = $this->CDplayer->nextSong();
        $this->display->nowPlaying($next);
    }

    public function setUp() {
        $cd1 = new CD('fantasy', [
            'jian dan ai',
            'ai zai xi yuan qian',
            'ren zhe',
            'dui bu qi',
            'an jing'
        ]);
        $cd2 = new CD('aiyo not bad', [
            'yang ming shan',
            'qe ai',
            'tian ya guo ke',
            'zen me le',
        ]);
        $this->CDs[] = $cd1;
        $this->CDs[] = $cd2;
    }
}