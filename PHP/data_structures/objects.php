<?php

// we can create an object like this.
class Fruit {
    public function getColor() {
        return "blue";
    }
}
$fruit = new Fruit();
$fruit->getColor();

$arr = [
    'apple' => 'applevalue',
    'pear'  => 'pearvalue'
];

// casts to object creates a stdClass object.
$arrToObject = (object) $arr;

print_r($arrToObject);