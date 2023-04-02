<?php

class Shape {
    const INNER = 0;
    const OUTER = 1;
    const FLAT = 2;

    public function getOpposite($shape) {
        switch ($shape) {
            case self::INNER:
                return self::OUTER;
                break;
            case self::OUTER:
                return self::INNER;
                break;
            default:
                return NULL;
        }
    }
}