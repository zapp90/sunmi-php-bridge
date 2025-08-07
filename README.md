#  Sunmi PHP Bridge

**Sunmi PHP Bridge** is a hybrid solution that allows your PHP-based POS system to print receipts, open cash drawers, and control Sunmi devices using a local Android HTTP bridge powered by the official Sunmi SDK.

---

##  How It Works

- ✅ Small Android service wraps Sunmi SDK functions
- ✅ Exposes local HTTP API (e.g. `http://127.0.0.1:9999/print`)
- ✅ Your PHP system sends requests to that local IP
- ✅ No internet required – works fully offline
- ✅ Compatible with Sunmi V1, V2, T2, T2mini, and more

---

##  Project Structure

```
sunmi-php-bridge/
├── android-sunmi-server/
│   ├── app/
│   │   └── src/
│   │       └── main/
│   │           └── java/
│   │               └── com/
│   │                   └── sunmibridge/
│   │                       ├── HTTPServer.java
│   │                       └── MainActivity.java
├── php-client-sample/
│   ├── print.php
│   └── test.php (I'll generate this for you)
├── LICENSE
└── README.md

```

---

## ▶ Sample PHP Usage

```php
// php-client-sample/print.php
$receipt = "Item A - RM5\nItem B - RM8\nTotal: RM13";
$response = file_get_contents("http://127.0.0.1:9999/print?text=" . urlencode($receipt));
echo $response;
```

---

##  Android API Endpoints

| Endpoint         | Method | Description             |
|------------------|--------|-------------------------|
| `/print?text=...`| GET    | Print text              |
| `/status`        | GET    | Check printer status    |
| `/cut`           | GET    | Cut paper (if supported)|
| `/drawer`        | GET    | Open cash drawer        |

---

##  License

MIT License

```
MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND...
```

---

##  Why This Exists

Most open-source POS systems are written in PHP and run in browsers — but Sunmi devices use native Android SDK. This bridge allows legacy systems to work with modern Sunmi hardware **without a rewrite**.

---

##  Contributions

Feel free to:
- Fork and improve
- Add more endpoints (QR code, image, barcode)
- Submit PRs for other device support
