/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.awt.Image;

/**
 *
 * @author dell
 */
public class PersonalProfile {
    private String name;
    private String geographicdata;
    private String dataofbirth;
    private String telephone;
    private String fax;
    private String email;
    private String securitynum;
    private String medicalnum;
    private String beneficiarynum;
    private String bankaccountnum;
    private String licensenum;
    private String vehiclenum;
    private String devicenum;
    private String linkedln;
    private String internetadd;
    private String bioidentifiers;
    private String code;
    private String facephoto;

    public String getFacephoto() {
        return facephoto;
    }

    public void setFacephoto(String facephoto) {
        this.facephoto = facephoto;
    }

    
    
    

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeographicdata() {
        return geographicdata;
    }

    public void setGeographicdata(String geographicdata) {
        this.geographicdata = geographicdata;
    }

    public String getDataofbirth() {
        return dataofbirth;
    }

    public void setDataofbirth(String dataofbirth) {
        this.dataofbirth = dataofbirth;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecuritynum() {
        return securitynum;
    }

    public void setSecuritynum(String securitynum) {
        this.securitynum = securitynum;
    }

    public String getMedicalnum() {
        return medicalnum;
    }

    public void setMedicalnum(String medicalnum) {
        this.medicalnum = medicalnum;
    }

    public String getBeneficiarynum() {
        return beneficiarynum;
    }

    public void setBeneficiarynum(String beneficiarynum) {
        this.beneficiarynum = beneficiarynum;
    }

    public String getBankaccountnum() {
        return bankaccountnum;
    }

    public void setBankaccountnum(String bankaccountnum) {
        this.bankaccountnum = bankaccountnum;
    }

    public String getLicensenum() {
        return licensenum;
    }

    public void setLicensenum(String licensenum) {
        this.licensenum = licensenum;
    }

    public String getVehiclenum() {
        return vehiclenum;
    }

    public void setVehiclenum(String vehiclenum) {
        this.vehiclenum = vehiclenum;
    }

    public String getDevicenum() {
        return devicenum;
    }

    public void setDevicenum(String devicenum) {
        this.devicenum = devicenum;
    }

    public String getLinkedln() {
        return linkedln;
    }

    public void setLinkedln(String linkedln) {
        this.linkedln = linkedln;
    }

    public String getInternetadd() {
        return internetadd;
    }

    public void setInternetadd(String internetadd) {
        this.internetadd = internetadd;
    }

    public String getBioidentifiers() {
        return bioidentifiers;
    }

    public void setBioidentifiers(String bioidentifiers) {
        this.bioidentifiers = bioidentifiers;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
}
