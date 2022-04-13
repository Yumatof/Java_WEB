package org.example.HW4;

import static java.lang.Math.sqrt;

public class TriangleSquare {


    public double calculationSquare(int sideA, int sideB, int sideC){




        int halfPerimeter = (sideA + sideB + sideC)/2;
        return sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }

    private void checkSideTriangle(int sideA, int sideB, int sideC){

    }


    }
