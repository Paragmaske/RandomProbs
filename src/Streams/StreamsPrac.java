package Streams;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsPrac {
    public static void main(String[] args) {
        List<Integer> li=List.of(1,2,3,4,5);
        Integer reduce = li.stream().reduce(2, (a, b) -> a + b);
        System.out.println(reduce);
        //li.stream().filter(a->a>2).forEach(System.out::println);

        List<String> lis=List.of("a","v","p","p");
        List<String> lis1=List.of("b","c","d");
        List<List<String>>  nes=List.of(lis,lis1);
        //nes.stream().flatMap(Collection::stream).forEach(System.out::print);

     //   nes.stream().flatMap(Collection::stream).sorted().forEach(System.out::print);

       // lis.stream().peek(a-> System.out.println(a)).map(String::toUpperCase).distinct().forEach(System.out::println);

      //  short circuit
        //allMatch  predicate
        //anyMatch noneMatch

    }

}
