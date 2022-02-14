package de.shhn;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Anagrams {
    public void printAnagrams(String fileName){
        File file = new File(fileName);
        Path currentDir = Paths.get(".");

        Map<String, List<String>> map = new TreeMap<>();
        try (Stream<String> stream = Files.lines(Paths.get(String.valueOf(currentDir.toAbsolutePath()),fileName))) {
            stream.forEach(word->{
                char[] chArr= word.toLowerCase().toCharArray();
                Arrays.sort(chArr);
                String s = new String(chArr);
                if(map.containsKey(s)){
                    map.get(s).add(word);
                }else {
                    List<String> list = new ArrayList();
                    list.add(word);
                    map.put(s, list);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        map.forEach((key, value) -> {
            if (value.size()>1){
                System.out.println(Arrays.toString(value.toArray()).replace("[","").replace("]",""));
            }
        });
    }
}
