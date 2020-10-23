/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;

/**
 *
 * @author dell
 */
public class VihecleInformation {
    private String manufactuer;
    private int modulenum;
    private String city;
    private int seats;
    private int maximumcapacity;
    private String drivername;
    private String dateofmanufacturer;
    private Date createon;
    private Boolean available;

    public VihecleInformation(Boolean available) {
        this.available = available;
    }
    
    

    public String getDateofmanufacturer() {
        return dateofmanufacturer;
    }

    public void setDateofmanufacturer(String dateofmanufacturer) {
        this.dateofmanufacturer = dateofmanufacturer;
    }

    public VihecleInformation (){
        this.createon = new Date();
    }
    
    public String getManufactuer() {
        return manufactuer;
    }

    public void setManufactuer(String manufactuer) {
        this.manufactuer = manufactuer;
    }

    public int getModulenum() {
        return modulenum;
    }

    public void setModulenum(int modulenum) {
        this.modulenum = modulenum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getMaximumcapacity() {
        return maximumcapacity;
    }

    public void setMaximumcapacity(int maximumcapacity) {
        this.maximumcapacity = maximumcapacity;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public Date getCreateon() {
        return createon;
    }

    public Boolean getAvailable() {
        return available;
    }
    
    @Override
    public String toString(){
        return drivername;
    }
    
            
}
