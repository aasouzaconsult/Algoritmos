<?php

/**
 * A hotel manager has to process N advance bookings of rooms for the next season.
 * His hotel has K rooms. Bookings contain an arrival date and a departure date.
 * He wants to find out whether there are enough rooms in the hotel to satisfy
 * the demand.
 * Write a program that solves this problem in time O(NlogN).
 *
 * Input: 
 * First list for arrival time of booking.
 * Second list for departure time of booking.
 * Third is K which denotes count of rooms.
 * 
 * Output: 
 * A boolean which tells whether its possible to make a booking. 
 * Return 0/1 for C programs.
 * O -> No there are not enough rooms for N booking.
 * 1 -> Yes there are enough rooms for N booking.
 *
 * Example: 
 * Input : 
 *       Arrivals :   [1 3 5]
 *       Departures : [2 6 8]
 *       K : 1
 *
 * Return : False / 0 
 *
 * At day = 5, there are 2 guests in the hotel. But I have only one room. 
 */

/**
 * Time: O(A+D) where A is size of arrival array, D is size of departure array
 * Space: O(1)
 *
 */
function bookingPossible($arrivals, $departures, $K) {
    if (empty($arrivals) || empty($departures) || $K < 1) {
        return False;
    }
    while (True) {
        if (!empty($arrivals) && !empty($departures)) {
            if ($arrivals[0] < $departures[0]) {
                if ($K > 0) {
                    array_shift($arrivals);
                    $K--;
                } else {
                    return False;
                }
            } else {
                array_shift($departures);
                $K++;
            }
        } elseif (!empty($arrivals)) {
            // arrival not empty
            if ($K > 0) {
                array_shift($arrivals);
                $K--;
            } else {
                return False;
            }
        } else {
            // both empty
            break;
        }
    }
    return True;
}

$arr = [1,3,5];
$dep = [2,6,8];
$K = 2;

echo bookingPossible($arr, $dep, $K) . PHP_EOL;