

<?php

/*
Your previous Plain Text content is preserved below:

Write a function that takes a list of words and outputs the anagrams in the list, preserving order. (An anagram is any rearrangement of letters).
Eg: 'cat' is an anagram of 'act'

For instance,

Input: ['cat', 'cat', 'octopus', 'care', 'news', 'acre', 'act', 'newspaper']
Output: ['cat', 'cat', 'care', 'acre', 'act']
 -->*/
   
  // Time: O(nlgn) 
  // Space: O(n) n is num of elements in string
  // loop through the array
  // sort the current string
  // "cat" => "act"
  // key => value
  // "str" => [0 , 1]


  // Time: O(n*mlgm)
  // Space: O(n)
  // sorting mlgm, m is the size of the longest string
  function getAnagrams($arr) {
    if (empty($arr)) {
      return [];
    }
    $table = [];
    for ($i=0; $i < sizeof($arr); $i++) {
      $strParts = str_split($arr[$i]);
      sort($strParts);
      $sortedStr = implode('', $strParts);
      if (!isset($table[$sortedStr])) {
        $table[$sortedStr] = [$i];
      } else {
        $table[$sortedStr][] = $i;
      }
    }
    $result = [];
    foreach($table as $key=>$value) {
      if (sizeof($value) > 1) {
        for ($i=0; $i < sizeof($value); $i++) {
          $result[] = $value[$i];
        }
      }
    }
    // put in ascending index
    sort($result);
    foreach($result as $key=>&$value) {
      $value = $arr[$value];
    }
    return $result;
  }

  $arr1 = ['cat', 'cat', 'octopus', 'care', 'news', 'acre', 'act', 'newspaper'];
  print_r(getAnagrams($arr1));

/*  
Write a function that takes in a Reverse Polish Notation (RPN) string and returns an integer.

Examples

"40 2 +" #=> 42 
"2 3 -" #=> -1  
"5 4 * 2 /" #=> 10 
"5 4 2 * -" #=> -3
  */
  // + -  * / 
  // integer and you can cast/convert the number to integer

  // only do + and - for v0
  function rpn($string) {
    if (empty($string)) {
      return;
    }
    $chars = explode(' ', $string);    
    $numbers = [];
    $result = 0;
    
    for ($i=0; $i < sizeof($chars); $i++) {    
      if (is_numeric($chars[$i])) {
        $numbers[] = intval($chars[$i]);
      } else {
        list($value1, $value2) = [array_pop($numbers), array_pop($numbers)];        
        if ($chars[$i] == "+") {
          $result = $value1 + $value2;
        } else if ($chars[$i] == "-") {
          $result = $value1 - $value2;
        } else if ($chars[$i] == "*") {
          $result = $value1 * $value2;
        } else {
          $result = $value1 / $value2;
        }
        array_push($numbers, $result);
      }      
    }
    return $result;
  }
  
echo rpn("40 2 +");

