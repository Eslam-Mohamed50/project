package com.example.projecct;

public class Users {
String name;
String name_en;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSpecialization_en() {
        return specialization_en;
    }

    public void setSpecialization_en(String specialization_en) {
        this.specialization_en = specialization_en;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    String location;

    public Users(String name, String name_en, String location, String specialization, String specialization_en, String phone1, String phone2) {
        this.name = name;
        this.name_en = name_en;
        this.location = location;
        this.specialization = specialization;
        this.specialization_en = specialization_en;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }

    String specialization;
String specialization_en;
String phone1;
String phone2;
public Users() {}




}
