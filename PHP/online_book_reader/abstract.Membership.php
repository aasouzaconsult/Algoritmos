<?php

abstract class Membership {
    protected $expiry;
    protected $cost;
    protected $maxActiveBook;
    protected $activeBooks;

    public function setExpiry($expiry) {
        $this->expiry = $expiry;
    }

    public function getExpiry() {
        return $this->expiry;
    }

    public function getMaxActiveBook() {
        return $this->maxActiveBook;
    }

    public function getActiveBooks() {
        return $this->activeBooks;
    }

    public function addActiveBook($book) {
        $this->activeBooks[$book->getTitle()] = $book;
    }
}