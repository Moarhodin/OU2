import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest{

    /*Tests that the methods getX and getY returns the right position*/
    @Test
     void testGetXGetY(){
        Position p= new Position(1,1);
        assertEquals(1, p.getX());
        assertEquals(1, p.getY());
    }

    /*Tests that the method equals returns true for the same position */
    @Test
    void testEqualsTrue(){
        Position p1= new Position(1,1);
        Position p2= new Position(1,1);
        assertEquals(p1, p2);
    }


    /*Tests that the method equals returns false for different position */
    @Test
    void testEqualsFalse(){
        Position p1= new Position(1,1);
        Position p2= new Position(2,1);
        assertNotEquals(p1, p2);
    }

    /*Tests that the method getPosToNorth returns the positionn to the north (y-1) */
    @Test
    void testGetPosToNorth(){
        Position p1= new Position(2,2);
        Position p2=new Position(2,1);
        assertEquals(p2, p1.getPosToNorth());
    }

    /*Tests that the method getPosToSouth returns the position to the south (y+1) */
    @Test
    void testGetPosToSouth(){
        Position p1= new Position(2,2);
        Position p2=new Position(2,3);
        assertEquals(p2, p1.getPosToSouth());
    }

    /*Tests that the method getPosToEast returns the position to the east (x+1) */
    @Test
    void testGetPosToEast(){
        Position p1= new Position(2,2);
        Position p2=new Position(3,2);
        assertEquals(p2, p1.getPosToEast());
    }

    /*Tests that the method getPosToWest returns the positionn to the west (x-1) */
    @Test
    void testGetPosToWest(){
        Position p1= new Position(2,2);
        Position p2=new Position(1,2);
        assertEquals(p2, p1.getPosToWest());
    }

    /*Tests that the method hashCode returns the same hashcode for the same position*/
    @Test
    void testHashCodeTrue(){
        Position p1=new Position(1,1);
        Position p2=new Position(1,1);

        assertEquals(p1,p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    /*Tests that the method hashCode don´t returns the same hashcode for different positions*/
    @Test
    void testHashCodeFalse(){
        Position p1=new Position(1,1);
        Position p2=new Position(2,2);

        assertNotEquals(p1,p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }
}