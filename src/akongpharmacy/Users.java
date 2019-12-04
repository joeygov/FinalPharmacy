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
public class Users {

    private String name;
    private String userName;
    private int age;
    private String password;

    public Users() {
    }

    public Users(String name, String userName, int age, String password) {
        this.name = name;
        this.userName = userName;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s", this.name, this.userName, this.age, this.password);
    }

}
