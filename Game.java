import java.util.*;

public class Game {
    
    public static class GameResult
    {
        private int roundsPlayed = 0; 
        private int timesUserWon = 0;
        private int timesComputerWon = 0; 
        public GameResult()
        {

        }

        public int getRoundsPlayed()
        {
            return roundsPlayed; 
        }
        
        public void setRoundsPlayed(int totalRoundsPlayed)
        {
            roundsPlayed = totalRoundsPlayed; 
        }

        public int getTimesUserWon()
        {
            return timesUserWon; 
        }

        public void setTimesUserWon(int totalTimesUserWon)
        {
            timesUserWon = totalTimesUserWon;
        }
        
        public int getTimesComputerWon()
        {
            return timesComputerWon;
        }

        public void setTimesComputerWon(int totalTimesComputerWon)
        {
            timesComputerWon = totalTimesComputerWon; 
        }

    }
   

    public static void main(String[] args) {
        System.out.println("During each round, players choose a move, which may be either Skadis, Tjusig, Klyket, Hovolm, or Pershult. The rules are:"

        + "\n Pershult beats Klyket, Skadis" 
        + "\n Klyket beats Tjusig, Hovolm"
        + "\n Tjusig beats Pershult, Skadis"
        + "\n Skadis Beats Hovolm, Klyket"
        + "\n Hovolm beats Pershult, Tjusig"
        + "\n The computer wins in the event of a tie.");
        
        
        GameResult thisGameResult = playerDecison();
        System.out.printf("The number of rounds played was: %d \n", thisGameResult.getRoundsPlayed());
        System.out.printf("The number of times the user won was: %d \n", thisGameResult.getTimesUserWon());
        System.out.printf("The number of times the computer won was: %d \n", thisGameResult.getTimesComputerWon()); 
      
    
    }

    public static GameResult playerDecison()
    {
        GameResult myResult = new GameResult(); 

        Scanner game = new Scanner(System.in);
        

        while(true)
        {
        System.out.print("If you want to play input 'y' else input 'n': ");
        String playerDecision = game.nextLine();

        if(playerDecision.equalsIgnoreCase("y"))
            {
                
                boolean roundResult = roundPlayed(); 
                if (roundResult == true) {
                    System.out.println("The computer won this round.");

                    //Save the number of times computer won
                    int timesComputerWonSoFar = myResult.getTimesComputerWon();
                    myResult.setTimesComputerWon(timesComputerWonSoFar + 1);
                }
                else
                {
                    System.out.println("The user won this round.");

                    //Save the number of times user won
                    int timesUserWonSoFar = myResult.getTimesUserWon();
                    myResult.setTimesUserWon(timesUserWonSoFar + 1);
                }

                //Save the number of rounds played
                int roundsPlayedSoFar = myResult.getRoundsPlayed(); 
                myResult.setRoundsPlayed(roundsPlayedSoFar + 1);
            }
        else if(playerDecision.equalsIgnoreCase("n"))
            {
                System.out.println("Thank you for playing. Here are you results: "); 
                break;
            }
        }
        
        return myResult; 
    }

    // this function returns true if the computer wins and false if user wins
    public static boolean roundPlayed()
    { 
        boolean computerWon = false; 
        
        //calculate user move and computer move
        char user_move = UserMove(); 
        switch(user_move)
        {
            case 'p':
                System.out.println("Your move is Pershult");
                break; 
            
            case 'k':
                System.out.println("Your move is Klyket");
                break; 

            case 't':
                System.out.println("Your move is Tjusig");
                break; 

            case 's':
                System.out.println("Your move is Skadis");
                break; 

            case 'h':
                System.out.println("Your move is Hovolm");
                break; 
        } 

        //get computer move
        char computer_move = ComputerMove(); 
        switch(computer_move)
        {
            case 'p':
                System.out.println("Computer move is Pershult");
                break; 
            
            case 'k':
                System.out.println("Computer move is Klyket");
                break; 

            case 't':
                System.out.println("Computer move is Tjusig");
                break; 

            case 's':
                System.out.println("Computer move is Skadis");
                break; 

            case 'h':
                System.out.println("Computer move is Hovolm");
                break; 
        } 
        computerWon = moveComparision(user_move, computer_move); 
     
       return computerWon; 
    }

    public static char UserMove()
    {
        Scanner move = new Scanner(System.in);
       
        System.out.println("Enter your move (k, s, t, h, p): ");
        String playerMove = move.nextLine();
        char user_move  = playerMove.toLowerCase().charAt(0); 
        if (validMove(user_move)) 
        {
            return user_move; 
        }
        else
        {
            System.out.println("Invalid move. Enter a valid move: ");
            UserMove(); 
        }
        return 'a'; 
    }

    public static char ComputerMove()
    {
        Random compMove = new Random(); 
        List <Character> AllMoves = List.of('k', 's', 't', 'h', 'p');
        int computer_Move = compMove.nextInt(AllMoves.size()); 
        return AllMoves.get(computer_Move); 

    }

    
    public static boolean moveComparision(char userMove, char computerMove)
    {
        boolean computerWins = false;
        
        
        if(userMove == computerMove)
        {
            //in case of tie computer wins
            computerWins = true; 
        }
        else
        {
            //figure out the winner using switch case
            switch (userMove)
            {
                case 's':
                    if (computerMove == 'h' || computerMove == 'k') {
                        
                        computerWins = true; 
                    }
                    else
                    {
                        computerWins = false;
                    }
                    break;
                case 't':
                    if (computerMove == 'p' || computerMove == 's') {
                        computerWins = true; 
                    }
                    else
                    {
                        computerWins = false;
                    }
                    break;
                case 'k':
                    if (computerMove == 't' || computerMove == 'h') {
                        computerWins = true; 
                    }
                    else
                    {
                        computerWins = false; 
                    }
                    break;
                case 'h': 
                    if (computerMove == 'p' || computerMove == 't') {
                        computerWins = true; 
                    }
                    else
                    {
                        computerWins = false; 
                    }
                    break;
                case 'p': 
                    if (computerMove == 'h' || computerMove == 'k') {
                        computerWins = true; 
                    }
                    else
                    {
                        computerWins = false; 
                    }
                    break;
            }
        }
        return computerWins; 
    }
  
    public static boolean validMove(char a)
    {
        if(a == 's' || a == 't' || a == 'k' || a == 'p' || a == 'h')
        {
            return true;
        }
        else
        {
            return false; 
        }
    }
}


