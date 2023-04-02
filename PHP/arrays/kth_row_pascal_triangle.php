<?php

/**
 * Given an index k, return the kth row of the Pascal’s triangle.
 * 
 * Pascal’s triangle : To generate A[C] in row R, sum up A[C] and A[C-1] from previous row R - 1.
 *
 * Example:
 * Input : k = 3
 * Return : [1,3,3,1]
 *
 * Note:Could you optimize your algorithm to use only O(k) extra space?
 */

/**
 * Time: O(n^2)
 * Time: O(n) where n is the size of pascal triangle at n.
 *
 */
function kthPascalTriangle($num) {
    if ($num < 0) {
        return [];
    } elseif ($num == 0) {
        return [1];
    } 
    $pascal = [1,1];
    if ($num > 1) {
        for ($i=2; $i <= $num; $i++) { 
            $temp = [1];
            for ($j=1; $j < sizeof($pascal); $j++) { 
                $temp[] = $pascal[$j] + $pascal[$j-1];
            }
            $temp[] = 1;
            $pascal = $temp;
            $temp = [];
        }
    }
    return $pascal;
}

$num1 = 4;

print_r(kthPascalTriangle($num1));