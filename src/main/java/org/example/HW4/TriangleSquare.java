package org.example.HW4;

import org.example.HW3.MyException.NonExistentTriangle;
import static java.lang.Math.sqrt;

public class TriangleSquare {
    private final String INCORRECT_SIDE_TRIANGLE = "Triangle with given sides exists.";

    public float calculationSquare(int sideA, int sideB, int sideC) throws NonExistentTriangle {


        try {
            checkSideTriangle(sideA, sideB, sideC);
        } catch (NonExistentTriangle be) {
            System.out.println(be.getMessage());
        }
        if(sideA<=0 || sideB<=0 || sideC<=0) return 0;

        if (!((sideA + sideB) > sideC)
                || !((sideA + sideC) > sideB)
                || !((sideB + sideC) > sideA)) return 0;

        float halfPerimeter = ((float) sideA + sideB + sideC) / 2;
        return (float) sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }
    private void checkSideTriangle(int sideA, int sideB, int sideC) throws NonExistentTriangle {
        if (!((sideA + sideB) > sideC)
                || !((sideA + sideC) > sideB)
                || !((sideB + sideC) > sideA)) {
            throw new NonExistentTriangle(INCORRECT_SIDE_TRIANGLE);
        }


    }

}
