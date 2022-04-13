package org.example.HW4.MyException;

public class NonExistentTriangle extends Exception{
    public NonExistentTriangle(String errorMsg){
        super(errorMsg);
    }

}
