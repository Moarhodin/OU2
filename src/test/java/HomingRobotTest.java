import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Test the methods in the HomingRobot class.
 * @name HomingRobotTest
 * @author ens21mrn
 * @version 2 2025-05-27
 */

public class HomingRobotTest{

    /**
     * Tests that the HomingRobot starts at the startposition in the maze.
     */
    @Test
    void testGetPositionHominggRobot() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        HomingRobot robot= new HomingRobot(m);

        Position p = new Position(1,0);
        assertEquals(p, robot.getPosition());

    }

    /**
     * Tests that the HomingRobot has reached goal.
     */
    @Test
    void testHasReachedGoalHomingRobot() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        HomingRobot robot= new HomingRobot(m);

        while(!(robot.hasReachedGoal())){
            robot.move();
        }
        assertTrue(robot.hasReachedGoal());
    }

    /**
     * Tests that the HomingRobot has not reached goal after one movement.
     */
    @Test
    void testHasReachedGoalHomingRobotFalse() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        HomingRobot robot= new HomingRobot(m);
        robot.move();
        assertFalse(robot.hasReachedGoal());
    }

    /**
     * Tests that the HomingRobot reaches goal in maze without inner walls.
     */
    @Test
    void testMazeNoInternalWallHomingRobot() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze2.txt"));
        Maze m=new Maze(s);
        HomingRobot robot= new HomingRobot(m);

        while(!(robot.hasReachedGoal())){
            robot.move();
        }

        assertTrue(robot.hasReachedGoal());
    }

    /**
     * Tests that the HomingRobot steps back in a dead-end maze.
     */
    @Test
    void testMazeTurnBackHomingRobot() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze3.txt"));
        Maze m=new Maze(s);
        HomingRobot robot= new HomingRobot(m);

        Position p1= new Position(1,0);
        assertEquals(p1, robot.getPosition());

        robot.move();
        Position p2= new Position(1,1);
        assertEquals(p2, robot.getPosition());

        robot.move();
        assertEquals(p1, robot.getPosition());
    }

    /**
     * Tests that the HomingRobot chooses the position closest to goal in a maze.
     */
    @Test
    void testRobotMovesToGoal() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        HomingRobot robot= new HomingRobot(m);

        Position p1= new Position(1,0);
        assertEquals(p1, robot.getPosition());

        robot.move();
        Position p2= new Position(1,1);
        assertEquals(p2, robot.getPosition());

        robot.move();
        Position p3= new Position(1,2);
        assertEquals(p3, robot.getPosition());

        robot.move();
        Position p4= new Position(1,3);
        assertEquals(p4, robot.getPosition());

        robot.move();
        Position p5= new Position(2,3);
        assertEquals(p5, robot.getPosition());

        robot.move();
        Position p6= new Position(3,3);
        assertEquals(p6, robot.getPosition());

        robot.move();
        Position p7= new Position(3,4);
        assertEquals(p7, robot.getPosition());
    }

    /**
     * Tests that the HomingRobot chooses the position closest to goal in a maze
     * when starting in the middle.
     */
    @Test
    void testHomingRobotStartInTheMiddle() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze4.txt"));
        Maze m=new Maze(s);
        HomingRobot robot= new HomingRobot(m);

        Position p1= new Position(3,2);
        assertEquals(p1, robot.getPosition());

        robot.move();
        Position p2= new Position(3,3);
        assertEquals(p2, robot.getPosition());

        robot.move();
        Position p3= new Position(2,3);
        assertEquals(p3, robot.getPosition());

        robot.move();
        Position p4= new Position(2,4);
        assertEquals(p4, robot.getPosition());

        assertTrue(robot.hasReachedGoal());
    }
}