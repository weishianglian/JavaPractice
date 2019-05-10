package me.wslian;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamExample {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("A", "B", "C", "a", "b", "c");
        List<String> list = stream.filter(x -> !x.equalsIgnoreCase("B"))
                .collect(Collectors.toList());

        // no need to close the stream
        // stream.close()

        System.out.println(list);
    }
}
