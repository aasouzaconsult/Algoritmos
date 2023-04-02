<?php

// You are in an infinite 2D grid where you can move in any of the 8 directions :
//  (x,y) to 
//     (x+1, y), 
//     (x - 1, y), 
//     (x, y+1), 
//     (x, y-1), 
//     (x-1, y-1), 
//     (x+1,y+1), 
//     (x-1,y+1), 
//     (x+1,y-1) 

/**
 * Since we must move to each point accordingly, the min steps required is essentially
 * the max step between rows moved and col moved.
 * Time: O(A) where A is size of array A, and assuming B is equal in size to A
 * Space: O(1)
 */
function minStepsInfiniteGrid($A, $B) {
    if (empty($A) || empty($B)) {
        return;
    }
    $result = 0;
    for ($i=1; $i < sizeof($A); $i++) { 
        $startRow = $A[$i-1];
        $startCol = $B[$i-1];
        $endRow = $A[$i];
        $endCol = $B[$i];
        
        $result += max(abs($endRow - $startRow), abs($endCol - $startCol));
    }
    return $result;
}

$A = [0,1,2];
$B = [0,1,2];

echo minStepsInfiniteGrid($A, $B);