package contact;

import java.util.HashMap;
import java.util.HashSet;

public class Contacts {
    HashMap<String, Contact> contacts;



    public Contacts(Contact... contact) {
        contacts = new HashMap<>();
        for (Contact c : contact) {
            contacts.put(c.getName(), c);
        }
    }

    public void addContact(Contact... c) {
        for (Contact c1 : c) {
            if (contacts.containsKey(c1.getName())) {
                System.out.println("this contact ' " + c1.getName() + " ' already exists");
            } else {
                contacts.put(c1.getName(), c1);
            }
        }
    }

    //remove more contacts
//    public void removeContact(Contact... c) {
//        for (Contact c1 : c) {
//            if (!contacts.containsKey(c1.getName())) {
//                System.out.println("this contact ' " + c1.getName() + " ' does not exist");
//            } else {
//                contacts.remove(c1.getName());
//            }
//        }
//    }


    //remove one contact
    public void removeContact(String name) {
        for (Contact c : contacts.values()) {
            if (c.getName().equals(name)) {
                contacts.remove(c.getName());
                System.out.println("successfully removed contact -> " + name);
                break;
            }
        }
    }


    public void showAllContacts() {
        System.out.println("All contacts: ");
        for (Contact c : contacts.values()) {
            System.out.println(c.getName() + ": " + c.getNumbers());
        }
    }


    public Contact searchByName(String name) {
        for (Contact c : contacts.values()) {
            if (c.getName().contains(name)) {
                System.out.println(c.getName() + ": " + c.getNumbers());
                return c;
            }
        }
        System.out.println("not found contact for this name -> " + name);
        return null;
    }



    public boolean isExistsByName(String name) {
        for (Contact c : contacts.values()) {
            if (c.getName().contains(name)) {
                return true;
            }
        }
        System.out.println("not found contact for this name -> " + name);
        return false;
    }




    public void searchByNumber(String number) {

        for (Contact c : contacts.values()) {
            for (String num : c.getNumbers()) {
                if (num.contains(number)) {
                    System.out.println(c.getName() + ": " + c.getNumbers());
                    break;
                }
            }
        }
        System.out.println("not found contact for this number -> " + number);
    }



    public void editContactByName(String newName, String oldName) {
        Contact findContact = searchByName(oldName);
        if (findContact == null) {
            System.out.println("Contact not found for this name -> " + oldName);
        } else {
            findContact.setName(newName);
            System.out.println("Contact name updated successfully.");
        }
    }


    public void editContactByNumber(String newNumber, String oldNumber, String oldName) {
        Contact contact = searchByName(oldName);
        if (contact == null) {
            System.out.println("Contact not found for this name -> " + oldName);
        } else {
            HashSet<String> numbers = contact.getNumbers();

            if (!numbers.contains(oldNumber)) {
                System.out.println("Invalid number. The old number does not exist.");
            } else {
                numbers.remove(oldNumber);
                numbers.add(newNumber);
                System.out.println("Number updated successfully.");
            }
        }
    }


}
