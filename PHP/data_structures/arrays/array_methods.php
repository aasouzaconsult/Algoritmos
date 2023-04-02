<?php
/**
 * Exhaustive list of all array methods 
 * http://php.net/manual/en/ref.array.php
 */
// is_array - Finds whether a variable is an array
// bool is_array ( mixed $var )
is_array('fds'); // false
is_array([]); // true
echo "is_array ----" . PHP_EOL;

// explode - split a string by string
// array explode ( string $delimiter , string $string [, int $limit = PHP_INT_MAX ] )
$pizza  = "piece1 piece2 piece3 piece4 piece5 piece6";
$pieces = explode(" ", $pizza);
echo "explode ----" . PHP_EOL;

// implode - join array elements with a string
// string implode ( string $glue , array $pieces )
$array = array('lastname', 'email', 'phone');
$comma_separated = implode(",", $array);

echo $comma_separated; // lastname,email,phone
echo "implode ----" . PHP_EOL;

// split - split a string into array by regular expression
// array split ( string $pattern , string $string [, int $limit = -1 ] )
// Delimiters may be slash, dot, or hyphen
$date = "04/30/1973";
list($month, $day, $year) = split('[/.-]', $date);
echo "Month: $month; Day: $day; Year: $year<br />\n";
echo "split ----" . PHP_EOL;

// preg_split - split string by a regular expression
// array preg_split ( string $pattern , string $subject [, int $limit = -1 [, int $flags = 0 ]] )
// split the phrase by any number of commas or space characters,
// which include " ", \r, \t, \n and \f
$keywords = preg_split("/[\s,]+/", "hypertext language, programming");
print_r($keywords);
echo "preg_split ----" . PHP_EOL;

// unset - unset a given variable
// void unset ( mixed $var [, mixed $... ] )
function foo()
{
    static $bar;
    $bar++;
    echo "Before unset: $bar, ";
    unset($bar);
    $bar = 23;
    echo "after unset: $bar\n";
}

foo();
foo();
foo();
echo "unset ----" . PHP_EOL;

// array_change_key_case — Changes the case of all keys in an array
// array array_change_key_case ( array $array [, int $case = CASE_LOWER ] )
$a = [
    'name' => 'gary',
    'age'  => 20,
];
$b = array_change_key_case($a, CASE_UPPER);
var_dump($b);
echo "array_change_key_case ----" . PHP_EOL;

// array_chunk — Split an array into chunks

$input_array = array('a', 'b', 'c', 'd', 'e');
print_r(array_chunk($input_array, 2));
print_r(array_chunk($input_array, 2, true));
echo "array_chunk ----" . PHP_EOL;

// array_column — Return the values from a single column in the input array
// array array_column ( array $input , mixed $column_key [, mixed $index_key = null ] )
// Array representing a possible record set returned from a database
$records = array(
    array(
        'id' => 2135,
        'first_name' => 'John',
        'last_name' => 'Doe',
    ),
    array(
        'id' => 3245,
        'first_name' => 'Sally',
        'last_name' => 'Smith',
    ),
    array(
        'id' => 5342,
        'first_name' => 'Jane',
        'last_name' => 'Jones',
    ),
    array(
        'id' => 5623,
        'first_name' => 'Peter',
        'last_name' => 'Doe',
    )
);
 
$first_names = array_column($records, 'first_name');
print_r($first_names);
echo "array_column ----" . PHP_EOL;

// array_combine — Creates an array by using one array for keys and another for its values
// array array_combine ( array $keys , array $values )
$a = array('green', 'red', 'yellow');
$b = array('avocado', 'apple', 'banana');
$c = array_combine($a, $b);

print_r($c);
echo "array_combine ----" . PHP_EOL;

// array_count_values — Counts all the values of an array
// returns an array using the values of array as keys and their frequency in array as values.
// array array_count_values ( array $array )
$array = array(1, "hello", 1, "world", "hello");
print_r(array_count_values($array));
echo "array_count_values ----" . PHP_EOL;

