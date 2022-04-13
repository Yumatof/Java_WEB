package org.example.HW4;

import org.example.HW4.MyException.NonExistentTriangle;
import static java.lang.Math.sqrt;

public class TriangleSquare {
    private final String INCORRECT_SIDE_TRIANGLE = "Triangle with given sides exists.";

    public double calculationSquare(int sideA, int sideB, int sideC){

        try {
            checkSideTriangle(sideA,sideB,sideC);
        } catch (NonExistentTriangle e){
            e.printStackTrace();
        }


        int halfPerimeter = (sideA + sideB + sideC)/2;
        return sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }

    private void checkSideTriangle(int sideA, int sideB, int sideC) throws NonExistentTriangle {
        if(((sideA + sideB) > sideC)
                &&((sideA + sideC) > sideB)
                &&((sideB + sideC) > sideA)) {
            throw new NonExistentTriangle(INCORRECT_SIDE_TRIANGLE);
        }
    }


    }
