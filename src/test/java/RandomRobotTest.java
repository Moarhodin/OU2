import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Test the methods in the RandomRobot class.
 * @name RandomRobotTest
 * @author ens21mrn
 * @version 2 2025-05-27
 */

public class RandomRobotTest{

    /**
     * Tests that the RandomRobot starts at the startposition in the maze.
     */
    @Test
    void testGetPositionRandomRobot() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        RandomRobot robot= new RandomRobot(m);

        Position p = new Position(1,0);
        assertEquals(p, robot.getPosition());

    }

    /**
     * Tests that the RandomRobot has reached goal.
     */
    @Test
    void testHasReachedGoalRandomRobot() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        RandomRobot robot= new RandomRobot(m);

        while(!(robot.hasReachedGoal())){
            robot.move();
        }
        assertTrue(robot.hasReachedGoal());
    }

    /**
     * Tests that the RanndomRobot has not reached goal after one movement.
     */
    @Test
    void testHasReachedGoalRandomRobotFalse() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        RandomRobot robot= new RandomRobot(m);
        robot.move();
        assertFalse(robot.hasReachedGoal());
    }


    /**
     * Tests that the RandomRobot reaches goal in maze without inner walls.
     */
    @Test
    void testMazeNoInternalWall() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze2.txt"));
        Maze m=new Maze(s);
        RandomRobot robot= new RandomRobot(m);

        while(!(robot.hasReachedGoal())){
            robot.move();
        }

        assertTrue(robot.hasReachedGoal());
    }

    /**
     * Tests that the RanndomRobot steps back in a dead-end maze.
     */
    @Test
    void testMazeTurnBack() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze3.txt"));
        Maze m=new Maze(s);
        RandomRobot robot= new RandomRobot(m);

        Position p1= new Position(1,0);
        assertEquals(p1, robot.getPosition());

        robot.move();
        Position p2= new Position(1,1);
        assertEquals(p2, robot.getPosition());

        robot.move();
        assertEquals(p1, robot.getPosition());
    }
}