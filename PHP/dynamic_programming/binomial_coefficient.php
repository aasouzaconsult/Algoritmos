<?php

/**
 * Computes the nth order binomial coefficient.
 * Time complexity: O(n^2)
 * compute values until given order param: (n^2)/2
 * 
 * Space complexity: O(n^2)
 * 
 */
function binomialCoefficient($order, $choose) {
    if ($order < 0) {
        return [];
    }
    // construct per row
    $temp = array_fill(0, $order+1, 0);
    $temp[0] = 1;
    // construct array
    $coefficients = array_fill(0, $order+1, $temp);
    unset($temp);
    // init end of coefficient for each row
    for ($i=1; $i < sizeof($coefficients); $i++) { 
        for ($j=1; $j <= $i; $j++) { 
            $coefficients[$i][$j] = $coefficients[$i-1][$j-1] + $coefficients[$i-1][$j];
        }
    }
    return $coefficients[$order][$choose];
}

function print2DArray($arr) {
    for ($i=0; $i < sizeof($arr); $i++) { 
        for ($j=0; $j < sizeof($arr[$i]); $j++) { 
            echo $arr[$i][$j] . " ";
        }
        echo PHP_EOL;
    }
}

echo binomialCoefficient(10, 0) . PHP_EOL;
echo binomialCoefficient(10, 1) . PHP_EOL;
echo binomialCoefficient(10, 2) . PHP_EOL;
echo binomialCoefficient(10, 3) . PHP_EOL;
echo binomialCoefficient(10, 4) . PHP_EOL;
echo binomialCoefficient(10, 5) . PHP_EOL;
echo binomialCoefficient(10, 6) . PHP_EOL;
echo binomialCoefficient(10, 7) . PHP_EOL;
echo binomialCoefficient(10, 8) . PHP_EOL;
echo binomialCoefficient(10, 9) . PHP_EOL;
echo binomialCoefficient(10, 10) . PHP_EOL;