<?php

/**
 * Assume you have a method 'isSubString' which checks if one word is a substring
 * of another. Given 2 strings, s1 and s2, write code to check if s2 is a rotation
 * of s1 using only 1 call to isSubString. eg('waterbottle' is a rotation of 'erbottlewat').
 */

/**
 * Append s1 after s1. so it's s1.s1.
 * Call isSubString(s2, s1.s1) to check if s2 is a substring of s1.s1
 * if true, s2 is a rotation, else false
 *
 * Time: O(A+B) assume isSubString runs in O(A+B) time
 * Space: O(n)
 */
function isStringRotation($str1, $str2) {
    $doubleS1 = $str1 . $str1;
    return isSubString($str2, $doubleS1);
}

function isSubString($checkStr, $targetStr) {
    // return true if $checkStr, is a substring of $targetStr
    // else return false
}