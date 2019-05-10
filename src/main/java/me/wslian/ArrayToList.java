package me.wslian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayToList {
    public static void main(String[] args) {
        String[] arr = {"A", "B", "C"};
        List<String> list1 = new ArrayList<>(Arrays.asList(arr));
        List<String> list2 = new ArrayList<>(List.of(arr));
        List<String> list3 = List.of(arr);
        List<String> list4 = Stream.of(arr).collect(Collectors.toCollection(ArrayList::new));
        List<String> list5 = Stream.of(arr).collect(Collectors.toList());

        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
        System.out.println(list3.getClass());
        System.out.println(list4.getClass());
        System.out.println(list5.getClass());
    }
}
