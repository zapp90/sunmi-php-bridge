<?php
// Sunmi Bridge Test Script

$ping = @file_get_contents("http://127.0.0.1:9999/status");

if ($ping === false) {
    echo " Failed to connect to Sunmi bridge. Is the Android server running?";
} else {
    echo " Sunmi bridge is up! Response: " . $ping;
}
?>
