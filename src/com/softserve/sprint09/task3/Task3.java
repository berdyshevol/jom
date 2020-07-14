package com.softserve.sprint09.task3;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Create the method writeFile(String filename, String text)
 * that write the text to file as sequence of bytes in binary format.
 *
 * For example, the text fragment
 *  Hello!
 *
 * should be represented in the file as a sequence of 7-bit bytes without spaces between them:
 *
 *
 * If less than 7 bits are required to represent the character then add to binary sequence leading zeros '0'.
 */
public class Task3 {
    public static void writeFile(String filename, String text) {
        try (FileWriter fw = new FileWriter(filename)) {
            char [] arr = text.toCharArray();
            for (char c : arr) {
                fw.write(convertCharTo7BitString(c));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String convertCharTo7BitString(int c) {
        return String.format("%7s", Integer.toString(c, 2)).replace(' ', '0');
    }

    public static void main(String[] args) {
        writeFile("test.txt", "Hello!");
//        System.out.println(convertCharTo7Bits(2));
    }
}