// array_diff_assoc — Computes the difference of arrays with additional index check
// array array_diff_assoc ( array $array1 , array $array2 [, array $... ] )
$array1 = array("a" => "green", "b" => "brown", "c" => "blue", "red");
$array2 = array("a" => "green", "yellow", "red");
$result = array_diff_assoc($array1, $array2);
print_r($result);
echo "array_diff_assoc ----" . PHP_EOL;

// array_diff_key — Computes the difference of arrays using keys for comparison
// array array_diff_key ( array $array1 , array $array2 [, array $... ] )
$array1 = array('blue'  => 1, 'red'  => 2, 'green'  => 3, 'purple' => 4);
$array2 = array('green' => 5, 'blue' => 6, 'yellow' => 7, 'cyan'   => 8);

var_dump(array_diff_key($array1, $array2));
echo "array_diff_key ----" . PHP_EOL;

// array_diff_uassoc — Computes the difference of arrays with additional index check which is performed by a user supplied callback function
// array array_diff_uassoc ( array $array1 , array $array2 [, array $... ], callable $key_compare_func )
function key_compare_func($a, $b)
{
    if ($a === $b) {
        return 0;
    }
    return ($a > $b)? 1:-1;
}

$array1 = array("a" => "green", "b" => "brown", "c" => "blue", "red");
$array2 = array("a" => "green", "yellow", "red");
$result = array_diff_uassoc($array1, $array2, "key_compare_func");
print_r($result);
echo "array_diff_uassoc(array1, array2) ----" . PHP_EOL;


// array_diff_ukey — Computes the difference of arrays using a callback function on the keys for comparison
// array array_diff_ukey ( array $array1 , array $array2 [, array $... ], callable $key_compare_func )
function key_compare_func2($key1, $key2)
{
    if ($key1 == $key2)
        return 0;
    else if ($key1 > $key2)
        return 1;
    else
        return -1;
}

$array1 = array('blue'  => 1, 'red'  => 2, 'green'  => 3, 'purple' => 4);
$array2 = array('green' => 5, 'blue' => 6, 'yellow' => 7, 'cyan'   => 8);

var_dump(array_diff_ukey($array1, $array2, 'key_compare_func'));
echo "array_diff_ukey(array1, array2) ----" . PHP_EOL;

// array_diff — Computes the difference of arrays
// array array_diff ( array $array1 , array $array2 [, array $... ] )
$array1 = array("a" => "green", "red", "blue", "red");
$array2 = array("b" => "green", "yellow", "red");
$result = array_diff($array1, $array2);

print_r($result);
echo "array_diff(array1, array2) ----" . PHP_EOL;

// array_fill_keys — Fill an array with values, specifying keys
// array array_fill_keys ( array $keys , mixed $value )
$keys = array('foo', 5, 10, 'bar');
$a = array_fill_keys($keys, 'banana');
print_r($a);
echo "array_fill_keys(keys, value) ----" . PHP_EOL;

// array_fill — Fill an array with values
// array array_fill ( int $start_index , int $num , mixed $value )
$a = array_fill(5, 6, 'banana');
$b = array_fill(-2, 4, 'pear');
print_r($a);
print_r($b);
echo "array_fill(start_index, num, value) ----" . PHP_EOL;

// array_filter — Filters elements of an array using a callback function
// array array_filter ( array $array [, callable $callback [, int $flag = 0 ]] )
function odd($var)
{
    // returns whether the input integer is odd
    return($var & 1);
}

function even($var)
{
    // returns whether the input integer is even
    return(!($var & 1));
}

$array1 = array("a"=>1, "b"=>2, "c"=>3, "d"=>4, "e"=>5);
$array2 = array(6, 7, 8, 9, 10, 11, 12);

echo "Odd :\n";
print_r(array_filter($array1, "odd"));
echo "Even:\n";
print_r(array_filter($array2, "even"));
echo "array_filter(input) ----" . PHP_EOL;

// array_flip — Exchanges all keys with their associated values in an array
// array array_flip ( array $array )
$input = array("oranges", "apples", "pears");
$flipped = array_flip($input);

