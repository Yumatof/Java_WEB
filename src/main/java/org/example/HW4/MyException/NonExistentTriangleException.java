package org.example.HW4.MyException;

public class NonExistentTriangleException extends Exception{
    public NonExistentTriangleException(String errorMsg){
        super(errorMsg);
    }

}
