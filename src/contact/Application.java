package contact;

import java.util.*;

public class Application {
    public static void main(String[] args) {

//        Contacts listOfContacts = new Contacts();
//
//        Contact c = new Contact("ali", "0912", "0937", "0921");
//
//
//        c.addNumbers("0910");
//        c.addNumbers("0921");
//        c.removeNumbers("0910", "0937");
//
//        System.out.println(c.getName());
//        System.out.println(c.getNumbers());
//
//        Contact c1 = new Contact("hasan", "09121", "09371", "09211");
//        Contact c2 = new Contact("naqi", "09122");
//
//        Contact c3 = new Contact("hasan", "09121");
//
//        listOfContacts.addContact(c, c1, c2, c3);
//
//        listOfContacts.showAllContacts();
//
//        listOfContacts.removeContact(c2);
//        listOfContacts.showAllContacts();
//
//
//        System.out.println("search by name: ");
//        listOfContacts.searchByName("ali");
//
//
//        System.out.println("search by number: ");
//        listOfContacts.searchByNumber("9121");
//
//
//        System.out.println("edit by name: ");
//        listOfContacts.editContactByName("alimohammad", "ali");
//
//
//        System.out.println("edit by number: ");
//        listOfContacts.editContactByNumber("09211", "0921111", "hasan");


        menuItem();

        Scanner input = new Scanner(System.in);
        Contacts contacts = new Contacts();

        boolean run = true;
        while (run) {

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("enter name");
                    String name = input.nextLine();
                    System.out.println("enter numbers (example: 0912,0937,0925)");
                    String numbers = input.nextLine();
                    List<String> seperated = new ArrayList<>(Arrays.asList(numbers.split(",")));
                    contacts.addContact(new Contact(name, String.valueOf(seperated)));
                    System.out.println("successfully added contact -> name: " + name + " , numbers: " + seperated);
                    menuItem();
                }
                case 2 -> {
                    System.out.println("enter name for remove");
                    String name = input.nextLine();
                    contacts.removeContact(name);
                    menuItem();
                }
                case 3 -> {

                    System.out.println("""
                            ***SEARCH***
                            1) by name
                            2) by number
                            
                            9) back to menu
                            """);

                    int choice02 = input.nextInt();
                    input.nextLine();

                    switch (choice02) {
                        case 1 -> {
                            System.out.println("enter name");
                            String name = input.nextLine();
                            contacts.searchByName(name);
                            menuItem();
                        }
                        case 2 -> {
                            System.out.println("enter number");
                            String number = input.nextLine();
                            contacts.searchByNumber(number);
                            menuItem();
                        }
                        case 9 -> {
                            menuItem();
                            break;

                        }
                        default -> System.out.println("Invalid option. Please try again.");
                    }
                }
                case 4 -> {
                    if (contacts.contacts.isEmpty()) {
                        System.out.println("contact list is empty");
                    } else {
                        contacts.showAllContacts();
                    }
                    menuItem();
                }
                case 5 -> {
                    System.out.println("enter name for edit");
                    String oldName = input.nextLine();
                    if (!contacts.isExistsByName(oldName)) {
                        System.out.println("contact not found");
                    } else {
                        System.out.println("find contact by name: " + oldName);

                        System.out.println("""
                                ***EDIT CONTACT***
                                
                                1) name
                                2) number
                                
                                9) back to menu
                                """);

                        int choice02 = input.nextInt();
                        input.nextLine();

                        switch (choice02) {
                            case 1 -> {
                                System.out.println("Enter new name:");
                                String newName = input.nextLine();
                                contacts.editContactByName(newName, oldName);
                                Contact find = contacts.searchByName(oldName);
                                System.out.println(find.getName() + " :" + find.getNumbers());
                                menuItem();
                            }
                            case 2 -> {
                                Contact find = contacts.searchByName(oldName);
                                if (find == null) {
                                    System.out.println("Contact not found.");
                                } else {
                                    System.out.println(find.getName() + " : " + find.getNumbers());

                                    System.out.println("Enter old number:");
                                    String oldNumber = input.nextLine().trim();

                                    System.out.println("Enter new number:");
                                    String newNumber = input.nextLine().trim();

                                    contacts.editContactByNumber(newNumber, oldNumber, oldName);
                                }
                                menuItem();
                            }
                            case 9 -> {
                                    menuItem();
                                break;
                            }

                            default -> System.out.println("Invalid option. Please try again.");
                        }
                    }


                }
                case 0 -> {
                    run = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void menuItem() {
        System.out.println("""
                ****MENU****
                1) add new contact
                2) remove contact
                3) search contact
                4) show all contact
                5) edit contact
                
                0) exit
                """);
    }
}
