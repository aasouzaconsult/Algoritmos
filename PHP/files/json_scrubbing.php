<?php

function readArray(&$contents, $scrubs) {
    foreach ($contents as $key => &$value) {
        if (gettype($value) == 'array') {
            if (in_array($key, $scrubs)) {
                foreach ($value as &$subValue) {
                    $subValue = preg_replace('/[a-zA-Z0-9]/', '*', $subValue);
                }
            } else {
                foreach ($value as $key2 => &$value2) {
                    readArray($value2, $scrubs);
                }
            }            
        } else {            
            if (in_array($key, $scrubs)) {
                $value = preg_replace('/[a-zA-Z0-9]/', '*', $value);
            }
        }
    }
}

$toScrub = [
    "ssn",
    "name",
    "card_number",
    "email",
    "phone",
    "cvc",
    "address",
    "dob",
    "ssn_last4",
    "phone_number"
];

$testFile1 = dirname(__FILE__) . '/examples/raw/payment_type_selected.json';
$resource1 = fopen($testFile1, 'r');
$contents = fread($resource1, filesize($testFile1));
$contents = json_decode($contents, True);
$iter = new RecursiveIteratorIterator(new RecursiveArrayIterator($contents));
while ($iter->valid()) {
    // echo $iter->key() . ' => ' . $iter->current() . PHP_EOL;
    if (in_array($iter->key(), $toScrub)) {
        echo "RUNS" . PHP_EOL;
        $value = $iter->current();
        $value = preg_replace('/[a-zA-Z0-9]/', '*', $value);
    }
    $iter->next();
}

// readArray($contents, $toScrub);
var_dump($contents);

$testFile2 = dirname(__FILE__) . '/examples/raw/signup_event_data.json';
$resource2 = fopen($testFile2, 'r');
$contents2 = fread($resource2, filesize($testFile2));
$contents2 = json_decode($contents2, True);
// readArray($contents2, $toScrub);
// var_dump($contents2);

