<?php


// Mastermind
// XXXX (X ranges from 1 to 6)
// GUESS XXXX\n => A B
// A: the number of digits that are both correct and on the correct positions
// B: the number of digits that are correct but NOT on the correct positions

// e.g. Secret code: 2346
// GUESS 1111\n => 0 0
// GUESS 1112\n => 0 1
// GUESS 2111\n => 1 0
// GUESS 1236\n => 1 2

// code: 1122
// GUESS: 1234\n => 1 1

// Goal: use as minimum number of guesses as possible to guess the secret code (4 0)



// brute: hitting from 1111 - 6666
// 1. digits that form secret code
// 2. what sequence are secret codes arranged

// 1. only concerned about B
// 1234, #A = 4
// 5234
  
// checkCurrDigit
// a. B decrease => backtrack prev digit ,ret -1
// b. B increase => curr digit counts to soln,ret 1
// c. B remain => move one to next digit, ret 0

// 1. wild guess, 1111
// 2. loop through current digit,
// 3.  
//     if checkCurrDigit == 0 || checkCurrDigit == 1:
//       continue
//     elseif checkCurrDigit == -1:
    
//     aux check using digit B:
//       make new request to server with amended digit
//         OR
//         amend the current digits
// 4. done

$fp = fsockopen("tcp://0.tcp.ngrok.io", 16881, $errno, $errstr, 30);
if (!$fp) {
    echo "$errstr ($errno)<br />\n";
} else {
    fwrite($fp, "START\n");
    while (!feof($fp)) {
        echo fgets($fp, 128);
        $code = "GUESS 1111\n";
        fwrite($fp, $code);        
        // echo $response;
        $response = fgets($fp, 128);
        echo $response;
        
        while ($response != "4 0") {
          // my function that returns a "GUESS 1111\n" with digits
          $request = guessDigit($code, "", $response);
          
        }
        
    }
    fclose($fp);
}

function guessDigit($code, $prevCode, $response) {
  $responses = explode(" ", $response);
  $A = $responses[0];
  $B = $responses[1];
  
  $code = (str) $code;
  $prevCode = (str) $code;
  for ($i=0; $i < strlen($code); $i++) {
    if (checkDigit($code[$i], $responses) == 0 || checkDigit($code[$i], $responses) == 1) {
      continue;
    } elseif (checkDigit($code[$i], $responses) == -1) {
      // revert to previous digit
      if (empty($prevCode)) {
        // replace with new number  
      } else {
        $code[$i] = $prevCode[$i];
      }
    }
    if ($A == '4' && $B == '0') {
      return "";
    } else {
       // manipulate current code to produce new code
    }
  }
}

function checkValues($B) {
  
}
?>
