import java.util.ArrayList;
import java.util.List;

/**
 * A robot that moves in a random direction
 * @name RandomRobot
 * @author johane, ens21mrn
 * @version 2 2025-05-27
 */
public class RandomRobot implements Robot{
    private Position pos;
    private Maze maze;
    private Position previousPosition;

    /**
     * Construct a robot in a given maze.
     * @param m the maze the robot should explore
     */
    public RandomRobot(Maze m) {
        pos = m.getStart();
        this.maze =m;
        previousPosition =pos;
    }

    /**
     * Move this robot. Tries to move in a random direction.
     * Avoids going back from where it came if possible
     */
    @Override
    public void move() {
        ArrayList<Position> movable = getMovableNeighboursForward();
        if(movable.isEmpty()) {
            stepBack();
        }
        else {
            moveToRandom(movable);
        }
    }

    /**
     * Get the neighbours of the current position that are movable.
     * Excludes the position the robot came from
     * @return the available positions
     */
    private ArrayList<Position> getMovableNeighboursForward() {
        ArrayList<Position> movable = new ArrayList<>();
        List<Position> neighbours = getNeighbours();
        for(Position p:neighbours) {
            if(maze.isMovable(p)&&!p.equals(previousPosition))
                movable.add(p);
        }
        return movable;
    }

    /**
     * Move to a random position from the list of movable positions
     * @param movable the list of movable positions

     */
    private void moveToRandom(ArrayList<Position> movable) {

        Position newPos=movable.get((int) (Math.random() * movable.size()));
        setPosition(newPos);
    }

    private void setPosition(Position p) {
        previousPosition =pos;
        pos=p;
    }

    /**
     * Step back to the previous position
     */
    private void stepBack() {
        setPosition(previousPosition);
    }

    /**
     * Get the neighbours of the current position
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
     * Get the current position of the robot
     * @return the position
     */

    public Position getPosition() {
        return pos;
    }

    /**
     * Check if the robot has reached the goal
     * @return true if the robot has reached the goal
     */
    public boolean hasReachedGoal() {
        return maze.isGoal(pos);
    }


}
