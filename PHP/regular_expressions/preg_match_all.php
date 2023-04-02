<?php

// Lets write a regular expression to extract the day of month in
// a string with numerous dates
$pattern = "/[a-zA-Z]+ (\d+)/";
$input_str = "June 24, August 13, and December 30";
if (preg_match_all($pattern, $input_str, $matches_out)) {
    // $matches_out is now an Array of size equal to N+1, for N 
    // number of groups you are capturing in your regex, and +1
    // for the substrings that matched.

    // This will print "2" because we are capturing only one group
    echo count($matches_out);

    // In addition, each value in $matches_out is another Array of 
    // size M, for M number of matches of the regex in the input.

    // This will print "3" for the three dates in our input string
    echo count($matches_out[0]);

    // $matches_out[0] is an Array of the matched strings from the
    // input string.

    // This prints an Array ("June 24", "August 13", "December 30")
    print_r($matches_out[0]);

    // $matches_out[1], $matches_out[2], etc. are Arrays filled with
    // the captured data in the same order as in the regex pattern.

    // This prints an Array ("24", "13", "30")
    print_r($matches_out[1]);
}