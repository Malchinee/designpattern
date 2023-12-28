package processor.impl;

import processor.BatchProcessing;

import javax.swing.*;
import java.io.*;


public class WomanProcessor2 implements BatchProcessing {
   private JTextArea resultTxt;
   private BufferedReader input = null;
   private BufferedWriter output1 = null;
   private BufferedWriter output2 = null;


   public WomanProcessor2(String inFile, String outFile1, String outFile2, JTextArea resultTxtA)throws IOException{

      input = new BufferedReader(new FileReader(inFile));
	  output1 = new BufferedWriter(new FileWriter(outFile1));
	  output2 = new BufferedWriter(new FileWriter(outFile2));
	  resultTxt=resultTxtA;
   }

   /*------------------------------------------------------------------------*/
   /* This method simply reads input file (Woman18+) line by line, and       */
   /* write each line read to one of the two output files, one is
   /* a file containing women whose ages are between 18 to 25, and the other
   /* is a file containing women whose ages are above 25. the data
   /* will not be accumulated in this class. Once a line is read,
   /* it is written immedietely to an output file                            */
   /*------------------------------------------------------------------------*/
   public void processData(){

       try{
           String line = input.readLine();
           while(line != null){ //not end of file
               String[] words = line.split("\\s");

               if (isAWoman(words) && is18To25 (words)){
                   output1.write(line+"\n");
               }
               else{
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
           System.err.println("Error: failed Woman processor 1");
           System.exit(1);
       }
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

    private boolean is18To25 (String[] words)   {
        boolean flag = false;
        for(int k=0; k< words.length; k++){  //One line
            if(words[k].length() == 10){
                flag = is18To25 (words[k]);
            }
        }
        return flag;
    }
    private boolean is18To25 (String word)   {
        boolean flag = false;
        if  ((Character.isDigit(word.charAt(0))==true)&&
                (Character.isDigit(word.charAt(1))==true)&&
                (Character.isDigit(word.charAt(2))==true)&&
                (Character.isDigit(word.charAt(3))==true)&&
                (word.charAt(4)== '-')&&
                (Character.isDigit(word.charAt(5))==true)&&
                (Character.isDigit(word.charAt(6))==true)&&
                (word.charAt(7)== '-')&&
                (Character.isDigit(word.charAt(8))==true)&&
                (Character.isDigit(word.charAt(9))==true)
        ){
            word = word.substring(0, 4);
            int year = Integer.parseInt(word);
            if (year <= 1989){
                flag = true;
            }
        }
        return flag;
    }
}
