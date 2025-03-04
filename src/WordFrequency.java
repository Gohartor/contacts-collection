import java.util.*;

public class WordFrequency {

    public static void main(String[] args) {

        List<String> input = new ArrayList<>();
        input.add("apple");
        input.add("banana");
        input.add("apple");
        input.add("orange");
        input.add("banana");
        input.add("kiwi");
        input.add("apple");
        input.add("berry");



        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String s : input) {
            wordFrequency.put(s, wordFrequency.getOrDefault(s, 0) + 1);
        }
        System.out.println("Word Frequency: " + wordFrequency);



//        public static HashMap<String, Integer> getAuthorMap (Map<String, String> firstMap) {
//            HashMap<String, Integer> authorMap = new HashMap<>();
//            for (String author : firstMap.values()) {
//                authorMap.put(author, authorMap.containsKey(author) ? authorMap.get(author) + 1 : 1);
//            }
//            return authorMap;
//        }


        Map<Integer, List<String>> frequencyGroups = new HashMap<>();

        for (Map.Entry<String, Integer> element : wordFrequency.entrySet()) {
            int frequency = element.getValue();
            String word = element.getKey();

            List<String> list2 = frequencyGroups.getOrDefault(frequency, new ArrayList<>());

            list2.add(word);

            frequencyGroups.put(frequency, list2);
//            frequencyGroups.computeIfAbsent(frequency, k -> new ArrayList<>()).add(word);
        }

        System.out.println("Same Length: " + frequencyGroups);
    }
}