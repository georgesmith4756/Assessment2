import java.util.Scanner;

public class Movement {

	public int[][] movePlayer(int boardSize, int[][] playerLoc, int [][] treasureLoc) {
		
		Scanner sc = new Scanner(System.in);
		String choice = "";
		Board game = new Board();
		
		
		System.out.println("Which direction would you like to move? (N,E,S,W)");
		choice = sc.nextLine().toLowerCase();
		
		//switch between possible user inputs
		switch(choice) {
		case "n":
			playerLoc[0][1] = playerLoc[0][1] - 1;
			if(playerLoc[0][1] == -1) {
				playerLoc[0][1] = boardSize - 1;
			}
			break;
		case "e":
			playerLoc[0][0] = playerLoc[0][0] + 1;
			break;
		case "s":
			playerLoc[0][1] = playerLoc[0][1] + 1;
			if(playerLoc[0][1] == boardSize) {
				playerLoc[0][1] = 0;
			}
			break;
		case "w":
			playerLoc[0][0] = playerLoc[0][0] - 1;
			break;
		}
	
		
		game.updateBoard(boardSize, playerLoc);
		System.out.println("Distance from treasure: " + calculateDistance(playerLoc, treasureLoc));
		return playerLoc;
		
	}
	
	public float calculateDistance(int[][] playerLoc, int[][] treasureLoc) {
		
		
		float xDistance = playerLoc[0][0] - treasureLoc[0][0];
		float yDistance = playerLoc[0][1] - treasureLoc[0][1];
		
		if(xDistance < 0) {
			xDistance = -1 * xDistance;
		}
		if(yDistance < 0) {
			yDistance = -1 * yDistance;
		}
		
	
		return (float) Math.sqrt((xDistance*xDistance) + (yDistance*yDistance));
	}
}
