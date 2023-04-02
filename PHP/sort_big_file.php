<?php

/**
 * Imagine you have a 20GB file with one string per line. Explain how you would
 * sort the file.
 */

// So we only know the file is 20GB and one string per line, without additional
// information about the kind of string we are dealing with. Let's assume the string
// is one word.
// The comparison of string relies on the first character, so "a..." < "b..."

// Brute Force.
// We can use inefficient sortings like bubble_sort, insertion sort, selection sort
// which has O(n^2) complexity and O(1) space.
// However, this might take too long to run as the filesize is large.

// counting sort, has O(n+k) time, which are non comparison
// based sort. could be useful here but we are missing information on what kinds
// of strings we are looking at. ie, we dont know if there will be enough
// duplicates to justify using counting sort

// Bucket sort could be an option here. Having O(n^2) worst case and O(n+k) average
// case. we know that there are only 26 alphabets so we could have 26 buckets.
// since we are talking about large inputs, we could modify the buckets such that each
// bucket also a minheap. that could reduce the complexity closer to O(n+k).


// If we don't have any buffer memory, we have to sort the file in place.
// We are forced to use comparison based algorithm here.

// Heapsort could be a good one here. we just imagine the file is like an array delimited
// by a new line. By heapifying the file, we have O(nlgn) time complexity. After
// the file is heapified, we then extract from top of line and push into bottom.
// This is O(n). So the final time complexity is O(nlgn + n), which simplifies to
// O(nlgn), having O(1) space complexity.

// Mergesort has O(nlgn), while quicksort has O(n^2) worse complexity(though really
// small chance if we use random parition). Since we don't know much about the nature
// of the strings, if we are not memory constrained, we can use mergesort, which
// has O(n) space complexity.

// Quicksort has O(n^2) worse case complexity. But if we really randomize the parition
// its a good chance we can get O(nlgn) complexity. If we are really memory constrained,
// we can use quicksort, which has space complexity of O(lgn).