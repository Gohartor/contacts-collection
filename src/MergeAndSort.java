import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;


public class MergeAndSort {

    public static ArrayList<Integer> sortTwoList(ArrayList<Integer> list1, ArrayList<Integer> list2) {

        Set<Integer> mergedList = new TreeSet<>();

        mergedList.addAll(list1);
        mergedList.addAll(list2);


        // estefade az tree set
        // bug in ravesh pak kardan data tekrari hast

        return new ArrayList<>(mergedList);
    }

    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        System.out.println("list1: " + list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1+1);
        list2.add(3+1);
        list2.add(5+1);


        System.out.println("list2: " + list2);

        System.out.println("Merged list (list1 + list2): " + MergeAndSort.sortTwoList(list1, list2));

    }
}
