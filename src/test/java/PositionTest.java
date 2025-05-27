import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest{

    /*Testar GetX och GetY*/
    @Test
     void testGetXGetY(){
        Position p= new Position(1,1);
        assertEquals(1, p.getX());
        assertEquals(1, p.getY());
    }

    /*Testar Equals, ska reeturnera sant*/
    @Test
    void testEqualsTrue(){
        Position p1= new Position(1,1);
        Position p2= new Position(1,1);
        assertEquals(p1, p2);
    }

    /*Testar Equals, ska reeturnera falskt*/
    @Test
    void testEqualsFalse(){
        Position p1= new Position(1,1);
        Position p2= new Position(2,1);
        assertNotEquals(p1, p2);
    }




}