import java.util.Scanner;

public class Board {
	
	public void createBoard(int boardSize) {
	

	String grid [][] = new String[boardSize][boardSize]; 
				
	//Map columns
	System.out.print("  ");
    for(int i = 0; i < boardSize; i++)
            System.out.print(i);
    System.out.println();

    //Middle of swamp map
    for(int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            grid[i][j] = "-";
            if (j == 0)
                System.out.print(i + "|" + grid[i][j]);
            else if (j == grid[i].length - 1)
                System.out.print(grid[i][j] + "|" + i);
            else
                System.out.print(grid[i][j]);
        }
        System.out.println();
    }

    //Map rows
    System.out.print("  ");
    for(int i = 0; i < boardSize; i++)
        System.out.print(i);
    System.out.println();
	}
	
	public int[][] createTreasure(int size) {
		int x = (int) (Math.random() * size);
		int y = (int) (Math.random() * size);
		
		int [][] location = {{x,y}};
		
		return location;
		
	}
	
	public int[][] createPlayer(int size) {
		int x = (int) (Math.random() * size);
		int y = (int) (Math.random() * size);
		
		int [][] location = {{x,y}};
		
		return location;
	}
	
	public void updateBoard(int boardSize, int[][] newLoc) {
		

		String grid [][] = new String[boardSize][boardSize]; 
					
		//Map columns
		System.out.print("  ");
	    for(int i = 0; i < boardSize; i++)
	            System.out.print(i);
	    System.out.println();

	    //Middle of swamp map
	    for(int i = 0; i < grid.length; i++) {
	        for (int j = 0; j < grid[i].length; j++) {
	            grid[i][j] = "-";
	            
	            if(i == newLoc[0][1] & j == newLoc[0][0]) {
	            	System.out.print("X");
	            }
	            else if (j == 0) {
	                System.out.print(i + "|" + grid[i][j]);}
	            else if (j == grid[i].length - 1) {
	                System.out.print(grid[i][j] + "|" + i);
	            }else {
	                System.out.print(grid[i][j]);}
	        }
	        System.out.println();
	    }

	    //Map rows
	    System.out.print("  ");
	    for(int i = 0; i < boardSize; i++)
	        System.out.print(i);
	    System.out.println();
	    
	 
	}
}
