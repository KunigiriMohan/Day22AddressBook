import java.util.*;

class AddressBookMain {

    private Map<String,Contact> person = new LinkedHashMap<>();             //Creating hashMap of the AddressBook
    /*
     * addContact() to add new created contacts to address book
     * */
    public void addContact(String name, Contact c) {
        person.put(name,c);
    }
    public void printCompanyDetails() {
        person.entrySet().stream().forEach(System.out::println);
    }

    /*
     * menu() method for showing options user has
     * */
    public static void menu()
    {
        System.out.println("Press 1 for Adding a new contact to your address book.");
        System.out.println("Press 2 for Editing Existing contact");
        System.out.println("Press 3 for Deleting Existing Contact");
        System.out.println("Press 4 for viewing the contacts present");
        System.out.println("Press 5 to Quit.");
    }

    /*
     * haveContacts() method to return index of particular person in person array
     * */
    int haveContact(String s) {
        for (int i = 0; i < person.size(); i++)
            if (person.containsKey(s))
                return i;

        return -1;
    }
    /*
     *editContact() to edit existing contacts
     **/
    public void editContact(String s) {
        Scanner inp = new Scanner(System.in);
        int place = haveContact(s);
        if (place >= 0) {

            System.out.println("Enter Last name");
            String lname = inp.next();
            System.out.println("Enter Phone Number");
            int phoneNumber = inp.nextInt();
            System.out.println("Enter City");
            String city = inp.next();
            System.out.println("Enter State");
            String state = inp.next();
            System.out.println("Enter Pin Code");
            int pinCode = inp.nextInt();

            Contact obj = new Contact(s, lname, phoneNumber, city, state, pinCode);


            person.replace(s,obj);
        } else if (place == -1) ;
        {
            System.out.println("\nFirst Name Not Match\n");
        }
    }

    /**
     * method for deleting contacts
     */
    public void deleteContact(String s) {
        int place = haveContact(s);
        if (place >= 0)
            person.remove(place);
    }

    /*
     * Mian function of class
     * */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        AddressBookMain obj = new AddressBookMain();
        menu();
        int choice = inp.nextInt();
        while (choice != 5) {

            if (choice == 1) {
                System.out.println("Enter First Name:");
                String fName = inp.next();
                if (obj.person.containsKey(fName)==true)            //Checking contact is present in the Address book or not
                {
                    System.out.println("Contact already present");
                }
                else
                {
                    System.out.println("Enter Last NAme");
                    String lName = inp.next();
                    System.out.println("Enter  phone number.");
                    int number = inp.nextInt();
                    System.out.println("Enter The City");
                    String city = inp.next();
                    System.out.println("Enter The State");
                    String state = inp.next();
                    System.out.println("Enter the pin code");
                    int pinCode = inp.nextInt();

                    obj.addContact(fName, new Contact(fName, lName, number, city, state, pinCode));
                }

            } else if (choice == 2) {

                System.out.println("Enter the First Name of the contact you want to edit?");
                String fName = inp.next();
                obj.editContact(fName);
            } else if (choice == 3) {
                System.out.println("What is the First name of the contact you want to delete?");
                String fName = inp.next();
                obj.deleteContact(fName);
            } else if (choice == 4) {
                obj.printCompanyDetails();
            }
            menu();
            choice = inp.nextInt();
        }
    }
}
