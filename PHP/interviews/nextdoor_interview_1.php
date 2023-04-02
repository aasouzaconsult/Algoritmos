<?php

// 1. A[101] 1-100 unsorted + 1 duplicate. Find the duplicate.
// [5,2,4,3,1,3]

// return the duplicate
// no duplicate, return NULL
// max size 101
// brute force
// Time: O(nlgn)
// Space: O(n)

// Time: O(n)
// Space: O(1)
function findDuplicate($arr) {
  // handle empty case
  if (empty($arr)) {
    return NULL;
  }
  // loop through array
  //    find the index for this current elemtn
  //    if arr index is possitve, set -ve
  //    else return the orgiinal elemnt
  //       return result
  $offset = 1;
  for ($i=0; $i < sizeof($arr); $i++) {
    $index = abs($arr[$i]) - $offset;
    if ($arr[$index] > 0) {
      $arr[$index] = -$arr[$index];
    } else { // element already negative, 
      return abs($arr[$i]); // not reutn
    }
  }
  return NULL;
  // return NULL;
  // [-1,-2,2]; // 3
  //  0 1 2
}
echo findDuplicate([5,2,4,3,1,3]);

?>
