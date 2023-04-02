<?php

class Puzzle {
    // array of pieces to put away
    private $pieces;
    // 2d array solution
    private $solution;
    // int size of the puzzle
    private $size;

    public function __construct($size, $pieces) {
        $this->pieces = $pieces;
        $this->size = $size;
        $this->solution = array_fill(0, $size, array_fill(0, $size, NULL));
    }

    /**
     * Put piece into the solution, turn it appropriately, and remove from the
     * list.
     */
    private function setEdgeInSolution(Edge $edge, $row, $col, Orientation $orientation) {
        $piece = $edge->getParentPiece();
        $piece->setEdgeAsOrientation($edge, $orientation);
        $this->pieces->remove($piece);
        $this->solution[$row][$col] = $piece;
    }

    /**
     * Find the matching piece in piecesToSearch and insert it at row, column
     */
    private function fixNextEdge($piecesToSearch, $row, $col) {
        if ($row == 0 && $col == 0) { // top left hand corner
            $piece = $piecesToSearch->remove();
            $this->orientTopLeftCorner($piece);
            $this->solution[$row][$col] = $piece;
        } else {
            // get the right edge and list to match
            if ($col == 0) {
                $pieceToMatch = $this->solution[$row-1][0];
                $orientationToMatch = Orientation::BOTTOM;
            } else {
                $pieceToMatch = $this->solution[$row][$col-1];
                $orientationToMatch = Orientation::RIGHT;
            }

            $edgeToMatch = $pieceToMatch->getEdgeWithOrientation($orientationToMatch);

            // get matching edge
            $edge = $this->getMatchingEdge($edgeToMatch, $piecesToSearch);
            if (empty($edge)) {
                return False; // can't solve
            }
            $orientation = $orientationToMatch->getOpposite();
            $this->setEdgeInSolution($piecesToSearch, $edge, $row, $col, $orientation);
        }
        return True;
    }

    /**
     * Solve puzzle.
     */
    public function solve() {
        // group pieces
        $cornerPieces = [];
        $borderPieces = [];
        $insidePieces = [];
        $this->groupPieces($cornerPieces, $borderPieces, $insidePieces);

        // walk throught the puzzle, finding the piece that joins the previous one
        for ($row=0; $row < $this->size; $row++) { 
            for ($col=0; $col < $this->size; $col++) { 
                $piecesToSearch = getPieceListToSearch($cornerPieces,
                    $borderPieces,
                    $insidePieces,
                    $row,
                    $col
                );
                if (!$this->fitNextEdge($piecesToSearch, $row, $col)) {
                    return False;
                }
            }
        }
        return True;
    }
}