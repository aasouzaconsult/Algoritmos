<?php

// When converting to boolean, the following values are considered FALSE:

// the boolean FALSE itself
// the integer 0 (zero)
// the float 0.0 (zero)
// the empty string, and the string "0"
// an array with zero elements
// the special type NULL (including unset variables)
// SimpleXML objects created from empty tags

var_dump((bool) "");        // false
var_dump((bool) 1);         // true
var_dump((bool) -2);        // true
var_dump((bool) "foo");     // true
var_dump((bool) 2.3e5);     // true
var_dump((bool) array(12)); // true
var_dump((bool) array());   // false
var_dump((bool) "false");   // true