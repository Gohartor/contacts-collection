import java.util.*;

public class DuplicateFinder {

    public static List<Integer> findDuplicates(List<Integer> nums) {

        Set<Integer> temp = new HashSet<>();

        //no diff between hashset and arraylist
        //Set<Integer> duplicates = new HashSet<>();

        List <Integer> duplicates = new ArrayList<>();

        for (Integer num : nums) {
            if (!temp.add(num)) {
                duplicates.add(num);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {

        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(3);
        input.add(4);
        input.add(5);

        System.out.println(input);
        System.out.println("list of duplicate: " + findDuplicates(input));
    }
}