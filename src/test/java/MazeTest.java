import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MazeTest{

    /*Testar att antalet kolonner och rader stämmer*/
    @Test
    void testNumColsRows() throws IOException{

            Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
            Maze m=new Maze(s);

            int rows = 7;
            int cols = 12;
            assertEquals(cols, m.getNumColumns());
            assertEquals(rows, m.getNumRows());

    }

    /*Testar att isGoal hittar rätt mål*/
    @Test
    void testIsGoalTrue() throws IOException{
        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        Position goal = new Position(8,6);
        assertTrue(m.isGoal(goal));

    }

    /*Testar att isGoal inte returnerar mål för en position som inte är mål*/
    @Test
    void testIsGoalFalse() throws IOException{
        Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
        Maze m=new Maze(s);
        Position p = new Position(1,1);
        assertFalse(m.isGoal(p));

    }

}