package processor.impl;

import processor.BatchProcessing;

import javax.swing.*;
import java.io.*;


public class ForkInputProcessor implements BatchProcessing {

     private JTextArea resultTxt;
     private BufferedReader input = null;
     private BufferedWriter output1 = null;
     private BufferedWriter output2 = null;


   public ForkInputProcessor(String inFile, String outFile1, String outFile2, JTextArea resultTxtA)throws IOException{
       input = new BufferedReader(new FileReader(inFile));
	   output1 = new BufferedWriter(new FileWriter(outFile1));
	   output2 = new BufferedWriter(new FileWriter(outFile2));
	   resultTxt=resultTxtA;
   }

   /*-------------------------------------------------------------*/
   /* This method simply reads input file line by line,          */
   /* and write each line read to one of the two output files,
   /* one is a file containing woman data and the other is a file
   /* containing man information. The information will not be
   /* accumulated in this class. Once a line is read, it is written
   /* immedietely to an output file                               */
   /*-------------------------------------------------------------*/
   /*这个方法只是逐行读取输入文件，*/
    /*并将读取的每一行写入两个输出文件中的一个，
    /*一个是包含女性数据的文件，另一个是文件
    /*包含man信息。信息将不会
    /*在本课程中积累。一旦一行被读取，它就被写入
    /*立即到输出文件*/
   /*-------------------------------------------------------------*/
   public void processData(){
       try{
		    resultTxt.setText("Man has been dropped.\n\n");
            String line = input.readLine();
            while(line != null){ //not end of file
                String[] words = line.split("\\s");

                if (isAMan(words)==true){
   			        output1.write(line+"\n");
   		        }
   		        else if(isAWoman(words)==true)   {
   			        output2.write(line+"\n");
			        resultTxt.append(line+"\n");
   		        }
                line = input.readLine();
            }

            if (input != null){
   		         input.close();
   		    }
   		    if (output1 != null){
   		         output1.close();
            }
            if (output2 != null){
   		         output2.close();
            }
      }
      catch(IOException exc){
            exc.printStackTrace();
            System.err.println("Error: failed Fork input processor");
            System.exit(1);
         }
   }
    private boolean isAMan(String[] words){
		boolean flag = false;
		for(int k=0; k< words.length; k++){  //One line
		   if( words[k].compareTo("male")==0 ){
				 flag = true;
			}
		}
	   return flag;
    }

    private boolean isAWoman(String[] words){
		boolean flag = false;
		for(int k=0; k< words.length; k++){  //One line
			 if( words[k].compareTo("female")==0 ){
				 flag = true;
				 break;
			}
		}
	   return flag;
    }
}