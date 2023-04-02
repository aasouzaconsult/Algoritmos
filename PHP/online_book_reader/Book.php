<?php

class Book {
    private $author;
    private $title;
    private $genre;

    public function __construct($title, $author, $genre) {
        $this->title = $title;
        $this->author = $author;
        $this->genre = $genre;
    }

    public function getTitle() {
        return $this->title;
    }

    public function getAuthor() {
        return $this->author;
    }

    public function getGenre() {
        return $this->genre;
    }
}