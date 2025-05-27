import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LeftHandRuleRobotTest{

    /*Kollar att roboten startar på start positionen*/
    @Test
    void testGetPositionLeftHandRuleRobot() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        LeftHandRuleRobot robot= new LeftHandRuleRobot(m);

        Position p = new Position(1,0);
        assertEquals(p, robot.getPosition());

    }

    /*Testar att roboten har gått i mål efter 1000 förflytttningar*/
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

    /*Testar att roboten inte har gått i mål efter en förslyttning*/
    @Test
    void testHasReachedGoalLeftHandRuleRobotFalse() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        LeftHandRuleRobot robot= new LeftHandRuleRobot(m);
        robot.move();
        assertFalse(robot.hasReachedGoal());
    }


    /*Testar atttt robot går i mål i labyrint utan innerväggar*/
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

    /*Testar att robot backar i labyrint med återvändsgränd*/
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

    /*Testar att robot följer vänsterhandsregeln*/
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
    @Test
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