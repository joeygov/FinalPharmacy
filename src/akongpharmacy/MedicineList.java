/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akongpharmacy;

import static akongpharmacy.Accounts.users;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author destacamento_sd2022
 */
public class MedicineList {

    Accounts r;
    List<Medicine> cough = new ArrayList<>();
    List<Medicine> pain = new ArrayList<>();
    List<Medicine> allergies = new ArrayList<>();
    List<Medicine> orders = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    int qty = 0;
    List<Double> quant = new ArrayList<>();

    public MedicineList() {
        r = new Accounts();
    }

    public Accounts getR() {
        return r;
    }

    public void setR(Accounts r) {
        this.r = r;
    }

    public void addMedicine() {
        this.allergies.add(new Medicine("Alerta", "antihistamine", "2 tablet", "tablet", 5, 10000));
        this.allergies.add(new Medicine("Benadryl", "antihistamine diphenhydramine ", "1 tablet", "tablet", 7, 10000));
        this.allergies.add(new Medicine("Chlor-Trimeton", "antihistamine", "1 tablet", "tablet", 6, 10000));
        this.allergies.add(new Medicine("Zyrtic", "antihistamine", "3 tablet", "tablet", 3, 10000));
        this.allergies.add(new Medicine("Claritin", "antihistamine", "1 tablet", "microtablet", 5, 10000));
        this.cough.add(new Medicine("Plemix", "Plemix Forte", "2x a day", "Dextromethorphan HCL", 5, 10000));
        this.cough.add(new Medicine("Tusiran", "Dextromethorphan HCL", "3x a day", "capsule", 7, 10000));
        this.cough.add(new Medicine("Solmux", "Dextromethorphan +", "4x a day", "capsule/syrup", 6, 10000));
        this.cough.add(new Medicine("Ambroxsol", "Dextromethorphan", "2x a day", "tablet/syrup", 3, 10000));
        this.cough.add(new Medicine("Benadryl", "diphenhydramine systemic", "4x a day", "capsule", 5, 10000));
        this.pain.add(new Medicine("Norco", "acetaminophen / hydrocodone systemic", "2 x a day", "capsule/liquid gel", 5, 10000));
        this.pain.add(new Medicine("Gabapentin", "gabapentin systemic", "2x a day", "syrup", 7, 10000));
        this.pain.add(new Medicine("Vicodin", "acetaminophen / hydrocodone systemic", "3x a day", "tablet", 6, 10000));
        this.pain.add(new Medicine("Celebrix", "celecoxib systemic", "3x a day", "capsule", 3, 10000));
        this.pain.add(new Medicine("OxyContin", " oxycodone systemic", "4x a day", "tablet", 5, 10000));
    }

    public void purchasingKindsOfMedicine() {
        boolean purchase = true;
        System.out.println("\n\nTYPE 'COUGH' FOR COUGH MEDICINE\nTYPE 'PAIN' FOR PAIN MEDICINE\nTYPE 'ALLERGIES' FOR ALLERGIES MEDICINE\nTYPE 'EXIT' TO EXIT\n");
        System.out.println("CHOICE: ");
        while (purchase == true) {  
            String para = input.nextLine();
            if ("cough".equals(para.toLowerCase())) {
                this.purchasingCoughMedicine();
            }
            if ("allergies".equals(para.toLowerCase())) {
                this.purchasingAllergiesMedicine();
            }
            if ("pain".equals(para.toLowerCase())) {
                this.purchasingPainMedicine();
            }
            if ("exit".equalsIgnoreCase(para.toLowerCase())) {
                purchase = false;
            }

        }
    }

    public int setInt(String label) {
        System.out.println(label + " : ");
        int result = input.nextInt();
        return result;
    }

    public String setString(String label) {
        System.out.println(label + " : ");
        String result = input.nextLine();
        return result;
    }

