package top.malchinee.decrypt.impl;
/*-------------------------------------------------*/
/* This is a subclass to implement interface       */
/* Encryption.                                     */
/* a) This class keeps a reference logger of       */
/*    MessageWriter.                               */
/* b) This logger is used to call logMsg in        */
/*    class MessageLogger                          */
/* c) The object is created from the Client        */
/*    file, like, logger = new FileLogger();       */
/*    Then logger is passed into THIS class        */
/*    TextMessage by                               */
/*    Message msg = new EncryptedMessage(logger);  */
/*-------------------------------------------------*/

import top.malchinee.decrypt.Decryption;
import top.malchinee.txtfile.TxtFileReader;

import javax.swing.*;

public class DecryptedInfo3 implements Decryption {

    public static final String CaesarCypher = "Caesar";
    private TxtFileReader reader = new TxtFileReader();
    private String str[];

    public void log(JTextArea txt) {
        txt.append("Decrypted Text\n");
        for(int i=0;i<reader.logMsg(CaesarCypher).size();i++) {
            str = ((String) (reader.logMsg(CaesarCypher).get(i))).split(" ");
            if(str[0].length()==0);
            else {
                String lName = decryptName(str[0]);
                String fName = decryptName(str[1]);
                String codeStr = decryptCode(str[2]);
                txt.append("Decrypted agent first name: " + fName + "\n");
                txt.append("Decrypted agent last name: " + lName + "\n");
                txt.append("Decrypted agent code: " + codeStr + "\n\n");
            }
        }
        txt.append("Data has been read from file " + CaesarCypher + ".txt" + "\n\n");
    }

    public String decryptName(String name) {
        char[] chars = name.toCharArray();

        for (int m = 0; m < chars.length; m++) {
            if (chars[m] == 'a')
                chars[m] = 'z';
            else if (chars[m] == 'A')
                chars[m] = 'Z';
            else
                chars[m]--;
        }
        return new String(chars);
    }

    public String decryptCode(String code) {
        char[] chars = code.toCharArray();

            for (int m = 0; m < chars.length; m++) {
                if (chars[m] == 'a')
                    chars[m] = 'z';
                else if (chars[m] == 'A')
                    chars[m] = 'Z';
                else if (chars[m] == '0')
                    chars[m] = '9';
                else
                    chars[m]--;
            }

        return new String(chars);
    }


}
