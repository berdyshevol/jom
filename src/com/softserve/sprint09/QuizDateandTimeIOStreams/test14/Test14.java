package com.softserve.sprint09.QuizDateandTimeIOStreams.test14;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * What will be the result of executing the following program?
 * a. Will be created empty file 'data.txt'
 * b. Compile error                                <-- V
 * c. The line 'abc' will be written in file 'data.txt'
 * d. Runtime error
 * e. The line 'abcabcabc' will be written in file 'data.txt'
 * f. The line '979899' will be written in file 'data.txt'
 * g. The line '979899979899979899' will be written in file 'data.txt'
 */
public class Test14 {
    public static void main(String[] args) {
        String text = "abc";
        byte[] data = text.getBytes();
//        OutputStream outputStream = new FileOutputStream("data.txt"); // requires try with resources, Unhandled exception: java.io.FileNotFoundException
//        for (int i = 0; i < 3; i++) {
//            outputStream.write(data); // Unhandled exception: java.io.IOException
//        }
//        outputStream.close();
    }
}
