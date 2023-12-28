package processor.impl;

import processor.BatchProcessing;

import javax.swing.*;
import java.io.*;


public class ManProcessor1 implements BatchProcessing {
   private JTextArea resultTxt;
   private BufferedReader input = null;
   private BufferedWriter output1 = null;
   private BufferedWriter output2 = null;
   //String file = "UpdatedFiles/Man18-.txt";

   public ManProcessor1(String inFile, String outFile1, String outFile2, JTextArea resultTxtA)throws IOException{
      input = new BufferedReader(new FileReader(inFile));
	  output1 = new BufferedWriter(new FileWriter(outFile1));
	  output2 = new BufferedWriter(new FileWriter(outFile2));
	  resultTxt=resultTxtA;
   }

   /*---------------------------------------------------------------------*/
   /* This method simply reads input file (Man) line by line, and  */
   /* write each line read to one of the two output files, one is
   /* a file containing men whose ages are below 18, and the other
   /* is a file containing men whose ages are above 18. the data
   /* will not be accumulated in this class. Once a line is read,
   /* it is written immedietely to an output file                      */
   /*------------------------------------------------------------------*/
   public void processData(){
//	  resultTxt.setText("25 < Women < 18 have been dropped.\n");
//	  resultTxt.append("Men < 18 have been dropped.\n\n");
       try{
           String line = input.readLine();
           while(line != null){ //not end of file
               String[] words = line.split("\\s");

               if (isAMan(words) && isYoungerThan18 (words)){
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
           System.err.println("Error: failed Man processor 1");
           System.exit(1);
       }
   }


    private boolean isAMan(String[] words){
        boolean flag = false;
        for(int k=0; k< words.length; k++){  //One line
            if( words[k].compareTo("male")==0 ){
                flag = true;
                break;
            }
        }
        return flag;
    }

    private boolean isYoungerThan18 (String[] words)   {
        boolean flag = false;
        for(int k=0; k< words.length; k++){  //One line
            if(words[k].length() == 10){
                flag = isYoungerThan18 (words[k]);
            }
        }
        return flag;
    }
    private boolean isYoungerThan18 (String word)   {
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
            if (year > 1996){
                flag = true;
            }
        }
        return flag;
    }
}


