import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Test the methods in the LeftHandRuleRobot class.
 * @name LeftHandRuleRobbotTest
 * @author ens21mrn
 * @version 2 2025-05-27
 */

public class LeftHandRuleRobotTest{

    /**
     * Tests that the LeftHandRuleRobot starts at the startposition in the maze.
     */
    @Test
    void testGetPositionLeftHandRuleRobot() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        LeftHandRuleRobot robot= new LeftHandRuleRobot(m);

        Position p = new Position(1,0);
        assertEquals(p, robot.getPosition());

    }

    /**
     * Tests that the LeftHanndRuleRobot has reached goal.
     */
    @Test
    void testHasReachedGoalLeftHandRuleRobot() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        LeftHandRuleRobot robot= new LeftHandRuleRobot(m);

        while(!(robot.hasReachedGoal())){
            robot.move();
        }
        assertTrue(robot.hasReachedGoal());
    }

    /**
     * Tests that the LeftHandRuleRobot has not reached goal after one movement.
     */
    @Test
    void testHasReachedGoalLeftHandRuleRobotFalse() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        LeftHandRuleRobot robot= new LeftHandRuleRobot(m);
        robot.move();
        assertFalse(robot.hasReachedGoal());
    }

    /**
     * Tests that the LeftHandRuleRobot reaches goal in maze without inner walls.
     */
    @Test
    void testMazeNoInternalWallLeftHandRuleRobot() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze2.txt"));
        Maze m=new Maze(s);
        LeftHandRuleRobot robot= new LeftHandRuleRobot(m);

        while(!(robot.hasReachedGoal())){
            robot.move();
        }

        assertTrue(robot.hasReachedGoal());
    }

    /**
     * Tests that the LeftHandRuleRobot steps back in a dead-end maze.
     */
    @Test
    void testMazeTurnBackLeftHandRuleRobot() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze3.txt"));
        Maze m=new Maze(s);
        LeftHandRuleRobot robot= new LeftHandRuleRobot(m);

        Position p1= new Position(1,0);
        assertEquals(p1, robot.getPosition());

        robot.move();
        Position p2= new Position(1,1);
        assertEquals(p2, robot.getPosition());

        robot.move();
        assertEquals(p1, robot.getPosition());
    }

    /**
     * Tests that the LeftHandRuleRobot follows the lefthandrule when choosing the next position.
     */
    @Test
    void testRobotFollowLeftWall() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        LeftHandRuleRobot robot= new LeftHandRuleRobot(m);

        Position p1= new Position(1,0);
        assertEquals(p1, robot.getPosition());

        robot.move();
        Position p2= new Position(1,1);
        assertEquals(p2, robot.getPosition());

        robot.move();
        Position p3= new Position(2,1);
        assertEquals(p3, robot.getPosition());

        robot.move();
        Position p4= new Position(3,1);
        assertEquals(p4, robot.getPosition());

        robot.move();
        Position p5= new Position(4,1);
        assertEquals(p5, robot.getPosition());
    }

    /*Testa att roboten följer reglerna när den inte har en väggg i närheten
    (går rakt fram tills den hittar en vägg)*/

    /**
     * Tests that the LeftHandRuleRobot  follows the rules in a maze without having
     * a wall close by (moving forward  untill it finds a wall).
     */
    /*@Test
    void testRobotStartInTheMiddle() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze4.txt"));
        Maze m=new Maze(s);
        LeftHandRuleRobot robot= new LeftHandRuleRobot(m);

        Position p1= new Position(3,2);
        assertEquals(p1, robot.getPosition());

        robot.move();
        Position p2= new Position(4,2);
        assertEquals(p2, robot.getPosition());

        robot.move();
        Position p3= new Position(2,3);
        assertEquals(p3, robot.getPosition());

        robot.move();
        Position p4= new Position(2,4);
        assertEquals(p4, robot.getPosition());

        assertTrue(robot.hasReachedGoal());
    }
}*/

void testRobotStartInTheMiddle() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze4.txt"));
        Maze m=new Maze(s);
        LeftHandRuleRobot robot= new LeftHandRuleRobot(m);

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
    /*void testRobotStartInTheMiddle() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze4.txt"));
        Maze m=new Maze(s);
        LeftHandRuleRobot robot= new LeftHandRuleRobot(m);

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
}*/