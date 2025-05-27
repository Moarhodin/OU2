import java.util.ArrayList;

/**
 * The interface for all the robots.
 * @name Robot
 * @author ens21mrn
 * @version 2 2025-05-27
 */
public interface Robot {


    public void move();
    public Position getPosition();
    public boolean hasReachedGoal();

}
