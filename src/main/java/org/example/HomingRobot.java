import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The robot keeps track of previous positions and chooses the available position closest to the goal.
 * @name HomingRobot
 * @author ens21mrn
 * @version 2 2025-05-27
 */
public class HomingRobot implements Robot {
    private Position pos;
    private Maze maze;
    private Position previousPosition;
    private static final int maxDistance=100000;

    //Ny
    private Stack<Position> pathStack;
    private List<Position> checkedPositions;

    /**
     * Method: HomingRobot
     * Construct a robot in a given maze.
     * @param m the maze the robot should explore
     */
    public HomingRobot(Maze m) {
        pos = m.getStart();
        this.maze =m;
        previousPosition =pos;
        this.pathStack = new Stack<>();
        this.checkedPositions = new ArrayList<>();
        checkedPositions.add(maze.getStart());
    }

    /**
     * Move this robot. Tries to move to the positon closest to a goal.
     * Avoids going back from where it came if possible
     */
    @Override
    public void move() {
        ArrayList<Position> movable = getMovableNeighboursForward();

        if(!movable.isEmpty()) {
            moveForward(movable);
        }
        else if(!pathStack.isEmpty()){
            pos = pathStack.pop();
        }else{
            stepBack();
        }
    }

    /**
     * Description: Moves the robot to an accepted position.
     * @param movable - The list of acceptable moves the robot can take.
     */
    public void moveForward(ArrayList<Position> movable){
        Position nextMove = chooseNextMove(movable);
        pathStack.push(pos);
        pos = nextMove;
        checkedPositions.add(pos);
    }

    /**
     * Description: Chooses the position the robot will move to from the list of accepted moves.
     * @param movable - The list of acceptable moves the robot can take.
     * @return Posiition - Returns the position the robot will move to.
     */
    private Position chooseNextMove(List<Position> movable) {

        Position nextPos=null;
        int distance=maxDistance;

        for (int x=0; x< movable.size();x++){
            Position position=movable.get(x);

            if(positionCloserToGoal(position, distance)){
                distance=maze.distanceToClosestGoal(position);
                nextPos=position;
            }
        }
        return nextPos;
    }

    /**
     * Description: Boolean that checks if the distance to the goal is closer than thee previous distance.
     * @param p - the neighbour position
     * @return true if the position is movable and not the previous position
     */
    private boolean positionCloserToGoal(Position p,int distance){
        return maze.distanceToClosestGoal(p)<distance;
    }



    /**
     * Description: Get the neighbours of the current position that are movable.
     * Excludes the position the robot came from
     * @return the available positions
     */
    private ArrayList<Position> getMovableNeighboursForward() {
        ArrayList<Position> movable = new ArrayList<>();
        List<Position> neighbours = getNeighbours();
        for(Position p:neighbours) {
            if(maze.isMovable(p)&&!checkedPositions.contains(p)){
                movable.add(p);
            }
        }
        return movable;
    }

    private void setPosition(Position p) {
        previousPosition =pos;
        pos=p;
    }

    /**
     * Description: Step back to the previous position
     */
    private void stepBack() {
        setPosition(previousPosition);
    }

    /**
     * Description: Get the neighbours of the current position
     * @return a list of the neighbours
     */
    private ArrayList<Position> getNeighbours() {
        ArrayList<Position> neighbours = new ArrayList<>();
        neighbours.add(pos.getPosToNorth());
        neighbours.add(pos.getPosToSouth());
        neighbours.add(pos.getPosToEast());
        neighbours.add(pos.getPosToWest());
        return neighbours;
    }

    /**
     * Description: Get the current position of the robot
     * @return the position
     */

    public Position getPosition() {
        return pos;
    }

    /**
     * Description: Check if the robot has reached the goal
     * @return true if the robot has reached the goal
     */
    public boolean hasReachedGoal() {
        return maze.isGoal(pos);
    }

}
