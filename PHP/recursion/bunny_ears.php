<?php

// We have a number of bunnies and each bunny has two big floppy ears.
// We want to compute the total number of ears across all the bunnies
// recursively (without loops or multiplication).

// bunnyEars(0) -> 0
// bunnyEars(1) -> 2
// bunnyEars(2) -> 4

// Mission statement:
// Base case: 0 as input, return 0

function bunnyEars($bunnies) {
    if ($bunnies == 0) {
        return 0;
    }
    return bunnyEars($bunnies - 1) + 2;
}

echo bunnyEars(0) . PHP_EOL; // 0
echo bunnyEars(1) . PHP_EOL; // 2
echo bunnyEars(2) . PHP_EOL; // 4
echo bunnyEars(3) . PHP_EOL; // 6
echo bunnyEars(4) . PHP_EOL; // 8
echo bunnyEars(5) . PHP_EOL; // 10