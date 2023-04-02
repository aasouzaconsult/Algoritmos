<?php

// Write a function that takes a matrix and examines each item in a spiral
// order, printing each item as it comes to it.
//
// For example, given a matrix like this as input:
//
// [11, 12, 13, 14, 15],
// [24, 25, 26, 27, 16],
// [23  30, 29, 28, 17],
// [22, 21, 20, 19, 18],
// Your program must print:
//
// 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30

$matrix1 = [];
$matrix1[] = [11, 12, 13, 14, 15];
$matrix1[] = [24, 25, 26, 27, 16];
$matrix1[] = [23, 30, 29, 28, 17];
$matrix1[] = [22, 21, 20, 19, 18];

$matrix2 = [
  [1,2,3,4],
  [5,6,7,8],
  [9,10,11,12],
  [13,14,15,16]
];

$matrix3 = [
  [1,2,3,4,5,6],
  [7,8,9,10,11,12],
  [13,14,15,16,17,18]
];

function printMatrix($matrix) {
  if (sizeof($matrix) < 1) {
    return;
  }
  $result = [$matrix, []];

  while (sizeof($result[0]) > 0) {
    $result = right($result);
    $result = down($result);
    $result = left($result);
    $result = up($result);
  }
  return implode(" ", $result[1]);
}

function right(&$result) {
  $matrix = &$result[0];
  $values = &$result[1];
  if (sizeof($matrix[0]) < 1) {
    return $result;
  }

  for($i=0; $i<sizeof($matrix[0]); $i++) {
    $values[] = $matrix[0][$i];
  }
  unset($matrix[0]);
  $matrix = array_values($matrix);

  return [$matrix, $values];
}

function down($result) {
  $matrix = &$result[0];
  $values = &$result[1];
  if (sizeof($matrix[0]) < 1) {
    return $result;
  }
  for ($i=0; $i<sizeof($matrix); $i++) {
    $values[] = array_pop($matrix[$i]);    
  }
  return [$matrix, $values];
}

function left($result) {
  $matrix = &$result[0];
  $values = &$result[1];
  if (sizeof($matrix[0]) < 1) {
    return $result;
  }
  
  for($i=sizeof(end($matrix))-1; $i >= 0; $i--) {
    $values[] = end($matrix)[$i];
  }
  array_pop($matrix);
  return [$matrix, $values];
}

function up($result) {
  $matrix = &$result[0];
  $values = &$result[1];
  if (sizeof($matrix[0]) < 1) {
    return $result;
  }
  for ($i=sizeof($matrix)-1; $i >= 0; $i--) {
    $values[] = array_shift($matrix[$i]);
  }
  return [$matrix, $values];
}

echo printMatrix($matrix1) . PHP_EOL;
echo printMatrix($matrix2) . PHP_EOL;
echo printMatrix($matrix3) . PHP_EOL;
?>
