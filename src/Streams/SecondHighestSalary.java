package Streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondHighestSalary {
    public static void main(String[] args) {
        Map<String,Integer> hm=new HashMap<>();
        hm.put("a",1000);
        hm.put("b",100);
        hm.put("c",1220);
        hm.put("c1",1220);
        hm.put("a",3000);
        hm.put("a1",3000);

        Map.Entry<String, Integer> second = hm.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList())
                .get(1);

        System.out.println(second);

        Map.Entry<Integer, List<Map.Entry<String, Integer>>> answer = hm.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(1);
        System.out.println(answer);

        Map.Entry<Integer , List<String>> entries =  hm.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue ,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(1);
        System.out.println(entries);

    }
}
