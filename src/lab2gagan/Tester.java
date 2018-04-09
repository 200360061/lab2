/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2gagan;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String userID, Password;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter userID = ");
        userID = sc.nextLine();
        while (userID.isEmpty()) {
            System.out.println("User ID cannot be empty");
            System.out.print("Enter userID = ");
            userID = sc.nextLine();
        }
        System.out.print("Enter Password = ");
        Password = sc.nextLine();
        while (Password.length() < 5) {
            System.out.println("Password must contain 5 or more characters");
            System.out.print("Enter Pasword = ");
            Password = sc.nextLine();
        }
        User newUser=new User(userID,Password);
        System.out.println("Welcome user : " +newUser.getUserID());
        System.out.print("Enter Password Again to log in =");
        Password=sc.nextLine();
        while(!PasswordGenerator.getSHA512Password(Password, newUser.getSalt()).equals(newUser.getPassword()))
        {
            System.out.println("Wrong Password Entered");
        System.out.print("Enter Password Again to log in =");
        Password=sc.nextLine();
        }
        if(PasswordGenerator.getSHA512Password(Password, newUser.getSalt()).equals(newUser.getPassword()))
        {
            System.out.println(newUser.getUserID() + " : You are Logged in successfully");
        }
    }

}
