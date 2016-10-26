import java.util.Random;


public class Jar {
   
   public int getRandomNumber(int maxNumber) {
    Random random = new Random();
    int someNumber = random.nextInt(maxNumber)+1;
    // Some number will be between 0 and 19
    return someNumber;
  }
  
   public boolean guess(int number, int answerNumber, int maxNumber) {
     boolean check=false;
     
     if(number > maxNumber) {
       throw new IllegalArgumentException("Your guess must be less than maximum fill amount.");
     }
     
     if(number < answerNumber) {
       throw new IllegalArgumentException("Your guess is too low.");
      }
       
     if(number > answerNumber) {
       throw new IllegalArgumentException("Your guess is too high.");
       }
     
    if(number == answerNumber){
       check = true;
     } 
     return check;
   }
  
     public void guessOverMax(int number, int maxNumber) {
          
     if(number > maxNumber) {
       throw new IllegalArgumentException("Your guess must be less than maximum fill amount.");
     }
    }

}