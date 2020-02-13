import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Phone phone = new Phone();
        boolean run = true;
        getMenuSelection(phone, run);

    }

    public static void getMenuSelection(Phone phone, boolean run){
        while(run) {
            System.out.println("Please select one of the following options:");
            System.out.println("1. Show list of contacts");
            System.out.println("2. Add a new contact");
            System.out.println("3. Edit an existing contact");
            System.out.println("4. Remove a contact");
            System.out.println("5. Search for a contact");
            System.out.println("6. Quit");
            Scanner scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                int entry = scanner.nextInt();
                scanner.nextLine();

                switch (entry) {
                    case 1: {
                        phone.showContactList();
                        System.out.println("Anything else?");
                        break;
                    }
                    case 2: {
                        System.out.println("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter number:");
                        String number = scanner.nextLine();
                        boolean wasCreated = phone.createContact(name, number);
                        if (wasCreated) {
                            System.out.println("Contact was added.");
                        } else {
                            System.out.println("Contact with that name already exists.");
                        }
                        System.out.println("Anything else?");
                        break;
                    }
                    case 3: {
                        System.out.println("Name of contact whose number you want to edit?");
                        String contactToEdit = scanner.nextLine();
                        System.out.println("Enter the new number:");
                        String newNumber = scanner.nextLine();
                        boolean wasEdited = phone.editContact(contactToEdit, newNumber);
                        if (wasEdited) {
                            System.out.println("New contact information was saved.");
                        } else {
                            System.out.println("No contact with that name was found.");
                        }
                        System.out.println("Anything else?");
                        break;

                    }
                    case 4: {
                        System.out.println("Name of contact you would like to remove:");
                        String contactToRemove = scanner.nextLine();
                        boolean wasRemoved = phone.removeContact(contactToRemove);

                        if (wasRemoved) {
                            System.out.println("Contact successfully removed.");
                        } else {
                            System.out.println("No contact with that name was found.");
                        }
                        System.out.println("Anything else?");
                        break;
                    }
                    case 5: {
                        System.out.println("Name of contact you would like to search for?");
                        String nameToSearch = scanner.nextLine();
                        String searchResult = phone.findContact(nameToSearch);
                        System.out.println("Result: " + searchResult);
                        System.out.println("Anything else?");

                    }
                    case 6: {
                        System.out.println("Goodbye.");
                        run = false;
                        break;
                    }
                    default: {
                        System.out.println("Invalid entry. Please enter a number 1-6");

                    }
                }
            }
        }
    }
}
