package top.malchinee.encrypt.impl;

import top.malchinee.encrypt.Encryption;
import top.malchinee.txtfile.TxtFileWriter;

import javax.swing.*;

public class EncryptedInfo3 implements Encryption {

    private TxtFileWriter writer = new TxtFileWriter();
    public static final String CAESAR = "Caesar";

    @Override
    public String encryptName(String inputStr) {
        char[] chars = inputStr.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                chars[i] = encryptCharacter(chars[i]);
            }
        }

        return new String(chars);
    }

    @Override
    public String encryptCode(String code) {
        char[] chars = code.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                chars[i] = encryptDigit(chars[i]);
            }
        }

        return new String(chars);
    }


    private char encryptCharacter(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            ch = (char) ((ch - 'a' + 1) % 26 + 'a');
        } else if (ch >= 'A' && ch <= 'Z') {
            ch = (char) ((ch - 'A' + 1) % 26 + 'A');
        }
        return ch;
    }

    private char encryptDigit(char digit) {
        if (digit >= '0' && digit <= '9') {
            digit = (char) ((digit - '0' + 1) % 10 + '0');
        }
        return digit;
    }

    @Override
    public void log(String lastNm, String firstNm, String code, JTextArea txt) {
        String encryptedFirstName = encryptName(firstNm);
        String encryptedLastName = encryptName(lastNm);
        String encryptedCode = encryptCode(code);

        txt.append("Encrypted Text\n");
        txt.append("Encrypted agent first name: " + encryptedFirstName + "\n");
        txt.append("Encrypted agent last name: " + encryptedLastName + "\n");
        txt.append("Encrypted agent code: " + encryptedCode + "\n\n");

        writer.logMsg(CAESAR, encryptedFirstName, encryptedLastName, encryptedCode);
        txt.append("Data has been logged." + "\n\n");
    }
}