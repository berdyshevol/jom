package com.softserve.sprint09.task6;

import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

/*public*/ class MyUtils {
    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        if (list == null) return null;
        Map<String, List<String>> tmp =  list.stream()
                .flatMap(x -> x)
                .filter(x -> x != null)
                .map(this::getOnlyDigitsForNumber)
                .filter(x -> !x.isEmpty())
                .distinct()
                .collect(groupingBy(
                        this::getCityCode,
                        mapping(this::getLocalNumber, toList())
                ));
        return tmp.entrySet().stream()
                .collect(toMap(
                            item -> item.getKey(),
                            item -> item.getValue().stream()
                                        .sorted()
                        ));
    }

    public String getOnlyDigitsForNumber(String input) {
        if (input == null) return null;
        return input.chars().filter(Character::isDigit)
                .collect(
                StringBuilder::new,
                StringBuilder::appendCodePoint,
                StringBuilder::append
        ).toString();
    }

    public String getCityCode(String code) {
        if (code.length() == 10)
            return code.substring(0, 3);
        else if (code.length() == 7)
            return "loc";
        else return "err";
    }

    public String getLocalNumber(String code) {
        if (code.length() == 10)
            return code.substring(3);
        else return code;
    }
}

/**
 * Create a Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) method of the MyUtils class
 * to build a Map of all phone numbers.
 * The key of Map is code of network and value contains sorted list of phones.
 * Remove all spaces, brakets and dashes from phone numbers.
 * For example, for a given
 * [
 *  ["093 987 65 43", "(050)1234567", "12-345"],
 *  ["067-21-436-57", "050-2345678", "0939182736", "224-19-28"],
 *  ["(093)-11-22-334", "044 435-62-18", "721-73-45"]
 * ]
 * you should get
 * {
 *   "050"=["1234567", "2345678"],
 *   "067"=["2143657"],
 *   "093"=["1122334", "9182736", "9876543"],
 *   "044"=["4356218"],
 *   "loc"=["2241928", "7217345"],
 *   "err"=["12345"]
 * }
 *
 *
 */

public class Task6 {
    public static void main(String[] args) {
        // smoke test
         List<Stream<String>> in = new ArrayList<Stream<String>>() {{
            add(Stream.of("093 987 65 43", "(050)1234567", "12-345"));
            add(Stream.of("067-21-436-57", "050-2345678", "0939182736", "224-19-28"));
            add(Stream.of("(093)-11-22-334", "044 435-62-18", "721-73-45", null));
            add(Stream.of());
            add(Stream.of("", " "));
            add(Arrays.stream(new String[]{null}));
            add(null);
        }};
//        var expected = Map.of(
//                "050", Stream.of("1234567", "2345678"),
//                "067", Stream.of("2143657"),
//                "093", Stream.of("1122334", "9182736", "9876543"),
//                "044", Stream.of("4356218"),
//                "loc", Stream.of("2241928", "7217345"),
//                "err", Stream.of("12345")
//        );
        System.out.println(new MyUtils().phoneNumbers(in));
//
//        var outRead = out.entrySet().stream()
//                .collect(Collectors.toMap(Map.Entry::getKey,
//                        me -> me.getValue().collect(toList())));
//        var expRead = expected.entrySet().stream()
//                .collect(Collectors.toMap(Map.Entry::getKey,
//                        me -> me.getValue().collect(toList())));
//
//        boolean isOk = outRead.keySet().equals(expRead.keySet())
//                && Objects.deepEquals(outRead, expRead);
//        System.out.println(isOk ? "OK" : "FAIL");
//        if (!isOk) {
//            outRead.forEach((k, v) -> System.out.printf("%s : %s%n", k, v));
//            System.out.println("^^^ GOT **************** EXPECTED vvv");
//            expRead.forEach((k, v) -> System.out.printf("%s : %s%n", k, v));
//        }
    }
}
