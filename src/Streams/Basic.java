package Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Basic {
    public static void main(String[] args) {
        List<Integer> l= List.of(1,2,3,4,5,1,1);



        List<Integer> collect = l.stream().
                collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting())).

                entrySet().stream().filter(a -> a.getValue() == 1).map(b -> b.getKey()).collect(Collectors.toList());
        System.out.println(collect.get(0));
        HashSet<Integer> hset  = new HashSet<>();
        l.stream().filter(x-> !hset.add(x)).collect(Collectors.toList());
    }

}
