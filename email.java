package emailapp;
import java.util.Scanner;

public class Email {
	
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "Mycompany.com";   
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("\nYour Password is: " + this.password);
 
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;       
    }   
    private String setDepartment() {
        System.out.print("New Worker: " + firstName + " " + lastName + "\n" + "\nDepartment Codes:\n1. Technical\n2  Admin\n3  Human Resource\n4. legal\n\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "Technical"; }
        else if (depChoice == 2) {return "Admin";}
        else if (depChoice == 3) {return "Human Resource";}
        else if (depChoice == 4) {return "legal";}
        else { return "";}
    }    
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!abcdefghijklmnopqrstuvwxyz@#$%";
        char [] password = new char[length];
        for (int i=0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    public void changePassword(String password) {
        this.password = password;
    }

   
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "."  ;
    }
}
