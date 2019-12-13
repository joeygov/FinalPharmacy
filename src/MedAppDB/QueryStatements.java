/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedAppDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import MedApp.*;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author destacamento_sd2022
 */
public class QueryStatements {

    public void register(String firstName, String lastname, String place, int edad, String email, String user, String password) {
        boolean flag = true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medappdb", "root", "");
            Statement stmt = con.createStatement();
            String query = "SELECT username FROM tblaccounts";
            ResultSet rs = stmt.executeQuery(query);

            stmt = con.createStatement();
            String sql = "INSERT INTO tblAccounts(lastname, firstName,address, age, email, username, password) VALUES ";
            sql += "('" + lastname + "','" + firstName + "','" + place + "','" + edad + "','" + email + "','" + user + "', '" + password + "')";
            System.out.println(sql);

            stmt.executeUpdate(sql);

            stmt.close();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void login(String username, String password) {
        MainMenu maintab = new MainMenu();
        Login home = new Login();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medappdb", "root", "");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM tblaccounts";
            ResultSet rs = stmt.executeQuery(query);
            stmt = con.createStatement();
            String sql = "select * from tblaccounts where username='" + username + "'and password='" + password + "'";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            int count = 0;
            while (rs.next()) {
                count = count + 1;
            }
            if (count == 1) {
                maintab.setVisible(true);
                new Login().setVisible(false);
                home.dispose();
            } else if (count > 1) {
                JOptionPane.showMessageDialog(null, "Login Failed!");

            }

            stmt.close();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void addMedecine(String medecineCategory, String medecineName, String genericName, String description, int price, int quantity, String dateManufactured, String expireDate) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medappdb", "root", "");
            Statement stmt = con.createStatement();
            String query = "SELECT medecineCategory FROM tblmedecine";
            ResultSet rs = stmt.executeQuery(query);

            stmt = con.createStatement();
            String sql = "INSERT INTO tblmedecine( medecineCategory, medicineName, genericName, description, price, quantity, dateProduce, dateExpire) VALUES ";
            sql += "('" + medecineCategory + "','" + medecineName + "','" + genericName + "','" + description + "','" + price + "','" + quantity + "', '" + dateManufactured + "','" + expireDate + "')";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void searhMedecine(String searchMed) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medappdb", "root", "");
            Statement stmt = con.createStatement();
            String query = "SELECT medicineName, genericName, description, price FROM tblmedecine";
            ResultSet rs = stmt.executeQuery(query);

            stmt = con.createStatement();
            String sql = "select * from tblmedecine where medicineName Like'" + searchMed + "'OR genericName Like'" + searchMed + "'";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String medecineName = rs.getString("medicineName");
                String genericName = rs.getString("genericName");
                String description = rs.getString("description");
                float price = rs.getInt("price");
                System.out.println(medecineName + "\t" + genericName
                        + "\t" + description + "\t" + price);

            }
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteMedicine(int medicineID, String medicineName) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medappdb", "root", "");
            Statement stmt = con.createStatement();
            String query = "SELECT medicineID, medecineCategory, medicineName, genericName, description, price, quantity, dateProduce, dateExpire FROM tblmedecine";
            ResultSet rs = stmt.executeQuery(query);
            stmt = con.createStatement();
            String sql = " DELETE from tblmedecine where medicineID='" + medicineID + " ' AND medicineName='" + medicineName + "'";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            System.out.println("\nMurag na Delete");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
//,String name,  String genericName, String description, int price, int quantity, String dateManufactured, String expireDate

    public void updateMedicine(int medID, String name, String gen, String descrip, int price, int quantity, String produceDate, String expireDate) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medappdb", "root", "");
            Statement stmt = con.createStatement();
            String query = "SELECT medicineID, medecineCategory, medicineName, genericName, description, price, quantity, dateProduce, dateExpire FROM tblmedecine";
            ResultSet rs = stmt.executeQuery(query);
            stmt = con.createStatement();
            String sql = "UPDATE `tblmedecine` SET `medicineName`='" + name + "',`genericName`='" + gen + "',`description`='" + descrip + "',`price`='" + price + "',`quantity`='" + quantity + "',`dateProduce`=" + produceDate + ",`dateExpire`=" + expireDate + " WHERE medicineID = " + medID;
            stmt.executeUpdate(sql);
            System.out.println(sql);
            stmt.close();
            con.close();
            System.out.println("\nMurag na Update");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    //medID, medicineName, quant

    public void printOrders(int medID, String medicineName, int quant) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medappdb", "root", "");
            Statement stmt = con.createStatement();
            //String query = "SELECT * FROM tblorders";
          
            //////////////////////////////////////////
            Statement state = con.createStatement();
            String quer = "SELECT medicineName, genericName, description, price FROM tblmedecine";
            ResultSet res = stmt.executeQuery(quer);
            System.out.println(res);
            state = con.createStatement();
            String ask = "select * from tblmedecine where medicineID ='" + medID + "'OR medicineName Like'" + medicineName + "'";
            System.out.println(ask);
            res = stmt.executeQuery(ask);
            while (res.next()) {
                String medecineName = res.getString("medicineName");
                String genericName = res.getString("genericName");
                String description = res.getString("description");
                float price = res.getInt("price");
                System.out.println(medecineName + "\t" + genericName
                        + "\t" + description + "\t" + price);
                //////////////////////////////////////////
                stmt = con.createStatement();
                String sql = "INSERT INTO tblorders( items, amount) VALUES ";
                sql += "('" + medicineName + "','" + quant * price + "')";
                float amount = quant * price;
                JOptionPane.showMessageDialog(null, "Your Reciepts:\n" + medicineName +"          "+ amount );
                
                System.out.println(sql);
                stmt.executeUpdate(sql);
            }
            stmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException ex) {
//            ex.printStackTrace();
            System.out.println(ex);
        }
    }

}
