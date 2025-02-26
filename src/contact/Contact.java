package contact;

import java.util.Arrays;
import java.util.HashSet;


public class Contact {
    String name;
    HashSet<String> numbers;


    Contact(String name, String... numbers) {
        this.name = name;
        this.numbers = new HashSet<>();
        this.numbers.addAll(Arrays.asList(numbers));
    }


    public String getName() {
        return name;
    }



    public HashSet<String> getNumbers() {
        return numbers;
    }



    public void addNumbers(String... numbers) {
        for (String number : numbers) {
            if (this.numbers.contains(number)) {
                System.out.println("your number -> ' " + number + " ' is already exist for " + this.name);
            } else {
                this.numbers.add(number);
            }
        }
    }

    public void removeNumbers(String... numbers) {
        for (String number : numbers) {
            if (this.numbers.contains(number)) {
                this.numbers.remove(number);
            } else {
                System.out.println("your number -> ' " + number + " ' is not exist for " + this.name);
            }
        }
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setNumbers(HashSet<String> numbers) {
        this.numbers = numbers;
    }
}
