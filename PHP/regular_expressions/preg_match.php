<?php

/**
 * http://php.net/manual/en/function.preg-match.php
 * Perform a regular expression match.
 *
 * int preg_match ( string $pattern , string $subject [, array &$matches [, int $flags = 0 [, int $offset = 0 ]]] )
 */

$string1 = "hello world";
echo preg_match('/^Hello/i', $string1);
echo preg_match('/world/', $string1);

function validate_email($email_address)
{
    if( !preg_match("/^([a-zA-Z0-9])+([a-zA-Z0-9\._-])*@([a-zA-Z0-9_-])+
                     ([a-zA-Z0-9\._-]+)+$/", $email_address))
    {
        return false;
    }   
    return true;
}

function validate_url($url)
{
    return preg_match('|^http(s)?://[a-z0-9-]+(.[a-z0-9-]+)*(:[0-9]+)?
                      (/.*)?$|i', $url);
}

/**
 * This handy function will remove such duplicate words.
 *
 */
function remove_duplicate_word($text)
{
    return preg_replace("/s(w+s)1/i", "$1", $text);
}

/**
 * Validate alpha numeric, dashes, underscores and spaces
 *
 */
function validate_alpha($text)
{
    return preg_match("/^[A-Za-z0-9_- ]+$/", $text);
}

/**
 * Validate US zip codes
 */
function validate_zip($zip_code)
{
    return preg_match("/^([0-9]{5})(-[0-9]{4})?$/i",$zip_code); 
}
