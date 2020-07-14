package com.softserve.sprint09.task4;


import java.io.FileReader;
import java.io.IOException;

/**
 * Create the method writeFile(String filename, String text)
 * that write the text to file as sequence of bytes in binary format.
 *
 * For example, the text fragment
 *   Hello!
 *
 * should be represented in the file as a sequence of 7-bit bytes without spaces between them:
 *
 *
 * If less than 7 bits are required to represent the character then add to binary sequence leading zeros '0'.
 */

public class Task4 {
    public static String readFile(String filename) {
        String result = "";
        try (FileReader fr = new FileReader(filename)) {
            int c = 0;
            char[] cbuf = new char[7];
            while ((c = fr.read(cbuf)) != -1) {
                if (c != cbuf.length) {
                    return result;
                }
                result += (char)convert7BitToChar(cbuf);
            }
        } catch (IOException e) {}
        return result;
    }

    private static int convert7BitToChar(char[] cbuf) {
        return Integer.parseInt(new String(cbuf), 2);
    }

    public static void main(String[] args) {
        System.out.println(readFile("test.txt"));
    }
}
