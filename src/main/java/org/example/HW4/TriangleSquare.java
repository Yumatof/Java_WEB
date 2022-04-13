package org.example.HW4;

import org.example.HW4.MyException.NonExistentTriangleException;

import static java.lang.Float.NaN;
import static java.lang.Math.sqrt;

public class TriangleSquare {
    private final String INCORRECT_SIDE_TRIANGLE = "Triangle with given sides exists.";

    public double calculationSquare(int sideA, int sideB, int sideC) throws NonExistentTriangleException {


        try {
            checkSideTriangle(sideA, sideB, sideC);
        } catch (NonExistentTriangleException be) {
            System.out.println(be.getMessage());
        }
        if(sideA<=0 || sideB<=0 || sideC<=0) return 0;

        if (!((sideA + sideB) > sideC)
                || !((sideA + sideC) > sideB)
                || !((sideB + sideC) > sideA)) return 0;

        double halfPerimeter = ((double) sideA + sideB + sideC) / 2;
        return sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }
    private void checkSideTriangle(int sideA, int sideB, int sideC) throws NonExistentTriangleException {
        if (!((sideA + sideB) > sideC)
                || !((sideA + sideC) > sideB)
                || !((sideB + sideC) > sideA)) {
            throw new NonExistentTriangleException(INCORRECT_SIDE_TRIANGLE);
        }


    }

}
