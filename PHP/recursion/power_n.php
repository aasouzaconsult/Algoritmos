<?php

// Given base and n that are both 1 or more, compute recursively (no loops)
// the value of base to the n power, so powerN(3, 2) is 9 (3 squared).

// powerN(3, 1) -> 3
// powerN(3, 2) -> 9
// powerN(3, 3) -> 27

// mission: given a base and power, return the exponential value.
// base case: power is 1, just return the base

function powerN($base, $power) {
    if ($power == 1) {
        return $base;
    }
    return powerN($base, $power-1) * $base;
}

echo powerN(3,1) . PHP_EOL;
echo powerN(3,2) . PHP_EOL;
echo powerN(3,3) . PHP_EOL;