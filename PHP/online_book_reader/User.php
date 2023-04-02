<?php

include_once("abstract.Membership.php");
include_once("BaseMembership.php");
include_once("Book.php");

class User {
    private $name;
    private $membership;

    public function __construct($name) {
        $this->name = $name;
        $this->membership = new BaseMembership();
    }

    public function changeMembership(Membership $membership) {
        $this->membership = $membership;
    }

    public function extendMembership() {
        $expiry = $this->membership->getExpiry();
        $this->membership->setExpiry($expiry + 1);
    }

    public function setActiveBook(Book $book) {
        $activeBooks = $this->membership->getActiveBooks();
        $maxAllowed = $this->membership->getMaxActiveBook();
        if (sizeof($activeBooks) == $maxAllowed) {
            throw new Exception("Max books allowed reached.");
        }
        $this->membership->addActiveBook($book);
    }

    public function removeActiveBook($title) {
        $books = $this->membership->getActiveBooks();
        if (isset($books[$title])) {
            unset($books[$title]);
        }
    }

    public function getActiveBooks() {
        return $this->membership->getActiveBooks();
    }

    public function browse($collection) {
        print_r($collection);
    }
}