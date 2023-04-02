<?php

class CircularArray implements IteratorAggregate{
    private $arr;
    private $head;

    public function __construct() {
        $this->arr = [];
        $this->head = NULL;
    }

    public function add($data) {
        if (empty($this->arr)) {
            $this->head = 0;
        }
        $this->arr[] = $data;
    }

    public function rotate() {
        if (is_null($this->head)) {
            return;
        }
        if ($this->head + 1 < sizeof($this->arr)) {
            $this->head++;
        } else {
            $this->head = 0;
        }
    }

    public function getIterator() {
        return new ArrayIterator($this->arr);
    }
}

$ca = new CircularArray();
$ca->add(1);
$ca->add(2);
$ca->add(3);
$ca->add(4);
$ca->add(5);
$ca->add(6);
$iter = $ca->getIterator();
// foreach ($iter as $val) {
//     echo $val . PHP_EOL;
// }
echo "=====" . PHP_EOL;
echo $iter->current() . PHP_EOL;
$iter->next();
echo $iter->current() . PHP_EOL;
$iter->next();
echo $iter->current() . PHP_EOL;
$iter->next();
echo $iter->current() . PHP_EOL;
$iter->next();
echo $iter->current() . PHP_EOL;
$iter->next();