print_r($flipped);
echo "array_flip(trans) ----" . PHP_EOL;

// array_intersect_assoc — Computes the intersection of arrays with additional index check
// array array_intersect_assoc ( array $array1 , array $array2 [, array $... ] )
$array1 = array("a" => "green", "b" => "brown", "c" => "blue", "red");
$array2 = array("a" => "green", "b" => "yellow", "blue", "red");
$result_array = array_intersect_assoc($array1, $array2);
print_r($result_array);
echo "array_intersect_assoc(array1, array2) ----" . PHP_EOL;

// array_intersect_key — Computes the intersection of arrays using keys for comparison
// array array_intersect_key ( array $array1 , array $array2 [, array $... ] )
$array1 = array('blue'  => 1, 'red'  => 2, 'green'  => 3, 'purple' => 4);
$array2 = array('green' => 5, 'blue' => 6, 'yellow' => 7, 'cyan'   => 8);

var_dump(array_intersect_key($array1, $array2));
echo "array_intersect_key(array1, array2) ---- " . PHP_EOL;

// array_intersect_uassoc — Computes the intersection of arrays with additional index check, compares indexes by a callback function
// array array_intersect_uassoc ( array $array1 , array $array2 [, array $... ], callable $key_compare_func )
$array1 = array("a" => "green", "b" => "brown", "c" => "blue", "red");
$array2 = array("a" => "GREEN", "B" => "brown", "yellow", "red");

print_r(array_intersect_uassoc($array1, $array2, "strcasecmp"));
echo "array_intersect_uassoc(array1, array2) ---- " . PHP_EOL;

// array_intersect_ukey — Computes the intersection of arrays using a callback function on the keys for comparison
// array array_intersect_ukey ( array $array1 , array $array2 [, array $... ], callable $key_compare_func )
// function key_compare_func($key1, $key2)
// {
//     if ($key1 == $key2)
//         return 0;
//     else if ($key1 > $key2)
//         return 1;
//     else
//         return -1;
// }

$array1 = array('blue'  => 1, 'red'  => 2, 'green'  => 3, 'purple' => 4);
$array2 = array('green' => 5, 'blue' => 6, 'yellow' => 7, 'cyan'   => 8);

var_dump(array_intersect_ukey($array1, $array2, 'key_compare_func'));
echo "array_intersect_ukey(array1, array2) ----" . PHP_EOL;

// array_intersect — Computes the intersection of arrays
// array array_intersect ( array $array1 , array $array2 [, array $... ] )
$array1 = array("a" => "green", "red", "blue");
$array2 = array("b" => "green", "yellow", "red");
$result = array_intersect($array1, $array2);
print_r($result);
echo "array_intersect(array1, array2) ----" . PHP_EOL;

// array_key_exists — Checks if the given key or index exists in the array
// bool array_key_exists ( mixed $key , array $array )
$search_array = array('first' => 1, 'second' => 4);
if (array_key_exists('first', $search_array)) {
    echo "The 'first' element is in the array";
}
echo "array_key_exists(key, search) ----" . PHP_EOL;

// array_keys — Return all the keys or a subset of the keys of an array
// array array_keys ( array $array [, mixed $search_value = null [, bool $strict = false ]] )
$array = array(0 => 100, "color" => "red");
print_r(array_keys($array));

$array = array("blue", "red", "green", "blue", "blue");
print_r(array_keys($array, "blue"));

$array = array("color" => array("blue", "red", "green"),
               "size"  => array("small", "medium", "large"));
print_r(array_keys($array));
echo "array_keys(input) ----" . PHP_EOL;

// array_map — Applies the callback to the elements of the given arrays
// array array_map ( callable $callback , array $array1 [, array $... ] )
function cube($n)
{
    return($n * $n * $n);
}

$a = array(1, 2, 3, 4, 5);
$b = array_map("cube", $a);
print_r($b);
echo "array_map(callback, arr1) ----" . PHP_EOL;

