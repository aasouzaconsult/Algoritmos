<?php

/**
 * Given a number, return true if the number is prime, false otherwise.
 * Trial division method.
 * Time: O(n^(1/2))
 */
function isPrime($num) {
    //base case, 2 and 3 are primes
    if ($num == 2 || $num == 3) {
        return True;
    } elseif ($num % 2 == 0) {
        return False;
    }
    // number loop from 2 until sqrt of num, if any mod value is a whole number,
    // then number cannot be a prime.
    for ($i=2; $i <= floor(sqrt($num)); $i++) { 
        if ($num % $i == 0) {
            return False;
        }
    }
    return True;
}

// 900719925474001 // True
$numbers = [
    2,3,5,6,7,8,9,10,11,36,37,
];
for ($i=0; $i < sizeof($numbers); $i++) { 
    if (isPrime($numbers[$i])) {
        echo $numbers[$i] . " is prime." . PHP_EOL;
    } else {
        echo $numbers[$i] . " NOT prime." . PHP_EOL;
    }
}