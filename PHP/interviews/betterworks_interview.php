<?php

/*
LCA Tree
                    A      |    X
                 /     \   |      \
               B        C  |        Y
             /   \     /   |
           D       E  F    |
         / | \             |
        G  H  I            |
      /                    |
    J                      |
*/
// every node can have arb num of childs
// A and X are roots of the tree
// given 2 nodes are definitely in a tree, not nece same tree

/*
  F -> C -> A
       B -> A 


*/
// traverse node1, count no of traversal= count1
// traverse node2, count no of traversal = count2
// max(count1 - count2)
// diff = abs(count1 - count2)
// traverse node1 diff number of times
// while (node1 not empty and node2 not empty)
//    node1 == node2



class Node {
  public $value;
  public $parent;
  // ..
  public function __construct($value, $parent) {
    $this->value = $value;
    $this->parent = $parent;
  }
  
  public function getValue() {
    return $value;
  }
      
}

// tree 1
$nodeX = new Node('X', null);
$nodeY = new Node('Y', $nodeX);

// tree 2
$nodeA = new Node('A', null);

$nodeB = new Node('B', $nodeA);
$nodeC = new Node('C', $nodeA);

$nodeD = new Node('D', $nodeB);
$nodeE = new Node('E', $nodeB);
$nodeF = new Node('F', $nodeC);

$nodeG = new Node('G', $nodeD);
$nodeH = new Node('H', $nodeD);
$nodeI = new Node('I', $nodeD);

$nodeJ = new Node('J', $nodeG);

// var_dump(lca($nodeB, $nodeC));
// var_dump(lca($nodeJ, $nodeE));
// var_dump(lca($nodeG, $nodeY));
var_dump(lca($nodeA, $nodeB));
// string spl_object_hash ( object $obj )

// Time: O(lgn) where n is the size of the longest tree
// Space: O(n)
function lca($node1, $node2) {
  // traverse each node all the way up, until root node
  // root has no parent
  // memoryaddress of parent => child node
  // spl_object_hash(node) = id 
  // id => parent
  // http://php.net/manual/en/function.spl-object-hash.php
  if (empty($node1) || empty($node2)) {
    return NULL;
  }
  $table = [];
  $trav1 = $node1;
  // construct hash table from 1st node
  while (!empty($trav1)) {
    $id = spl_object_hash($trav1);
    $table[$id] = 1; // id of A => NULL
    $trav1 = $trav1->parent;
  }
  // id A => null
  
  // $table = [hash(a) -> null]
  
  // lookup node2's parent in hash table
  $trav2 = $node2;
  while (!empty($trav2)) {
    $id = spl_object_hash($trav2); 
    if (isset($table[$id])) { // will not run for B
      return $trav2;
    }
    $trav2 = $trav2->parent;
  }
  
  return NULL;
}

// def lca(left, right):
//     '''Find the lowest common ancestor of two nodes

//     Given two Node objects, return the first common parent, or None
//     if the nodes have no parents in common.

//     Examples using tree above:
//         Given nodes B and C, return node A
//         Given nodes J and E, return node B
//         Given nodes G and Y, return None
//     '''
//     raise NotImplementedError('Your code here!')