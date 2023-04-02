<?php
// Float expressions
$a = 1.234; 
$b = 1.2e3; 
$c = 7E-10;


$a = 1.23456789;
$b = 1.23456780;
$epsilon = 0.00001;

// To test floating point values for equality, an upper bound on the relative
// error due to rounding is used. This value is known as the machine epsilon,
// or unit roundoff, and is the smallest acceptable difference in calculations.
if(abs($a-$b) < $epsilon) {
    echo "true";
}

// Some numeric operations can result in a value being NAN. NAN compared with any
// other value will result in false. we do not compare NAN with anything(even itself)
// . We should only use the builtin method is_nan() to check for NAN value.

?>