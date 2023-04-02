<?php

/**
 * Implement hash table with open addressing collision resolution method.
 * Open addressing: linear probing method.
 */
class HashTable {
    private $arr;
    private $size;

    public function __construct($size) {
        if (!is_numeric($size) || $size < 1) {
            throw new Exception("Table size must be a positive integer.");
        }
        $this->size = $size;
        $this->arr = array_fill(0, $size, NULL);
    }

    public function add($key, $value) {
        $hashKey = $this->hash($key);
        while (!empty($this->arr[$hashKey])) {
            $hashKey++;
            if ($hashKey >= $this->size) {
                $hashKey = 0;
            }
        }
        $this->arr[$hashKey] = $value;
        return;
    }

    public function get($key) {
        $hashKey = $this->hash($key);
        return $this->arr[$hashKey];
    }

    public function remove($key) {
        $hashKey = $this->hash($key);
        $this->arr[$hashKey] = NULL;
        return;
    }

    public function exists($key) {
        $hashKey = $this->hash($key);
        return $this->arr[$hashKey] != NULL;
    }

    private function hash($key) {
        if (gettype($key) == 'string') {
            $keyCount = 0;
            for ($i=0; $i < strlen($key); $i++) { 
                $keyCount += ord($key[$i]);
            }
        } elseif (gettype($key) == 'integer') {
            $keyCount = $key;
        }        
        return $keyCount % $this->size;
    } 
}