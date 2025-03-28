import java.util.ArrayList;
import java.util.HashSet;

public class Maze {
    private int currentPositionX = 0;
    private int currentPositionY = 0;
    private int endPositionX;
    private int endPositionY;
    private int previousCoordinateX;
    private int previousCoordinateY;
    private String[][] maze;
    ArrayList<String> coordinates = new ArrayList<String>();
    private HashSet<String> visited = new HashSet<String>();

    public Maze(String[][] maze){
        endPositionX = maze[0].length-1;
        endPositionY = maze.length-1;
        this.maze = maze;
    }

    public void testMaze(){
        for (String[] r: maze){
            for (String c : r) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void addCoordinate(int x, int y){
        String coordinate = "(" + y + "," + x + ")";
        coordinates.add(coordinate);
    }


    public boolean checkPast(){
        String currentCoordinate = "(" + currentPositionY + "," + currentPositionX + ")";
        return !visited.contains(currentCoordinate);
    }

    public boolean isVisited(int x, int y) {
        String coordinate = "(" + y + "," + x + ")";
        return visited.contains(coordinate);
    }

    public void markVisited(int x, int y) {
        String coordinate = "(" + y + "," + x + ")";
        visited.add(coordinate);
    }

    public boolean goDown(){
        try {
            if (maze[currentPositionY + 1][currentPositionX].equals(".") && !isVisited(currentPositionX, currentPositionY + 1)) {
                currentPositionY = currentPositionY + 1;
                addCoordinate(currentPositionX, currentPositionY);
                markVisited(currentPositionX, currentPositionY);
                return true;
            }
        }
        catch (Exception e){
            return false;
        }
        return false;
    }

    public boolean goUp() {
        try {
            if (maze[currentPositionY - 1][currentPositionX].equals(".") && !isVisited(currentPositionX, currentPositionY - 1)) {
                currentPositionY = currentPositionY - 1;
                addCoordinate(currentPositionX, currentPositionY);
                markVisited(currentPositionX, currentPositionY);
                return true;
            }
        }
        catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean goLeft(){
        try {
            if (maze[currentPositionY][currentPositionX - 1].equals(".") && !isVisited(currentPositionX - 1, currentPositionY)) {
                currentPositionX = currentPositionX - 1;
                addCoordinate(currentPositionX, currentPositionY);
                markVisited(currentPositionX, currentPositionY);
                return true;
            }
        }
        catch (Exception e){
            return false;
        }
        return false;
    }

    public boolean goRight(){
    try {
        if (maze[currentPositionY][currentPositionX + 1].equals(".") && !isVisited(currentPositionX + 1, currentPositionY)) {
            currentPositionX = currentPositionX + 1; 
            addCoordinate(currentPositionX, currentPositionY); 
            markVisited(currentPositionX, currentPositionY); 
            return true; 
        }
    }
    catch (Exception e) {
        return false;
    }
    return false; 
}

    public boolean checkFork() {
        int test = 0;

        if (currentPositionY < maze.length - 1 && maze[currentPositionY + 1][currentPositionX].equals(".")) {
            test++;
        }
        if (currentPositionY > 0 && maze[currentPositionY - 1][currentPositionX].equals(".")) {
            test++;
        }
        if (currentPositionX < maze[0].length - 1 && maze[currentPositionY][currentPositionX + 1].equals(".")) {
            test++;
        }
        if (currentPositionX > 0 && maze[currentPositionY][currentPositionX - 1].equals(".")) {
            test++;
        }

        return test > 1;
    }

    public void goBack(){
        coordinates.remove(coordinates.size() - 1); 
        String[] last = coordinates.get(coordinates.size() - 1).replace("(", "").replace(")", "").split(",");
        currentPositionX = Integer.parseInt(last[1]);
        currentPositionY = Integer.parseInt(last[0]);
    }

    public void mazeSolver(){
        addCoordinate(0, 0);
        markVisited(currentPositionX, currentPositionY); 

        while (!checkEnd()){
            if (!checkFork()){
                if (!handleFork()){
                    if (coordinates.size() > 1) {
                        goBack();
                    }
                }
            } else {
                if (goRight()) {
                    
                } 
                else if (goDown()) {
                    
                }
                else if (goUp()) {
                    
                }
                else if (goLeft()) {
                    
                }
                else {
                    if (coordinates.size() > 1) {
                        goBack();
                    }
                }
            }
            if (checkEnd()){
                break;
            }
        }
        System.out.println(coordinates);
    }

    public boolean checkEnd(){
        return (currentPositionX == endPositionX) && (currentPositionY == endPositionY);
    }

    public boolean handleFork() {
        return goRight() || goDown() || goUp() || goLeft();
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
