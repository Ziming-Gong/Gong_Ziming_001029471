/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Users;

import Business.Abstract.User;
import Business.CustomerDirectory;
import Business.ProductDirectory;
import java.util.Date;

/**
 *
 * @author AEDSpring2019
 */
public class Customer extends User implements Comparable<Customer>{
    private CustomerDirectory directory;


    public Customer(String password, String userName) {
        super(password, userName, "Customer");
        directory = new CustomerDirectory();

    }





    public CustomerDirectory getDirectory() {
        return directory;
    }

    public void setDirectory(CustomerDirectory directory) {
        this.directory = directory;
    }

    
    
    @Override
    public String toString(){
        return getUserName();
    }
    
    public boolean verify(String password) {
        if(password.equals(getPassword()))
            return true;
        return false;
    }

    @Override
    public int compareTo(Customer c) {
        return c.getUserName().compareTo(this.getUserName());
    }
}
