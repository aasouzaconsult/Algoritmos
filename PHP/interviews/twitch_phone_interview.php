<?php
// design and implement a class that's called a forest. maintains a collection of trees(like CS trees), init. forest class has no data, empty.
// 2 public methods

// 1. addLink(parentNode, childNode) // 2 strings // create a link between forest on these 2 nodes
// parentNode->child(num) = childNode;

// 2. debugPrint() // print state of forest to the console


// req 1: easily see parent child relationship
// req 2: relative depth of node within the forest.

// tree: 
// every tree has root,
// every node has arbitray number of child nodes
// each node holds its own name

// init forest has no nodes
// forest = [node1, node2, node3];
// parentNode = node1/node2/node3

class Node {
  private $data;
  private $children;
  private $childCount;

  public function __construct($data, $child) {
    $this->data = $data;
    $this->children = [];
    $this->childCount = 0;
    if (!empty($child)) {
      $this->children[$child->data] = $child;
      $this->childCount++;
    }
  }

  public function getChildren() {
    return $this->children;  
  }
}

class Forest {
  // container to contain each tree. infinte num of trees
  private $trees; // vector array of trees

  public function __construct() {
    $this->trees = []; // hashtable
  }

  public function addLink($parentStr, $childStr) {
    if (empty($this->trees)) {
      $parentNode = new Node($parentStr, $childNode);
      $childNode = new Node($childStr, NULL);  
      $this->trees[$parentNode->data] = $parentNode;
      return;
    }
    // check if trees already has the parentNode
    if (!isset($this->trees[$parentStr]) !isset($this->trees[$childStr])) {
      $preExisting = False; 
      foreach ($this->trees as $tree) {
        if(checkExists($tree, $parentStr, $childStr)) {
          // true if parentstr/childstr exists in current tree as a child.
          // append to the current found child          
          $childNode = new Node($childStr, NULL);
          $tree->getChildren[$childStr] = $childNode;
          $preExisting = True;
          break;
        }
      }
      // preexisting true
      //add new parentnode to forest
    }

    return;
  }

  function debugPrint() {
    // tree1: C -> D -> A -> B
    // C
    //    child1    
    //    child2    
    //    child3
    // child1
    //    child4
    //    child5
    // ....
    // lastChild
    //    -
    //BFS
    foreach($this->trees as $tree) {
      $queue = [$tree]
      while (!empty($queue)) {
      
      }
    }
  }
}


function main() {
  $forest = new Forest();
  $forest->addLink("A", "B");
  $forest->addLink("C", "D");
  $forest->addLink("D", "A");
}

C -> D -> A -> B

$trees = [node('C')];


"A", "B"
C, D
D, A

node("A")->child = "B"
// forest = [node('A')];
node("C")->child = "D"
// forest = [node('A'), node('C')];