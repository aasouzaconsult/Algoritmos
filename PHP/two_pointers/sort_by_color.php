<?php

/**
 * Time: O(n^2)
 * Space: O(1)
 */
function sortByColor($arr1, $order) {
    if (empty($arr1)) {
        return [];
    }
    $i = 0;
    $orderIdx = 0;

    while ($i < sizeof($arr1)) {
        if ($arr1[$i] != $order[$orderIdx]) {
            $found = False;
            for ($j=$i+1; $j < sizeof($arr1); $j++) { 
                if ($arr1[$j] == $order[$orderIdx]) {
                    swap($arr1[$i], $arr1[$j]);
                    $found = True;
                    $i++;
                }
            }
            if (!$found) {
                $orderIdx++;
            }
        } else {
            $i++;
        }
    }
    return $arr1;
}

function swap(&$v1, &$v2) {
    $temp = $v1;
    $v1 = $v2;
    $v2 = $temp;
}

/**
 * OPTIMAL
 * Time: O(n) where n is size of array
 * Space: O(1)
 *
 */
function sortByColorV2($arr1) {
    if (empty($arr1)) {
        return [];
    }
    $end_0 = -1;
    $start_2 = sizeof($arr1);
    $i = 0;
    $j = sizeof($arr1) - 1;
    while ($i <= $j) {
        if ($arr1[$i] == 0 || $arr1[$j] == 0) {
            $end_0++;
            if ($arr1[$i] == 0) {
                swap($arr1[$i], $arr1[$end_0]);
            } else {
                swap($arr1[$j], $arr1[$end_0]);
            }
        }
        if ($arr1[$i] == 2 || $arr1[$j] == 2) {
            $start_2--;
            if ($arr1[$i] == 2) {
                swap($arr1[$i], $arr1[$start_2]);
            } else {
                swap($arr1[$j], $arr1[$start_2]);
            }
        }
        $i++;
        $j--;
    }
    return $arr1;
}

$order = [
    0 => 0,
    1 => 1,
    2 => 2
];
$arr1 = [0,1,2,0,1,2];

print_r(sortByColor($arr1, $order));
print_r(sortByColorV2($arr1));