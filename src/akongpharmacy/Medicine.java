/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akongpharmacy;

/**
 *
 * @author destacamento_sd2022
 */
public class Medicine {

    private String brandName;
    private String genericName;
    private String dossage;
    String description;
    private double price;
    private int quantity;

    public Medicine() {
    }

    public Medicine(String brandName, String genericName, String dossage, String description, double price, int quantity) {
        this.brandName = brandName;
        this.genericName = genericName;
        this.dossage = dossage;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getDossage() {
        return dossage;
    }

    public void setDossage(String dossage) {
        this.dossage = dossage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%2f\t%d", this.brandName, this.genericName, this.dossage,
                this.description, this.price, this.quantity);
    }

}
