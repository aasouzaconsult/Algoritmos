<?php


// We have bunnies standing in a line, numbered 1, 2, ...
// The odd bunnies (1, 3, ..) have the normal 2 ears.
// The even bunnies (2, 4, ..) we'll say have 3 ears,
// because they each have a raised foot.
// Recursively return the number of "ears" in the bunny
// line 1, 2, ... n (without loops or multiplication).

// bunnyEars2(0) -> 0
// bunnyEars2(1) -> 2
// bunnyEars2(2) -> 5

// mission statement: given the number of bunnies, return the total number of ears
// odd bunny 2 ears
// even bunny 3 ears
// base case: 0 bunnies
function bunnyEars2($bunnies) {
    if ($bunnies == 0) {
        return 0;
    } elseif ($bunnies % 2 == 0) {
        //even case
        return bunnyEars2($bunnies-1) + 3;
    } else {
        // odd case
        return bunnyEars2($bunnies-1) + 2;
    }
}

echo bunnyEars2(0) . PHP_EOL; // 0
echo bunnyEars2(1) . PHP_EOL; // 2
echo bunnyEars2(2) . PHP_EOL; // 5
echo bunnyEars2(3) . PHP_EOL; // 7
echo bunnyEars2(4) . PHP_EOL; // 10
echo bunnyEars2(5) . PHP_EOL; // 12