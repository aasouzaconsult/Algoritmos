<?php

include_once("../../Utility.php");

/**
 * https://www.interviewbit.com/problems/prettyprint/
 * Time: O(n^2)
 * Space: O(n^2)
 */

function prettyPrint($num) {
    if ($num < 1) {
        return;
    }
    // calculate matrix size
    $size = $num * 2 - 1;
    // init matrix by this size
    $matrix = array_fill(0, $size, array_fill(0, $size, NULL));
    // insert guiding values
    $j = $num;
    for ($i=0; $i < $num; $i++) { 
        $matrix[$i][$i] = $j;
        $j--;
    }    
    $j+=2;
    for ($k=$i; $k < sizeof($matrix); $k++) { 
        $matrix[$k][$k] = $j;
        $j++;
    }
    $mid = floor(sizeof($matrix) / 2);    
    list($leftIndex, $rightIndex) = [$mid-1, $mid+1];
    while (True) {
        // both left and right index out of bounds
        if ($leftIndex < 0 && $rightIndex >= sizeof($matrix)) {
            break;
        }
        $value = $matrix[$leftIndex][$leftIndex];
        // set left side of value
        if ($leftIndex >= 0) {
            
            for ($i=0; $i < sizeof($matrix); $i++) { 
                $matrix[$leftIndex][$i] = $value;
                $matrix[$i][$leftIndex] = $value;
            }
        }
        // set right side of value
        if ($rightIndex < sizeof($matrix)) {            
            for ($i=0; $i < sizeof($matrix); $i++) { 
                $matrix[$rightIndex][$i] = $value;
                $matrix[$i][$rightIndex] = $value;
            }
        }    
        $leftIndex--;
        $rightIndex++;
    }
    return $matrix;
}

$util = new Utility();
$util->print2DArray(prettyprint(4));