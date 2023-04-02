<?php

class Collection {
    private $books;
    private $count;

    public function __construct() {
        $this->books = [];
        $this->count = 0;
    }

    public function addBook(Book $book) {
        $title = $book->getTitle();
        if (!isset($this->books[$title])) {
            $this->books[$title] = $book;
            $this->count++;
            return True;
        }
        return False;
    }

    public function addBooks($books) {
        if (empty($books)) {
            return False;
        }
        foreach ($books as $book) {
            $this->addBook($book);
        }
        return True;
    }

    public function getBooks() {
        return $this->books;
    }

    public function getBook($title) {
        if (isset($this->books[$title])) {
            return $this->books[$title];
        }
        return;
    }
}