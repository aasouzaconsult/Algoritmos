<?php

// A long array A[] is given to you. There is a sliding window of size w which is
// moving from the very left of the array to the very right. You can only see the
// w numbers in the window. Each time the sliding window moves rightwards by one position.

// Example :

// The array is [1 3 -1 -3 5 3 6 7], and w is 3.

// Window position Max
     
// [1 3 -1] -3 5 3 6 7 3
// 1 [3 -1 -3] 5 3 6 7 3
// 1 3 [-1 -3 5] 3 6 7 5
// 1 3 -1 [-3 5 3] 6 7 5
// 1 3 -1 -3 [5 3 6] 7 6
// 1 3 -1 -3 5 [3 6 7] 7
// Input: A long array A[], and a window width w
// Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
// Requirement: Find a good optimal way to get B[i]

//  Note: If w > length of the array, return 1 element with the max of the array. 

/**
 * Brute force.
 * Compare the window values to look for max value at each sliding window instance.
 * 
 * Time: O(nw)
 * Space: O(n)
 */
function slidingWindowMax($arr, $w) {
    $result = [];

    for ($i=0; $i <= sizeof($arr)-$w; $i++) {
        if (!empty($result)) {
            $lastValue = $result[sizeof($result)-1];
            if ($arr[$i + $w - 1] >= $lastValue) {
                $result[] = $arr[$i + $w - 1];
                continue;
            }
        }
        $maxValue = max(array_slice($arr, $i, $w));
        $result[] = $maxValue;
    }
    return $result;
}

/**
 * OPTIMAL.
 * Use a double ended queue.
 * the left of the queue is the maximum value for the current window size.
 * Elements to the right of the queue are elements in descending order. meaning
 * that element will be the maximum of the window if previous elements are popped off.
 * we also need to keep track of when the max elements falls outside of the window. 
 * To do that, we store the indexes of the element instead of the element itself.
 * 
 * 1. init queue and result array
 * 2. loop through array
 * 3.   if queue is empty, just append current index to end of the queue
 * 4.   else pop off indexes at the end of queue which its elements are less than current element
 * 5.       put current element into the end of the queue. // descending order is maintained here.
 * 6.   if current window has reached its size
 * 7.       pop off indexes that falls outside of window
 * 8.       put first(the maximum) index element to result
 * 9. return result
 *
 * Time: O(n)
 * Space: O(n)
 */
function slidingWindowMaxV2($arr, $w) {
    $result = [];
    $queue = [];
    for ($i=0; $i < sizeof($arr); $i++) { 
        if (empty($queue)) {
            $queue[] = $i;
        } else {
            while ($arr[$queue[sizeof($queue)-1]] <= $arr[$i]) {
                array_pop($queue);
                if (empty($queue)) {
                    break;
                }
            }
            $queue[] = $i;
        }
        if ($i >= $w - 1) {
            while ($i - $queue[0] >= $w) {
                array_shift($queue);
            }
            $result[] = $arr[$queue[0]];
        }
    }
    return $result;
}

$arr1 = [1, 3, -1, -3, 5, 3, 6, 7];
$arr2 = [ 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 ];

print_r(slidingWindowMax($arr1, 3));
print_r(slidingWindowMax($arr2, 2));

print_r(slidingWindowMaxV2($arr1, 3));
print_r(slidingWindowMaxV2($arr2, 2));
