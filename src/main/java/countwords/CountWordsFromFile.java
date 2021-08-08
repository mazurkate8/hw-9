package countwords;

import util.Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class CountWordsFromFile implements Parser {
    HashMap<String, Integer> countMap;

   public CountWordsFromFile(){
        countMap = new HashMap<>();
    }

    @Override
    public void parseFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            HashMap<String, Integer> tmpMap = new HashMap<>();
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] arr = line.split(" ");
                    for (String word : arr) {
                        int count = tmpMap.getOrDefault(word, 0);
                        tmpMap.put(word, count + 1);
                    }
                }
            }
            countMap = tmpMap
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(
                            toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2)-> e2, LinkedHashMap::new)
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Integer> getCountMap() {
        return countMap;
    }

    @Override
    public boolean isAcceptableLine(String line) {
        return false;
    }
}
