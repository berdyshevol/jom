package com.softserve.sprint04.task3;

import java.util.List;
import java.util.Map;
public class MyUtils {
    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        for ( Map.Entry<String, String> entry : map.entrySet()) {
            if (!list.contains(entry.getValue())) return false;
        }
        return true;
    }
}
