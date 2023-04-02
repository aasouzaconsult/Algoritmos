<?php

/**
 * You are given a list of projects and a list of dependencies (which is a list
 * of pairs of projects, where the second project is dependent on the first project).
 * All of a project's dependencies must be built before the project is. Find a build
 * order that will allow the projects to be built. If there is no valid build order,
 * return an error.
 *
 * EXAMPLE:
 *
 * Input: 
 *     projects: a,b,c,d,e,f
 *     dependencies: (a,d), (f,b), (b,d), (f,a), (d,c)
 * Output: f,e,a,b,d,c
 */

/**
 * A version of DFS.
 * If a cycle is detected. return False.
 * Maintain a traverse stack for the current order of node traversals.
 * If the traverse stack becomes empty, look for the next unvisited node and put
 * into traverse stack.
 * The corresponding node popped from traverse stack has all its edges analyzed,
 * put into traverse stack and mark visited.
 * Time: O(|V|+|E|) where V is number of vertices, E as number of edges
 * Space: O(|V|) 
 */
function buildOrder($graph) {
    $visited = array_fill(0, $graph->getVerticeCount(), False);
    $travStack = [];
    $result = [];

    for ($i=0; $i < $graph->getVerticeCount(); $i++) { 
        if (!$visited[$i] && !in_array($i, $travStack)) {
            $travStack[] = $i;
        } elseif ($visited[$i] && in_array($i, $travStack)) {
            // cycle detected. graph is not a DAG.
            return False;
        }

        while (!empty($travStack)) {
            $index = array_pop($travStack);
            if (!$visited[$index]) {
                $visited[$index] = True;
                $curr = $graph->getEdges()[$index];

                while (!empty($curr)) {
                    if (!$visited[$curr->data]) {
                        $visited[$curr->data] = True;
                        $travStack[] = $curr->data;
                    }
                    $curr = $curr->next;
                }
            }
            $result[] = $index;
        }
    }
    return implode(" ", array_reverse($result));
}