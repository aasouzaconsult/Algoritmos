<?php

/**
 * You have a stack of n boxes, with widths w, height h, and depths d. The boxes
 * cannot be rotated and can only be stacked on top of one another if each box
 * in the stack is strictly larger than the box above it in width, height, and depth.
 * Implement a method to compute the height of the tallest possible stack. The height
 * of a stack is the sum of the heights of each box.
 */

/**
 * DP solution.
 * 1. generate all rotations of each of the boxes, so u have 3X of the number of boxes now.
 * 2. sort the boxes by descending base area, from largest(0 index) to smallest(1 index)
 * 3. initialize maxHeight and result array to store maximum height and its
 * immediate base box respectively
 * 4. set front and back pointers, with front = back+1 index.
 * 5. compare each set of front and back boxes to see if front box can fit into back box
 * 6. if fits, update max height where applicable and set the parent. back will stop at front index.
 * 7. else, advance front and set back to initial 0 position.
 * 8. get largest height and its associated index.
 * 9. use result array to construct the actual boxes involved.
 * 10. return height or actual boxes, whichever is asked for.
 * Time: O(n^2)
 * Space: O(n) from originally O(3n)
 * 
 */
function maxHeight($boxes) {
    // generate all box rotations and sort them by base area in descending order
    // ie. largest base area is at index 0, smallest area at last index
    $boxes = generateRotations($boxes);
    usort($boxes, 'compareBase');

    $maxHt = [];
    $result = [];
    for ($i=0; $i < sizeof($boxes); $i++) { 
        $maxHt[] = $boxes[$i][0][2];
        $result[] = $i;
    }
    $back = 0;
    $front = $back + 1;
    
    while ($front < sizeof($boxes)) {
        $smallerBase = [$boxes[$front][0][0], $boxes[$front][0][1]];
        $smallerHeight = $boxes[$front][0][2];
        $largerBase = [$boxes[$back][0][0], $boxes[$back][0][1]];

        if (canBeAbove($largerBase, $smallerBase)) {
            if ($maxHt[$back] + $smallerHeight > $maxHt[$front]) {
                $maxHt[$front] = $maxHt[$back] + $smallerHeight;
                $result[$front] = $back;
            }
            $back++;
            if ($back == $front) {
                $back = 0;
                $front++;
            }
        } else {
            $back = 0;
            $front++;
        }
    }
    // get max height and it's index. 
    $largest = max($maxHt);
    $key = array_search($largest, $maxHt);

    $resultBoxes[$key] = $boxes[$key][0];
    while ($result[$key] != $key) {
        $resultBoxes[] = $boxes[$result[$key]][0];
        $key = $result[$key];
    }
    echo $largest . PHP_EOL;
    return $resultBoxes;
}

function canBeAbove($base, $top) {
    if ($base[0] > $top[0] && $base[1] > $top[1]) {
        return True;
    }
    return False;
}

function generateRotations($boxes) {
    $result = [];
    foreach ($boxes as $box) {
        $temp = [];
        for ($i=0; $i < sizeof($box); $i++) { 
            $box[] = array_shift($box);
            $base = $box[0] * $box[1];
            $temp[] = [$box, $base];
        }
        $result = array_merge($result, $temp);
    }
    return $result;
}

function compareBase($value1, $value2) {
    if ($value1[1] == $value2[1]) {
        return 0; 
    }
    return ($value1[1] > $value2[1]) ? -1 : 1;
}
$boxes2 = [
    [4, 6, 7],
    [1, 2, 3],
    [4, 5, 6],
    [10, 12, 32],
];

$boxes1 = [
    [1,2,4],
    [3,2,5]
];

print_r(maxHeight($boxes1));
print_r(maxHeight($boxes2));
