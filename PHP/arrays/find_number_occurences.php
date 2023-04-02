<?php

/**
 * Given a sorted array of integers and a number, find the number of occurences
 * of the number.
 */

/**
 * Method 1. Do a linear search and count the number occurence.
 * Time: O(n)
 * Space: O(1)
 */
function findOcurrenceBrute($arr, $num) {
    if (empty($arr)) {
        return 0;
    }
    $count = 0;
    for ($i=0; $i < sizeof($arr); $i++) { 
        if ($arr[$i] == $num) {
            $count++;
        }
    }
    return $count;
}

/**
 * Optimal
 * Method 2.
 * Using binary search, we search for starting and ending index of the number.
 * Then ending index - starting index + 1 will be the number of occurence.
 * Time: O(lgn) where n is size of the array
 * Space: O(1)
 *
 */
function findOcurrence($arr, $num) {
    if (empty($arr)) {
        return 0;
    }
 
    $leftIndex = findLeftOcurrenceIndex($arr, $num, 0, sizeof($arr)-1);
    $rightIndex = findRightOcurrenceIndex($arr, $num, 0, sizeof($arr)-1);
    echo $leftIndex . " : " . $rightIndex . PHP_EOL;
    if (is_null($leftIndex)) {
        return 0;
    }
    return $rightIndex - $leftIndex + 1;
}

function findLeftOcurrenceIndex($arr, $num, $start, $end) {
    if ($start > $end) {        
        return;
    }
    $mid = floor(($start + $end) / 2);
    if ($arr[$mid] == $num) {
        if ($mid - 1 < 0 || $arr[$mid - 1] != $num) {
            return $mid;
        } else {
            return findLeftOcurrenceIndex($arr, $num, $start, $mid-1);
        }
    } elseif ($num < $arr[$mid]) {
        return findLeftOcurrenceIndex($arr, $num, $start, $mid-1);
    } else {
        return findLeftOcurrenceIndex($arr, $num, $mid+1, $end);
    }
}

function findRightOcurrenceIndex($arr, $num, $start, $end) {
    if ($start > $end) {
        return;
    }
    $mid = floor(($start + $end) / 2);
    if ($arr[$mid] == $num) {
        if ($mid+1 >= sizeof($arr) || $arr[$mid+1] != $num) {
            return $mid;
        } else {
            return findRightOcurrenceIndex($arr, $num, $mid+1, $end);
        }
    } elseif ($num < $arr[$mid]) {
        return findRightOcurrenceIndex($arr, $num, $start, $mid-1);
    } else {
        return findRightOcurrenceIndex($arr, $num, $mid+1, $end);
    }
}

/**
 * Using binary search. When number is found, iteratively search its left and right
 * for the same number until both ends are not the number. Then return the count.
 * Time: O(lgn + S) where n is size of array, S is number of times the number occurs
 * Space: O(1)
 * 
 */
function findOcurrenceV3($arr, $num) {
    if (empty($arr)) {
        return 0;
    }
    return findOcurrenceCount($arr, $num, 0, sizeof($arr)-1);
}

function findOcurrenceCount($arr, $num, $start, $end) {
    if ($start > $end) {
        return 0;
    }
    $mid = floor(($start + $end) / 2);
    if ($arr[$mid] == $num) {
        $count = 1;
        $i = $mid-1;
        $j = $mid+1;
        while ($i >=0 && $j < sizeof($arr)) {
            if ($arr[$i] == $num) {
                $count++;
                $i--;
            } elseif ($arr[$j] == $num) {
                $count++;
                $j++;
            } else {
                break;
            }
        }
        return $count;
    } elseif ($num < $arr[$mid]) {
        return findOcurrenceCount($arr, $num, $start, $mid-1);
    } else {
        return findOcurrenceCount($arr, $num, $mid+1, $end);
    }
}

$arr1 = [1,2,2,3,3,3,3,5,5];
$arr2 = [ 1, 2, 3, 4, 5, 5, 5, 6 ];
echo findOcurrence($arr1, 3) . PHP_EOL;
echo findOcurrenceBrute($arr1, 3) . PHP_EOL;
echo findOcurrenceV3($arr1, 3) . PHP_EOL;
echo PHP_EOL;
echo findOcurrence($arr2, 5) . PHP_EOL;
echo findOcurrenceBrute($arr2, 5) . PHP_EOL;
echo findOcurrenceV3($arr2, 5) . PHP_EOL;
