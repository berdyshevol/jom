package com.softserve.sprint04.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*public*/ class MyUtils {
    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
        Map<String, List<String>> result = new HashMap<>();
        for (Map.Entry<String, String> phone: phones.entrySet()) {
            if (result.containsKey(phone.getValue())) {
                result.get(phone.getValue()).add(phone.getKey());
            } else {
                result.put(
                        phone.getValue(),
                        new ArrayList<String>() {{add(phone.getKey());}}
                );
            }
        }
        return result;
    }
}

public class Task1 {
    public static void main(String[] args) {
        // smoke test
        Map<String, String> phones = new HashMap<String, String>() {{
            put("0967654321", "Petro");
            put("0677654321", "Petro");
            put("0501234567", "Ivan");
            put("0970011223", "Stephan");
            put("0631234567", "Ivan");
            put("bad", null);
            put(null, null);
        }};

        System.out.println(new MyUtils().createNotebook(phones));
        // {null=[null, bad], Ivan=[0501234567, 0631234567], Petro=[0967654321, 0677654321], Stepan=[0970011223]}
    }
}
