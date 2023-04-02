<?php

function __autoload($className) {
    $filename = "./" . $className . ".php";
    include_once($filename);
}

function main() {
    $prem = new PremiumMembership();
    $user = new User('gary');
    $user->changeMembership($prem);

    $collection = new Collection();
    $books = [
        new Book('dance', 'robert', 'scifi'),
        new Book('run', 'daniel', 'inspiration'),
        new Book('blood diamond', 'craig', 'non-fiction'),
        new Book('refactoring', 'hahaguy', 'technology'),
    ];
    $collection->addBooks($books);
    $bookCollection = $collection->getBooks();
    $user->browse($bookCollection);

    $book = $collection->getBook('refactoring');
    $user->setActiveBook($book);
    $book2 = $collection->getBook('blood diamond');
    $user->setActiveBook($book2);
    print_r($user->getActiveBooks());
}

main();