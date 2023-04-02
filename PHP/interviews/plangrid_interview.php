<?php

/*
**
** Traffic Lights
**
** Make a controller for a traffic light at a 4-way intersection
**
** no crosswalks / pedestrian stuff
** no turn signals
**
** There's an East-West light, and a North-South light.
** Green light: on for 8 "ticks"
** Yellow light: on for 3 "ticks"
** Red light: for 2 "ticks" both lights are red, for safety's sake, then wait for other light to finish
**
** System must be testable
** Therefore "time" probably can't be real clock time...
** use "steps" or "ticks" instead of real seconds
** Something drives the whole system with "steps" or "ticks"
**
** There's some way of reading the state of the system
** current "step" or "tick" for testing purposes
** current state of each light
**
** Desired output: Print out the state of each light at each time step
**
*/

  // TrafficLight
  // light 1: east west 
  // light 2: north south light 
  // time ticks
  
  // requirements  
  // way to read state of the system
  // readState() -> tick: # , [light1, light2]: read/green/yellow
  
  // green -> 8tick, yellow ->3 tick ->red 2ticks
  // green -> multiples of 8, y ->multiples of 3, red->multiples of 2
  class TrafficLightSystem {
    private $lights; // hashtable of DirectionLight objects
      
    public function __construct() {
        $this->lights = [];
        $this->lights['EW'] = new DirectionLight();
        $this->lights['NS'] = new DirectionLight();
    }
      
    public function getStates($tick) {
        $result = [];
        foreach ($this->lights as $directionLight) {
            $result[] = $directionLight->getState($tick);
        }
        return $result;
    }
  }

  class DirectionLight {
    private $red;
    private $yellow;
    private $green;
    private $cycle;// circular linked list
    
    public function __construct() {
        $this->cycle = new LinkedList();
        $this->red = new RedLight();
        $this->green = new GreenLight();
        $this->yellow = new YellowLight();
        // for first 8, put in green, then 3 yellow, 2 red
        
        for ($i=0; $i<= 8; $i++) {
            if ($this->cycle->isEmpty()) {
                $head = $this->cycle->getHead();
                $head->data = $this->green();
            } else {
                $this->cycle->insert($this->green);
            } 
        }
        $trav = $this->cycle->getHead();
        while (!$trav != NULL) {
            $trav = $trav->next;
        }
        //for loop for yellow
        $trav->next = $this->yellow;
        $trav = $trav->next;
        //for loop for red
        ...
    
        // last node next point to starting green node.
    }
    
    public function getState($tick) {
        
    }
    
  }

  abstract class Light {
    
  }
  
  class RedLight {
  
  }

  class GreenLight {
  
  }

  class YellowLight {
  
  }
