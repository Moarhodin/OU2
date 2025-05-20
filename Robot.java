import java.util.ArrayList;

/**
 * The interface for all the robots.
 * @author eens21mrn
 * @version 2025-04-28
 */
public interface Robot {


    public void move();
    public Position getPosition();
    public boolean hasReachedGoal();

}
