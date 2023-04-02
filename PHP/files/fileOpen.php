<?php

$file = getcwd() . '/test_file.txt' or die('Could not open file');

$fh = fopen($file, 'r') or die('Could not open file');

$data = fread($fh, filesize($file)) or die('Could not read file!');

fclose($fh);

echo $data;
echo 'File size: ' . filesize($file) . ';' . PHP_EOL;
echo 'File owner: ' . fileowner($file) . ';' . PHP_EOL;
echo 'File group: ' . filegroup($file) . ';' . PHP_EOL;
echo 'File permissions ' . fileperms($file) . ';' . PHP_EOL;
echo 'File type: ' . filetype($file) . ';' . PHP_EOL;
// echo 'File last accessed on: ' . date('Y-m-d', fileatime($file)) . ';' . PHP_EOL;
// echo 'File last modified on: ' . date('Y-m-d', filemtime($file)) . ';' . PHP_EOL;

?>