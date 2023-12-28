package top.malchinee.decrypt;

import javax.swing.*;

public interface Decryption {
    public abstract String decryptName(String inputStr);
    public abstract String decryptCode (String code);
    public abstract void log(JTextArea txt);
}
