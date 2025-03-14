import java.util.ArrayList;

public class Maze {
    private int currentPositionX = 0;
    private int currentPositionY = 0;
    private int endPositionX;
    private int endPositionY;
    private int previousCoordinateX;
    private int previousCoordinateY;
    private String[][] maze;
    ArrayList<String> coordinates = new ArrayList<String>();

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
        String coordinate = "(" + currentPositionX + "," + currentPositionY + ")";
        coordinates.add(coordinate);
    }


    public boolean checkPast(){
        if (currentPositionX == previousCoordinateX && currentPositionY == previousCoordinateY){
            return false;
        }
        return true;
    }

    public boolean goUp(){
        try {
            while (maze[currentPositionY + 1][currentPositionX].equals(".")) {
                currentPositionY = currentPositionY + 1;
                if (!checkPast()) {
                    currentPositionY = currentPositionY - 1;
                    return true;
                }
                addCoordinate(currentPositionX, currentPositionY);
                previousCoordinateX = currentPositionX;
                previousCoordinateY = currentPositionY - 1;
                break;
            }
        }
        catch (Exception e){
            return true;
        }
         return false;
    }

    public boolean goDown() {
        try{
         while (maze[currentPositionY - 1][currentPositionX].equals(".")) {
             currentPositionY = currentPositionY - 1;
             if (!checkPast()) {
                 currentPositionY = currentPositionY + 1;
                 return true;
             }
             addCoordinate(currentPositionX, currentPositionY);
                 previousCoordinateX = currentPositionX;
                 previousCoordinateY = currentPositionY + 1;
                 break;
         }}
        catch (Exception e) {
            return true;
        }
         return false;
    }

    public boolean goLeft(){
        try {
            while (maze[currentPositionY][currentPositionX - 1].equals(".")) {
                currentPositionX = currentPositionX - 1;
            if (!checkPast()) {
                currentPositionX = currentPositionX + 1;
                return true;
            }
            addCoordinate(currentPositionX, currentPositionY);
                previousCoordinateX = currentPositionX + 1;
                previousCoordinateY = currentPositionY;
        }}
        catch (Exception e){
            return true;
        }
        return false;
    }

    public boolean goRight(){
        try {
        while (maze[currentPositionY][currentPositionX+1].equals(".")) {
            currentPositionX = currentPositionX + 1;
            if (!checkPast()) {
                currentPositionX = currentPositionX - 1;
                return true;
            }
            addCoordinate(currentPositionX, currentPositionY);
                previousCoordinateX = currentPositionX - 1;
                previousCoordinateY = currentPositionY;
                break;
        }}
        catch (Exception e){
            return true;
        }
        return false;
    }

    public void mazeSolver(){
        System.out.println("test");
        while (!checkEnd()){
            if (!goRight()){
                goRight();
            }
            if (!goUp()){
                goUp();
            }
            if (!goDown()){
                goDown();
            }
            if (!goLeft()){
                goLeft();
            }
            System.out.println("(" + currentPositionX + "," + currentPositionY + ")");
            System.out.println(coordinates);
            if (checkEnd()){
                break;
            }
        }
        System.out.println(coordinates);
        System.exit(0);
    }

    public boolean checkEnd(){
        return (currentPositionX == endPositionX) && (currentPositionY == endPositionY);
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
