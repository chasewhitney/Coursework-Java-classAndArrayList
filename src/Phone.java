import java.util.ArrayList;

public class Phone {
    private ArrayList<Contact> contacts;

    public Phone(){
        this.contacts = new ArrayList<Contact>();
    }

    public void showContactList(){
        ArrayList<Contact> contacts = this.getContacts();
        this.displayContacts(contacts);
    }

    public boolean createContact(String name, String number) {
        return this.verifyAndAddContact(name, number);
    }

    public boolean editContact(String name, String number) {
        return this.verifyAndEditContact(name, number);
    }

    public boolean removeContact(String name) {
        int index = getContactIndex(name);
        if(index == -1) return false;

        this.contacts.remove(index);
        return true;
    }

    public String findContact(String name) {
        return this.findContactByName(name);
    }

    private String findContactByName(String name){
        int index = getContactIndex(name);
        if(index == -1) return "No contact with that name was found.";

        Contact contact = this.contacts.get(index);
        return contact.getName() + " - " + contact.getNumber();
    }

    private boolean verifyAndEditContact(String name, String number) {
        int index = getContactIndex(name);
        if(index == -1) return false;

        Contact contact = this.contacts.get(index);
        contact.setNumber(number);
        return true;
    }

    private ArrayList<Contact> getContacts() {
        return contacts;
    }

    private int getContactIndex(String name) {
        for( Contact c : this.contacts) {
            if( c.getName().equals(name)) {
                return this.contacts.indexOf(c);
            }
        }
        return -1;
    }

    private boolean verifyAndAddContact(String name, String number) {
        int index = getContactIndex(name);
        if(index != -1) return false;

        this.contacts.add(new Contact(name, number));
        return true;
    }

    private void displayContacts(ArrayList<Contact> contacts){
        if(contacts.size() < 1) {
            System.out.println("No contacts to show.");
        } else {
            for(int i = 0; i < contacts.size(); i++) {
                Contact c = contacts.get(i);
                System.out.println(c.getName() + " - " + c.getNumber());
            }
        }
    }

}
