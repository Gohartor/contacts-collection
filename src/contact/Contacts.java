package contact;

import java.util.Arrays;
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


    public void removeContact(Contact... c) {
        for (Contact c1 : c) {
            if (!contacts.containsKey(c1.getName())) {
                System.out.println("this contact ' " + c1.getName() + " ' does not exist");
            } else {
                contacts.remove(c1.getName());
            }
        }
    }


    public void showAllContacts() {
        System.out.println("All contacts: ");
        for (Contact c : contacts.values()) {
            System.out.println(c.getName() + ": " + c.getNumbers());
        }
    }


    public Contact  searchByName(String name) {
        boolean found = false;
        for (Contact c : contacts.values()) {
            if (c.getName().contains(name)) {
                System.out.println(c.getName() + ": " + c.getNumbers());
                return c;
            }
        }
        System.out.println("not found contact for this name -> " + name);
        return null;
    }




    public Contact searchByNumber(String number) {
        for (Contact c : contacts.values()) {
            for (String num : c.getNumbers()) {
                if (num.contains(number)) {
                    System.out.println(c.getName() + ": " + c.getNumbers());
                    return c;
                }
            }
        }
        System.out.println("not found contact for this number -> " + number);
        return null;
    }



    public void editContactByName(String newName, String oldName) {
        Contact contact = searchByName(oldName);
        if (contact != null) {
            contact.setName(newName);
            System.out.println("successfully edited contact -> " + newName);
        }
    }


    public void editContactByNumber(String newNumber, String oldNumber, String oldName) {
        Contact contact = searchByName(oldName);
        if (contact != null) {
            contact.setName(contact.getName());
            contact.removeNumbers(oldNumber);
            contact.addNumbers(newNumber);
            System.out.println("successfully edited contact -> " + newNumber);
        }
    }


}
