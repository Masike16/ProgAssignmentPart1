/**
*Student Name: Masike Rasenyalo
* Student Number: ST10452404
*/
package login;

import java.util.Scanner;


public class Login {

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*()_+].*");
    }

    
    public String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        } else if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        } else {
            this.username = username;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
            return "Username successfully captured. Password successfully captured.";
        }
    }

   
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

   
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again";
        }
    }

   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login();

        System.out.println("Welcome to the login and registration system.");
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Create a username (with an underscoore, and 5 characters): ");
        String username = scanner.nextLine();
        System.out.print("Create a password (1 uppercase, 8 characters, 1 number, 1 special character): ");
        String password = scanner.nextLine();

        String registrationResult = loginSystem.registerUser(username, password, firstName, lastName);
        System.out.println(registrationResult);

        if (registrationResult.contains("successfully captured")) {
            System.out.println("Registration successful.");
            System.out.print("Username: ");
            String loginUsername = scanner.nextLine();
            System.out.print("Password: ");
            String loginPassword = scanner.nextLine();

            boolean loginSuccess = loginSystem.loginUser(loginUsername, loginPassword);
            System.out.println(loginSystem.returnLoginStatus(loginSuccess));
        }

        scanner.close();
    }
}