<?php

/**
 * In the class problem of the towers of Hanoi, you have 3 towers and N disks of
 * different sizes which can slide onto any tower. The puzzle starts with disks
 * sorted in ascending order of size from top to bottom(ie. each disk sits on top
 * of an even bigger one). You have the following constraints:
 * 1. Only one disk can be moved at a time.
 * 2. A disk is slide off the top of one tower onto another tower.
 * 3. A disk cannot be placed on top of a smaller disk.
 * Write a program to move disks from the first tower to the last using stacks.
 */

/**
 * Time: O(2^n) where n is size of the height
 * Space: O(2^n)
 */
function towerOfHanoi($height, $src, $aux, $dst) {
    if ($height >= 1) {
        // move n-1 disk from src to aux stack
        towerOfHanoi($height-1, $src, $dst, $aux);
        // move disk n from src to dst
        $disk = array_pop($src[1]);
        array_push($dst[1], $disk);
        echo "Move disk from {$src[0]} to {$dst[0]}" . PHP_EOL;
        
        // move n-1 disk from aux stack to dst
        towerOfHanoi($height-1, $aux, $src, $dst);
    }
}

$src1 = ['src', [5,3,1]];
$aux1 = ['aux', []];
$dst1 = ['dst', []];

towerOfHanoi(3, $src1, $aux1, $dst1);