    public void purchasingCoughMedicine() {
        int tambal = 0;
        boolean status = true;
        while (status == true) {
            System.out.println("Enter Medicine Name: ");
            String kind = input.next();
            for (Medicine ubo : this.cough) {
                if (ubo.getBrandName().equalsIgnoreCase(kind)) {
                    qty = this.setInt("QUANTITY: ");
                    quant.add(ubo.getPrice() * qty);
                    tambal = ubo.getQuantity() - qty;
                    ubo.setQuantity(tambal);
                    //                   System.out.println(ubo);
//                    String brandName, String genericName, String dossage, String description, double price, int quantity
                    this.orders.add(new Medicine(ubo.getBrandName(), ubo.getGenericName(), ubo.getDossage(), ubo.getDescription(), ubo.getPrice(), qty));
                    System.out.format("%20s %40s %15s %15s %15s\n", ubo.getBrandName(), ubo.getGenericName(), ubo.getPrice(), qty, qty * ubo.getPrice());
                    System.out.println("ADD MORE MEDICINE ? y/n : ");
                    String ans = input.next();
                    if (ans.equalsIgnoreCase("n")) {
                        status = false;
                        printOrders();
                    }
                }

            }
        }
    }

    public double total() {
        double total = 0;
        for (double e : this.quant) {
            total += e;
        }
        return total;
    }

    public void purchasingPainMedicine() {
        int tambal = 0;
        boolean status = true;
        while (status == true) {
            System.out.println("Enter Medicine Name: ");
            String kind = input.next();
            for (Medicine sakit : this.pain) {
                if (sakit.getBrandName().equalsIgnoreCase(kind)) {
                    qty = this.setInt("QUANTITY: ");
                    this.quant.add(sakit.getPrice() * qty);
                    tambal = sakit.getQuantity() - qty;
                    sakit.setQuantity(tambal);
                    //                   System.out.println(sakit);
//                    String brandName, String genericName, String dossage, String description, double price, int quantity
                    this.orders.add(new Medicine(sakit.getBrandName(), sakit.getGenericName(), sakit.getDossage(), sakit.getDescription(), sakit.getPrice(), qty));
                    System.out.format("%20s %40s %15s %15s %15s\n", sakit.getBrandName(), sakit.getGenericName(), sakit.getPrice(), qty, qty * sakit.getPrice());
                    System.out.println("ADD MORE MEDICINE ? y/n : ");
                    String ans = input.next();
                    if (ans.equalsIgnoreCase("n")) {
                        status = false;
                         printOrders();
                    }
                }
            }
        }
    }

    public void purchasingAllergiesMedicine() {
        int tambal = 0;
        boolean status = true;
        while (status == true) {
            System.out.println("Enter Medicine Name: ");
            String kind = input.next();
            for (Medicine katol : this.allergies) {
                if (katol.getBrandName().equalsIgnoreCase(kind)) {
                    qty = this.setInt("QUANTITY: ");
                    quant.add(katol.getPrice() * qty);
                    tambal = katol.getQuantity() - qty;
                    katol.setQuantity(tambal);
//                    System.out.println(katol);
//                    String brandName, String genericName, String dossage, String description, double price, int quantity
                    this.orders.add(new Medicine(katol.getBrandName(), katol.getGenericName(), katol.getDossage(), katol.getDescription(), katol.getPrice(), qty));
                    System.out.format("%20s %40s %15s %15s %15s\n", katol.getBrandName(), katol.getGenericName(), katol.getPrice(), qty, qty * katol.getPrice());
                    System.out.println("ADD MORE MEDICINE ? y/n : ");
                    String ans = input.next();
                    if (ans.equalsIgnoreCase("n")) {
                        status = false;
                         printOrders();
                    }
                }

            }
        }
    }

