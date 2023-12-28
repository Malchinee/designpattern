package top.malchinee.txtfile;
/*------------------------------------------------*/
/* THis class implements interface MessageLogger  */
/* This class provides a method called            */
/*            logMsg(String msg)                  */
/* to write a message into a file called log.txt  */
/*------------------------------------------------*/

import top.malchinee.util.FileUtil;

import java.util.Vector;

public class TxtFileReader {

	public Vector logMsg(String encryptOption) {
		Vector r;
    	FileUtil futil = new FileUtil();
		r=futil.fileToVector(encryptOption+".txt");
		return r;
  }
}
