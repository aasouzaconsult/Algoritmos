<?php

// http://www.geeksforgeeks.org/word-break-problem-using-backtracking/

// Given a valid sentence without any spaces between the words and a dictionary of valid English words, find all possible ways to break the sentence in individual dictionary words.

// Example

// Consider the following dictionary 
// { i, like, sam, sung, samsung, mobile, ice, 
//   cream, icecream, man, go, mango}

// Input: "ilikesamsungmobile"
// Output: i like sam sung mobile
//         i like samsung mobile

// Input: "ilikeicecreamandmango"
// Output: i like ice cream and man go
//         i like ice cream and mango
//         i like icecream and man go
//         i like icecream and mango

function wordBreak($str, $dict) {
    if (empty($str)) {
        return $str;
    }
    $result = [];
    wordBreakUtil($str, $dict, $result);
    print_r($result);
    return $result;
}

function wordBreakUtil($str, $dict, &$result) {
    for ($i=0; $i < strlen($str); $i++) { 
        $prefix = substr($str, 0, $i+1);
        if (isset($dict[$prefix])) {
            if ($i == strlen($str)) {
                echo implode(" ", $result) . PHP_EOL;
                return;
            }
            if (!in_array($prefix, $result)) {
                $result[] = $prefix;
            }
            $newStr = substr($str, $i+1);
            wordBreakUtil($newStr, $dict, $result);
        }
    }
}

$dict = [
    "i" => 1,
    "like" => 1,
    "sam" => 1,
    "sung" => 1,
    "samsung" => 1,
    "mobile" => 1,
    "ice" => 1,
    "cream" => 1,
    "icecream" => 1,
    "man" => 1,
    "go" => 1,
    "mango" => 1,
    "and" => 1,
];

$str1 = "ilikesamsungmobile";
$str2 = "ilikeicecreamandmango";

wordBreak($str1, $dict);
wordBreak($str2, $dict);
