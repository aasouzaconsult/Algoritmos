/*

+-----------------------+
| x |   |   |   |   |   |
+-----------------------+
|   |   | x | x |   |   |
+-----------------------+
|   |   |   | x |   |   |
+-----------------------+


If cell alive:
  if have 2 or 3 alive neighbors, stay alive, otherwise die
if cell dead:
  if exactly 3 alive neighbors, become alive, otherwise, stay dead

*/

<?php

  // game of life
  // go through generations, each cell changes their state
  // changes state based on neighbours
  // neigbhours are next and diagonally nexts
  // max neigbhours oc each cell = 8 
  // alive = NULL
  // dead = x

  # get_next_state(board) -> board
  # input board -> 2d array.  min = 0, max = PHP_INT_MAX
  # output: 2d->array, each cells in their next state
  
  /**
  Time: O(n * m) n is row, m is col
  Space: O(n * m) // O(1)
  */
  function getNextState($board) {
    // check empty board
    if (empty($board)) {
      return;
    }
    // loop through the board O(n^2)
    //   look at each cell, determine their next state by a helper function
    //   if (needsFlip($board, $row, $col)) {
    //      if current cell is x, set null. vice versa
    //          }
    $temp = $board;
    for ($row=0; $row < sizeof($board); $row++) {
      for ($col=0; $col < sizeof($board[$row]); $col++) {
        if (needsFlip($board, $row, $col, $board[$row][$col])) {
          // as long as this board element is not o or y. 
          if ($board[$row][$col] != 'o' || $board[$row][col] != 'y') {
            // handle with code below
            if ($board[$row][$col] == 'x') {
              $temp[$row][$col] = NULL;
              // represent alive as o
            } else {
              $temp[$row][$col] = 'x';
              // represent alive as y
            }
          }
          
        }
      }
    }
    // loop through the board again, set o to NULL, y to x O(nm
    return $temp;
  }

// If cell alive:
//   if have 2 or 3 alive neighbors, stay alive, otherwise die
// if cell dead:
//   if exactly 3 alive neighbors, become alive, otherwise, stay dead

  function needsFlip($board, $row, $col, $element) {
    // num of alive neighbours
    // count dead neighbours by x
    $deads = 0;
    for ($i=$row-1; $i <= $row+1; $i++) {
      for ($j = $col-1; $j <= $col+1; $j++) {
        if ($i == 0 && $j == 0) {
          continue;
        } else {
          // all neigbhours
          if (!empty($board[$i][$j]) && $board[$i][$j] != 'o' && $board[$i][$j] != 'y') {
            $deads++;
          }
        }
      }
    }

    $count = 8 - $deads;
    // based on what element passed in, and what count is, return approp
    if ($element == 'x') {
      return $count == 3;
    } else {
      if ($count == 2 || $count == 3) {
        return False;
      } else {
        return True;
      }
    }
  }
?>
