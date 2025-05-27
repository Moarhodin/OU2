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

    /*Testar att GetPosToNorth returnerar positionen till norr (y-1)*/
    @Test
    void testGetPosToNorth(){
        Position p1= new Position(2,2);
        Position p2=new Position(2,1);
        assertEquals(p2, p1.getPosToNorth());
    }

    /*Testar att GetPosToSouth returnerar positionen till norr (y+1)*/
    @Test
    void testGetPosToSouth(){
        Position p1= new Position(2,2);
        Position p2=new Position(2,3);
        assertEquals(p2, p1.getPosToSouth());
    }

    /*Testar att GetPosToEast returnerar positionen till öst (x+1)*/
    @Test
    void testGetPosToEast(){
        Position p1= new Position(2,2);
        Position p2=new Position(3,2);
        assertEquals(p2, p1.getPosToEast());
    }

    /*Testar att GetPosToWest returnerar positionen till väst (x-1)*/
    @Test
    void testGetPosToWest(){
        Position p1= new Position(2,2);
        Position p2=new Position(1,2);
        assertEquals(p2, p1.getPosToWest());
    }







}