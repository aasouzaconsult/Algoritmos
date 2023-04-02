<?php

/**
 * Describe how you could use a single array to implement 3 stacks.
 */

// Split the array into 3 equal sized portions.
// have 3 pointers each pointing to the current empty location in each stack.
// when u add into a stack, you must specify which stack you are adding to.
// when an item is added to one of the stack, the corresponding pointer increments
// to next empty location in stack.
// when you delete and item from the stack, remove the top item from the stack
// and move the pointer 1 position back.
// if any of the stack is full, double the size of the entire array. so each stack size
// is thus doubled.
// move the existing stack elements to their new stack location, while still maintaining a stack.