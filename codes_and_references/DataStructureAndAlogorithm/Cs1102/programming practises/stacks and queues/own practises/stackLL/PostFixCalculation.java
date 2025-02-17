import java.util.*;
import java.lang.*;

class PostFixCalculation{
  public static void main(String[]args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("pleas enter the question");
    String question = scanner.nextLine();
    String postFixQuestion= convertPostFix(question);
    
    StackLL stack = new StackLL();
    for(int i =0; i < postFixQuestion.length(); i++){
      if(postFixQuestion.substring(i,i+1).matches("[+|-|*|/]")){
        int digit1= stack.pop();
        int digit2= stack.pop();
        int digit3= 0;
        
        char ch= postFixQuestion.charAt(i);
        switch(ch){
          case '+': digit3= digit1+digit2;break;
          case '-': digit3= digit2-digit1;break;
          case '*': digit3= digit1*digit2;break;
          case '/': digit3= digit2/digit1;break;
        }
        
        stack.push(digit3);
      }
      else{
        stack.push(Integer.parseInt(postFixQuestion.charAt(i)));
      }
    }
    System.out.println(stack.pop);
  }
  
  public static String convertPostFix(String question){
    StackLL stack = new StackLL();
    
    String answer ="";
    
    for( int i =0; i <question.length(); i++){
      char ch = question.charAr(i);
      if(ch.equals('(')){
        stack.push(ch);
      }
      else if(ch.equals(')')){
        while(!stack.peek().equals('(')){
          answer+=stack.pop();
         }
        stack.pop();
      }
      else if(ch.matches("[*|-|/|+]")){
        
        while(!stack.isEmpty()&&!stack.peek().equals('(')&&precedence(ch)<=precedence(stack.peek())){
          answer+=stack.pop();
        }
        stack.push(ch);
      }
      else{
        answer+=ch;
      }
    }
    while(!stack.isEmpty()){
      answer+=stack.pop();
    }
    return answer;
  }
  
  public static int presendence(char ch){
    switch(ch){
      case '+': return 3;break;
      case '-': return 3;break;
      case '*': return 5;break;
      case '/': return 5;break;
    }
  }
}
              
       
              
              
              
              
              
              
              
              
                   
                   