<!-- You are given a nested dictionary. Write a function that will find all occurrences of the value and return the key paths. A key path represents the position of a value where nesting is delimited with '.'

# ex. the value at key_path 'company.name' for the following nested dictionary is 'postmates'
data = {
   "name": "sara",
   "phone_number": "861-092-0492",
   "company": {
      "name": "postmates",
      "phone_number": "861-092-0492",
      "address": "425 Market St."
   }
}


get_key_paths_for_value(data, 'sara')
# returns ['name']

get_key_paths_for_value(data, '861-092-0492')
# returns ['phone_number', 'company.phone_number']

get_key_paths_for_value(data, 'hey')
# returns []

-->
<?php
// n level deep, n 100 lvl deep arb
// values are all string
// key are all string
// input: assoc array
// output: array

// Time: O(n) where n is size of the number of key value stores
// Space: O(n)
function get_key_paths_for_value($data, $searchValue) {
  // init a key path variable
  $result = [];
  // loop through data, search for value. $key => $value
  //    key store
  //    if value is string, check if equal to searchvalue
  //    else // hash map
  //        result = call this function to recur this hashmap
  foreach ($data as $key => $value) {
    if ($value == $searchValue) {
      $result[] = $key; //array_push(to the end)
    } else {
      if (gettype($value) != 'string') {
        $path = $key;
        recurHashMap($value, $result, $path, $searchValue);
      }
    }
  }
  return $result;
}

// recur
// base case, all values are string
// ret true if value in current hashmap, else
function recurHashMap($data, &$result, &$path, $searchValue) {
  foreach($data as $key=>$value) {
    if ($value == $searchValue) {
      $result[] = $path . "." . $key;
    } else {
      if (gettype($value) != 'string') {
        recurHashMap($value, $result, , $path, $searchValue); 
      }
    }
  }
}





// You are given a sorted list of timestamps of when a single user logged into their account. We would like to know if they logged into their account 5 or more times within any 30 day period (not only the last 30).
# timestamps of logins in ascending order
//
// timestamps = [
//     1416182478,  #EPOCH TIME
//     1416182490,
//     ...
// ]

// def has_five_or_more_in_ANY_30_days(timestamps):
//     # should return True or False
// IP: array
// OP: true if user 5 or more times, false otherwise

// sliding window starts from first
function has_five_or_more_in_ANY_30_days($timestamps) {
  // loop through timestamps
  // this timestamp + 30days, size of the window
  // endtime = timestamp + 30days(epoch)
  
  for ($i=0; $i < sizeof($timestamps); $i++) {
    $count = 0;
    $endTime = $timestamps[$i] + epoch(30);
    
    for ($j = $i ; $j < $i + 5; $j++{
     // check timestamp[$i 
    }
//     for($j=$i+1; $j <sizeof($timestamps); $j++ ) {
//       if ($timestamps[$j]) {
      
//       }
//     }
    $endTime > $timestamps[$i] = check no of elements traversed
      if 5 or more traversed, return true, 
  }
  
  
  
  
}

// binary search

// 30days(epoch)
