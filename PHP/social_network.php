<?php

/**
 * How would you design the data structures for a very large social network like
 * Facebook or LinkedIn? Describe how you would design an algorithm to show the 
 * shortest path between two people. (eg. me->bob->susan->jason->you)
 */

// 1. Constraints and use cases
// - user are connected to each other, ie. friends with each other
// - 1 billion user
// - average user has 200 friends, some user has tens of thousands of friends
// - user1 wants to find the shortest route to user2
// - me->friend1->friend2->you

// 2. Abstract design
// - We can have User table to represent users 
// - User
// -   - id
// -   - username PK
// -   - useremail PK
// -   - created_at
// -   - other data fields
// - Friend table to represent friend relationship
// - Friend
// -   - user_id
// -   - friend_id
// -   - accepted
// -   - created_at
// - we can represent user as vertices and friends connection as edges, as of a graph.
// - due to 6 degree of separation rules. both users are bound to be connected at most 5 friends away
// - we can use BFS to start searching for both users.
// - the point at which the 2 traversal points meet, means that this the common friend of friend that connects them together.
// - return the traversed path for 2 users and join them together. that is the path traversed to find another user.