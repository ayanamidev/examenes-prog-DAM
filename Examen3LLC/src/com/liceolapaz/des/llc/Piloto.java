package com.liceolapaz.des.llc;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Piloto {
    String driverid;
    int permanentNumber;
    String code;
    URL url;
    String givenName;
    String familyName;
    Date dateOfBirth;
    String nationality;

    public Piloto(String driverid, int permanentNumber, String code, URL url, String givenName, String familyName, Date dateOfBirth, String nationality) {
        this.driverid = driverid;
        this.permanentNumber = permanentNumber;
        this.code = code;
        this.url = url;
        this.givenName = givenName;
        this.familyName = familyName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

    public String getDriverid() {
        return driverid;
    }

    public int getPermanentNumber() {
        return permanentNumber;
    }

    public String getCode() {
        return code;
    }

    public URL getUrl() {
        return url;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }


}
