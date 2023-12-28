package top.malchinee;
/*---------------------------------------------------------*/
/* This adapter class extends InfoValidation and           */
/* implements CusInfoValidator, and so the first           */
/* 4 functionalities listed in class CusInfoValidator      */
/* are automatically inherited from class InfoValidation,  */
/* and in this addapter class, isValidSSNNum(String SSNNum)*/
/* is emplemented.                                         */
/*---------------------------------------------------------*/


import java.util.regex.Pattern;

class InformationAdapter extends InfoValidation implements CusInfoValidator{

    /*------------------------------------------*/
	/* The Social Security number is a 9-digit  */
	/* number in the format "AAA-GG-SSSS".      */
	/*------------------------------------------*/
	public boolean isValidSSNNum(String SSNNum){
	   boolean isValid=true;
	   if(SSNNum.length() == 0){
		      isValid = false;
		      System.out.println("Empty string ***");
	   }
	   else{
			   String ns = SSNNum.trim();
			   String nStr = ns.replaceAll("\\s{1,}", "");
			   int len = nStr.length();

			   if ( (len==11) && (nStr.charAt(3) == '-') && (nStr.charAt(6) == '-')  ) {
				  for(int m=0; m<len; m++){
					    if(  (m != 3) && (m !=6) && ( Character.isDigit(nStr.charAt(m))==false) ){
					    	isValid=false;
					    }
				  }
			   }
			   else{
				  isValid=false;
			   }
	   }
	   return  isValid;
    }

	@Override
	public boolean isValidEmailAddr(String email) {
		if (email == null || email.isEmpty()) {
			return false;
		}
		if (email.length() < 5) {
			return false;
		}
		String pattern = "^[A-Za-z][A-Za-z0-9]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
		return Pattern.matches(pattern, email);
	}
}


