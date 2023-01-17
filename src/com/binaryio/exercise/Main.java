package com.binaryio.exercise;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestObjectStream testObjectStream=new TestObjectStream();
        testObjectStream.write();
        testObjectStream.read();


//        for(String arg : args){
//            System.out.println(arg);
//        }

//        TestFileStream testFileStream=new TestFileStream();
//        testFileStream.write();
//        testFileStream.read();
    }
}
