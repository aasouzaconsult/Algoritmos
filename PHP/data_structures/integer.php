<?php
$a = 1234; // decimal number
$a = -123; // a negative number
$a = 0123; // octal number (equivalent to 83 decimal)
$a = 0x1A; // hexadecimal number (equivalent to 26 decimal)
$a = 0b11111111; // binary number (equivalent to 255 decimal)
// To explicitly convert to integer
$b = (int) "4";
echo gettype($b) . PHP_EOL;
echo PHP_INT_MAX . PHP_EOL;
echo PHP_INT_MIN . PHP_EOL;
?>