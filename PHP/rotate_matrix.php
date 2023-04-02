<?php

/**
 * Given an image represented by an NxN matrix. where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 * Input: 2D array
 * size: 1 <= N <= 1000
 * Output: 2D array rotated 90 degrees right
 *
 * Time: O(n^2)
 * Space: O(1)
 */

function rotateMatrixRight90($arr) {
    for ($i=0; $i < sizeof($arr)/2; $i++) { 
        $first = $i;
        $last = sizeof($arr) - $i - 1;
        for ($j=$first; $j < $last; $j++) { 
            // offset
            $offset = $j - $first;
            // save top
            $top = $arr[$first][$j];
            // left -> top
            $arr[$first][$j] = $arr[$last-$offset][$first];
            // down -> left
            $arr[$last-$offset][$first] = $arr[$last][$last-$offset];
            // right -> down
            $arr[$last][$last-$offset] = $arr[$j][$last];
            // top -> right
            $arr[$j][$last] = $top;
        }
    }
    return $arr;
}

function print2Darray($arr) {
    for ($i=0; $i < sizeof($arr); $i++) { 
        for ($j=0; $j < sizeof($arr[$i]); $j++) { 
            echo $arr[$i][$j] . " ";
        }
        echo PHP_EOL;
    }
}

$arr = [
    [1,2,3,4],
    [5,6,7,8],
    [9,10,11,12],
    [13,14,15,16]
];

print2Darray(rotateMatrixRight90($arr));