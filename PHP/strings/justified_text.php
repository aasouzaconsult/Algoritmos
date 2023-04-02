<?php

// Given an array of words and a length L, format the text such that each line
// has exactly L characters and is fully (left and right) justified.
// You should pack your words in a greedy approach; that is, pack as many words
// as you can in each line.

// Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
// Extra spaces between words should be distributed as evenly as possible.
// If the number of spaces on a line do not divide evenly between words, the
// empty slots on the left will be assigned more spaces than the slots on the right.
// For the last line of text, it should be left justified and no extra space is
// inserted between words.

// Your program should return a list of strings, where each string represents a
// single line.

// Example:

// words: ["This", "is", "an", "example", "of", "text", "justification."]

// L: 16.

// Return the formatted lines as:

// [
//    "This    is    an",
//    "example  of text",
//    "justification.  "
// ]
//  Note: Each word is guaranteed not to exceed L in length. 

/**
 * Time: O(n^2 * m) where n is size of sub array of words defined by start end end.
 * m is size of line length
 * Space: O(n)
 */
function justifiedText($words, $length) {
    if (empty($words)) {
        return [];
    }
    $result = [];
    list($counter, $spaces) = [0, 0];
    list($start, $end) = [0, 0];
    for ($i=0; $i < sizeof($words); $i++) {
        if ($counter + $spaces + strlen($words[$i]) == $length) {
            $end = $i;
            $result[] = constructLine($words, $length, $start, $end);
            list($counter, $spaces) = [0, 0];
            $start = $i+1;
        } elseif ($counter + $spaces + strlen($words[$i]) > $length) {
            $result[] = constructLine($words, $length, $start, $end);
            list($counter, $spaces) = [strlen($words[$i]), 1];
            list($start, $end) = [$i, $i];
        } else {
            $counter += strlen($words[$i]);
            $spaces++;
            $end = $i;
        }
    }
    if ($counter > 0) {
        $line = "";
        for ($i=$start; $i <= $end; $i++) { 
            if ($i == $end) {
                $pad = "";
            } else {
                $pad = " ";
            }
            $line += $words[$i] + $pad;
        }
        $result[] = $words[line];
    }
    return $result;
}

/**
 * Time: O(n * m) where n is size of sub array of words defined by start end end.
 * m is size of line length
 * Space: O(n)
 */
function constructLine($words, $length, $start, $end) {
    $result = [];
    for ($i=$start; $i <= $end; $i++) {
        if ($i == $end) {
            $pad = "";
        } else {
            $pad = " ";
        }
        $result[] = $words[$i] . $pad;
    }
    $count = 0;
    for ($i=0; $i < sizeof($result); $i++) { 
        $count += strlen($result[$i]);
    }
    while ($count < $length) {
        for ($i=0; $i < sizeof($result); $i++) { 
            if ($i == sizeof($result)-1) {
                continue;
            }
            $result[$i] .= " ";
            $count++;
            if ($count == $length) {
                break;
            }
        }
    }
    return implode("", $result);
}

$words1 = ["This", "is", "an", "example", "of", "text", "justification."];

print_r(justifiedText($words1, 16));
