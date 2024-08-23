package Codelit;

import java.util.List;
import java.util.Optional;

public class wa {
    public static void main(String[] args) {
        List<Integer> l= List.of(1,2,3,4,5,6);
        l.stream().filter(a->a%2!=0).reduce(Integer::sum);
    }

}
