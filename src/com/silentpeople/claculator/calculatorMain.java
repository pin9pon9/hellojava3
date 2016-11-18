package com.silentpeople.claculator;

import java.security.acl.LastOwnerException;
import java.util.Scanner;
public class calculatorMain {
	
	   public static String inputValCheck (String inputVal) { 
		    inputVal = inputVal.replace(" ", "");
		    return inputVal; // 리턴하는 자료의 형이 String 이기때문에 맞춰줘야함 public static void > public static String
	        }// 공백제거 외에 다른 것들도 기능을추가해보기
	   public static boolean statrWithNotNumeric (String inputVal) {
		   boolean a1 = inputVal.startsWith("-"); //숫자가아닌 기호로 시작하는애들 다 확인해서 true로 반환해주기 해보자
		   return a1; //a1을 반환해줌 
	   }
	   public static String [] splitWithSign(String inputVal) {
		   String [] a2 = inputVal.split("[\\+\\-\\*\\/\\=]");
		   return a2;
	   }
	   public static  int [] StringArrToInteArr (String [] splitValues) {
		   int [] num = new int[10]; //10개를 만들어라 
		   for(int cnt=0; cnt < splitValues.length; cnt++) {
	            try{
	            	num[cnt] = Integer.parseInt(splitValues[cnt]);
	            	//System.out.println(num[cnt]);
	            }catch(java.lang.NumberFormatException e){
	            	System.out.println("입력범위 초과: -2147483648~2147483647");
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
	            System.out.println("0으로 나누기는 불가능합니다. 다시 입력해주세요!!");
	            return true;  // 0으로 나누는 상황이면 true 아니면 false
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
         
         //입력값 검증 코드  
         inputVal =inputValCheck(inputVal);  // 공백제거
         // inputValCheck 메소드 호출을 하였고 inputVal 인자를 써서 처리하라고 함 근데 inputVal 의 종류가 String 이기때문에 위에도 맞춰줘야함
                 
         if (statrWithNotNumeric(inputVal)) { //숫자가 아닌 기호로 시작하면 true를 반환하는 메소드
       	 System.out.println("첫 입력 수는 음수를 지원하지 않습니다."); // - 말고 다른 특수기호들도 왔을때 경고해주기
       	 continue; 
         }
         //System.out.println(inputVal);
          
         String [] splitValues = splitWithSign(inputVal);         
        // System.out.println(splitValues.length);
         
        /* for(int cnt=0; cnt<splitValues.length;cnt++) { 
            System.out.println(splitValues[cnt]);
         }      */   
         
         //int [] num = new int[splitValues.length]; 길게 쓸필요가없이 바로 넣어줘도됨↓
         //문자열 배열을 정수 배열로 바꾸는 코드블럭 ↓
         int [] num = StringArrToInteArr(splitValues);
         
        /* for(int cnt=0; cnt<splitValues.length;cnt++){
            try{
               num[cnt] = Integer.parseInt(splitValues[cnt]);
               //System.out.println(num[cnt]);
            }catch(java.lang.NumberFormatException e){
               System.out.println("입력범위 초과: -2147483648~2147483647");
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
         }*/ //연산기호를 추출하는 코드 ↑↓
         char sign = PopSign(inputVal);
         
       /*  if(num[1] == 0 && sign == '/') {
            System.out.println("0으로 나누기는 불가능합니다. 다시 입력해주세요!!");
            continue;
         }*/
         // 0으로 나누기를 방지하기위한 코드 방지를하고 다시 입력하게 해줌 ↑↓
         if(blockDivideByZero(num[1], sign)) continue; // 하나만 지정할때는 블록을 쓰지 않아도된다. 
       /*  if(blockDivideByZero(num[1], sign)) {  ↑위의 코드와 동일
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
         }//+ - * / 를 처리해주는 코딩
         
         
         System.out.println("yes or no");
         inputVal = scan.nextLine();
			switch (inputVal) { // switch(문자열) >> 문자열 X 안됨원래 >> 업데이트되면서 쓸수있었으나 안될때도있다
				case "y":  case "Y":
					yesno = true;
					continue; //아래에 break; 를 주면 Unreachable code 에러가나옴 도달할수없다 컨티뉴를 썼기때문에 즉 while 문 안에있기때문에 밑으로 올수가없다
					//break; 혹시모르니 주석처리는해줌
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
      }while(yesno); //스위치문 안에 yesno 변수를넣어주면 while문에서 작동 안함 scope 발생
      System.out.println("종료되었습니다.");
      
   }   
   
  
}
