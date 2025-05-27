import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RandomRobotTest{

    /*Kollar att roboten startar på start positionen*/
    @Test
    void testGetPositionRandomRobot() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        RandomRobot robot= new RandomRobot(m);

        Position p = new Position(1,0);
        assertEquals(p, robot.getPosition());

    }

    /*Testar att roboten har gått i mål efter 1000 förflytttningar*/
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

    /*Testar att roboten inte har gått i mål efter en förslyttning*/
    @Test
    void testHasReachedGoalRandomRobotFalse() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        RandomRobot robot= new RandomRobot(m);
        robot.move();
        assertFalse(robot.hasReachedGoal());
    }


    /*Testar atttt robot går i mål i labyrint utan innerväggar*/
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

    /*Testar att robot backar i labyrint med återvändsgränd*/
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