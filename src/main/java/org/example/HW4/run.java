package org.example.HW4;

import org.example.HW4.MyException.NonExistentTriangleException;

public class run {
    public static void main (String [] args) throws NonExistentTriangleException {
        TriangleSquare t = new TriangleSquare();
        System.out.println(t.calculationSquare(3,100,2));
    }
}
