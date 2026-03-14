# AES Encryption in Java

This project demonstrates the implementation of AES encryption using Java.  
It supports encryption and decryption using both ECB and CBC modes.

The program takes a message as input, encrypts it using AES, and then displays the encrypted blocks in Base64 format.

## Features

- AES encryption using ECB mode
- AES encryption using CBC mode
- Base64 representation of encrypted blocks
- Simple graphical input/output using Java Swing

## Technologies Used

| Technology | Purpose |
|-----------|--------|
| Java | Programming language |
| AES | Symmetric encryption algorithm |
| Base64 | Encoding encrypted data |
| Swing | Simple graphical interface |

## File Structure

| File | Description |
|-----|-------------|
| AES.java | Main program implementing AES encryption and decryption |

## How It Works

1. User enters a message.
2. The message must be a multiple of 16 characters.
3. The message is encrypted using AES.
4. The encrypted blocks are converted to Base64.
5. The program displays encrypted and decrypted messages.

## Author

Tarafh Al-Akor
