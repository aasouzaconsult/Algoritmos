<?php

$caves = [];

function initCaves(&$caves, $num) {
    for ($i=0; $i < $num; $i++) { 
        $caves[] = 'O';
    }
    $startCave = rand(0, $num);
    $caves[$startCave] = 'ALI';
}

function getAliCave($caves) {
    for ($i=0; $i < sizeof($caves); $i++) { 
        if ($caves[$i] == 'ALI') {
            return $i;
        }
    }
}

function move(&$caves, $currCave) {
    $direction = rand(0, 1);
    $caves[$currCave] = 'O';
    if ($direction == 0) {
        if ($currCave-1 >= 0) {
            $caves[$currCave-1] = 'ALI';
        } else {
            $caves[$currCave+1] = 'ALI';
        }
    } else {
        if ($currCave+1 < sizeof($caves)) {
            $caves[$currCave+1] = 'ALI';
        } else {
            $caves[$currCave-1] = 'ALI';
        }
    }
}

function findAli($caves) {
    $even = True;
    $currIndex = 0;
    while ($caves[$currIndex] != 'ALI') {
        $currIndex += 2;
        if ($currIndex > sizeof($caves)) {
            if ($even) {
                $currIndex = 0;
                $even = False;
            } else {
                $currIndex = 1;
                $even = True;
            }
        }
        move($caves, getAliCave($caves));
        // printCaves($caves);
    }
    echo "ALI found at position: {$currIndex}" . PHP_EOL;
}

function printCaves($caves) {
    for ($i=0; $i < sizeof($caves); $i++) {         
        echo $caves[$i] . " ";        
    }
    echo PHP_EOL;
}

$caves = [];
initCaves($caves, 10000);
// printCaves($caves);
// while (True) {
//     move($caves, getAliCave($caves));
//     printCaves($caves);
//     echo PHP_EOL;
// }
findAli($caves);
