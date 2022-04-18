package org.example.HW4;


import org.example.HW4.MyException.NonExistentTriangle;
import org.example.HW4.TriangleSquare;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleTest {

    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);
    TriangleSquare ts = new TriangleSquare();

    @Test
    @DisplayName("Позитивный тест")
    @Tag("triangle")
    public void positiveTest() throws NonExistentTriangle {
        logger.info("Run positive test");
        assertTrue(ts.calculationSquare(3,3,3) == (float) 3.8971143);
    }

    @Test
    @DisplayName("Негативный тест(отрицательное число)")
    @Tag("triangle")
    public void negativeNumberTest() throws NonExistentTriangle {
        logger.info("Run negative test(with negative number)");
        assertTrue(ts.calculationSquare(3,3,-5) == 0);
    }

    @Test
    @DisplayName("Негативный тест(ноль)")
    @Tag("triangle")
    public void zeroNumberTest() throws NonExistentTriangle {
        logger.info("Run negative test(with zero)");
        assertTrue(ts.calculationSquare(3,3,0) == 0);
    }

    @Test
    @DisplayName("Негативный тест(несуществующий треугольник)")
    @Tag("triangle")
    public void nonExistentTriangleTest() throws NonExistentTriangle {
        logger.info("Run negative test(with zero)");
        assertTrue(ts.calculationSquare(3,100,2) == 0);
    }



}
