<?php

/**
 * Implementation of a dictionary
 */

class Dictionary {
    private $container;

    public function __construct($dict=array()) {
        $this->container = $dict;
    }

    /**
     * Insert an element into dictionary
     * Time: O(1)
     * @param  [type] $key   [description]
     * @param  [type] $value [description]
     * @return [type]        [description]
     */
    public function insert($key, $value) {
        $this->container[$key] = $value;
    }

    /**
     * Delete an element into dictionary
     * Time: O(1)
     * @param  [type] $key [description]
     * @return [type]      [description]
     */
    public function delete($key) {
        if (isset($this->container[$key])) {
            unset($this->container[$key]);
        }
    }

    public function printDictionary() {
        print_r($this->container);
    }

    public function getDict() {
        return $this->container;
    }
}

$dict = new Dictionary();
$dict->insert('gfdsg', 'diamond');
$dict->insert('wtf', 'watermelon');
$dict->insert('a', 'apple');
$dict->insert('b', 'banana');
$dict->insert('c', 'carrot');
$dict->printDictionary();
$dict->delete('c');
$dict->printDictionary();
asort($dict->getDict());
$dict->printDictionary();
