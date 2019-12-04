/*
 * To change this license headcougher, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akongpharmacy;

import java.util.Scanner;

/**
 *
 * @author destacamento_sd2022
 */
public class MYPHARMACYAPP {

    public static void main(String[] args) {
        Accounts r = new Accounts();
        PHARMACYPROCESS process = new PHARMACYPROCESS();
        process.addAllMed();
        Scanner input = new Scanner(System.in);
        String pharma = "admin";
        boolean flag = false;
        String user;

       

        while (true) {
            System.out.println("\nPRESS 1 TO REGISTER\nPRESS 2 TO LOGIN\n");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    r.register();
                    break;
                case 2:
                    flag = true;
                    System.out.println("***************************************************************WELCOME TO AKONGPHARMACY****************************************************");
                    System.out.println("USERNAME: ");
                    while (flag == true) {
                        //System.out.println("USERNAME: ");
                        String username = input.nextLine();
                        if (username.equals(pharma)) {
                            System.out.print("Password: ");
                            String pass = input.nextLine();
                            if (pharma.equals(pass)) {
                                System.out.println("\nWelcome Pharmacist!");
                                while (flag == true) {
                                    System.out.println("\n[1] SEARCH MEDICINE\n[2] ADD MEDICINE\n[3] DELETE MEDICINE \n[4] LOGOUT\n");
                                    choice = input.nextInt();
                                    switch (choice) {
                                        case 1:
                                            process.searchMedicinePharmacists();
                                            break;
                                        case 2:
                                            process.AddMedicine();
                                            break;
                                        case 3:
                                            process.removeMed();
                                            break;
                                        case 4:
                                            flag = false;
                                            break;
                                        default:
                                            System.out.println("Invalid!");
                                    }
                                }
                            }
                        } else {
                            for (Users tao : r.users) {
                                if (tao.getUserName().equals(username)) {
                                    System.out.println("PASSWORD: ");
                                    String password = input.nextLine();
                                    if (tao.getPassword().equals(password)) {
                                        System.out.println("SUCCESSFULLY LOGIN!");
                                        user = username;
                                        while (flag) {
                                            System.out.println("\n[1] Search Medicine\n[2] Purchase\n[3] Logout");
                                            choice = input.nextInt();
                                            switch (choice) {
                                                case 1:
                                                    process.searchMedicineCustomer();
                                                    break;
                                                case 2:
                                                    process.purchaseMedicine(user);
                                                    break;
                                                case 3:
                                                    flag = false;
                                                    break;
                                                default:
                                                    System.out.println("INVALID INPUT!!!");
                                            }
                                        }

                                    } else {
                                        System.out.println("PASSWORD INCORRECT! ");
                                    }

                                }
                            }
                        }

                    }
                    break;
                default:
                    System.out.println("NOT AN OPTION!");
            }

        }
    }

}