// array_merge_recursive — Merge two or more arrays recursively
$ar1 = array("color" => array("favorite" => "red"), 5);
$ar2 = array(10, "color" => array("favorite" => "green", "blue"));
$result = array_merge_recursive($ar1, $ar2);
print_r($result);
echo "array_merge_recursive(array1) ---- " . PHP_EOL;

// array_merge — Merge one or more arrays
// array array_merge ( array $array1 [, array $... ] )
$array1 = array("color" => "red", 2, 4);
$array2 = array("a", "b", "color" => "green", "shape" => "trapezoid", 4);
$result = array_merge($array1, $array2);
print_r($result);
echo "array_merge(array1) ---- " . PHP_EOL;

// array_multisort — Sort multiple or multi-dimensional arrays
// bool array_multisort ( array &$array1 [, mixed $array1_sort_order = SORT_ASC [, mixed $array1_sort_flags = SORT_REGULAR [, mixed $... ]]] )
$ar = array(
       array("10", 11, 100, 100, "a"),
       array(   1,  2, "2",   3,   1)
      );
array_multisort($ar[0], SORT_ASC, SORT_STRING,
                $ar[1], SORT_NUMERIC, SORT_DESC);
var_dump($ar);
echo "array_multisort(arr) ---- " . PHP_EOL;

// array_pad — Pad array to the specified length with a value
// array array_pad ( array $array , int $size , mixed $value )
$input = array(12, 10, 9);

$result = array_pad($input, 5, 0);
// result is array(12, 10, 9, 0, 0)

$result = array_pad($input, -7, -1);
// result is array(-1, -1, -1, -1, 12, 10, 9)

$result = array_pad($input, 2, "noop");
// not padded
echo "array_pad(input, pad_size, pad_value) ----" . PHP_EOL;

// array_pop — Pop the element off the end of array
// mixed array_pop ( array &$array )
$stack = array("orange", "banana", "apple", "raspberry");
$fruit = array_pop($stack);
print_r($stack);
echo "array_pop(array) ----" . PHP_EOL;

// array_product — Calculate the product of values in an array
// number array_product ( array $array )
$a = array(2, 4, 6, 8);
echo "product(a) = " . array_product($a) . "\n";
echo "product(array()) = " . array_product(array()) . "\n";
echo "array_product(array) ----" . PHP_EOL;

// array_push — Push one or more elements onto the end of array
// int array_push ( array &$array , mixed $value1 [, mixed $... ] )
$stack = array("orange", "banana");
array_push($stack, "apple", "raspberry");
print_r($stack);
echo "array_push(array, var) ----" . PHP_EOL;

// array_rand — Pick one or more random entries out of an array
// mixed array_rand ( array $array [, int $num = 1 ] )
$input = array("Neo", "Morpheus", "Trinity", "Cypher", "Tank");
$rand_keys = array_rand($input, 2);
echo $input[$rand_keys[0]] . "\n";
echo $input[$rand_keys[1]] . "\n";
echo "array_rand(input) ----" . PHP_EOL;

// array_reduce — Iteratively reduce the array to a single value using a callback function
// mixed callback ( mixed $carry , mixed $item )
function sum($carry, $item)
{
    $carry += $item;
    return $carry;
}

function product($carry, $item)
{
    $carry *= $item;
    return $carry;
}

$a = array(1, 2, 3, 4, 5);
$x = array();

var_dump(array_reduce($a, "sum")); // int(15)
var_dump(array_reduce($a, "product", 10)); // int(1200), because: 10*1*2*3*4*5
var_dump(array_reduce($x, "sum", "No data to reduce")); // string(17) "No data to reduce"
echo "array_reduce(input, function) ----" . PHP_EOL;

// array_replace_recursive — Replaces elements from passed arrays into the first array recursively
// array array_replace_recursive ( array $array1 , array $array2 [, array $... ] )
$base = array('citrus' => array("orange") , 'berries' => array("blackberry", "raspberry"), 'others' => 'banana' );
$replacements = array('citrus' => 'pineapple', 'berries' => array('blueberry'), 'others' => array('litchis'));
$replacements2 = array('citrus' => array('pineapple'), 'berries' => array('blueberry'), 'others' => 'litchis');

