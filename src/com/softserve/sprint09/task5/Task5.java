package com.softserve.sprint09.task5;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*public*/ class MyUtils {
    public Stream<String> nameList(Map<String, Stream<String>> map) {
        return map.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(x -> x != null) // check if value is not null
                .flatMap(stringStream -> stringStream
                        .filter(x -> x != null) // check if string is not null
                        .map(str -> getConsistentTitleCaseWord(str))
                        .filter(str -> !str.isEmpty())
                )
                .distinct()
                .sorted()
                ;
    }

    public String getConsistentTitleCaseWord(String str) {
        IntStream firstLetterStream = str.chars()
                .filter( x -> !Character.isSpaceChar(x) )
                .limit(1)
                .map(Character::toUpperCase);
        IntStream restLettersStream = str.chars()
                .filter( x -> !Character.isSpaceChar(x) )
                .skip(1)
                .map(Character::toLowerCase);

        return  IntStream.concat(
                        firstLetterStream,
                        restLettersStream
                ).collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append
                ).toString();
    }
}

/**
 * Let the key of Map is project name and value contains list of participants.
 * Create a Stream<String> nameList(Map<String, Stream<String>> map) method of the MyUtils class
 * to build sorted stream of all participants without duplication.
 * Please ignore null or empty strings, extra spaces and case sensitivity.
 * Throw NullPointerException if map is null.
 * For example, for a given map
 * {"Desktop"=[" iVan", "PeTro ", " Ira "], "Web"=["STepan", "ira ", " Andriy ", "an na"], "Spring"=["Ivan", "Anna"]}
 * you should get
 * ["Andriy", "Anna", "Ira", "Ivan", "Petro ", "Stepan"]
 */
public class Task5 {
    public static void main(String[] args) {
        Stream<String> stringStreamDesktop = Stream.of(" iVan", "PeTro ", " Ira ", null, "", "q");
        Stream<String> stringStreamWeb = Stream.of("STepan", "ira ", " Andriy ", "an na");
        Stream<String> stringStreamSpring = Stream.of("Ivan", "Anna");
        Map<String, Stream<String>> test = new HashMap<String, Stream<String>>() {{
            put("Desktop", stringStreamDesktop);
            put("Web", stringStreamWeb);
            put("null", null);
            put("Spring", stringStreamSpring);
        }};
        new MyUtils().nameList(test).forEach(System.out::println);

    }
}
