<?php

/**
 * Find the nth prime number.
 * Optimizations:
 * 1. skip all even numbers
 * 2. to check if an integer is prime, we loop through all know primes less than
 * sqrt of integer and perform modulo check. any modulo returning 0 will render this
 * integer as not prime.
 * 3. once a prime is found, add it into the prime list, if number of prime has 
 * reached $n, return the last prime inserted.
 *
 * Time: O(n^2) although the actual runtime will be much faster
 * Space: O(n)
 */
function nthPrime($n) {
    // invalid input
    if ($n < 1) {
        return -1;
    }
    // put in first prime number
    $primes[1] = 2;
    if ($n == 1) {
        return $primes[1];
    }
    $primeCount = 1; // keep track of the number of prime elements found
    // loop until nth prime is found
    for ($i=3; $i < PHP_INT_MAX; $i+=2) { 
        // check for prime with list of know primes
        $isPrime = True;
        for ($j=1; $j < $i && $primes[$j] <= floor(sqrt($i)); $j++) { 
            if ($i % $primes[$j] == 0) {
                $isPrime = False;
                break;
            }
        }
        if ($isPrime) {
            $primes[] = $i;
            if (++$primeCount == $n) {
                break;
            }
        }
    }
    return end($primes);
}

/**
 * Sieve of Eratosthenes.
 * Time: O(nlog logn)
 * Space: O(n)
 */
function allPrimesTo($number) {
    $isPrime = array_fill(0, $number+1, True);
    for ($i=2; $i <= floor(sqrt($number)); $i++) { 
        if ($isPrime[$i]) {
            for ($j=pow($i, 2); $j <= $number; $j +=$i) { 
                $isPrime[$j] = False;
            }
        }
    }
    $result = [];
    for ($i=2; $i < sizeof($isPrime); $i++) { 
        if ($isPrime[$i]) {
            $result[] = $i;
        }
    }
    return $result;
}
// 2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97
echo implode(" ", allPrimesTo(200)) . PHP_EOL;
for ($i=1; $i <=30 ; $i++) { 
    echo nthPrime($i) . " ";
}
echo PHP_EOL;