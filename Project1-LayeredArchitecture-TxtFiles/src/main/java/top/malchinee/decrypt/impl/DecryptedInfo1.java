package top.malchinee.decrypt.impl;
/*-------------------------------------------------*/
/* This is a subclass to implement interface       */
/* Mesage.                                         */
/* a) This class keeps a reference logger of       */
/*    MessageLogger.                               */
/* b) This logger is used to call logMsg in        */
/*    class MessageLogger                          */
/* c) The object is created from the Client        */
/*    file, like, logger = new FileLogger();       */
/*    Then logger is passed into THIS class        */
/*    TextMessage by                               */
/*    Message msg = new EncryptedMessage(logger);  */
/* d) The algorithm is that a-->z, b-->y, ...m-->n */
/*    y-->b,z-->a, and uppercase lettet remins     */
/*    unchanged                                    */
/*-------------------------------------------------*/

import top.malchinee.decrypt.Decryption;
import top.malchinee.txtfile.TxtFileReader;

import javax.swing.*;


public class DecryptedInfo1 implements Decryption {

   private TxtFileReader reader = new TxtFileReader();
   public static final String FOLDING = "Folding";
   private String str[]=null;

   public void log(JTextArea txt){
	   txt.append("Decrypted Text\n");
	   for(int i=0;i<reader.logMsg(FOLDING).size();i++) {
		   str = ((String) (reader.logMsg(FOLDING).get(i))).split(" ");
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
      txt.append("Data has been read from file "+ FOLDING +".txt"+"\n\n");
   }

   public String decryptName(String msg){
	  System.out.println(msg);
	  char[] alphabet = getAlphabetArray();
	  char[] chars = msg.toCharArray();

	  System.out.println("CharLen"+chars.length);

	  for (int m = 0; m < chars.length; m++){
	     for(int n = 0; n < 26; n++){
	        if ( chars[m] == alphabet[n]){
	        	chars[m] = alphabet[25-n];
	        	break;
	        }
	        else if ( chars[m] == Character.toUpperCase(alphabet[n])){
				chars[m] = Character.toUpperCase(alphabet[25-n]);
				break;
	        }
	      }
	  }
	  return new String(chars);
   }

   public String decryptCode (String code) {
      char[] digitArr = getDigitArray();
	  char[] codeChars = code.toCharArray();
	  char[] alphabet = getAlphabetArray();

	     for (int m = 0; m < codeChars.length; m++){
		    for(int n = 0; n < 26; n++){
	           if ( codeChars[m] == alphabet[n]){
	              codeChars[m] = alphabet[25-n];
	        	  break;
	           }
	           else if ( codeChars[m] == Character.toUpperCase(alphabet[n]) ){
			      codeChars[m] = Character.toUpperCase(alphabet[25-n]);
				  break;
	           }
	        }

            for(int j = 0; j < 10; j++){
	           if ( codeChars[m] == digitArr[j]){
	              codeChars[m] = digitArr[9-j];
	        	  break;
	           }
	        }
	     }
	   return new String(codeChars);
   }

  private char[] getAlphabetArray(){
     String str = "abcdefghijklmnopqrstuvwxyz";
	 char[] chArray = str.toCharArray();
	 return chArray;
  }

  private char[] getDigitArray(){
     String str = "0123456789";
  	 char[] chArray = str.toCharArray();
  	 return chArray;
  }
}
