<?php
$var1['apple'] = 'apple element';
$var1['pear'] = 'pear element';
print_r ($var1);
$var2 = array(1,2,3,4);
print_r ($var2);
$str1 = '34,56,67,89,05';
$var3 = explode(',', $str1);
print_r ($var3);
$str2 = implode(' and', $var3);
echo $str2 . PHP_EOL;

// Array key casts
// strings containing valid integers will have array keys stored as integer.
// "8" will be stored as key 8. "08" is not a valid decimal integer. so it
// will not be cast ot key int.
// 
// floats can also be cast to key integers, the fractional part of float will
// be truncated
//
// bool will also be cast to integers, true cast to key 1 and false to key 0.
// 
// null will be cast to empty string, the key will be ""
// 
// arrays and objects CANNOT be used as keys. doing so will result in illegal offset type error

// Array assignment is by default value copying. if u want to pass by reference, use the reference & operator.
$arr1 = array(2, 3);
$arr2 = $arr1;
$arr2[] = 4; // $arr2 is changed,
             // $arr1 is still array(2, 3)
             
$arr3 = &$arr1;
$arr3[] = 4; // now $arr1 and $arr3 are the same

// COMMON array operations

// initialize an array
$arr = [];

// Create
// add a value to the end of the array
// O(1) time complexity
$arr[] = 'apple';

// Access
// access an array element directly 
// O(1) time complexity
echo $arr[0] . PHP_EOL;

// Delete
// remove an element from the array, the array is still there.
// O(1) time complexity
unset($arr[0]);
print_r($arr);

// array_values
// return an indexed array of values
$arr[] = 'pear';
$arr[] = 'orange';
print_r(array_values($arr));

// array_diff
// array array_diff ( array $array1 , array $array2 [, array $... ] )
// return an array containing values in array1 that are not present in any of the subsequent arrays

// array_shift
// mixed array_shift ( array &$array )
// shift an element of the beginning of the array
echo array_shift($arr) . PHP_EOL;

// array_pop
// mixed array_pop ( array &$array )
// pop the element at the end of the array
echo  array_pop($arr) . PHP_EOL;

// check for empty array using empty();
if (empty($arr)) {
    echo "arr is empty" . PHP_EOL;
}


echo "ADVANTAGES OF ARRAY" . PHP_EOL;
echo "1. it can be used to represent multiple values of the same type by a single variable" . PHP_EOL;
echo "2. 2D arrays can be used to represent matrices. 3D arrays can be used to represent 3 dimensional plains." . PHP_EOL;
echo "3. random access of elements is easy as elements are accessed directly by indexes." . PHP_EOL;

echo "DISADVANTAGES OF ARRAY" . PHP_EOL;
echo "1. arrays is of fixed size, the memory allocated to an array cannot be increased or reduced. this could lead to wastage of memory space or overflow" . PHP_EOL;
echo "2. elements of array are stored in consecutive memory locations, so insertions and deletions are difficult and time consuming." . PHP_EOL;
echo "3. we MUST know in advance how many elements are to be stored in array." . PHP_EOL;
