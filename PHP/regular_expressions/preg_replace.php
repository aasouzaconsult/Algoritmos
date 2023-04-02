<?php

/**
 * http://php.net/manual/en/function.preg-replace.php
 * Performs a regular expression search and replace.
 * 
 * mixed preg_replace ( mixed $pattern , mixed $replacement , mixed $subject [, int $limit = -1 [, int &$count ]] )
 */

$string1 = "hello world";
echo preg_replace('/hello/', 'hi', $string1) . PHP_EOL;

$string = 'April 15, 2003';
$pattern = '/(\w+) (\d+), (\d+)/i';
$replacement = '${1}1,$3';
echo preg_replace($pattern, $replacement, $string) . PHP_EOL;

$string = 'The quick brown fox jumps over the lazy dog.';
$patterns = array();
$patterns[0] = '/quick/';
$patterns[1] = '/brown/';
$patterns[2] = '/fox/';
$replacements = array();
$replacements[] = 'slow';
$replacements[] = 'black';
$replacements[] = 'bear';
echo preg_replace($patterns, $replacements, $string);