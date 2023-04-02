<?php

// Pretty print a json object using proper indentation.

// Every inner brace should increase one indentation to the following lines.
// Every close brace should decrease one indentation to the same line and the following lines.
// The indents can be increased with an additional ‘\t’
// Example 1:

// Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
// Output : 
// { 
//     A:"B",
//     C: 
//     { 
//         D:"E",
//         F: 
//         { 
//             G:"H",
//             I:"J"
//         } 
//     }     
// }
// Example 2:

// Input : ["foo", {"bar":["baz",null,1.0,2]}]
// Output : 
// [
//     "foo", 
//     {
//         "bar":
//         [
//             "baz", 
//             null, 
//             1.0, 
//             2
//         ]
//     }
// ]
// [] and {} are only acceptable braces in this case.

// Assume for this problem that space characters can be done away with.
// Your solution should return a list of strings, where each entry corresponds
// to a single line. The strings should not have “\n” character in them.

/**
 * Time: O(n) where n is size of json input string.
 * Space: O(n)
 * 
 */
function prettyJson($json) {
    if (sizeof($json) < 1) {
        return [];
    }
    $result = [];
    $indentLevel = 0;
    $line = "";
    for ($i=0; $i < strlen($json); $i++) {
        if ($json[$i] == '[' || $json[$i] == '{') {
            $tabs = tabs($indentLevel);
            if ($i != 0) {
                if (strlen($line) > 0) {
                    $result[] = $tabs . $line;
                }                
                $line = "";
            }
            $result[] = $tabs . $json[$i];
            $indentLevel++;
        } elseif ($json[$i] == ']' || $json[$i] == '}' || $json[$i] == ',') {
            if ($json[$i] == ',' && ($json[$i-1] == ']' || $json[$i-1] == '}')) {
                $result[sizeof($result)-1] .= ',';
                continue;
            }
            $tabs = tabs($indentLevel);
            if ($json[$i] == ',') {
                $line .= ',';
            }
            if (strlen($line) > 0) {
                $result[] = $tabs . $line;
            }
            if ($json[$i] != ',') {
                $indentLevel--;
                $tabs = tabs($indentLevel);
                $result[] = $tabs . $json[$i];
            }
            $line = "";
        } else {
            if ($json[$i] != ' ') {
                $line .= $json[$i];
            }            
        }
    }
    return $result;
}

function tabs($num) {
    if ($num == 0) {
        return "";
    }
    $result = "";
    for ($i=0; $i < $num; $i++) { 
        $result .= "\t";
    }
    return $result;
}

function printJson($arr) {
    for ($i=0; $i < sizeof($arr); $i++) { 
        echo $arr[$i] . PHP_EOL;
    }
    echo PHP_EOL;
}

$arr1 = [
    'A' => "B",
    'C' => [
        "D" => "E",
        "F" => [
            "G" => "H",
            "I" => "J"
        ],
    ]
];
$arr1 = '{A:"B",C:{D:"E",F:{G:"H",I:"J"}}}';
$arr2 = '["foo", {"bar":["baz",null,1.0,2]}]';

printJson(prettyJson($arr1));
printJson(prettyJson($arr2));
