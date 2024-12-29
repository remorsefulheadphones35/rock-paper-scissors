import java.util.Random; 
import java.util.Scanner; 

class RockPaperScissors{
    
    //method that takes in the choices that the computer has and returns a random choice from the array choices
    public static String computersTurn(int number){
          String[] choices = {"Rock", "Paper", "Scissors"};
          String move = choices[number]; 
          return move; 
     }
     //prints the different moves that the computer is capable of doing
     public static void printChoices(){
          String[] choices = {"Rock", "Paper", "Scissors"};
          for(int i = 0; i < choices.length; i++){
               System.out.println(choices[i]); 
          }
     }

    public static void main(String[] args) {
        //creation of scanner and random number objects
        Scanner scan = new Scanner(System.in); 
        Random rng = new Random(); 
        
        //stores the wins for the computer and player
        int playerWins = 0;
        int computerWins = 0;   

        //boolean value that controls whether the game loop starts or not
        boolean startGame = true; 
        
        System.out.println("Welcome to Rock, Paper, Scissors!");
        while(startGame == true){ //while loop controlling the game 
               
        	   int random = 0 + rng.nextInt(3); //random number generator from 0-2 for the method computersTurn
               System.out.print("Pick rock, paper, or scissors: "); 
               String playerChoice = scan.next(); // player picking between rock, paper or scissors
               // simple error checking to make the player only chooses the Strings rock, paper, or scissors
               if(!playerChoice.equalsIgnoreCase("rock") && !playerChoice.equalsIgnoreCase("paper") && !playerChoice.equalsIgnoreCase("scissors")){
                    System.out.println("Error, please pick rock, paper or scissors"); 
               }
               else{ //rest of the game loop while the user input matches rock, paper, or scissors
                     String computerChoice = computersTurn(random); //random number being passed to the method computersTurn and picking a random choice from the array choices
                     System.out.println(); 
                     printChoices(); //calling the method printChoices to list the possible moves of the computer
                     System.out.println("The computer throws: "+ computerChoice); 
               //conditional statements handling the outcome of the computer vs the player's choice
               if(playerChoice.equalsIgnoreCase(computerChoice)){ //if both outcomes are the same it is a tie no points awarded
                    System.out.println("Tie, no points awarded"); 
               }
               if(playerChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors")){ //if the player picks rock and the computer picks scissors, the player wins
                    System.out.println("Rock beats Scissors");
                    System.out.println("Player Wins");
                    playerWins++;  //adding a point to the player's score
               }
               if(playerChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock")){ //if the player picks paper and the computer picks rock, the player wins
                    System.out.println("Paper beats Rock");
                    System.out.println("Player Wins");
                    playerWins++;  //adding a point to the player's score
               }
               if(playerChoice.equalsIgnoreCase("Scissors") && computerChoice.equalsIgnoreCase("Paper")){ //if the player picks Scissors and the computer picks Paper, pthe layer wins
                    System.out.println("Scissors beats paper");
                    System.out.println("Player Wins");
                    playerWins++; //adding a point to the player's score
                    
               }
               if(computerChoice.equalsIgnoreCase("Rock") && playerChoice.equalsIgnoreCase("Scissors")){ //if the computer picks Scissors and the computer picks Scissors, the computer wins
                    System.out.println("Rock beats Scissors");
                    System.out.println("Computer Wins");
                    computerWins++;  //adding a point to the computers's score
               }
               if(computerChoice.equalsIgnoreCase("Paper") && playerChoice.equalsIgnoreCase("Rock")){ //if the computer picks Paper and the computer picks Rock, the computer wins
                    System.out.println("Paper beats Rock");
                    System.out.println("Computer Wins");
                    computerWins++;  //adding a point to the computers's score
               }
               if(computerChoice.equalsIgnoreCase("Scissors") && playerChoice.equalsIgnoreCase("Paper")){ //if the computer picks Scissors and the computer picks paper, the computer wins
                    System.out.println("Scissors beats paper");
                    System.out.println("Computer Wins");
                    computerWins++; //adding a point to the computers's score
               }
               
               //printing the current player and computer scores after a round has ended
               System.out.println();
               System.out.println("Player wins: " + playerWins);
               System.out.println("Computer wins: " + computerWins);

               if(playerWins == 6){ //handling the outcome of a win for the player
                    System.out.println("The player has won");
                    startGame = false; 
                    System.out.print("Play again? Y/N: "); //starting the game again
                     String playAgain = scan.next(); 
                    if(playAgain.equalsIgnoreCase("y")){
                        startGame = true;
                        computerWins = 0; //reseting computer's score
                        playerWins = 0;   //reseting player's score
                    }
                    if(playAgain.equalsIgnoreCase("n")){ //ending the game and terminating the program
                        System.out.println("Thanks for playing!");
                        startGame = false; //disabling game loop
                        scan.close(); //closing scanner
                    }
               }
               if(computerWins == 6){ //handling the outcome of the computer winning 
                    System.out.println("The Computer has won");
                    startGame = false; 
                    System.out.print("Play again? Y/N: ");
                    String playAgain = scan.next(); 
                    if(playAgain.equalsIgnoreCase("y")){ //starting the game again
                        startGame = true; //starting game loop again
                        computerWins = 0; //reseting computer's score
                        playerWins = 0;   //reseting player's score
                    }
                    if(playAgain.equalsIgnoreCase("n")){ //ending the game and terminating the program
                        System.out.println("Thanks for playing!");
                        startGame = false; //disabling game loop
                        scan.close(); //closing scanner
                    }
               }
            }
              
        }
        
    }
}