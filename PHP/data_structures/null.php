<?php

// NULL is the only possible value of type null

// A variable is considered to be null if:
// it has been assigned the constant NULL.
// it has not been set to any value yet.
// it has been unset().

$var = NULL;

// use is_null to check for null value.
echo is_null($var);

// we can use unset() to set a variable to NULL.
$var2 = 2;
unset($var2);
echo is_null($var2);