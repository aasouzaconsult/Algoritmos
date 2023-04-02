<?php

function __autoload($className) {
    $filename = "./" . $className . ".php";
    include_once($filename);
}

function main() {
    $player1 = new Player('gary', True);
    $player2 = new Player('janice', False);
    $game = new OthelloGame(8, $player1, $player2);
    $game->setUp();

    // $whiteChoices = $board->getChoices($player1);
    // $whiteCoord = $player1->makeChoice($whiteChoices);
    // $board->add($player1, $whiteCoord);
    // print_r($whiteCoord);
    // $board->printBoard();

    $player1Turn = True;    
    do {
        $board = $game->getBoard();
        if ($player1Turn) {
            $choices = $board->getChoices($player1);
            $coord = $player1->makeChoice($choices);
            $board->add($player1, $coord);
        } else {
            $choices = $board->getChoices($player2);
            $coord = $player2->makeChoice($choices);
            $board->add($player2, $coord);
        }
        $player1Turn = !$player1Turn;
        echo "=========================" . PHP_EOL;
        $board->printBoard();
    } while (!$board->isFull() || !$choices->isEmpty());

    $game->declareResult();
}

main();