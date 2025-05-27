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
    void testHasReachedGoalRandomRobot() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        RandomRobot robot= new RandomRobot(m);
        robot.move();
        assertFalse(robot.hasReachedGoal());
    }




}