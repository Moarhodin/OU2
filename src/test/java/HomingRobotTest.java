import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HomingRobotTest{

    /*Kollar att roboten startar på start positionen*/
    @Test
    void testGetPositionHominggRobot() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        HomingRobot robot= new HomingRobot(m);

        Position p = new Position(1,0);
        assertEquals(p, robot.getPosition());

    }

    /*Testar att roboten har gått i mål efter 1000 förflytttningar*/
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

    /*Testar att roboten inte har gått i mål efter en förslyttning*/
    @Test
    void testHasReachedGoalHomingRobotFalse() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        HomingRobot robot= new HomingRobot(m);
        robot.move();
        assertFalse(robot.hasReachedGoal());
    }


    /*Testar atttt robot går i mål i labyrint utan innerväggar*/
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

    /*Testar att robot backar i labyrint med återvändsgränd*/
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


    /*Testar att robot väljer positionen närmast mål i labyrint*/
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

    /*Testar att robot väljer positionen närmast mål i labyrint vid start i mitten*/
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