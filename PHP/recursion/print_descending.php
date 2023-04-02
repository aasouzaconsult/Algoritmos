<?php

function printDescending($n) {
    echo $n . PHP_EOL;
    if ($n > 1) {
        printDescending($n-1);
    }
}

printDescending(10);