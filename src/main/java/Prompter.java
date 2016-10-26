import java.io.Console;
import java.util.Scanner;

public class Prompter {

  private String mTypeOfItem;
  private int mMaxNumber;
  private int mAnswer;
  
  Console console = System.console();
  Jar jar = new Jar();
  
  public void start() {
   System.out.printf("=========\n*Setting*\n=========\n");
   mTypeOfItem = console.readLine("Enter the type of item:  ");
   mMaxNumber = Integer.parseInt(console.readLine("Enter maximum number of items:  "));
   mAnswer = promptRandomNumber();
   
   promptGuessNumber();

  }
  
  public int promptRandomNumber() {
      return jar.getRandomNumber(mMaxNumber);
  }
  
  public void promptGuessNumber() {
    Scanner scanner = new Scanner(System.in);
    boolean checkSolved = false;
    int numberOfTries = 0;
    int attempts = 0;
    
      System.out.printf("\n========\n*Player*\n========\n");
      System.out.printf("How many %ss in the jar?\n\n", mTypeOfItem);
    
    while(!checkSolved) {
      
      System.out.printf("Guess [1~%d]:  ",mMaxNumber);

      int guessedNumber = scanner.nextInt();

      try{
      
      jar.guessOverMax(guessedNumber, mMaxNumber);
      attempts ++;
      checkSolved = jar.guess(guessedNumber, mAnswer, mMaxNumber);
      
      } catch(IllegalArgumentException iae) {
        console.printf("%s Please try agian.\n", iae.getMessage()); 
        }
    }

      if(checkSolved){
      System.out.printf("Congratulation!! You got it in %s attempt(s).\n", attempts);
      }
  }

}