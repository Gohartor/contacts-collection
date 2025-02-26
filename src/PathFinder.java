import java.util.*;

class PathFinder {
    public static void main(String[] args) {




        // state 01 ----------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        System.out.println("write your input, for example(8,9|9,4|4,7 ... ) : ");
        String input = sc.nextLine();

        List<String> step1 = new ArrayList<>(Arrays.asList(input.split("\\|")));

        List<Integer> nums = new LinkedList<>();

        for (String pair : step1) {
            List<String> step2 = new ArrayList<>(Arrays.asList(pair.split(",")));

            nums.add(Integer.parseInt(step2.getFirst()));
        }

        System.out.println("nums: " + nums);







        // state 02 ----------------------------------------------------------------

/*        Scanner sc = new Scanner(System.in);

        System.out.println("write your input, for example(8,9|9,4|4,7 ... ) : ");
        String input = sc.nextLine();

        List<String> step1 = new ArrayList<>(Arrays.asList(input.split("\\|")));

        Set<Integer> nums = new HashSet<>();


        for (String pair : step1) {
            List<String> step2 = new ArrayList<>(Arrays.asList(pair.split(",")));
            nums.add(Integer.parseInt(step2.get(0)));
            nums.add(Integer.parseInt(step2.get(1)));
        }


        LinkedList<Integer> linkedList = new LinkedList<>(nums);

        System.out.println("linkedList: " + linkedList);
        System.out.println(linkedList.get(2));
        linkedList.remove(2);
        System.out.println(linkedList);*/


    }
}
