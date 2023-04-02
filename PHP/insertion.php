<?php

/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write
 * a method to insert M into N such that M starts at bit j and ends at bit i. You
 * can assume that the bits j through i have enough space to fit all of m. That is,
 * if M = 10011, you can assume that there are at least 5 bits between j and i.
 * You would not, for example have j=3 and i=2, because M could not fully fit 
 * between bit 3 and bit 2.
 *
 * EXAMPLE
 * Input: N = 100000000000, M = 10011, i = 2, j = 6
 * Output: N=10001001100
 *
 * // $mask = $mask | (1 << index); // set a index bit to 1
 * // $mask = $mask & ~(1 << index); // set a index bit to 0
 * // ($mask & (1 << index)) != 0 // check a bit. if its 1, its true, 0 false
 */
function insertionV2($M, $N, $j, $i) {
    $allOnes = ~0b0;
    $left = $allOnes << $j + 1;
    $right = ((1 << $i) - 1);

    $mask = $left | $right;
    
    $nCleared = $N & $mask;
    $mShifted = $M << $i;
    $result = $nCleared | $mShifted;

    return decbin($result);
}

function insertion($M, $N, $j, $i) {
    // find out the length of M, ie position of most significant bit
    $mCopy = $M;
    $index = 0;
    while ($mCopy > 1) {
        $mCopy = $mCopy >> 1;
        $index++;
    }

    $N = $N | (1 << $j);
    for ($i=$index; $i >= 0; $i--) { 
        if (($M & (1 << $i)) != 0) {
            $N = $N | (1 << $j); // set bit to 1
        } else {
            $N = $N & ~(1 << $j); // set bit to 0
        }
        $j--;
    }
    return decbin($N);
}

$N1 = 0b10000000000;
$M1 = 0b10011;
$result = 0b10001001100;

insertion($M1, $N1, 6, 2) . PHP_EOL;
echo insertionV2($M1, $N1, 6, 2) . PHP_EOL;
