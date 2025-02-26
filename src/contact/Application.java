package contact;

public class Application {
    public static void main(String[] args) {

        Contacts listOfContacts = new Contacts();

        Contact c = new Contact("ali", "0912", "0937", "0921");


        c.addNumbers("0910");
        c.addNumbers("0921");
        c.removeNumbers("0910", "0937");

        System.out.println(c.getName());
        System.out.println(c.getNumbers());

        Contact c1 = new Contact("hasan", "09121", "09371", "09211");
        Contact c2 = new Contact("naqi", "09122");

        Contact c3 = new Contact("hasan", "09121");

        listOfContacts.addContact(c, c1, c2, c3);

        listOfContacts.showAllContacts();

        listOfContacts.removeContact(c2);
        listOfContacts.showAllContacts();


        System.out.println("search by name: ");
        listOfContacts.searchByName("ali");


        System.out.println("search by number: ");
        listOfContacts.searchByNumber("9121");


        System.out.println("edit by name: ");
        listOfContacts.editContactByName("alimohammad", "ali");


        System.out.println("edit by number: ");
        listOfContacts.editContactByNumber("09211", "0921111", "hasan");









    }
}
