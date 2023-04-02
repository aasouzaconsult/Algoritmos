<?php

/**
 * Radix sort, like counting sort and bucket sort, is an integer based
 *  algorithm. Hence radix sort is among the fastest sorting algorithms
 *  around, in theory. The particular distinction for radix sort is that
 *  it creates a bucket for each digit in numbers; as such, each bucket
 *  in radix sort must be a growable list that may admit different keys.
 *
 *  For decimal values, the number of buckets is 10, as the decimal system
 *  has 10 numerals (i.e 0..9). Then the keys are continuously sorted by
 *  significant digits.
 */

/**
 * Time: O(kn) where n is number of elements and k is number of passes of the sorting algorithm
 * Space: O(n)
 */
function radixSort($input) {
    // find out the max digits among the given input integers
    // loop while not max digit length
    //     create a bucket for each digit from 0 to 9
    //     loop through every input element
    //         put elements with same digits number in the same bucket
    //     copy sorted element into input array
    //     advance digit placement to look at next higher order
    // return sorted input
}