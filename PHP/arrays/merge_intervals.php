<?php

// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
// You may assume that the intervals were initially sorted according to their start times.
// 
// Example 1:
// Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
// 
// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
// 
// Make sure the returned intervals are also sorted.

/**
 * Time: O(n)
 * Space: O(1)
 *
 */
function mergeIntervals($intervals, $newInterval) {
    if (empty($intervals)) {
        return $newInterval;
    } elseif (empty($newInterval)) {
        return $intervals;
    }
    // loop through every interval
    foreach ($intervals as $key => $interval) {
        $result = computeIntervals($newInterval, $interval);
        // based on result act accordingly based on scenarios
        $flag = $result[0];
        $range = $result[1];
        if ($flag == 0) {
            $currRange = $intervals[$key];
            unset($intervals[$key]);
            array_splice($intervals, $key, 0, [$range]);
            array_splice($intervals, $key, 0, [$currRange]);
            break;
        } elseif ($flag == 2) {
            unset($intervals[$key]);
            $newInterval = $range;
        } else {
            // do nothing
        }        
    }
    return $intervals;
}

function computeIntervals($newRange, $currRange) {
    $newSmall = $newRange[0];
    $newLarge = $newRange[1];
    $currSmall = $currRange[0];
    $currLarge = $currRange[1];

    if ($newLarge < $currSmall) {
        // case 1
        // add newRange before currRange
        // return newRange
        return [0, $newRange];
    } else {
        if ($currLarge < $newSmall) {
            // case 5
            // newRange compare with next, retain currRange
            // return newRange
            return [1, $newRange];
        } elseif ($newSmall < $currSmall && $currSmall < $newLarge && $newLarge < $currLarge) {
            // case 2
            // construct ns, cl. destroy currRange
            // return new constructed range
            return [2, [$newSmall, $currLarge]];
        } elseif ($newSmall < $currSmall && $currSmall < $newLarge && $currLarge < $newLarge) {
            // case 2
            // currRange is within newRange
            return [2, $newRange];
        } elseif ($currSmall < $newSmall && $newLarge < $currLarge) {
            // case 3
            // destroy currRange
            // return $currRange
            return [2, $currRange];
        } else {
            // case 4
            // construct cs, nl. destroy currRange
            // return new constructed range
            return [2, [$currSmall, $newLarge]];
        }
    }
}
$intervals1 = [
    [1,3],
    [6,9]
];
$newInterval1 = [2,5];

$intervals2 = [
    [1,2],[3,5],[6,7],[8,10],[12,16]
];
$newInterval2 = [4,9];
print_r(mergeIntervals($intervals1, $newInterval1));
print_r(mergeIntervals($intervals2, $newInterval2));