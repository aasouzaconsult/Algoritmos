<?php

// Compare two version numbers version1 and version2.

// If version1 > version2 return 1,
// If version1 < version2 return -1,
// otherwise return 0.
// You may assume that the version strings are non-empty and contain only digits and the . character.
// The . character does not represent a decimal point and is used to separate number sequences.
// For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

// Here is an example of version numbers ordering:

// 0.1 < 1.1 < 1.2 < 1.13 < 1.13.4

function compareVersion($version1, $version2) {
    return compareVersionHelper($version1, $version2, 0, 0);
}

function compareVersionHelper($version1, $version2, $v1Index, $v2Index) {
    list($curr1, $curr2) = ["", ""];
    if ($v1Index >= strlen($version1) && $v2Index >= strlen($version2)) {
        return 0;
    } elseif ($v1Index >= strlen($version1)) {
        while ($version2[$v2Index] != '.') {
            $curr2 += $version2[$v2Index];
            $v2Index++;
            if ($v2Index >= strlen($version2)) {
                break;
            }
        }
        if ((int)$curr2 == 0) {
            return 0;
        }
        return -1;
    } elseif ($v2Index >= strlen($version2)) {
        while ($version1[$v1Index] != '.') {
            $curr1 += $version1[$v1Index];
            $v1Index++;
            if ($v1Index >= strlen($version1)) {
                break;
            }
        }
        if ((int)$curr1 == 0) {
            return 0;
        }
        return 1;
    }

    while ($version1[$v1Index] != '.') {
        $curr1 .= $version1[$v1Index];
        $v1Index++;
        if ($v1Index >= strlen($version1)) {
            break;
        }
    }
    while ($version2[$v2Index] != '.') {
        $curr2 .= $version2[$v2Index];
        $v2Index++;
        if ($v2Index >= strlen($version2)) {
            break;
        }
    }

    if ((int)$curr1 > (int)$curr2) {
        return 1;
    } elseif ((int)$curr1 < (int)$curr2) {
        return -1;
    }
    list($curr1, $curr2) = ["", ""];
    return compareVersionHelper($version1, $version2, $v1Index+1, $v2Index+1);
}
$v1 = "0.1";
$v2 = "1.1";
$v3 = "1.2";
$v4 = "1.13";
$v5 = "1.13.4";
$v6 = "01";
$v7 = "1";

echo compareVersion($v1, $v2) . PHP_EOL; // -1
echo compareVersion($v2, $v3) . PHP_EOL; // -1
echo compareVersion($v3, $v4) . PHP_EOL; // -1
echo compareVersion($v4, $v5) . PHP_EOL; // -1
echo compareVersion($v6, $v7) . PHP_EOL; // 0
