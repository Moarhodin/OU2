
/**
 * The robot moves like a human, vu always keeping their left hand on a wall.
 * @name LeftHandRuleRobot
 * @author ens21mrn
 * @version 2 2025-05-27
 */

import java.util.ArrayList;
import java.util.List;


public class LeftHandRuleRobot implements Robot {
    private Position pos;
    private Maze maze;
    private Position previousPosition;
    private boolean foundWall;
    private Direction direction;

    /**
     * Description: Construct a robot in a given maze.
     * @param m the maze the robot should explore
     */
    public LeftHandRuleRobot(Maze m) {
        pos = m.getStart();
        this.maze = m;
        previousPosition = pos;
        this.direction = Direction.SOUTH;

        //Checks if there are any walls surrounding the position
        this.foundWall = !(maze.isMovable(pos.getPosToWest()) &&
                maze.isMovable(pos.getPosToSouth()) &&
                maze.isMovable(pos.getPosToEast()) &&
                maze.isMovable(pos.getPosToNorth()));
    }

    /**
     * Description: Move this robot. Tries to move the robot by following the left-hand-rule.
     * Avoids going back from where it came if possible
     */
    @Override
    public void move() {

        ArrayList<Position> movable = getMovableNeighboursForward();

        //Gets the position in all of the directions surronding the robot current position
        Position forward = getPositionInDirection(direction);
        Position left = getPositionInDirection(direction.turnLeft());
        Position backward = getPositionInDirection(direction.turnBackwards());
        Position right = getPositionInDirection(direction.turnRight());

        //How the robot moves if no wall has been found
        if (foundWall == false) {
            NoWallFound(movable, forward, right, backward, left);

        } else {
            //How the robot moves after finding a wall
            WallFound(movable, forward, right, backward, left);
        }
    }

    /**
     * Description: How the robot moves if no walls are found.
     * @param movable - The list of acceptable moves the robot can take.
     * @param forward - The forward position.
     * @param right- The right position.
     * @param backward- The backward position.
     * @param left- The left position.
     */
    public void NoWallFound(ArrayList<Position> movable, Position forward, Position right, Position backward, Position left){

        if (!maze.isMovable(left)) {
            foundWall = true;
        }

        if (movable.contains(forward)) {
            setPosition(forward);
        } else if (movable.contains(right)) {
            direction = direction.turnRight();
            setPosition(right);
            foundWall = true;
        } else if (movable.contains(left)) {
            direction = direction.turnLeft();
            setPosition(left);
            foundWall = true;
        } else if (movable.contains(backward)) {
            direction = direction.turnBackwards();
            setPosition(backward);
            foundWall = true;
        }
    }

    /**
     * Description: How the robot moves if walls are found.
     * @param movable - The list of acceptable moves the robot can take.
     * @param forward - The forward position.
     * @param right- The right position.
     * @param backward- The backward position.
     * @param left- The left position.
     */
    public void WallFound(ArrayList<Position> movable, Position forward, Position right, Position backward, Position left){

        if (movable.contains(left)) {
            direction = direction.turnLeft();
            setPosition(left);
        } else if (movable.contains(forward)) {
            setPosition(forward);
        } else if (movable.contains(right)) {
            direction = direction.turnRight();
            setPosition(right);
        } else if (movable.contains(backward)) {
            direction = direction.turnBackwards();
            setPosition(backward);
        }
    }

    /**
     * Description: Get the neighbours of the current position that are movable.
     * @return the available positions
     */
    private ArrayList<Position> getMovableNeighboursForward() {
        ArrayList<Position> movable = new ArrayList<>();
        List<Position> neighbours = getNeighbours();
        for(Position p:neighbours){
            if (maze.isMovable(p)) {
                movable.add(p);
            }
        }
        return movable;
    }

    /**
     * Description: This method is used to calculate and get the robot new position based
     * on the current positions coordinates.
     * @param direction - the current direction of the robot
     * @return Position - the new position based of the robots direction
     */
    private Position getPositionInDirection(Direction direction) {
        int x = pos.getX();
        int y = pos.getY();


        switch (direction) {
            case NORTH:
                return new Position(x, y - 1);
            case EAST:
                return new Position(x + 1, y);
            case SOUTH:
                return new Position(x, y + 1);
            case WEST:
                return new Position(x - 1, y);
            default:
                throw new IllegalArgumentException("Not available direction");
        }
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


    private enum Direction {
        NORTH, EAST, SOUTH, WEST;

        /**
         * Description: This method is used to change the direction by turning right.
         * @return direction - The new direction of the position
         */
        public Direction turnRight() {
            return values()[(ordinal() + 1) % values().length];
        }

        /**
         * Description: This method is used to change the direction by turning left.
         * @return direction - The new direction of the position
         */
        public Direction turnLeft() {
            return values()[(ordinal() + values().length - 1) % values().length];
        }

        /**
         * Description: This method is used to change the direction by turning backward.
         * @return direction - The new direction of the position
         */
        public Direction turnBackwards() {
            return values()[(ordinal() + 2) % values().length];
        }
    }

}
