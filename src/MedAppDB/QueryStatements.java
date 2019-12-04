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

/**
 *
 * @author destacamento_sd2022
 */
public class QueryStatements {

    public void register(String firstName, String lastname, String place, int edad, String email, String user, String password) {
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
        Home home = new Home();

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
                System.out.println("Login Successful");
                maintab.setVisible(true);
                home.dispose();
            } else if (count > 1) {
                System.out.println("Login Failed!");

            } else {
                System.out.println("Account doesn't exist!");;
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
            String sql = "select * from tblmedecine where medicineName='" + searchMed + "'OR genericName='" + searchMed + "'";
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

    public void deleteMedicine(int medID, String medName) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medappdb", "root", "");
            Statement stmt = con.createStatement();
            String query = "SELECT medicineID, medecineCategory, medicineName, genericName, description, price, quantity, dateProduce, dateExpire FROM tblmedecine";
            ResultSet rs = stmt.executeQuery(query);
            stmt = con.createStatement();
            String sql = " DELETE from tblmedecine where medicineID='" + medID + " ' AND medicineName='" + medName + "'";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            System.out.println("\nMurag na Delete");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
