package me.wslian;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileToString {
    public static void main(String[] args) {
        String path = "Java12Test.iml";

        // Java 7
        try {
            List<String> content = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Java 8
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            String content = stream.collect(Collectors.joining(System.lineSeparator()));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Java 11
        try {
            String content = Files.readString(Paths.get(path));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Apache Common IO
        try {
            String content = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
