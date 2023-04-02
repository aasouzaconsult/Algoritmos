<?php

class EmailTemplate {
    private $id;
    private $templates;
    private static $instance;

    public function __construct() {
        if (!self::$instance) {
             self::$instance = $this;
             $this->id = 0;
             $this->templates = []; // list of available templates
        }
        return self::$instance;
    }
}