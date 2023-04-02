<?php

function string_compare($str1, $str2, $i, $j) {
    $opt = [];

    if ($i == 0) {
        return $j+1;
    } elseif ($j == 0) {
        return $i+1;
    }
    $opt[0] = string_compare($str1, $str2, $i-1, $j-1) + match($str1[$i], $str2[$j]);
    $opt[1] = string_compare($str1, $str2, $i, $j-1) + 1;
    $opt[2] = string_compare($str1, $str2, $i-1, $j) + 1;

    $lowestCost = $opt[0];
    for ($i=1; $i <= 2; $i++) { 
        if ($opt[$i] < $lowestCost) {
            $lowestCost = $opt[$i];
        }
    }
    return $lowestCost;
}

function match($char1, $char2) {
    if ($char1 == $char2) {
        return 0;
    }
    return 1;
}

function print2DArray($arr) {
    for ($i=0; $i < sizeof($arr); $i++) { 
        for ($j=0; $j < sizeof($arr[$i]); $j++) { 
            echo $arr[$i][$j] . " ";
        }
        echo PHP_EOL;
    }
}

/**
 * Given str1, find out the cost required to convert str1 to str2.
 * str1 = "thou shalt not" ROW
 * str2 = "you should not" COL
 */
function string_compare_DP($str1, $str2) {
    $MATCH = 0;
    $INSERT = 1;
    $DELETE = 2;

    // init DP table, with Cell object inserted into each cell
    $temp = array_fill(0, strlen($str2)+1, 0);
    $compareTable = array_fill(0, strlen($str1)+1, $temp);
    
    for ($i=0; $i < strlen($str1)+1; $i++) { 
        for ($j=0; $j < strlen($str2)+1; $j++) { 
            // if 1st string is empty, the only option is to insert all char
            // of 2nd string
            if ($i == 0) {
                $compareTable[$i][$j] = $j;
            } elseif ($j == 0) { // if 2nd string is empty, the only option is to remove all char from 1st string
                $compareTable[$i][$j] = $i;
            } elseif ($str1[$i-1] == $str2[$j-1]) {
                $compareTable[$i][$j] = $compareTable[$i-1][$j-1];
            } else {
                $compareTable[$i][$j] = 1 + min($compareTable[$i-1][$j-1], $compareTable[$i-1][$j], $compareTable[$i][$j-1]);
            }
        }
    }
    print2DArray($compareTable);
    // return cost
    return $compareTable[strlen($str1)][strlen($str2)];
}
echo "answer is: " . levenshtein("thou shalt not", "you should not") . PHP_EOL;
// echo string_compare("thou shalt", "you should", 9, 9) . PHP_EOL;
echo string_compare_DP("thou shalt not", "you should not") . PHP_EOL;
echo string_compare_DP("sunday", "saturday") . PHP_EOL;
