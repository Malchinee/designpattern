package top.malchinee.decrypt;

import javax.swing.*;

public class DecryContext {
    private Decryption en;

    public DecryContext(Decryption en){
        this.en = en;
    }

    public void doDecryption(JTextArea txt){
        en.log(txt);
    }
}
