package com.silentpeople.claculator;

import java.security.acl.LastOwnerException;
import java.util.Scanner;
public class calculatorMain {
	
	   public static String inputValCheck (String inputVal) { 
		    inputVal = inputVal.replace(" ", "");
		    return inputVal; // �����ϴ� �ڷ��� ���� String �̱⶧���� ��������� public static void > public static String
	        }// �������� �ܿ� �ٸ� �͵鵵 ������߰��غ���
	   public static boolean statrWithNotNumeric (String inputVal) {
		   boolean a1 = inputVal.startsWith("-"); //���ڰ��ƴ� ��ȣ�� �����ϴ¾ֵ� �� Ȯ���ؼ� true�� ��ȯ���ֱ� �غ���
		   return a1; //a1�� ��ȯ���� 
	   }
	   public static String [] splitWithSign(String inputVal) {
		   String [] a2 = inputVal.split("[\\+\\-\\*\\/\\=]");
		   return a2;
	   }
	   public static  int [] StringArrToInteArr (String [] splitValues) {
		   int [] num = new int[10]; //10���� ������ 
		   for(int cnt=0; cnt < splitValues.length; cnt++) {
	            try{
	            	num[cnt] = Integer.parseInt(splitValues[cnt]);
	            	//System.out.println(num[cnt]);
	            }catch(java.lang.NumberFormatException e){
	            	System.out.println("�Է¹��� �ʰ�: -2147483648~2147483647");
	            }
	       } 
		   return num;
	   }
	   public static char PopSign(String inputVal) {
		   String [] signArray = {"+", "-","*","/"};
	         char sign = '+';
	         for(int cnt=0;cnt<signArray.length;cnt++){
	            int signOrder = inputVal.indexOf(signArray[cnt]);
	            if(signOrder < 0){
	               continue;
	            }
	            sign = inputVal.charAt(signOrder);
	         }
	         return sign ;
	   }
	   public static boolean blockDivideByZero(int num, char sign ) {
		   if(num == 0 && sign == '/') {
	            System.out.println("0���� ������� �Ұ����մϴ�. �ٽ� �Է����ּ���!!");
	            return true;  // 0���� ������ ��Ȳ�̸� true �ƴϸ� false
		   }
		   else {
			   return false;
		   }
	   }
	  /* public static void lastVal(int [] num, char sign) {
		   long result=0;
	       double result2=0.0;
	       switch(sign){
	       	case '+':
	            result = (long)num[0]+(long)num[1];
	            System.out.println(result);
	            //return true;   
	         case '-':
	            result = (long)num[0]-(long)num[1];
	            System.out.println(result);
	            // return true;
	         case '*':
	            result = (long)num[0]*(long)num[1];
	            System.out.println(result);
	            // return true;
	         case '/':
	            result2 = (double)num[0] / (double)num[1];
	            System.out.println(result2);
	            // return true;
	         default:
	            break;
	         }
	}*/
   public static void main(String [] args ) {
	   
      String inputVal;
      //String YesOrNo;
      boolean yesno = true;
      
      do{
         System.out.println("Input:");
         Scanner scan = new Scanner(System.in);
         inputVal = scan.nextLine();
         
         //�Է°� ���� �ڵ�  
         inputVal =inputValCheck(inputVal);  // ��������
         // inputValCheck �޼ҵ� ȣ���� �Ͽ��� inputVal ���ڸ� �Ἥ ó���϶�� �� �ٵ� inputVal �� ������ String �̱⶧���� ������ ���������
                 
         if (statrWithNotNumeric(inputVal)) { //���ڰ� �ƴ� ��ȣ�� �����ϸ� true�� ��ȯ�ϴ� �޼ҵ�
       	 System.out.println("ù �Է� ���� ������ �������� �ʽ��ϴ�."); // - ���� �ٸ� Ư����ȣ�鵵 ������ ������ֱ�
       	 continue; 
         }
         //System.out.println(inputVal);
          
         String [] splitValues = splitWithSign(inputVal);         
        // System.out.println(splitValues.length);
         
        /* for(int cnt=0; cnt<splitValues.length;cnt++) { 
            System.out.println(splitValues[cnt]);
         }      */   
         
         //int [] num = new int[splitValues.length]; ��� ���ʿ䰡���� �ٷ� �־��൵�ʡ�
         //���ڿ� �迭�� ���� �迭�� �ٲٴ� �ڵ�� ��
         int [] num = StringArrToInteArr(splitValues);
         
        /* for(int cnt=0; cnt<splitValues.length;cnt++){
            try{
               num[cnt] = Integer.parseInt(splitValues[cnt]);
               //System.out.println(num[cnt]);
            }catch(java.lang.NumberFormatException e){
               System.out.println("�Է¹��� �ʰ�: -2147483648~2147483647");
            }
         }*/
         
         //System.out.println(num[0]);
         
         /*String [] signArray = {"+", "-","*","/"};
         char sign = '+';
         for(int cnt=0;cnt<signArray.length;cnt++){
            int signOrder = inputVal.indexOf(signArray[cnt]);
            if(signOrder < 0){
               continue;
            }
            //System.out.println(signOrder);
            sign = inputVal.charAt(signOrder);
            //System.out.println(sign);
         }*/ //�����ȣ�� �����ϴ� �ڵ� ���
         char sign = PopSign(inputVal);
         
       /*  if(num[1] == 0 && sign == '/') {
            System.out.println("0���� ������� �Ұ����մϴ�. �ٽ� �Է����ּ���!!");
            continue;
         }*/
         // 0���� �����⸦ �����ϱ����� �ڵ� �������ϰ� �ٽ� �Է��ϰ� ���� ���
         if(blockDivideByZero(num[1], sign)) continue; // �ϳ��� �����Ҷ��� ����� ���� �ʾƵ��ȴ�. 
       /*  if(blockDivideByZero(num[1], sign)) {  ������ �ڵ�� ����
        	 continue;
         }*/
         
                     
         long result=0;
         double result2=0.0;
         switch(sign){
         case '+':
            result = (long)num[0]+(long)num[1];
            System.out.println(result);
            break;
         case '-':
            result = (long)num[0]-(long)num[1];
            System.out.println(result);
            break;
         case '*':
            result = (long)num[0]*(long)num[1];
            System.out.println(result);
         case '/':
            result2 = (double)num[0] / (double)num[1];
            System.out.println(result2);
            break; 
         default:
            break;
         }//+ - * / �� ó�����ִ� �ڵ�
         
         
         System.out.println("yes or no");
         inputVal = scan.nextLine();
			switch (inputVal) { // switch(���ڿ�) >> ���ڿ� X �ȵʿ��� >> ������Ʈ�Ǹ鼭 �����־����� �ȵɶ����ִ�
				case "y":  case "Y":
					yesno = true;
					continue; //�Ʒ��� break; �� �ָ� Unreachable code ���������� �����Ҽ����� ��Ƽ���� ��⶧���� �� while �� �ȿ��ֱ⶧���� ������ �ü�������
					//break; Ȥ�ø𸣴� �ּ�ó��������
				case "n": case "N":
					yesno = false;
					break;
			/*	/case "Y":
					yesno = true;
					continue;
					//break;
				case "N":
					yesno = false;
					break;*/
				default:
					break;
			}
      }while(yesno); //����ġ�� �ȿ� yesno �������־��ָ� while������ �۵� ���� scope �߻�
      System.out.println("����Ǿ����ϴ�.");
      
   }   
   
  
}
