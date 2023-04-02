<?php

echo 'this is a simple string with single quotes' . PHP_EOL;

echo 'to escape a literal single quote, we\'ll have to use a backslash' . PHP_EOL;

echo 'things like \n or \r will output literally rather than any special meaning' . PHP_EOL;


echo "this is a string in double quotes" . PHP_EOL;

echo "things like \n or \r will have special meanings in a double quoted string" . PHP_EOL;

$var = 1;
echo "{$var} variable can be referenced in this way in double quote." . PHP_EOL;

// escape characters
// \n line feed
// \r carriage return
// \t horizontal tab
// \v vertical tab
// \e escape
// \f form feed
// \\ backslash
// \$ dollar sign
// \" double quote

$heredoc =<<<WTF
foobar! {$var} we can use variables in curly brackets in heredoc
WTF;
echo $heredoc . PHP_EOL;

$nowdoc = <<<'EOT'
this is a single quoted nowdoc. no parsing is done inside a nowdoc
this is ideal for embedding PHP code.
EOT;
echo $nowdoc;


$juice = "apple";

echo "He drank some $juice juice. When a $ sign is encountered, php will greedily take in as many character as possible to try to form a variable name.".PHP_EOL;

// Won't work, outputs: This is { fantastic}
echo "This is { $great}";

// Works, outputs: This is fantastic
echo "This is {$great}. we can also have functions within a set of curly bracket." . PHP_EOL;

$test = "we can find out the length of string using strlen()";
echo strlen($test).  PHP_EOL;

$test2 = "we can loop through a string using a for loop. each character takes a index";
for($i=0; $i<strlen($test2); $i++) {
    echo $test2[$i];
}

// Get the first character of a string
$str = 'This is a test.';
$first = $str[0];

// Get the third character of a string
$third = $str[2];

// string conversion to numbers
// If the string does not contain any of the characters '.', 'e', or 'E' and
// the numeric value fits into integer type limits (as defined by PHP_INT_MAX),
// the string will be evaluated as an integer. In all other cases it will be evaluated
// as a float.

// If the string starts with valid numeric data, this will be the value used. Otherwise, the value will be 0 (zero).
// Valid numeric data is an optional sign. followed by one or more digits.
$foo = 1 + "10.5";                // $foo is float (11.5)
$foo = 1 + "-1.3e3";              // $foo is float (-1299)
$foo = 1 + "bob-1.3e3";           // $foo is integer (1)
$foo = 1 + "bob3";                // $foo is integer (1)
$foo = 1 + "10 Small Pigs";       // $foo is integer (11)
$foo = 4 + "10.2 Little Piggies"; // $foo is float (14.2)
$foo = "10.0 pigs " + 1;          // $foo is float (11)
$foo = "10.0 pigs " + 1.0;        // $foo is float (11)


// STRING FUNCTIONS

// Removes whitespace or other characters from the right side of a string
echo rtrim("gfd    ");

// Removes whitespace or other characters from the left side of a string
echo ltrim("   fdsdf");

// Removes whitespace or other characters from both side of a string
echo trim("   fdsafs     ");

// Returns the ASCII value of the first character in the string
echo ord("afds") . PHP_EOL;

// Returns the character from the given ASCII value
echo chr(41);
print "we can also use print instead of echo, but print is generally slower than echo." . PHP_EOL;

$testStringToArray = "hello world. this is gary";
$arr1 = explode(" ", $testStringToArray);
print_r($arr1);

$number = 9;
$str = "Beijing";
// prints a formatted string.
printf("There are %u million bicycles in %s.",$number,$str);
