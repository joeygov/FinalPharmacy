/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akongpharmacy;

import java.util.Scanner;

/**
 *
 * @author destacamento_sd2022
 */
public class PHARMACYPROCESS extends Accounts {

    Accounts r;

    Scanner input = new Scanner(System.in);
    //  Accounts users = new Accounts();
    MedicineList tambals = new MedicineList();

    public PHARMACYPROCESS() {
        r = new Accounts();
    }

    public PHARMACYPROCESS(String name, String userName, int age, String password) {
        super(name, userName, age, password);
    }

    public Accounts getR() {
        return r;
    }

    public void setR(Accounts r) {
        this.r = r;
    }

    public void greet() {
        System.out.println("Hi " + r.getUserName() + " how can I help you?\n");

    }

    public int setInt(String label) {
        System.out.println(label + ": ");
        int result = input.nextInt();
        return result;
    }

    public String setString(String label) {
        System.out.println(label + ": ");
        String result = input.nextLine();
        return result;
    }

    public String setStringWithSpace(String label) {
        System.out.println(label + " : ");
        String result = input.next();
        return result;
    }

    public void AddMedicine() {
        System.out.println("\n*************************************************ADD MEDICINE****************************************************************************\n");
        System.out.println("\nTO ADD MEDICINE\nTYPE 'COUGH' FOR COUGH MEDICINE\nTYPE 'PAIN' FOR PAIN MEDICINE\nTYPE 'ALLERGIES' FOR ALLERGIES MEDICINE");
        String result = this.setStringWithSpace("");
        String brandName = this.setStringWithSpace("Brand Name");
        String genericName = this.setStringWithSpace("Generic Name");
        String dossage = this.setStringWithSpace("Dossage");
        String description = this.setStringWithSpace("Description");
        int price = this.setInt("Price");
        int quantity = this.setInt("Quantity");
        Medicine e = new Medicine(brandName, genericName, dossage, description, price, quantity);
        if (result.equalsIgnoreCase("cough")) {
            tambals.cough.add(e);
        }
        if (result.equalsIgnoreCase("allergies")) {
            tambals.allergies.add(e);
        }
        if (result.equalsIgnoreCase("pain")) {
            tambals.pain.add(e);
        }
    }

    public void removeMed() {
        System.out.println("\n**************************************************REMOVE MEDICINE**********************************************************************\n");
        System.out.println("\nTO DELETE MEDICINE\nTYPE 'COUGH' FOR COUGH MEDICINE\nTYPE 'PAIN' FOR PAIN MEDICINE\nTYPE 'ALLERGIES' FOR ALLERGIES MEDICINE\n");
        String result = this.setStringWithSpace("\nTYPE OF MEDICINE TO BE REMOVE: ");
        String name = this.setStringWithSpace("NAME OF MEDICINE: ");
        if (result.equalsIgnoreCase("cough")) {
            for (int i = 0; i < tambals.cough.size(); ++i) {
                if (tambals.cough.get(i).getBrandName().equalsIgnoreCase(name)) {
                    tambals.cough.remove(tambals.cough.get(i));
                }
            }
        }
        if (result.equalsIgnoreCase("allergies")) {
            for (int i = 0; i < tambals.allergies.size(); ++i) {
                if (tambals.allergies.get(i).getBrandName().equalsIgnoreCase(name)) {
                    tambals.allergies.remove(tambals.allergies.get(i));
                }
            }
        }
        if (result.equalsIgnoreCase("pain")) {
            for (int i = 0; i < tambals.pain.size(); ++i) {
                if (tambals.pain.get(i).getBrandName().equalsIgnoreCase(name)) {
                    tambals.pain.remove(tambals.pain.get(i));
                }
            }
        }
    }

    public void addAllMed() {
        tambals.addMedicine();

    }

    public void searchMedicinePharmacists() {
        System.out.println("\n*****************************************************************SEARCH MEDICINE*****************************************************\n");
        System.out.println(" PRESS 1 to VIEW ALL MEDICINE\n PRESS 2 TO VIEW PAIN MEDICINES\n PRESS 3 TO VIEW COUGH MEDICINE\n PRESS 4 TO VIEW ALLERGIES MEDICINE\n\n");
        System.out.println("ENTER NUMBER: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                tambals.showAllMedicineToPharmacists();
                break;
            case 2:
                tambals.showPainMedicineToAdmin();
                break;
            case 3:
                tambals.showCoughMedicineToAdmin();
                break;
            case 4:
                tambals.showAllergiesMedicineToAdmin();
                break;
            default:
                System.out.println("INVALID INPUT!");
        }
    }

    public void searchMedicineCustomer() {
        System.out.println("\n*****************************************************************SEARCH MEDICINE****************************************************\n");
        System.out.println(" PRESS 1 to VIEW ALL MEDICINE\n PRESS 2 TO VIEW PAIN MEDICINES\n PRESS 3 TO VIEW COUGH MEDICINE\n PRESS 4 TO VIEW ALLERGIES MEDICINE\n\n");
        System.out.println("ENTER NUMBER: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                tambals.showAllMedicineToCustomer();
                break;
            case 2:
                tambals.showPainMedicineToCustomer();
                break;
            case 3:
                tambals.showCoughMedicineToCustomer();
                break;
            case 4:
                tambals.showAllergiesMedicineToCustomer();
                break;
            default:
                System.out.println("INVALID INPUT!");
        }

    }

    public void purchaseMedicine(String user) {
        System.out.println("\n*****************************************************************PLACE YOUR ORDER***************************************************\n");
        tambals.purchasingKindsOfMedicine();
        //tambals.printOrders();
    }

}
