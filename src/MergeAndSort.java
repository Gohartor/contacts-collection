import java.util.ArrayList;
import java.util.Collections;


public class MergeAndSort {

    public static ArrayList<Integer> sortTwoList(ArrayList<Integer> list1, ArrayList<Integer> list2) {

        ArrayList<Integer> mergedList = new ArrayList<>();

        mergedList.addAll(list1);
        mergedList.addAll(list2);
        Collections.sort(mergedList);

        return mergedList;
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
