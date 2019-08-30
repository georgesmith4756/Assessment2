import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Board game = new Board();
		Movement mv = new Movement();
		
		int [][] playerLoc = new int[0][1]; 
		int [][] treasureLoc = new int[0][1]; 
		int boardSize =0;
		
		int difficulty = 0;
		int maxTurns = 0;
		int turns = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to The Infinite Tesselating Swamp, you have been dropped into the middle of ");
		System.out.println("an infinite grey swamp and must find your way to the treasure hid within it");
		System.out.println("You possess a compass which will advise you of how far you are from ");
		System.out.println("the treasure and must choose which direction to travel in to find it, good luck.");
		System.out.println("");
		//Determine size of board from user
		
	
		System.out.println("Firstly, how big would you like your board? (numbers only)");
		boardSize = sc.nextInt();
		
		
		System.out.println("What Difficulty would you like to play (1 = easy, 2 = medium, 3 = hard)");
		difficulty = sc.nextInt();
		
		//switch between difficulty choices
		switch(difficulty) {
			case 1:
			maxTurns = boardSize * 10;
			break;
			case 2:
			maxTurns = boardSize * 2;	
			break;
			case 3:
			maxTurns = boardSize;
			break;
		}
		
		treasureLoc = game.createTreasure(boardSize);
		playerLoc = game.createPlayer(boardSize);
		
		while((playerLoc[0][0] == treasureLoc [0][0]) == true && (playerLoc[0][1] == treasureLoc[0][1]) == true) {
			playerLoc = game.createPlayer(boardSize);
		}
		
		game.updateBoard(boardSize, playerLoc);
		
		while(((playerLoc[0][0] == treasureLoc[0][0]) == false || (playerLoc[0][1] == treasureLoc[0][1]) == false) && turns < maxTurns) {
			System.out.println("You failed to find the treasure there, you have " + (maxTurns - turns) + " more tries to");
			System.out.println("find it before you are lost to the swamp");
			playerLoc = mv.movePlayer(boardSize, playerLoc,treasureLoc);
			turns++;
			
		}
		
		if((playerLoc[0][0] == treasureLoc [0][0]) == true && (playerLoc[0][1] == treasureLoc[0][1]) == true) {
			System.out.println("You found the treasure, Congratulations");
		}else {
			System.out.println("You ran out of turns, game over");
		}
		
	}
}
