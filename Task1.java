

import java.util.Scanner;
import java.util.Random;

public class Task1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int  maximumAttempts = 5;
		int totalRounds = 0;
		int roundsWon = 0;
		
		boolean playAgain = false;
		do {
			
			totalRounds++;
			int numberToguess = random.nextInt(50)+1;
			int attemptsLeft = maximumAttempts;
			boolean correctGuessed = false;
			
			System.out.println("\n Rounds " + totalRounds + ": Guess the number between 1 to 50");
			
			while(attemptsLeft > 0) {
				
				System.out.print("Enter your guess (" + attemptsLeft + " attempts left): ");
				int guess = sc.nextInt();
				attemptsLeft--;
			
			if(guess == numberToguess) {
				System.out.println(" Correct! You guessed the number.");
				correctGuessed = true;
				roundsWon++;
				
			}else if(guess < numberToguess){
				System.out.println("You are close But Too Low!");
				
			}else {
				System.out.println("You are close But Too High!");
			}
			}
			
			if (!correctGuessed) {
                System.out.println("Out of attempts, The number was: " + correctGuessed);
            }
			
			System.out.print("Do you want to play another round?  ");
            sc.nextLine(); 
            String answer = sc.nextLine().trim().toLowerCase();
            playAgain = answer.equals("yes") || answer.equals("y");

			
			
		}while(playAgain);
		
		System.out.println("\n Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Your Score: " + (roundsWon * 10) + " points");
        sc.close();
	}

}
