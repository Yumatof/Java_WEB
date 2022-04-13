package HW3Test;

import org.example.HW4.MyException.NonExistentTriangleException;
import org.example.HW4.TriangleSquare;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


import static java.lang.Float.NaN;

public class TriangleTest {
    TriangleSquare ts = new TriangleSquare();

    @Test
    public void positiveTest() throws NonExistentTriangleException {
        Assertions.assertTrue(ts.calculationSquare(3,3,3) == (double) 3.897114317029974);
    }

    @Test
    public void negativeNumberTest() throws NonExistentTriangleException {

        Assertions.assertTrue(ts.calculationSquare(3,3,-5) == 0);
    }

    @Test
    public void zeroNumberTest() throws NonExistentTriangleException {

        Assertions.assertTrue(ts.calculationSquare(3,3,0) == 0);
    }

    @Test
    public void nonExistentTriangleTest() throws NonExistentTriangleException {

        Assertions.assertTrue(ts.calculationSquare(3,100,2) == 0);
    }



}
