<?php

class Orientation {
    const LEFT = 0;
    const TOP = 1;
    const RIGHT = 2;
    const BOTTOM = 3;

    public function getOpposite($orientation) {
        switch ($orientation) {
            case self::LEFT:
                return self::RIGHT;
                break;
            case self::RIGHT:
                return self::LEFT;
                break;
            case self::TOP:
                return self::BOTTOM;
            case self::BOTTOM:
                return self::TOP;
            default:
                return NULL;
        }
    }
}