package org.example.HW3.MyException;

public class NonExistentTriangle extends Exception{
    public NonExistentTriangle(String errorMsg){
        super(errorMsg);
    }

}
