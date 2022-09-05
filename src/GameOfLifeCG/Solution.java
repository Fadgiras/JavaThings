import java.util.*;

class Solution {

    public int width;

    public static String cellSet(boolean state, String[][] Grid, int x, int y){
        return state ? Grid[x][y] = "1" : (Grid[x][y] = "0");
    }

    public static boolean isAlive(String cell){
        return Integer.parseInt(cell)==1 ? true : false;  
    }

    private static List<String> getNeighbours(int x, int y, int Xmax, int Ymax) {
        List<String> neighbors = new ArrayList<String>();
        int currentX, currentY;
        for (int xx = -1; xx <= 1; xx++) {
            for (int yy = -1; yy <= 1; yy++) {
                // You are not neighbor to yourself
                if (xx == 0 && yy == 0) {
                    continue; 
                }
                if (withinGrid(x + xx, y + yy, Xmax, Ymax)) {
                    //need thoses 2 vars to fix String confusion problem
                    currentX=x+xx;
                    currentY=y+yy;
                    neighbors.add(currentX+";"+currentY);
                }
            }
        }
        return neighbors;
    }

    static boolean withinGrid(int colNum, int rowNum, int Xmax, int Ymax) {
        if((colNum < 0) || (rowNum <0) ) {
            return false;    //false if row or col are negative
        }
        if((colNum >= Xmax) || (rowNum >= Ymax)) {
            return false;    //false if row or col are above max defined
        }
        return true;
    }

	public static void main(String args[]) {
        String line = new String();
        List<String> currentNeighbours;
        try (Scanner in = new Scanner(System.in)) {
			int width = in.nextInt();
			int height = in.nextInt();
			String[] grid = new String[height];

			for (int i = 0; i < height; i++) {
			    line = in.next();
			    grid[i]=line;
			}

			String[][] gameGrid = new String[width][height];
            String[][] gameGridRes = new String[width][height];
            String[][] gameGridAnswer = new String[width][height];

			//filling the grid
			for (int y = 0; y < height; y++) {
			    for (int x = 0; x < width; x++) {
			        // Regex splits the string into an array of single character Strings
			        // ex : "cat".split -> "c","a","t"
			        gameGrid[x][y] = grid[y].split("(?!^)")[x];
			    }
			}

			//Finding the neighbours of given cell
			//First, need to check if current cell is alive, if not skip it for now

			for(int i2 = 0; i2<height; i2++){
			    for(int j = 0; j<width; j++){
			        if(isAlive(gameGrid[j][i2])){
                        currentNeighbours = getNeighbours(j,i2, width, height);
                        int HP=0;
                        boolean stillAlive = false;
                        //need to analyze each neighbour to add an HP if alive
                        for(String neighbour : currentNeighbours){
                            neighbour.split(";");
                            int currentX = Integer.parseInt(neighbour.split(";")[0]);
                            int currentY = Integer.parseInt(neighbour.split(";")[1]);
                            if(isAlive(gameGrid[currentX][currentY])){
                                HP++;
                            }
                        }

                        // verify HP condition
                        if(HP==2||HP==3){
                            stillAlive=true;
                        }
                        cellSet(stillAlive,gameGridRes,j,i2);
			        }

                    //Analyzing once again, for the dead cells this time
                    if(!isAlive(gameGrid[j][i2])){
                        currentNeighbours = getNeighbours(j,i2, width, height);
                        int HP=0;
                        boolean resurrected = false;
                        //need to analyze each neighbour to add an HP if neighbour alive
                        for(String neighbour : currentNeighbours){
                            neighbour.split(";");
                            int currentX = Integer.parseInt(neighbour.split(";")[0]);
                            int currentY = Integer.parseInt(neighbour.split(";")[1]);
                            if(isAlive(gameGrid[currentX][currentY])){
                                HP++;
                            }
                        }

                        // verify HP condition
                        if(HP==3){
                            resurrected=true;
                        }
                        cellSet(resurrected,gameGridRes,j,i2);
                    }
			    	}
			}

            for(int y = 0; y<height; y++){
                String buffer = new String("");
                for(int x = 0; x<width; x++){
                    buffer += gameGridRes[x][y];
                }
                gameGridAnswer[0][y]= buffer;
            }

            //Answer
            for(int i = 0; i<height; i++){
                System.out.println(gameGridAnswer[0][i]);
            }
				}
    }
}
