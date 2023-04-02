<?php

/**
 * Given an input file with four billion non-negative integers, provide an algorithm
 * to generate an integer that is not contained in the file. Assume you have 1GB of
 * memory available for this task.
 *
 * FOLLOW UP
 * What if you have only 10MB of memory? Assume that all the values are distinct
 * and we now have no more than one billion non-negative integers.
 */

/**
 * Assume each integer is 8 bytes long, 
 * 1KB -> 128 ints
 * 1MB -> 128,000 ints
 * 1GB -> 128,000,000 ints
 *
 * This means, each time, we can process a maximum of 128million integers.
 *
 * 4,000,000,000 / 128,000,000 = 31.25 times
 *
 * This means, to just look at all the 4B integers with 1GB memory, we need to fetch
 * integers into memory 31.25 times.
 * 
 */