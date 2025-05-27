import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RandomRobotTest{

    /*Kollar att roboten startar på start positionen*/
    @Test
    void testGetPositionRobot() throws IOException{

        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        RandomRobot robot= new RandomRobot(m);

        Position p = new Position(1,0);
        assertEquals(p, robot.getPosition());

    }

}