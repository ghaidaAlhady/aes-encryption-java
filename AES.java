/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gradedlap2_tarafh_2306125;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

public class AES {

    static String message = "";
    static String key = "abcdefghijklmnop";     // 16 characters
    static String ivText = "1234567890123456";  // 16 characters

    // convert each encrypted block into Base64 separately
    public static String convertBlocksToBase64(byte[] data) {
        String result = "";

        for (int i = 0; i < data.length; i += 16) {
            byte[] block = new byte[16];

            for (int j = 0; j < 16; j++) {
                block[j] = data[i + j];
            }

            result += "Encrypted Block " + ((i / 16) + 1)
                    + "    |    "
                    + Base64.getEncoder().encodeToString(block)
                    + "\n";
        }

        return result;
    }

    public static void main(String[] args) {

        try {
            // input window
            message = JOptionPane.showInputDialog(
                    null,
                    "Enter a message:",
                    "Input",
                    JOptionPane.PLAIN_MESSAGE
            );

            if (message == null) {
                return;
            }

            // message length must be multiple of 16
            if (message.length() % 16 != 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "Message length must be multiple of 16 characters."
                );
                return;
            }

            // AES key
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

            // IV for CBC
            IvParameterSpec iv = new IvParameterSpec(ivText.getBytes());

            // Encryption Using ECB Mode
            
            Cipher ecbEncrypt = Cipher.getInstance("AES/ECB/NoPadding");
            ecbEncrypt.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] ecbEncrypted = ecbEncrypt.doFinal(message.getBytes());

            Cipher ecbDecrypt = Cipher.getInstance("AES/ECB/NoPadding");
            ecbDecrypt.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] ecbDecrypted = ecbDecrypt.doFinal(ecbEncrypted);

            String ecbOutput = "";
            ecbOutput += "Encryption Using ECB Mode:\n";
            ecbOutput += "Message              |    " + message + "\n";
            ecbOutput += convertBlocksToBase64(ecbEncrypted);
            ecbOutput += "Decrypted Message    |    " + new String(ecbDecrypted) + "\n\n";

         
            // Encryption Using CBC Mode
            
            Cipher cbcEncrypt = Cipher.getInstance("AES/CBC/NoPadding");
            cbcEncrypt.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            byte[] cbcEncrypted = cbcEncrypt.doFinal(message.getBytes());

            Cipher cbcDecrypt = Cipher.getInstance("AES/CBC/NoPadding");
            cbcDecrypt.init(Cipher.DECRYPT_MODE, secretKey, iv);
            byte[] cbcDecrypted = cbcDecrypt.doFinal(cbcEncrypted);

            String cbcOutput = "";
            cbcOutput += "Encryption Using CBC Mode:\n";
            cbcOutput += "Message              |    " + message + "\n";
            cbcOutput += convertBlocksToBase64(cbcEncrypted);
            cbcOutput += "Decrypted Message    |    " + new String(cbcDecrypted);

            // output window
            JOptionPane.showMessageDialog(
                    null,
                    ecbOutput + cbcOutput,
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage()
            );
        }
    }
}