    public void printOrders() {
        double amount = total();
        double discount = amount * .20;
        System.out.println("YOUR ORDERS!\n");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.format("%20s %40s %15s %20s %10s\n", "ITEM NAME", "GENERIC NAME", "UNIT PRICE", "QUANTITY", "SUBTOTAL");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < this.orders.size(); ++i) {
            //(String brandName, String genericName, String dossage, String description, double price, int quantity) {
            System.out.format("%20s %40s %15s %20s %10s\n", this.orders.get(i).getBrandName(), this.orders.get(i).getGenericName(), this.orders.get(i).getPrice(), this.orders.get(i).getQuantity(), quant.get(i));
            System.out.println("---------------------------------------------------------------------------------------------------------------");
        }
        System.out.format("%103s %2s \n", "TOTAL:", total());
        if (users.get(0).getAge() >= 60) {
            System.out.println("\n");
            System.out.format("%106s ", "DISCOUNT:   20%  ");
            System.out.println();
            System.out.format("%103s %2s\n", "DISCOUNTED AMOUNT: ", discount);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.format("%103s %2s", "TOTAL PAYABLE: ", amount - discount);
            System.out.println("\n");
            System.out.println("------------------------------------------------------------------------------------------------------------------");

        }
        if (users.get(0).getAge() < 60) {
            discount = 0;
            System.out.println("\n\n");
            System.out.println();
            System.out.format("%103s %2s\n", "DISCOUNTED AMOUNT: ", discount);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.format("%103s %2s", "TOTAL PAYABLE: ", amount);
            System.out.println("\n");
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }

    }

    public void showCoughMedicineToCustomer() {
        System.out.println();
        System.out.println(" MEDICINES FOR COUGH:\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%20s %40s %15s %20s %10s\n", "BRANDNAME", "GENIRICNAME", "DOSSAGE", "DESCRIPTION", "PRICE");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        for (Medicine hubak : this.cough) {
            System.out.format("%20s %40s %15s %20s %10s\n", hubak.getBrandName(), hubak.getGenericName(), hubak.getDossage(), hubak.getDescription(), hubak.getPrice());
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

    }

    public void showCoughMedicineToAdmin() {
        System.out.println();
        System.out.println(" MEDICINES FOR COUGH:\n");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%20s %40s %15s %20s %10s %10s", "BRANDNAME", "GENIRICNAME", "DOSSAGE", "DESCRIPTION", "PRICE", "QUANTITY");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        for (Medicine ubo : this.cough) {
            System.out.format("%20s %40s %15s %20s %10s  %10s\n", ubo.getBrandName(), ubo.getGenericName(), ubo.getDossage(), ubo.getDescription(), ubo.getPrice(), ubo.getQuantity());
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

    }

    public void showPainMedicineToCustomer() {
        System.out.println();
        System.out.println(" MEDICINES FOR PAIN:\n");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%20s %40s %15s %20s %10s\n", "BRANDNAME", "GENIRICNAME", "DOSSAGE", "DESCRIPTION", "PRICE");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        for (Medicine sakit : this.pain) {
            System.out.format("%20s %40s %15s %20s %10s\n", sakit.getBrandName(), sakit.getGenericName(), sakit.getDossage(), sakit.getDescription(), sakit.getPrice());
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

    }

    public void showPainMedicineToAdmin() {
        System.out.println();
        System.out.println(" MEDICINES FOR PAIN:\n");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%20s %40s %15s %20s %10s %10s\n", "BRANDNAME", "GENIRICNAME", "DOSSAGE", "DESCRIPTION", "PRICE", "QUANTITY");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        for (Medicine sakit : this.pain) {
            System.out.format("%20s %40s %15s %20s %10s %10s\n", sakit.getBrandName(), sakit.getGenericName(), sakit.getDossage(), sakit.getDescription(), sakit.getPrice(), sakit.getQuantity());
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

    }

    public void showAllergiesMedicineToCustomer() {
        System.out.println();
        System.out.println(" MEDICINES FOR ALLERGIES:\n");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%20s %40s %15s %20s %10s\n", "BRANDNAME", "GENIRICNAME", "DOSSAGE", "DESCRIPTION", "PRICE");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        for (Medicine katol : this.allergies) {
            System.out.format("%20s %40s %15s %20s %10s\n", katol.getBrandName(), katol.getGenericName(), katol.getDossage(), katol.getDescription(), katol.getPrice());
            System.out.println();
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
    }

    public void showAllergiesMedicineToAdmin() {
        System.out.println();
        System.out.println(" MEDICINES FOR ALLERGIES:\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%20s %40s %15s %20s %10s %10s", "BRANDNAME", "GENIRICNAME", "DOSSAGE", "DESCRIPTION", "PRICE", "QUANTITY");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        for (Medicine katol : this.allergies) {
            System.out.format("%20s %40s %15s %20s %10s %10s\n", katol.getBrandName(), katol.getGenericName(), katol.getDossage(), katol.getDescription(), katol.getPrice(), katol.getQuantity());
            System.out.println();
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    }

    public void showAllMedicineToCustomer() {

        this.showAllergiesMedicineToCustomer();
        this.showCoughMedicineToCustomer();
        this.showPainMedicineToCustomer();
    }

    public void showAllMedicineToPharmacists() {
        this.showAllergiesMedicineToAdmin();
        this.showCoughMedicineToAdmin();
        this.showPainMedicineToAdmin();

    }

}
