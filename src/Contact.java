//package Line_Conversion;
public class Contact {

    private int phonenumber; // Stores phone number of contact
    private String fName;
    private String lName;
    private String city;
    private String state;
    private int pinCode;

    public Contact(String firstName, String lastName,  int phoneNumber ,String c,String s,int pn) {
        fName = firstName;
        lName=lastName;
        city=c;
        phonenumber = phoneNumber;
        state=s;
        pinCode=pn;

    }
    public String getCity() {
        return city;
    }
    public String getState(){
        return state;
    }

    public int getNumber(int newnum) {
        return phonenumber;
    }
    public String getfName() {
        return fName;
    }
    public String getlName() {
        return lName;
    }

    public int getNumber() {
        return phonenumber;
    }
    public void setLastName(String lName) {
        this.lName = lName;
    }


    public String toString() {
        return  " Name: " + fName + " Last Name: "+lName+" Phone#: " + phonenumber+" City: "+city+" State: "+state +" Pin Code: "+pinCode ;
    }
}