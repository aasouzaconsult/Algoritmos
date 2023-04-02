<?php

// You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

// Find i, j, k such that :
// max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
// Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

// **abs(x) is absolute value of x and is implemented in the following manner : **

//       if (x < 0) return -x;
//       else return x;
// Example :

// Input : 
//         A : [1, 4, 10]
//         B : [2, 15, 20]
//         C : [10, 12]

// Output : 5 
//          With 10 from A, 15 from B and 10 from C. 

/**
 * OPTIMAL
 * 1. maintain 3 pointers, 1 for each array
 * 2. compute the min and max value for each iteration, and update the global min
 * diff if smaller
 * 3. find the min value and update the corresponding array's pointer
 * 
 * Time: O(a + b + c) where a, b, c are sizes of A B C array respectively
 * Space: O(1)
 */
function minDiff($A, $B, $C) {
    list($i, $j, $k) = [0,0,0];
    $minDiff = PHP_INT_MAX;
    $result = [];

    while ($i < sizeof($A) && $j < sizeof($B) && $k < sizeof($C)) {
        $maxValue = max($A[$i], $B[$j], $C[$k]);
        $minValue = min($A[$i], $B[$j], $C[$k]);
        $diff = $maxValue - $minValue;

        if ($diff == 0) {
            echo $A[$i] . " . " . $B[$j] . " . " . $C[$k] . PHP_EOL;
            return 0;
        } elseif ($diff < $minDiff) {
            $result = [$A[$i], $B[$j], $C[$k]];
            $minDiff = $diff;
        }
        if ($A[$i] == $minValue) {
            $i++;
        } elseif ($B[$j] == $minValue) {
            $j++;
        } else{
            $k++;
        }
    }
    print_r($result);
    return $minDiff;
}

$A = [1, 4, 10];
$B = [2, 15, 20];
$C = [10, 12];

$D = [20, 24, 100];
$E = [2, 19, 22, 79, 800];
$F = [10, 12, 23, 24, 119];

echo minDiff($A, $B, $C) . PHP_EOL;
echo minDiff($D, $E, $F) . PHP_EOL;