$basket = array_replace_recursive($base, $replacements, $replacements2);
print_r($basket);
echo "array_replace_recursive(array, array1) ----" . PHP_EOL;

// array_replace — Replaces elements from passed arrays into the first array
// array array_replace ( array $array1 , array $array2 [, array $... ] )
$base = array("orange", "banana", "apple", "raspberry");
$replacements = array(0 => "pineapple", 4 => "cherry");
$replacements2 = array(0 => "grape");

$basket = array_replace($base, $replacements, $replacements2);
print_r($basket);
echo "array_replace(array, array1) ----- " . PHP_EOL;

// array_reverse — Return an array with elements in reverse order
// array array_reverse ( array $array [, bool $preserve_keys = false ] )
$input  = array("php", 4.0, array("green", "red"));
$reversed = array_reverse($input);
$preserved = array_reverse($input, true);

print_r($input);
print_r($reversed);
print_r($preserved);
echo "array_reverse(array) ---- " . PHP_EOL;

// array_search — Searches the array for a given value and returns the first corresponding key if successful
// mixed array_search ( mixed $needle , array $haystack [, bool $strict = false ] )
$array = array(0 => 'blue', 1 => 'red', 2 => 'green', 3 => 'red');

$key = array_search('green', $array); // $key = 2;
$key = array_search('red', $array);   // $key = 1;
echo "array_search(needle, haystack) ----" . PHP_EOL;

// array_shift — Shift an element off the beginning of array
// mixed array_shift ( array &$array )
$stack = array("orange", "banana", "apple", "raspberry");
$fruit = array_shift($stack);
print_r($stack);
echo "array_shift(array) ----" . PHP_EOL;

$a = file_get_contents('array.php', 'r');
if ($a) {
    echo $a;
}
// array_slice — Extract a slice of the array
// array array_slice ( array $array , int $offset [, int $length = NULL [, bool $preserve_keys = false ]] )
// array_splice — Remove a portion of the array and replace it with something else
// array_sum — Calculate the sum of values in an array
// array_udiff_assoc — Computes the difference of arrays with additional index check, compares data by a callback function
// array_udiff_uassoc — Computes the difference of arrays with additional index check, compares data and indexes by a callback function
// array_udiff — Computes the difference of arrays by using a callback function for data comparison
// array_uintersect_assoc — Computes the intersection of arrays with additional index check, compares data by a callback function
// array_uintersect_uassoc — Computes the intersection of arrays with additional index check, compares data and indexes by separate callback functions
// array_uintersect — Computes the intersection of arrays, compares data by a callback function
// array_unique — Removes duplicate values from an array
// array_unshift — Prepend one or more elements to the beginning of an array
// array_values — Return all the values of an array
// array_walk_recursive — Apply a user function recursively to every member of an array
// array_walk — Apply a user supplied function to every member of an array
// array — Create an array
// arsort — Sort an array in reverse order and maintain index association
// asort — Sort an array and maintain index association
// compact — Create array containing variables and their values
// count — Count all elements in an array, or something in an object
// current — Return the current element in an array
// each — Return the current key and value pair from an array and advance the array cursor
// end — Set the internal pointer of an array to its last element
// extract — Import variables into the current symbol table from an array
// in_array — Checks if a value exists in an array
// key_exists — Alias of array_key_exists
// key — Fetch a key from an array
// krsort — Sort an array by key in reverse order
// ksort — Sort an array by key
// list — Assign variables as if they were an array
// natcasesort — Sort an array using a case insensitive "natural order" algorithm
// natsort — Sort an array using a "natural order" algorithm
// next — Advance the internal array pointer of an array
// pos — Alias of current
// prev — Rewind the internal array pointer
// range — Create an array containing a range of elements
// reset — Set the internal pointer of an array to its first element
// rsort — Sort an array in reverse order
// shuffle — Shuffle an array
// sizeof — Alias of count
// sort — Sort an array
// uasort — Sort an array with a user-defined comparison function and maintain index association
// uksort — Sort an array by keys using a user-defined comparison function
// usort — Sort an array by values using a user-defined comparison function