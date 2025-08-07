<?php
$receipt = "Sunmi + PHP\nItem A - RM5\nItem B - RM3\nTOTAL: RM8\n";
$url = "http://127.0.0.1:9999/print?text=" . urlencode($receipt);
$response = file_get_contents($url);
echo "Android response: " . $response;
