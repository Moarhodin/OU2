import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MazeTest{

    @Test
    void testNumColsRows() throws IOException{

            Scanner s = new Scanner(new File("src/test/resources/maze.txt"));
            Maze m=new Maze(s);

            int rows = 7;
            int cols = 12;
            assertEquals(cols, m.getNumColumns());
            assertEquals(rows, m.getNumRows());

    }

}