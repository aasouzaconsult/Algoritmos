<?php

// Given a collection of intervals, merge all overlapping intervals.

// For example:

// Given [1,3],[2,6],[8,10],[15,18],

// return [1,6],[8,10],[15,18].

// Make sure the returned intervals are sorted.

/**
 * Time: O(nlgn) where n is size of interval. nlgn is due to comparison based sorting.
 * Space: O(n)
 *
 */
function mergeIntervals2($intervals) {
    uasort($intervals, compare);
    $stack = [];
    $stack[] = array_shift($intervals);
    foreach ($intervals as $interval) {
        if (canMerge($interval, $stack[sizeof($stack)-1])) {
            $result = merge($interval, $stack[sizeof($stack)-1]);
            array_pop($stack);
            $stack[] = $result;
        } else {
            $stack[] = $interval;
        }
    }
    return $stack;
}

function compare($range1, $range2) {
    if ($range1[0] < $range2[0]) {
        return -1;
    } else {
        return 1;
    }
}

/**
 * Time: O(n^2) where n is size of interval
 * Space: O(1)
 *
 */
function mergeIntervals($intervals) {
    if (empty($intervals)) {
        return;
    }
    do {
        $merged = False;
        for ($i=0; $i < sizeof($intervals); $i++) { 
            for ($j=$i+1; $j < sizeof($intervals); $j++) {
                if (canMerge($intervals[$i],$intervals[$j])) {
                    $result = merge($intervals[$i], $intervals[$j]);
                    unset($intervals[$j]);
                    $intervals[$i] = $result;
                    $merged = True;
                    break;
                }
            }
            if ($merged) {
                break;
            }
        }
        $intervals = array_values($intervals);
    } while ($merged);

    return $intervals;
}

function merge($range1, $range2) {
    $result = [];
    $i = 0;
    $j = 0;
    while ($i < sizeof($range1) && $j < sizeof($range2)) {
        if ($range1[$i] < $range2[$j]) {
            $result[] = $range1[$i];
            $i++;
        } else {
            $result[] = $range2[$j];
            $j++;
        }
    }
    while ($i < sizeof($range1)) {
        $result[] = $range1[$i];
        $i++;
    }
    while ($j < sizeof($range2)) {
        $result[] = $range2[$j];
        $j++;
    }
    return [$result[0], $result[sizeof($result)-1]];
}

function canMerge($range1, $range2) {
    list($small1, $large1) = $range1;
    list($small2, $large2) = $range2;
    if ($large1 < $small2 || $large2 < $small1) {
        return False;
    }
    return True;
}

$intervals1 = [[2,6],[8,10],[15,18],[1,3]];
$intervals2 = [[1,3], [2,4], [5,7], [6,8]];

// print_r(mergeIntervals($intervals1));
// print_r(mergeIntervals($intervals2));
print_r(mergeIntervals2($intervals1));
print_r(mergeIntervals2($intervals2));