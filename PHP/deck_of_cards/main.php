<?php

function __autoload($className) {
    $filename = "./" . $className . ".php";
    include_once($filename);
}

$game = new Game();
$player1 = new Player('bob');
$player2 = new Player('mary');

$game->setGame([$player1, $player2]);
$deck = $game->getDeck();

$player1->drawCard($deck->getCard());
$player2->drawCard($deck->getCard());
$player1->drawCard($deck->getCard());
$player2->drawCard($deck->getCard());

$game->decideWinner($player1, $player2);