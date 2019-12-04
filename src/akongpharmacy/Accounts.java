/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akongpharmacy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author destacamento_sd2022
 */
public class Accounts extends Users {

    Scanner input = new Scanner(System.in);
    static List<Users> users;

    public Accounts() {
       users = new ArrayList<>();
    }

    public Accounts(String name, String userName, int age, String password) {
        super(name, userName, age, password);
    }

    public static List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
    

    public void register() {
        System.out.println("************************************************************REGISTRATION FORM*************************************************************");

        System.out.println("NAME: ");
        String name = input.next();
        super.setName(name);

        System.out.println("USERNAME: ");
        String username = input.next();
        super.setUserName(username);

        System.out.println("AGE: ");
        int edad = input.nextInt();
        super.setAge(edad);
        while (super.getAge() < 18) {
            System.out.println("MINORS ARE NOT ALLOWED!");
            System.out.println("AGE: ");
            edad = input.nextInt();
            super.setAge(edad);
        }
        
        System.out.println("PASSWORD: ");
        String password = input.next();
        super.setPassword(password);
        this.users.add(new Users(super.getName(), super.getUserName(), super.getAge(), super.getPassword()));
    }

    public void logIn() {
        System.out.println("***************************************************************WELCOME TO AKONGPHARMACY****************************************************");
        System.out.println();
        System.out.println("USERNAME: ");
        String username = input.next();

        for (Users tao : this.users) {
            if(tao.getUserName() == " "){
                System.out.println("YOU DON'T HAVE AN ACCOUNT YET!");
            }
            if (tao.getUserName().equals(username)) {
                System.out.println("PASSWORD: ");
                String password = input.next();
                if (tao.getPassword().equals(password)) {
                    System.out.println("SUCCESSFULLY LOGIN!");
                } else {
                    System.out.println("PASSWORD INCORRECT! ");
                }
            } else {
                System.out.println("USERNAME NOT AVAILABLE!");
            }
        }
    }

}
