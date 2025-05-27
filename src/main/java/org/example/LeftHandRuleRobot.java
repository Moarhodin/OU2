
/**
 * The robot moves like a human, vu always keeping their left hand on a wall.
 * @name LeftHandRuleRobot
 * @author ens21mrn
 * @version 2 2025-05-27
 */

import java.util.ArrayList;
import java.util.List;

public class LeftHandRuleRobot implements Robot{

    private Position pos;
    private Maze maze;
    private Position previousPosition;


    //ny
    private boolean foundWall;
    private Direction direction;

    /**
     * Construct a robot in a given maze.
     * @param m the maze the robot should explore
     */
    public LeftHandRuleRobot(Maze m) {
        pos = m.getStart();
        this.maze =m;
        previousPosition =pos;

        //ny
        this.direction = Direction.SOUTH;

        //Checks if there are any walls surrounding the position
        this.foundWall = !(maze.isMovable(pos.getPosToWest()) &&
                maze.isMovable(pos.getPosToSouth()) &&
                maze.isMovable(pos.getPosToEast()) &&
                maze.isMovable(pos.getPosToNorth()));
    }

    /**
     * Move this robot. Tries to move in a random direction.
     * Avoids going back from where it came if possible
     */

    //@Override
    /*public void move() {
        // Hämta alla möjliga grannar utan att exkludera previousPosition
        ArrayList<Position> allMovableNeighbours = new ArrayList<>();
        for (Position p : getNeighbours()) {
            if (maze.isMovable(p)) {
                allMovableNeighbours.add(p);
            }
        }

        // Om den enda möjliga vägen är tillbaka där vi kom ifrån - gå tillbaka
        if (allMovableNeighbours.size() == 1 && allMovableNeighbours.contains(previousPosition)) {
            setPosition(previousPosition);
            return;
        }

        // Annars, kör vanliga logiken med exkludering av previousPosition
        ArrayList<Position> movable = getMovableNeighboursForward();

        Position forward = getPositionInDirection(direction);
        Position left = getPositionInDirection(direction.turnLeft());
        Position backward = getPositionInDirection(direction.turnBackwards());
        Position right = getPositionInDirection(direction.turnRight());

        if (!foundWall) {
            if (movable.contains(forward)) {
                setPosition(forward);
            } else {
                direction = direction.turnRight();
                setPosition(right);
                foundWall = true;
            }
        } else {
            if (movable.contains(left)) {
                direction = direction.turnLeft();
                setPosition(left);
            } else if (movable.contains(forward)) {
                setPosition(forward);
            } else if (movable.contains(right)) {
                direction = direction.turnRight();
                setPosition(right);
            } else {
                direction = direction.turnBackwards();
                setPosition(backward);
            }
        }
    }*/
    @Override
    public void move() {

        ArrayList<Position> movable = getMovableNeighboursForward();


        if (movable.isEmpty()) {
            stepBack();
        } else {

            //Gets the position in all of the directions surronding the robot current position
            Position forward = getPositionInDirection(direction);
            Position left = getPositionInDirection(direction.turnLeft());
            Position backward = getPositionInDirection(direction.turnBackwards());
            Position right = getPositionInDirection(direction.turnRight());

            if (foundWall == false) {
                if (movable.contains(forward)) {
                    setPosition(forward);
                } else {
                    direction = direction.turnRight();
                    setPosition(right);
                    foundWall = true;
                }
            } else {
                if (movable.contains(left)) {
                    direction = direction.turnLeft();
                    setPosition(left);
                } else if (movable.contains(forward)) {
                    setPosition(forward);
                } else if (movable.contains(right)) {
                    direction = direction.turnRight();
                    setPosition(right);
                } else {
                    direction = direction.turnBackwards();
                    setPosition(backward);
                }
            }
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
     * Method: getPositionInDirection
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

    private enum Direction {
        NORTH, EAST, SOUTH, WEST;

        /**
         * Method: turnRight
         * Description: This method is used to change the direction by turning right.
         * @return direction - The new direction of the position
         */
        public Direction turnRight() {
            return values()[(ordinal() + 1) % values().length];
        }

        /**
         * Method: turnLeft
         * Description: This method is used to change the direction by turning left.
         * @return direction - The new direction of the position
         */
        public Direction turnLeft() {
            return values()[(ordinal() + values().length - 1) % values().length];
        }

        /**
         * Method: turnBackwards
         * Description: This method is used to change the direction by turning backward.
         * @return direction - The new direction of the position
         */
        public Direction turnBackwards() {
            return values()[(ordinal() + 2) % values().length];
        }
    }


}
