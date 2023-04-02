<?php

// We have triangle made of blocks. The topmost row has 1 block,
// the next row down has 2 blocks, the next row has 3 blocks, and so on.
// Compute recursively (no loops or multiplication) the total number of
// blocks in such a triangle with the given number of rows.

// triangle(0) -> 0
// triangle(1) -> 1
// triangle(2) -> 3
// triangle(3) -> 6
// triangle(4) -> 10

// mission statement: given the number of rows of triangle, return the total number of blocks required to construct triangle
// base case: 0 row -> 0 block
// 1 row -> 1 block
// 2 rows -> 3 blocks
function triangle($number) {
    if ($number == 0) {
        return 0;
    } elseif ($number == 1) {
        return 1;
    }
    return triangle($number-1) + $number;
}

echo triangle(0) . PHP_EOL; // 0
echo triangle(1) . PHP_EOL; // 1
echo triangle(2) . PHP_EOL; // 3
echo triangle(3) . PHP_EOL; // 6
echo triangle(4) . PHP_EOL; // 10