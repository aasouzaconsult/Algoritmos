<?php

// Given a string containing only digits, restore it by returning all possible
// valid IP address combinations.

// A valid IP address must be in the form of A.B.C.D, where A,B,C and D are
// numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.

// Example:

// Given “25525511135”,

// return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings
// are sorted in order)

/**
 * Brute Force.
 * 
 * Check all possible combinations and store valid combinations in results.
 *
 * Time: O(n^3)
 * Space: O(n)
 */
function validIpAddresses($str) {
    if (empty($str)) {
        return [];
    }
    $result = [];
    for ($i=0; $i < 3 && $i < strlen($str); $i++) { // O(3)
        $sub1 = substr($str, 0, $i+1);        
        if (isValidPart($sub1)) {
            for ($j=$i+1; $j <= $i+3 && $j < strlen($str); $j++) { 
                $sub2 = substr($str, $i+1, $j - $i);
                if (isValidPart($sub2)) {
                    for ($k=$j+1; $k <= $j+3 && $k < strlen($str) ; $k++) { 
                        $sub3 = substr($str, $j+1, $k - $j);
                        if (isValidPart($sub3)) {
                            $sub4 = substr($str, $k+1);
                            if (strlen($sub4) > 0 && isValidPart($sub4)) {
                                $result[] = $sub1 . "." . $sub2 . "." . $sub3 . "." . $sub4;
                            }
                        }
                    }
                }
            }
        }
    }
    return $result;
}

function isValidPart($str) {
    if (strlen($str) > 3) {
        return False;
    }
    if ($str[0] == '0' && strlen($str) > 1) {
        return False;
    }
    if ((int)$str >= 0 && (int)$str <= 255) {
        return True;
    }
    return False;
}

// Its also possible for a DFS(backtracking) solution.
// NOT WORKING FOR str2. get back later.
function validIpAddressesV2($str) {
    if (strlen($str) < 4 || strlen($str) > 12 || strlen($str) < 1) {
        return [];
    }
    $result = [];
    $temp = "";
    dfs($str, $result, $temp, 0);
    return $result;
}

function dfs($str, &$result, $temp, $count) {
    if ($count == 3 && isValidPart($str)) {
        $result[] = $temp . $str;
        return;
    }
    for ($i=1; $i < 4 && $i < strlen($str); $i++) {        
        $sub = substr($str, 0, $i+1);
        if (isValidPart($sub)) {;
            $newStr = substr($str, $i+1);
            dfs($newStr, $result, $temp . $sub . ".", $count+1);
        }
    }
}

$str1 = "25525511135";
$str2 = "0100100";
$str3 = "25011255255";
print_r(validIpAddresses($str1));
print_r(validIpAddresses($str2));
print_r(validIpAddresses($str3));
print_r(validIpAddressesV2($str1));
print_r(validIpAddressesV2($str2));
print_r(validIpAddressesV2($str3));