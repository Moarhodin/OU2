import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest{
    @Test
    void testGetXGetY(){
        Position p= new Position(1,1);
        assertEquals(1, p.getX());
        assertEquals(1, p.getY());
    }


}