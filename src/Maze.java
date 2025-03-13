import java.util.ArrayList;

public class Maze {
    private int currentPositionX = 0;
    private int currentPositionY = 0;
    private int endPositionX = 0;
    private int endPositionY = 0;
    private String[][] maze;
    ArrayList<String> coordinates = new ArrayList<String>();

    public Maze(String[][] maze){
        endPositionX = maze[0].length-1;
        endPositionY = maze.length-1;
        this.maze = maze;
    }

    public boolean addCoordinate(int x, int y){
        String coordinate = "(" + currentPositionX + "," + currentPositionY + "_";
        if (checkCoordinates(coordinate)){
            return true;
        }
        else {
            coordinates.add(coordinate);
        }
        return false;
    }

    public boolean checkCoordinates(String coordinate){
        for (String s : coordinates) {
            if (s.equals(coordinate)) {
                return true;
            }
        }
        return false;
    }

    public void goUp(){
         while (maze[currentPositionX][currentPositionY+1].equals(".")) {
            currentPositionY = currentPositionY+1;
            if(addCoordinate(currentPositionX,currentPositionY)){
                break;
            }
        }
        checkEnd();
    }

    public void goDown() {
         while (maze[currentPositionX][currentPositionY - 1].equals(".")) {
            currentPositionY = currentPositionY - 1;
             if(addCoordinate(currentPositionX,currentPositionY)){
                 break;
             }
        }
        checkEnd();
    }

    public void goLeft(){
        while (maze[currentPositionX-1][currentPositionY].equals(".")) {
            currentPositionX = currentPositionX-1;
            if(addCoordinate(currentPositionX,currentPositionY)){
                break;
            }
        }
        checkEnd();
    }

    public void goRight(){
        while (maze[currentPositionX+1][currentPositionY].equals(".")) {
            currentPositionX = currentPositionX+1;
            if(addCoordinate(currentPositionX,currentPositionY)){
                break;
            }
        }
        checkEnd();
    }

    public void checkEnd(){
        if (currentPositionX == endPositionX && currentPositionY == endPositionY){
            System.out.println(coordinates);
            System.exit(0);
        }
    }

    // create coordinate
    // current position
    // coordinate list
    // go up
    // go down
    // go left
    // go right
    // check fork
    // check if at end
    // check if at dead end
    // move in one path
    // print list
}
