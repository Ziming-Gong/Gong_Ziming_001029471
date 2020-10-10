/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class VihecleInformationDirectory {

    public static VihecleInformation addVihecle;
    private ArrayList<VihecleInformation> viheclelist;

    public VihecleInformationDirectory(){
        this.viheclelist = new ArrayList<VihecleInformation>();
    }
    
    public ArrayList<VihecleInformation> getViheclelist() {
        return viheclelist;
    }

    public void setViheclelist(ArrayList<VihecleInformation> viheclelist) {
        this.viheclelist = viheclelist;
    }
    
    public VihecleInformation addVihecle(){
        VihecleInformation vihecle = new VihecleInformation();
        viheclelist.add(vihecle);
        return vihecle;
    }
    public void deletevihecle(VihecleInformation vihecle){
        viheclelist.remove(vihecle);
    }
    
    public VihecleInformation searchvihecle(String drivername){
        for (VihecleInformation vihecle : viheclelist){
            if (vihecle.getDrivername().equals(drivername)){
            return vihecle;
        }
        }
        return null;
    }
    
    public VihecleInformation searchmodulenumber(String modulenum){
        for (VihecleInformation vihecle : viheclelist){
            String mn = String.valueOf(vihecle.getModulenum());
            if(mn.equals(modulenum)){
                return vihecle;
            }
        }
        return null;
    }
    
    public VihecleInformation searchyouruber(String drivername, String city, String dateofmanufacturer, String manufactuer,String maximumcapacity, String modulenum, String seats){
        for(VihecleInformation vihecle : viheclelist){
            if(vihecle.getDrivername().equals(drivername)){
                return vihecle;
            }
            if(vihecle.getCity().equals(city)){
                return vihecle;
            }
            if(vihecle.getDateofmanufacturer().equals(dateofmanufacturer)){
                return vihecle;
            }
            if(vihecle.getManufactuer().equals(manufactuer)){
                return vihecle;
            }
            String mc = String.valueOf(vihecle.getMaximumcapacity());
            if(mc.equals(maximumcapacity)){
                return vihecle;
            }
            String mn = String.valueOf(vihecle.getModulenum());
            if(mn.equals(modulenum)){
                return vihecle;
            }
            String s = String.valueOf(vihecle.getSeats());
            if(s.equals(seats)){
                return vihecle;
            }
        }
    return null;
    }
}
